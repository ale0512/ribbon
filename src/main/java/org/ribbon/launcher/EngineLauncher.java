package org.ribbon.launcher;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineLauncher implements Daemon{
	private final static Logger log = LoggerFactory.getLogger(EngineLauncher.class);
	
    private static EngineLauncher engineLauncherInstance = new EngineLauncher();
    
     
    
    
	public void init(DaemonContext context) throws DaemonInitException, Exception {
		log.info("初始化");
	}

	public void start() throws Exception {
		 log.info("开始");
	}

	public void stop() throws Exception {
		log.info("停止");
		 System.exit(0);
	}

	public void destroy() {
		 log.info("销毁");
	}

}
