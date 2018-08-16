package com.perspicace.ai.deepbot.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@Configuration
public class MyRabbitConfig {
	
	protected Channel channel;
	protected Connection connection;
	
	/**
	@Bean
    public Queue queue() {
        return new Queue("log_queue");
    }**/
	
	@Value("${spring.rabbitmq.host}")  
	private String host;
	
	@Value("${spring.rabbitmq.port}")  
	private int port;
	
	@Value("${spring.rabbitmq.username}")  
	private String username;
	
	@Value("${spring.rabbitmq.password}")  
	private String password;
	
	@Value("${spring.rabbitmq.queues}")
	private String queue;
	
	public MyRabbitConfig(){
		
	}
	
	private void init(){
		log.info("connection to mq....");
		
		ConnectionFactory factory = new ConnectionFactory();
		  
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password); 
        
        log.info(host+"-"+port+"-"+username+"-"+password+"-"+queue);
		
        try{
	         //getting a connection
	         connection = factory.newConnection();
		    
	         //creating a channel
	         channel = connection.createChannel();
		    
	         //declaring a queue for this channel. If queue does not exist,
	         //it will be created on the server.
	         channel.queueDeclare(queue, false, false, false, null);
	         
	         log.info("connection to mq success");
        }catch(Exception e){
       	    log.error("connection to mq error");
       	    e.printStackTrace();
        }
	}
	
	public void sendStringMessage(String content) throws IOException{
		if(connection==null){
			init();
		}
		channel.basicPublish("", queue, null,content.getBytes());
	}
	
}
