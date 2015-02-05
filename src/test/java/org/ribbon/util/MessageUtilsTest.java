package org.ribbon.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.ribbon.entity.RztMessage;

public class MessageUtilsTest {



	public void testBuild() {
		RztMessage rzt = MessageUtils.build(Constants.SIMPLE);
		assertEquals(rzt.getCaller(), "8001,8002,8003");
	}

}
