package org.ribbon.util;

import java.io.File;
import java.io.IOException;

import jodd.props.Props;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesLoader {
	static String path = PropertiesLoader.class.getClassLoader().getResource("").getPath();
	
	static{
		System.setProperty("logFilesPath", new File(path).getParent()+"\\"+"logs");
	}
	private static Logger log = LoggerFactory.getLogger(PropertiesLoader.class);
	private static String PROPERTIES = "config.properties";
	
	
	private static Props props;
	
	static {
		
		props = new Props();
		try {
			String clazzPath = new File(path).getParent()+"\\";
			String confPath = clazzPath+"logs";
			log.info("Log Path:"+confPath);
			if(new File(confPath+PROPERTIES).exists()){
				log.info("Properties:"+path);
				props.load(new File(confPath+PROPERTIES));
			}else{
				log.info("Properties:"+path);
				props.load(new File(path+PROPERTIES));
			}
			
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

	/**
	 * 获取Rzt系统的Host地址（包含端口）
	 * 
	 * @return
	 */
	public static String getRztHost() {
		return props.getValue("rzt.host");
	}
	
	public static int getRztPort(){
		return Integer.valueOf(props.getValue("rzt.port"));
	}

	/**
	 * 是否已SSL连接
	 * 
	 * @return
	 */
	public static boolean getSsl() {
		return Boolean.valueOf(props.getValue("ssl"));
	}

	/**
	 * 获取Client端口
	 * 
	 * @return
	 */
	public static int getPort() {
		return Integer.valueOf(props.getValue("server.port"));
	}
	
	public static String getDriver(){
		return props.getValue("driver");
	}
	
	public static String getDriverUrl(){
		return props.getValue("driverUrl");
	}
	
	public static String getUser(){
		return props.getValue("user");
	}
	
	public static String getPassword(){
		return props.getValue("password");
	}

	public static String getCharset(){return  props.getValue("charset");}
	
}
