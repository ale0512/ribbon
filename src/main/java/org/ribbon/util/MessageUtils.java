package org.ribbon.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.ribbon.entity.RztMessage;

public class MessageUtils {
	
	
	public static RztMessage  build(String content) {
		ByteArrayInputStream input = new ByteArrayInputStream(content.getBytes());
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(input, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int flag = 0;
		BufferedReader reader = new BufferedReader(isr);
		RztMessage rzt = new RztMessage();
		String line = "";
		StringBuilder messageBody = new StringBuilder();
		try {
			while ((line = reader.readLine()) != null) {
				flag++;
				if (line.startsWith("Caller:")) {
					rzt.setCaller(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Call-Caller-Mode:")) {
					rzt.setCallCallerMode(line.substring(line.indexOf(":")+1).trim());
				}else if(line.startsWith("Call-ID:")){
					
				}else if (line.startsWith("Callee:")) {
					rzt.setCallee(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Call-Callee-Mode:")) {
					rzt.setCallCalleeMode(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Display-Name:")) {
					rzt.setDisplayName(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("C-Platform:")) {
					rzt.setPlatForm(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Request-ID:")) {
					rzt.setRequestId(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Retry:")) {
					rzt.setRetry(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Replay:")) {
					rzt.setReplay(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("MSNUser:")) {
					rzt.setMsnUser(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Content-Type:")) {
					rzt.setContentType(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Content-Length:")) {
					rzt.setContentType(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Sms_Type:")) {
					rzt.setSmsType(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("Sms_Title:")) {
					rzt.setSmsTitle(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("File-List:")) {
					rzt.setFileList(line.substring(line.indexOf(":")+1).trim());
				}else if (line.startsWith("File-Name:")) {
					rzt.setFileName(line.substring(line.indexOf(":")+1).trim());
				}else {
					if(flag>1){
						messageBody.append(line);
					}
				}
				
			}
			rzt.setTextBody(messageBody.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rzt;
	}
}
