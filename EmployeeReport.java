import java.io.*;
import java.sql.*;
import javax.swing.*;

class EmployeeReport 
{
	public EmployeeReport ()
	{
		try
		{
		 Class.forName("org.postgresql.Driver");
 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hotel","postgres","system");
    		
    		Statement st=con.createStatement();
    		
    		BufferedWriter bw=new BufferedWriter(new FileWriter("EmployeeReport.html"));
    		bw.write("<html>");
    		bw.write("<title>  </title>");
    		bw.write("<head>   </head>");
    		bw.write("<body>");
    		bw.write("<h1><center> <font color='purple'>Hotel Reservation System</font></center></h1>");
    		
    		bw.write("<h2><center> <font color='green'>EMPLOYEE DETAILS REPORT </font></center></h1>");
    		bw.write("<hr color=black size=5>");
    		bw.write("<table border=0 cellpadding=10 align=center>");
    		
    		ResultSet rs=st.executeQuery("select * from emp");
    		
			ResultSetMetaData rsmd=rs.getMetaData();
		
			int col=rsmd.getColumnCount();
			
			bw.write("<tr>");
			for(int i=1;i<=col;i++)
			{
				bw.write("<th><font color='Blue'>"+rsmd.getColumnName(i));
			}
			while(rs.next())
			{
				bw.write("<tr>");
				for(int i=1;i<=col;i++)
				{
					bw.write("<td><font color='Blue'>"+rs.getString(i));
				}
			}
			bw.write("</table>");
			bw.write("<hr color=black size=2>");
			bw.write("<h3 align='right'>Authorised Signature:-.................</h3>");
			
			Runtime r=Runtime.getRuntime();
			r.exec("explorer EmployeeReport.html");
			bw.close();
		}
		catch(Exception e)
		{
			System.out.print("\n Error="+e);
		}
	}
	public static void main(String arg[])
	{
		EmployeeReport ob=new EmployeeReport ();
	}
}