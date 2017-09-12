package JDBC;
import java.sql.*;  
import java.io.*; 
import java.util.*;
public class Curdopp
{
	public static void main(String[] args) throws Exception
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement stmt=con.createStatement();
	
		while(true)
		{
			System.out.println("1 to insert records");
			System.out.println("2 to update records");
			System.out.println("3 to delete records");
			System.out.println("4 to sorting data");
			System.out.println("5 to Display an employee");
			System.out.println("6 to Display all");
			System.out.println("7 to check Total columns, Col Name of 1st col, Col Type of 1st column");
			System.out.println("8 to check Driver name,version,username,database product name,product version");
			System.out.println("9 to exit");
			//ResultSet rs=null;
			ResultSet rs=stmt.executeQuery("select * from emp2");
			ResultSetMetaData rsmd=rs.getMetaData(); 
			DatabaseMetaData dbmd=con.getMetaData();
			PreparedStatement ps=null;
			int choice=sc.nextInt();
			int id;
			float sal;
			String name,city;
			int i;
			switch(choice)
			{
				case 1:
				
				     ps = con.prepareStatement("insert into emp2 values(?,?,?,?)");
				     System.out.println("enter the id");
				     id=sc.nextInt();
				     ps.setInt(1, id);
				     System.out.println("enter the name");
				     name=sc.next();
				     ps.setString(2, name);
				     System.out.println("Enter the city");
				     city=sc.next();
				     ps.setString(3, city);
				     System.out.println("Enter salary");
				     sal=sc.nextFloat();
				     ps.setFloat(4, sal);
				     i = ps.executeUpdate();
				     if (i != 0) 
				     {
				         System.out.println("Inserted");
				     } else 
				     {
				         System.out.println("not Inserted");
				     }					
					break;
				case 2:    
					ps = con.prepareStatement("update emp2 set city=?,sal=sal+? where id=?");
					System.out.println("enter city");
					city=sc.next();
					ps.setString(1, city);
					System.out.println("enter sal");
					sal=sc.nextFloat();
					ps.setFloat(2, sal);
					System.out.println("enter id");
					id=sc.nextInt();
					ps.setInt(3, id);
					i = ps.executeUpdate();
					if (i != 0) 
					{
						System.out.println("updated");
					} 
					else 
					{
						System.out.println("not updated");
					}		   
					break;
				case 3:  
					ps = con.prepareStatement("delete from emp2 where id=?");
					System.out.println("enter the id to delete");
					id=sc.nextInt();
			     	ps.setInt(1, id);
			     	i = ps.executeUpdate();
			     	if (i != 0)
			     	{
			     		System.out.println("deleted");
			     	} 
			     	else 
			     	{
			     		System.out.println("not deleted");
			     	}
					break;
				case 4:
					ps = con.prepareStatement("select * from emp2 " + " ORDER BY name ASC");
					rs=ps.executeQuery();
					System.out.println("id\tname\tcity\tsalary");
					System.out.println("-------------------------------");
					while (rs.next()) 
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
					}
					System.out.println();
					break;
				case 5:     
					ps = con.prepareStatement("select * from emp2 where id=?");
					System.out.println("enter the id to display the employee");
					id=sc.nextInt();
					
					ps.setInt(1, id);
					rs=ps.executeQuery();
					if (rs.next()) 
					{
						System.out.println("id\t"+rs.getInt(1));
						System.out.println("Name\t"+rs.getString(2));
						System.out.println("city\t"+rs.getString(3));
						System.out.println("salary\t"+rs.getFloat(4));
					}
					else{
						System.out.println("id not found");
					}
					System.out.println();
					break;
				case 6:System.out.println("id\tname\tcity\tsalary");
						System.out.println("-------------------------------");
				     while (rs.next()) 
				     {
				         System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				     }
				     System.out.println();
					break;
				case 7: 
						System.out.println("number of columns: "+rsmd.getColumnCount());
						System.out.println("1st column name: "+rsmd.getColumnName(1));
						System.out.println("Data type: "+rsmd.getColumnTypeName(1));
						System.out.println();
					break;
				case 8: System.out.println("Driver Name: "+dbmd.getDriverName());  
					System.out.println("Driver Version: "+dbmd.getDriverVersion());  
					System.out.println("UserName: "+dbmd.getUserName());  
					System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
					System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
					System.out.println();
					break;
			
				case 9:System.exit(0);
					break;
				default :System.out.println("invalid input.. try again");
					break;
			}
			
		}
		
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		} 
	}
}
