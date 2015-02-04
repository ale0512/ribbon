package org.ribbon.bridge;

import java.util.Calendar;

import jodd.util.StringUtil;

import org.ribbon.db.SmsDao;
import org.ribbon.entity.MsgOutbox;
import org.ribbon.entity.RztMessage;
import org.ribbon.util.Constants;
import org.ribbon.util.MessageUtils;

public class RibbonBridge implements Runnable{
	
	private String content;

	public void start() {
		RztMessage rztMessage = MessageUtils.build(this.getContent());
		build(rztMessage);
	}

	public static void build(RztMessage message) {
		SmsDao dao = new SmsDao();
		String receiver = message.getCallee();
		if (StringUtil.isNotEmpty(receiver)) {
			String[] callee = receiver.split(Constants.SIGN_COMMA);
			for (int i = 0; i < callee.length; i++) {
				MsgOutbox outbox = new MsgOutbox();
				outbox.setSender(message.getCaller());
				outbox.setSendTime(Calendar.getInstance().getTime());
				outbox.setMsgTitle(message.getSmsTitle());
				if(StringUtil.isNotEmpty(message.getSmsType())){
					if (message.getSmsType().toLowerCase().equals("sms")) {
						outbox.setMsgType(MsgOutbox.MSG_TYPE_SMS);
					} else if (message.getSmsType().toLowerCase().equals("mms")) {
						outbox.setMsgType(MsgOutbox.MSG_TYPE_MMS);
					}
				}
				outbox.setExpressLevel(MsgOutbox.LEVEL_LOW);
				outbox.setMmsContentLocation(message.getTextBody());
				outbox.setReceiver(callee[i]);
				dao.insert(outbox);
			}
		}
	}

	public void run() {
		 this.start();
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
