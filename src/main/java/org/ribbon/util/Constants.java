package org.ribbon.util;

public class Constants {
	
	/**
	 * 下划线
	 */
	public static final String SIGN_DASH = "_";
	
	/**
	 * 逗号
	 */
	public static final String SIGN_COMMA = ",";
	
	public static final String SUCCESS = "RZT/1.0 200 OK\r\n";
	public static final String ERROR = "RZT/1.0 400 OK\r\n";
	
	public static final String SIMPLE="MAKECALL RZT/1.0 \n" +
			"Caller: 8001,8002,8003 \n" +
			"Call-Caller-Mode: order \n" +
			"Callee: 8005,8006 \n" +
			"Call-Callee-Mode: simultaneity \n" +
			"Display-Name: 0000 \n" +
			"Call-ID: a6j798243hlji@xianghangkj.com \n" +
			"Request-ID: 1 \n" +
			"Retry: 3 \n" +
			"\r\n" +
			"今天天气不错\r\n " +
			"我们去吃烧烤\r\n" ;
			 
}
