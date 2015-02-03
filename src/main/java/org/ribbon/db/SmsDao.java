package org.ribbon.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ribbon.entity.MsgOutbox;
import org.ribbon.util.Constants;
import org.ribbon.util.JdbcUtils;

public class SmsDao {

	public void insert(MsgOutbox msg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO msg_outbox (ExpressLevel, Sender, Receiver,MsgType, MsgTitle, MMSContentLocation, SendTime) VALUES ");
		sql.append("(");
		sql.append("'"+msg.getExpressLevel()+"'").append(Constants.SIGN_COMMA);
		sql.append("'"+msg.getSender()+"'").append(Constants.SIGN_COMMA);
		sql.append("'"+msg.getReceiver()+"'").append(Constants.SIGN_COMMA);
		sql.append("'"+msg.getMsgType()+"'").append(Constants.SIGN_COMMA);
		sql.append("'"+msg.getMsgTitle()+"'").append(Constants.SIGN_COMMA);
		sql.append("'"+msg.getMmsContentLocation()+"'").append(Constants.SIGN_COMMA);
		sql.append("'"+msg.getSendTimeStr()+"'");
		sql.append(")");
		try {
			conn = JdbcUtils.getConnection();
			System.out.println(sql.toString());
			ps = JdbcUtils.getPreparedStatement(conn, sql.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}
}
