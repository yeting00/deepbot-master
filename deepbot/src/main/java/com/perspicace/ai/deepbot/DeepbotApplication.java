package com.perspicace.ai.deepbot;

import com.perspicace.ai.deepbot.utils.IceInvokeParams;
import com.perspicace.ai.deepbot.utils.IceInvoker;
import com.perspicace.ai.deepbot.utils.LocalMessageQueue;
import com.perspicace.ai.deepbot.utils.Sl4jLoggerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description:
 * @Author: 叶挺
 * @Date: Created in 2018/8/16 9:59
 * @Modified By:
 */
@SpringBootApplication
@EnableNeo4jRepositories("com.perspicace.ai.deepbot.neo4j.repository")
@Slf4j
public class DeepbotApplication {


	static boolean init() {
		//判断外部是否传入了配置文件路径
		String configPath = null;
		Properties prop ;
		log.info ( "没有外部配置 读取jar内 server_config.properties" );
		try {
			InputStream is = DeepbotApplication.class.getClassLoader ( ).getResourceAsStream ( "server_config.properties" );
			prop = new Properties ( );
			prop.load ( is );
			//初始化远程调用配置
			IceInvokeParams iceInvokeParams = IceInvokeParams.createWithPropties ( prop );
			IceInvoker.initParams ( iceInvokeParams );
			return true;
		} catch (IOException e) {
			e.printStackTrace ( );
			return false;
		}
	}

	public static void main(String[] args) {
		log.info ( "**************项目启动***************" );
//        SpringUtil.getBean(MqRepositoryImpl.class);
		boolean init = init ( );
		if (!init) {
			log.info ( "加载配置文件失败" );
			System.exit ( -1 );
		}
		SpringApplication.run(DeepbotApplication.class, args);
		Ice.InitializationData initData = new Ice.InitializationData ( );
		initData.properties = Ice.Util.createProperties ( );
		initData.properties.setProperty ( "Ice.Admin.DelayCreation" , "1" );

		initData.logger = new Sl4jLoggerUtil( "system" );
		log.info ( "started..." );
		//本地消息队列开启
		LocalMessageQueue.getInstance ( ).start ( );
		IceBox.Server server = new IceBox.Server ( );
//        int status = server.main("IceBox.Server", args, "application-icebox.properties");
		int status = server.main ( "IceBox.Server" , args , "icebox.properties" );
		System.exit ( status );


		//add test

	}

}
