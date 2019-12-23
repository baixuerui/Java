
/*
�����ѯ���
*/
import java.sql.*;
public class JDBCQuery{
public static void main(String[] args)
{
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try{
		//1��ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ����
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","06523X");
		//3����ȡ���ݿ��������
		stmt = conn.createStatement();
		//4��ʵ��sql���
		String sql = "select empno, ename, sal from emp";
		rs = stmt.executeQuery(sql);
		//5�������ѯ���
		while (rs.next()){
			//String empno = rs.getString(1);
			//String ename = rs.getString(2);
			//String sal = rs.getString(3);
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			String sal = rs.getString("sal");
			System.out.println(empno + "\t" + ename + "\t" + sal);
		}
	}catch (Exception e){
		e.printStackTrace();
	}finally{
		//6���ͷ���Դ
		if (rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if (stmt != null){
			try{
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if (conn != null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}		
	
	
}
}