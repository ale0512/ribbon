package org.ribbon.rzt;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.ribbon.bridge.RibbonBridge;
import org.ribbon.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RztClientHandler extends IoHandlerAdapter {
	private final static Logger log = LoggerFactory.getLogger(RztClientHandler.class);

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		log.debug("客户端: " + session.getRemoteAddress());
//		IoBuffer buffer = IoBuffer.allocate(10);
//		buffer.setAutoExpand(true);
//		buffer.putInt(400);
//		buffer.flip();
//		session.write(buffer);
	}

	// 当客户端发送消息到达时
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String s = (String) message;
		log.debug("服务器返回的数据：" + s);
		 RibbonBridge bridge = new RibbonBridge();
		 bridge.setContent(s);
		 Thread thread = new Thread(bridge);
		 thread.start();
	}

	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		log.debug("客户端与服务端断开连接.....");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		log.debug("创建客户端会话：" + session.getRemoteAddress());
	}

	/**
	 * 当信息已经传送给客户端后触发此方法. 
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
	}
}
