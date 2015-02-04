package org.ribbon.rzt;

import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.ribbon.util.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RztClient {
	private final static Logger LOGGER = LoggerFactory.getLogger(RztClient.class);

	private IoConnector connector;

	public RztClient() {

		connector = new NioSocketConnector ();
		
		//创建接受数据的过滤器  
        DefaultIoFilterChainBuilder chain = connector.getFilterChain();  
		
        
      //设定这个过滤器将一行一行(/r/n)的读取数据     
        chain.addLast("chain", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		connector.setHandler(new RztClientHandler());
		ConnectFuture connFuture = connector.connect(new InetSocketAddress(PropertiesLoader
				.getRztHost(), PropertiesLoader.getRztPort()));

		LOGGER.debug("About to wait.");
		connFuture.awaitUninterruptibly();
		connFuture.getSession().getCloseFuture().awaitUninterruptibly();

		connector.dispose();

	}

	public static void main(String[] args) {
		new RztClient();
	}
}
