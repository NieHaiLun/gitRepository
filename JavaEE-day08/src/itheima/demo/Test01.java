package itheima.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ������ע������
//		DriverManager.registerDriver(new Driver());
		//1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.�������
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
		//3.������ִ��
		Statement stat= con.createStatement();
		//4.ִ��SQL���
		String sql="INSERT INTO users(username,password) VALUES('JKL','012')";
		//5.��������
//		int count = stat.executeUpdate(sql);
		
//		String sql2="UPDATE users set username='jkl' WHERE uid=6";
//		stat.executeUpdate(sql2);
		
		String sql3="SELECT * FROM users WHERE uid>2";
		PreparedStatement pst=con.prepareStatement(sql3);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"\t"+rs.getString("username")+"\t"+rs.getString("password"));
		}
		//6.�ͷ���Դ
		pst.close();
		stat.close();
		con.close();
	}
}
