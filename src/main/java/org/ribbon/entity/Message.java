package org.ribbon.entity;

import java.io.Serializable;

/** 
* @ClassName: Message 消息类
* @Description: <p></p>
* <ul>
*   <li></li>
*</ul>
* @author TrebleS
* @date 2015-1-31 上午10:06:51 
*  
*/
public abstract class Message implements Serializable{
	private static final long serialVersionUID = 3347627624201473160L;

	/**
	 * 将消息实体转成文本信息
	 * @return
	 */
	public abstract String toText();
}
