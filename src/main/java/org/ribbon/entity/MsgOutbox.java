package org.ribbon.entity;

import java.util.Date;

import jodd.datetime.JDateTime;

/**
 * @ClassName: MsgOutbox 彩信系统，信息发送对象
 * @Description: <p>
 *               构建该对象，将数据存入对应的表中。
 *               </p>
 *               <ul>
 *               <li></li>
 *               </ul>
 * @author TrebleS
 * @date 2015-1-31 下午7:35:23
 * 
 */
public class MsgOutbox extends Message {

	private static final long serialVersionUID = -7646966352360797998L;

	/**
	 * 最高优先级
	 */
	public static final int LEVEL_HIGH = 0;
	/**
	 * 较高优先级
	 */
	public static final int LEVEL_MIDD = 1;
	/**
	 * 普通优先级
	 */
	public static final int LEVEL_LOW = 2;

	/**
	 * 普通短信
	 */
	public static final int MSG_TYPE_SMS = 0;
	/**
	 * 彩信
	 */
	public static final int MSG_TYPE_MMS = 1;
	/**
	 * WAP PUSH
	 */
	public static final int MSG_TYPE_WAP_PUSH = 2;
	/**
	 * 快闪短信
	 */
	public static final int MSG_TYPE_FLUSH = 3;
	/**
	 * 标识
	 */
	private int msgID;
	/**
	 * 发送优先级
	 */
	private int expressLevel;
	/**
	 * 发送者
	 */
	private String sender;
	/**
	 * 接受者
	 */
	private String receiver;
	/**
	 * 消息类型 0= 普通短信 1 = 彩信 （系统默认为1，彩信） 2 = wap push 3 = 免提短信（快闪短信）
	 */
	private int msgType;
	/**
	 *  可作为普通短信的内容 可作为wap push中的提示语和URL，提示语和url之间用 #### 分隔 例如：push测试####wap.baidu.com 可作为彩信的标题
	 */
	private String msgTitle;
	/**
	 * 彩信内容的全路径文件名，如发短信和wap push，则本字段不用填写，彩信内容文件以下3种方式提供：  单一资源文件 （比如一个图片文件或一个声音文件）  ini简单彩信描述文件  smil标准彩信描述文件 关于ini文件和smil的文件格式
	 */
	private String mmsContentLocation;
	/**
	 * 发送时间
	 */
	private Date sendTime;
	/**
	 * 指定串口号
	 */
	private int commPort;

	@Override
	public String toText() {

		return null;
	}

	/**
	 * @return the msgID
	 */
	public int getMsgID() {
		return msgID;
	}

	/**
	 * @param msgID
	 *            the msgID to set
	 */
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}

	/**
	 * @return the expressLevel
	 */
	public int getExpressLevel() {
		return expressLevel;
	}

	/**
	 * @param expressLevel
	 *            the expressLevel to set
	 */
	public void setExpressLevel(int expressLevel) {
		this.expressLevel = expressLevel;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver
	 *            the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the msgType
	 */
	public int getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType
	 *            the msgType to set
	 */
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	/**
	 * @return the msgTitle
	 */
	public String getMsgTitle() {
		return msgTitle;
	}

	/**
	 * @param msgTitle
	 *            the msgTitle to set
	 */
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	/**
	 * @return the mmsContentLocation
	 */
	public String getMmsContentLocation() {
		return mmsContentLocation;
	}

	/**
	 * @param mmsContentLocation
	 *            the mmsContentLocation to set
	 */
	public void setMmsContentLocation(String mmsContentLocation) {
		this.mmsContentLocation = mmsContentLocation;
	}

	/**
	 * @return the sendTime
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime
	 *            the sendTime to set
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * @return the commPort
	 */
	public int getCommPort() {
		return commPort;
	}

	/**
	 * @param commPort
	 *            the commPort to set
	 */
	public void setCommPort(int commPort) {
		this.commPort = commPort;
	}

	public String getSendTimeStr(){
		JDateTime time = new JDateTime(this.getSendTime());
		return time.toString("YYYY-MM-DD hh:mm:ss");
	}
}
