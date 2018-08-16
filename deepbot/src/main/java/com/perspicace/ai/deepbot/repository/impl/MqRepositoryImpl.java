package com.perspicace.ai.deepbot.repository.impl;


import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service("mqService")
@Slf4j
public class MqRepositoryImpl {

	private Channel channel;
    private Connection connection;
    private Map<String,String> queueTypeMap;//保存队列名称
    private Map<String,Integer> queueCountMap;//保存队列数量
	
	private String exchange="exchange_1";//交换机名称

	public MqRepositoryImpl(){}

	//queues   queueName:queueCount 
	//每个队列可以分支为几个队列  queue_1 queue_2
	public MqRepositoryImpl(String host, int port, String userName, String password, String queues) throws Exception{
		 log.info("connection to mq....");
		
		 ConnectionFactory factory = new ConnectionFactory();
		  
		 queueTypeMap=new HashMap<String,String>();
		 queueCountMap=new HashMap<String,Integer>();
		 
		 
		 String queueArr[]=queues.split(",");
		 for(int i=0;i<queueArr.length;i++){
			 //queueinfo[0] 是queue名称 
			 String[] queueinfo=queueArr[i].split(":");
			 
			 String queueName=queueinfo[0];
			 Integer queueCount=Integer.parseInt(queueinfo[1]);
			 
			 //保存队列名称和数量
			 queueTypeMap.put(queueName,queueName);
			 queueCountMap.put(queueName,queueCount);
		 }
		 
         factory.setHost(host);
         factory.setPort(port);
         factory.setUsername(userName);
         factory.setPassword(password); 
         
         log.info(host+"-"+port+"-");
		
         try{
	         //getting a connection
	         connection = factory.newConnection();
		    
	         //creating a channel
	         channel = connection.createChannel();
		    
	         //声明交换机类型
	         channel.exchangeDeclare(exchange, "direct");//topic
	         
	         //声明多个队列
	         Set set=queueTypeMap.keySet();
	         Iterator<String> it=set.iterator();
	         while(it.hasNext()){
	        	 String queueKey=it.next();
	        	 String queueType=queueTypeMap.get(queueKey);
	        	 Integer queueCount=queueCountMap.get(queueKey);
	        	 
	        	 //至少有一个
	        	 if(queueCount<=0){
	        		 queueCount=1;
	        	 }
	        	 
	        	 for(int i=0;i<queueCount;i++){
	        		 //queue_1 queue_2 queue_3
	        		 String queueName=queueType+"_"+(i+1);
	        		 
	        		 Map args=new HashMap();
	        		 if(queueType.equals("call_server_queue")){
	        			 args.put("x-message-ttl", 5000);
	        		 }
	        		 
	        		 //声明队列
		        	 channel.queueDeclare(queueName, false, false, false, args);
		        	 
		        	 //交换机绑定队列
		        	 channel.queueBind(queueName, exchange, queueName+"_routing");
	        	 }
	         }
	         
	         log.info("connection to mq success");
         }catch(Exception e){
        	 log.error("connection to mq error");
        	 e.printStackTrace();
        	 throw new Exception("初始化mq失败..");
         }
	}
	
	/**
	 * send
	 * @param obj
	 * @throws IOException
	 */
	public void sendMessage(Serializable obj,String _queueType) throws IOException{
		String queueType=queueTypeMap.get(_queueType);
		
		String queueName=queueType+"_1";//默认队列1
		
		String routingKey=queueType+"_routing";
		
		//exchange routingKey 
		channel.basicPublish(exchange, routingKey, null,SerializationUtils.serialize(obj));
	}
	
	/**
	 * send
	 * @param obj
	 * @throws IOException
	 * 指定特定队列编号
	 */
	public void sendMessage(Serializable obj,String _queueType,int queueIndex) throws IOException{
		String queueType=queueTypeMap.get(_queueType);
		
		String queueName=queueType+"_"+queueIndex;//默认队列1
		
		Integer queueCount=queueCountMap.get(_queueType);
		if(queueCount<queueIndex){
			queueIndex=queueCount;
		}
		
		//下标不对为默认为1
		if(queueIndex<=0){
			queueIndex=1;
		}
		
		String routingKey=queueName+"_routing";
		
		//exchange routingKey 
		channel.basicPublish(exchange, routingKey, null,SerializationUtils.serialize(obj));
	}
	
	public void sendJSonMessage(Serializable obj,String queue) throws IOException{
		String queueType=queueTypeMap.get(queue);
		
		String queueName=queueType+"_1";//默认队列1
		
		String routingKey=queueName+"_routing";
		
		String content=JSONObject.toJSONString(obj);
		channel.basicPublish(exchange, routingKey, null,content.getBytes());
	}
	
	public void sendStringMessage(String content,String queue) throws IOException{
		String queueType=queueTypeMap.get(queue);
		
		String queueName=queueType+"_1";//默认队列1
		
		String routingKey=queueName+"_routing";
		
		channel.basicPublish(exchange, routingKey, null,content.getBytes());
	}
}
