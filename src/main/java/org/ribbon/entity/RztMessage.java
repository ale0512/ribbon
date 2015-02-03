package org.ribbon.entity;


/**
 * @ClassName: RztMessage 协同通信的消息实体
 * @Description: <p>
 *               TODO
 *               </p>
 *               <ul>
 *               <li></li>
 *               </ul>
 * @author TrebleS
 * @date 2015-1-31 上午10:08:24
 * 
 */
public class RztMessage extends Message {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7510437614662544585L;

	/**
	 * simultaneity
	 */
	public static String CALL_MODE_SIM = "simultaneity";
	/**
	 * order
	 */
	public static String CALL_MODE_order = "order";

	/**
	 * 主叫号码列表，多个以逗号分开；
	 */
	private String caller;
	/**
	 * 系统呼叫主叫模式，{ simultaneity, order}，默认为Order
	 */
	private String callCallerMode;

	/**
	 * 被叫号码列表，多个以逗号隔开
	 */
	private String callee;

	/**
	 * 系统呼叫被叫模式，从{ simultaneity, order}中取值，默认为order模式
	 */
	private String callCalleeMode;

	/**
	 * 协同通信系统呼叫用户时使用的主叫号码
	 */
	private String displayName;

	/**
	 * 发起通信的平台，从{“400-platform”，”RZT-platform”}集合中取值；
	 */
	private String platForm;

	private String requestId;

	/**
	 * 重复次数
	 */
	private String retry;

	/**
	 * 重复播放语音次数
	 */
	private String replay;

	/**
	 * msn接收的用户列表，以逗号隔开
	 */
	private String msnUser;

	/**
	 * 消息体类型，文本类型时填application/text
	 */
	private String contentType;

	/**
	 * 消息体长度，按字节计算，不包括消息头字段后面的空行长度，从body的第一个字节开始到该消息最后一个字节的长度；
	 */
	private String contentLength;

	/**
	 * 短信还是彩信；
	 */
	private String smsType;

	/**
	 * 彩信或者短信的标题；
	 */
	private String smsTitle;

	/**
	 * 请求彩信内容文件列表；
	 */
	private String fileList;

	/**
	 * 请求彩信内容文件路径；
	 */
	private String fileName;
	
	/**
	 * 消息内容
	 */
	private String textBody;

	/**
	 * @return the caller
	 */
	public String getCaller() {
		return caller;
	}

	/**
	 * @param caller
	 *            the caller to set
	 */
	public void setCaller(String caller) {
		this.caller = caller;
	}

	/**
	 * @return the callCallerMode
	 */
	public String getCallCallerMode() {
		return callCallerMode;
	}

	/**
	 * @param callCallerMode
	 *            the callCallerMode to set
	 */
	public void setCallCallerMode(String callCallerMode) {
		this.callCallerMode = callCallerMode;
	}

	/**
	 * @return the callee
	 */
	public String getCallee() {
		return callee;
	}

	/**
	 * @param callee
	 *            the callee to set
	 */
	public void setCallee(String callee) {
		this.callee = callee;
	}

	/**
	 * @return the callCalleeMode
	 */
	public String getCallCalleeMode() {
		return callCalleeMode;
	}

	/**
	 * @param callCalleeMode
	 *            the callCalleeMode to set
	 */
	public void setCallCalleeMode(String callCalleeMode) {
		this.callCalleeMode = callCalleeMode;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the platForm
	 */
	public String getPlatForm() {
		return platForm;
	}

	/**
	 * @param platForm
	 *            the platForm to set
	 */
	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the retry
	 */
	public String getRetry() {
		return retry;
	}

	/**
	 * @param retry
	 *            the retry to set
	 */
	public void setRetry(String retry) {
		this.retry = retry;
	}

	/**
	 * @return the replay
	 */
	public String getReplay() {
		return replay;
	}

	/**
	 * @param replay
	 *            the replay to set
	 */
	public void setReplay(String replay) {
		this.replay = replay;
	}

	/**
	 * @return the msnUser
	 */
	public String getMsnUser() {
		return msnUser;
	}

	/**
	 * @param msnUser
	 *            the msnUser to set
	 */
	public void setMsnUser(String msnUser) {
		this.msnUser = msnUser;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the contentLength
	 */
	public String getContentLength() {
		return contentLength;
	}

	/**
	 * @param contentLength
	 *            the contentLength to set
	 */
	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	/**
	 * @return the smsType
	 */
	public String getSmsType() {
		return smsType;
	}

	/**
	 * @param smsType
	 *            the smsType to set
	 */
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	/**
	 * @return the smsTitle
	 */
	public String getSmsTitle() {
		return smsTitle;
	}

	/**
	 * @param smsTitle
	 *            the smsTitle to set
	 */
	public void setSmsTitle(String smsTitle) {
		this.smsTitle = smsTitle;
	}

	/**
	 * @return the fileList
	 */
	public String getFileList() {
		return fileList;
	}

	/**
	 * @param fileList
	 *            the fileList to set
	 */
	public void setFileList(String fileList) {
		this.fileList = fileList;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toText() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the textBody
	 */
	public String getTextBody() {
		return textBody;
	}

	/**
	 * @param textBody the textBody to set
	 */
	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	

}
