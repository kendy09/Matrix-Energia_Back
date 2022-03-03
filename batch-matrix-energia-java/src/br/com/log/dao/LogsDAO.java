package br.com.log.dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.model.Log;
import br.com.log.factory.ConnectionFactory;

public class LogsDAO {



	public void save(Log log) {

		String sql = "INSERT INTO log(data,ip,request,status,user_agent)values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
			conn=ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);	
			pstm.setTimestamp(1, java.sql.Timestamp.valueOf(log.getData()));
			pstm.setString(2, log.getIp());
			pstm.setString(3,log.getRequest());
			pstm.setInt(4,log.getStatus());
			pstm.setString(5,log.getUser_agent());
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
}
