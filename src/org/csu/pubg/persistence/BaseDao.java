package org.csu.pubg.persistence;

import java.sql.*;

public class BaseDao {

	private static String url = "jdbc:mysql://127.0.0.1:3306/pubg?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	//private static String mysqlName="chat";//连接创建的数据库名
	private static String username = "root";
	private static String password = "";

	public static Connection openConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeAll(ResultSet rs,PreparedStatement psst,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(psst!=null){
			try {
				psst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println(BaseDao.openConnection());
	}


}
