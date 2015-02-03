package org.ribbon.rzt;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.ribbon.util.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: RztClient Rzt服务器端
 * @Description: <p>
 *               模拟Rzt系统向RztClient发送消息
 *               </p>
 *               <ul>
 *               <li></li>
 *               </ul>
 * @author TrebleS
 * @date 2015-1-31 上午11:14:28
 * 
 */
public class RztServer {

	private static Logger log = LoggerFactory.getLogger(PropertiesLoader.class);

	/**
	 * 服务器监听端口
	 */
	private static final int PORT = PropertiesLoader.getPort();

	/**
	 * 连接Rzt服务器
	 */
	public void connent() {
		// 服务器端主要对象
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();

		// 协议解析
		chain.addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

		try {
			addLogger(chain);
		} catch (Exception e) {
			log.error(e.toString());
		}
		// Bind
		// 设置消息处理类（创建、关闭Session，可读可写等等，继承自接口IoHandler）
		acceptor.setHandler(new RztProtocolHandler());
		// 设置接收缓存区大小
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		try {
			// 服务器开始监听
			acceptor.bind(new InetSocketAddress(PORT));
		} catch (IOException e) {
			log.error(e.toString());
		}
		log.info("开始监听本机端口：" + PORT);
	}

	private static void addLogger(DefaultIoFilterChainBuilder chain) throws Exception {
		chain.addLast("logger", new LoggingFilter());
		log.info("Logging ON");
	}

	public static void main(String[] args) {
		RztServer server = new RztServer();
		server.connent();
	}
}
