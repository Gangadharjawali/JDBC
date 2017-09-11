package JDBC;
import java.sql.*;
public class StudentDetail_In_JDBC {
	public static void main(String args[])
	{
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from std1");
			while(rs.next())
			{
				int id = rs.getInt("id");
				String fname = rs.getString("name");
				String lname = rs.getString("lname");

				System.out.println("Reg_id:"+id);
				System.out.println("First Name:"+fname);
				System.out.println("Last Name:"+lname);
				System.out.println("________________");
			}	
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
