package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {

	public static Long checkResultInDatabase(String query, String url, String user, String pass) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Long result = null;
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				result = rs.getLong(1);
			}
			
		} catch (SQLException e) {
			
			System.out.println("Connector error: " + e.getMessage());
			
		}finally{
			
			try {
				if(rs!=null&&!rs.isClosed()){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Connector error: " + e.getMessage());
			}
			try {
				if(ps!=null&&!ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				System.out.println("Connector error: " + e.getMessage());
			}
			try {
				if(conn!=null&&!conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Connector error: " + e.getMessage());
			}
			
		}
		return result;
		
	}
	
}
