package JDBC;
import java.sql.*;  
import java.io.*; 
import java.util.*;
class Insert
{  
	public static void main(String args[])throws Exception
	{  
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");  
		PreparedStatement ps=con.prepareStatement("insert into emp1 values(?,?,?)");  
		do
		{  
			System.out.println("enter id:");  
			int id=sc.nextInt();
			System.out.println("enter name:");  
			String name=sc.next();  
			System.out.println("enter salary:");  
			float salary=sc.nextFloat();  
			  
			ps.setInt(1,id);  
			ps.setString(2,name);  
			ps.setFloat(3,salary);  
			int i=ps.executeUpdate();  
			System.out.println(i+" records inserted");    
			System.out.println("Do you want to continue: y/n");  
			String s=sc.next();
			if(s.startsWith("n"))
			{  
				break;  
			}  
		}
		while(true);  
		con.close();  
	}
}  