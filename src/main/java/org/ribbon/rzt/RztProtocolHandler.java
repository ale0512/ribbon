package org.ribbon.rzt;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.ribbon.bridge.RibbonBridge;
import org.ribbon.util.ByteAndStr16;
import org.ribbon.util.Constants;
import org.ribbon.util.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RztProtocolHandler extends IoHandlerAdapter {
	private final static Logger LOGGER = LoggerFactory.getLogger(RztProtocolHandler.class);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		LOGGER.warn("Unexpected exception.", cause);
		// Close connection when unexpected exception is caught.
		IoBuffer buffer = IoBuffer.allocate(10);
		buffer.setAutoExpand(true);
		try {
			buffer.putString(Constants.ERROR, Charset.forName(PropertiesLoader.getCharset()).newEncoder());
			session.write(buffer);
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}finally{
			session.close(true);
		}
		
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
 
		 IoBuffer bbuf = (IoBuffer) message;
		 byte[] byten = new byte[bbuf.limit()];
		 bbuf.get(byten, bbuf.position(), bbuf.limit());
		 String sms = ByteAndStr16.toStringHex2(byten);
		 LOGGER.debug("收到客户端的消息" + sms);//
		 bbuf.flip();
		// String s = null;
		// try {
		// s = new String(message.toString().getBytes(PropertiesLoader.getCharset()),"UTF-8");
		// LOGGER.debug(s);
		// } catch (UnsupportedEncodingException e) {
		// LOGGER.debug("字符集编码错误"+PropertiesLoader.getCharset()+">+UTF-8");
		// }

		// RibbonBridge bridge = new RibbonBridge();
		// bridge.setContent(sms);
		// Thread thread = new Thread(bridge);
		// thread.start();
		IoBuffer buffer = IoBuffer.allocate(10);
		buffer.setAutoExpand(true);
		try {
			buffer.putString(Constants.SUCCESS, Charset.forName(PropertiesLoader.getCharset()).newEncoder());
			buffer.flip();
			session.write(buffer);
			Thread.sleep(2000);
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
	}
}
