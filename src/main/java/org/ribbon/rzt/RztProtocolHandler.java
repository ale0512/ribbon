package org.ribbon.rzt;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.ribbon.bridge.RibbonBridge;
import org.ribbon.util.ByteAndStr16;
import org.ribbon.util.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class RztProtocolHandler extends IoHandlerAdapter {
	private final static Logger LOGGER = LoggerFactory.getLogger(RztProtocolHandler.class);

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        LOGGER.warn("Unexpected exception.", cause);
        // Close connection when unexpected exception is caught.
        session.close(true);
    }
    
    @Override
    public void messageReceived(IoSession session, Object message) {
        IoBuffer bbuf = (IoBuffer) message;
        byte[] byten = new byte[bbuf.limit()];
        bbuf.get(byten, bbuf.position(), bbuf.limit());
        String sms = ByteAndStr16.toStringHex2(byten);
        LOGGER.debug("客户端收到消息" + sms);
        bbuf.flip();
//        session.write(buffer);
//        String s = null;
//        try {
//            s = new String(message.toString().getBytes(PropertiesLoader.getCharset()),"UTF-8");
//            LOGGER.debug(s);
//        } catch (UnsupportedEncodingException e) {
//            LOGGER.debug("字符集编码错误"+PropertiesLoader.getCharset()+">+UTF-8");
//        }

//		RibbonBridge bridge = new RibbonBridge();
//		bridge.setContent(s);
//		Thread thread = new Thread(bridge);
//		thread.start();
        byte[] success = {73,75,63,63,65,73,73} ;
        session.write(success);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
    	LOGGER.debug(" 客户端与服务端断开连接.....");
    }
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
		LOGGER.debug(" 创建会话.....");	
	}
}
 

   
