package org.ribbon.rzt;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.ribbon.bridge.RibbonBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    	String s = (String)message; 
    	LOGGER.debug("客户端返回的数据：" + s);
		RibbonBridge bridge = new RibbonBridge();
		bridge.setContent(s);
		Thread thread = new Thread(bridge);
		thread.start();
    	
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
    	LOGGER.debug(" 客户端与服务端断开连接.....");
    }

	/* (non-Javadoc)
	 * @see org.apache.mina.core.service.IoHandlerAdapter#sessionCreated(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
		LOGGER.debug(" 创建会话.....");	
	}
}
 

   
