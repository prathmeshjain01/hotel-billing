
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Bill {
   Connection cn=null;
   PreparedStatement pst=null;
   ResultSet rs=null;
   ResultSetMetaData rsm=null;
   BufferedWriter bw;
   
  Bill()
   {
       try
       {
 Class.forName("org.postgresql.Driver");
 cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hotel","postgres","system");
          
           pst=cn.prepareStatement("select * from reservation where rid=(select max(rid) from reservation)");  
           rs=pst.executeQuery();
                            
           bw=new BufferedWriter(new FileWriter("Bill.html"));
           bw.write("<h1 align=center><font color=blue face=Comic Sans MS>Hotel Reservation </font></h1>");
          
           bw.write("<h2 align=center><font color=red>Bill</h2>");      
           bw.write("<hr color=green><br/>");                                
           while(rs.next())
           {
               bw.write("<table border=0 align=center>");                   
               bw.write("<tr>");
               bw.write("<td><b>Reservation No:</b>"+rs.getString(1)+ "<td><b> BookingDate:</b>"+rs.getString(2)+"</td>");
               bw.write("<tr>");
	 bw.write("<tr>");
              
               bw.write("<tr>");
               bw.write("<td><b>Customer Name:</b>"+rs.getString(6)+"</td>");
               bw.write("<tr>");
               bw.write("<td><hr color=pink width=100%><td><hr color=pink width=100%><td><hr color=pink width=100%>");                   
               bw.write("<tr>");
               bw.write("<td><b>Room No:</b>"+rs.getString(3)+"</td>");
               bw.write("<td><b>Total Room:</b>"+rs.getString(8)+"</td>");
               bw.write("<tr>");
               bw.write("<td><hr color=pink width=100%><td><hr color=pink width=100%><td><hr color=pink width=100%>");                   
               bw.write("<tr>");
               bw.write("<td><b>Total Amount:</b>"+rs.getString(10)+"</td>");
               bw.write("<tr>");
               bw.write("<td><hr color=pink width=100%><td><hr color=pink width=100%><td><hr color=pink width=100%>");                   
               bw.write("</table>");
               bw.write("<br/>");
           }
           bw.close();
           Runtime r=Runtime.getRuntime();
           r.exec("explorer Bill.html");  
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,"Error = "+e);
      }
   } 
   public static void main(String arg[])
   {
       new Bill();
   } 
}