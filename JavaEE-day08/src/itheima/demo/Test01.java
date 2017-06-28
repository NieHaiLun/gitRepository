package itheima.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 驱动被注册两次
//		DriverManager.registerDriver(new Driver());
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
		//3.获得语句执行
		Statement stat= con.createStatement();
		//4.执行SQL语句
		String sql="INSERT INTO users(username,password) VALUES('JKL','012')";
		//5.处理结果集
//		int count = stat.executeUpdate(sql);
		
//		String sql2="UPDATE users set username='jkl' WHERE uid=6";
//		stat.executeUpdate(sql2);
		
		String sql3="SELECT * FROM users WHERE uid>2";
		PreparedStatement pst=con.prepareStatement(sql3);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"\t"+rs.getString("username")+"\t"+rs.getString("password"));
		}
		//6.释放资源
		pst.close();
		stat.close();
		con.close();
	}
}
