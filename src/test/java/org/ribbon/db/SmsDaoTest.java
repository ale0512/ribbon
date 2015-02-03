package org.ribbon.db;

import java.util.Date;

import org.junit.Test;
import org.ribbon.entity.MsgOutbox;

public class SmsDaoTest {

	@Test
	public void testInsert() {
		MsgOutbox msg = new MsgOutbox();
		
		msg.setExpressLevel(MsgOutbox.LEVEL_LOW);
		msg.setCommPort(0);
		msg.setMsgTitle("Message Titles");
		msg.setMmsContentLocation("mmsContentLocation");
		msg.setMsgType(MsgOutbox.MSG_TYPE_SMS);
		msg.setSender("13466701620");
		msg.setReceiver("15901284372");
		msg.setSendTime(new Date(System.currentTimeMillis()));
		SmsDao smsDao = new SmsDao();
		smsDao.insert(msg);
 
	}

}
