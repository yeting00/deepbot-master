package com.perspicace.ai.deepbot.utils;

import com.perspicace.modules.AICall.AICall.AICallServicePrx;
import com.perspicace.modules.AICall.AICall.SayObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class LocalMessageQueue extends Thread{
	
	private static LocalMessageQueue messageQueue;
	public static LocalMessageQueue getInstance(){
		if(messageQueue==null){
			messageQueue=new LocalMessageQueue();
		}
		return messageQueue;
	}
	
	private Logger logger=LoggerFactory.getLogger(LocalMessageQueue.class);
	
	private boolean isRunning=false;
	
	 //队列大小  
    private final int QUEUE_LENGTH = 10000*10;  
	private BlockingQueue<SayObj> queue=new ArrayBlockingQueue<SayObj> (QUEUE_LENGTH);
	
	private AICallServicePrx aiCallServicePrx;
	
	public LocalMessageQueue(){
		logger.info("初始化 AICallServicePrx...");
		//aiCallServicePrx = (AICallServicePrx)IceSampleClientUtil.createIceProxyByName(AICallServicePrx.class,"AICallService@AICallServiceAdapter");
		aiCallServicePrx= IceInvoker.getAICallServicePrx();
		isRunning=true;
	}
	
	public void addMessage(SayObj sayObj){
		queue.add(sayObj);
	}
	
	public void run(){
		while(isRunning){
			SayObj sayObj;
			try {
				logger.info("size=="+queue.size());
				sayObj = queue.take();
				if(sayObj!=null){
					logger.info("返回==="+sayObj.sayingText);
					long time1=System.currentTimeMillis();
					String str=aiCallServicePrx.listionBack(sayObj);
					long time2=System.currentTimeMillis();
					
					logger.info("cost=="+(time2-time1)+"  back="+str);
					
					Thread.sleep(1);
				}else{
					logger.info("队列中已无消息!");
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
