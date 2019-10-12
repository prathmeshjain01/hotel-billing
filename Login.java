import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends javax.swing.JFrame 
{
  JButton b1;
  JButton b2;
  JPasswordField jPasswordField1;
  JLabel l1;
  JLabel l2;
  JTextField t1;
  Connection cn=null;
  Statement st=null;

    public Login() 
    {
          

           initComponents();
            setSize(400,200);
	setVisible(true);
	setTitle("Login");
try
    {
      Class.forName("org.postgresql.Driver");
 cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hotel","postgres","system");
      st=cn.createStatement();
    }
    catch(Exception e)
    {
      System.out.println("Error is "+e);
    }
  }

    @SuppressWarnings("unchecked")
           
    private void initComponents() 
     {

        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        l1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        l1.setText("User Name");
        getContentPane().add(l1);
        l1.setBounds(40, 40, 120, 20);

        l2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        l2.setText("Password");
        getContentPane().add(l2);
        l2.setBounds(40, 80, 100, 20);

        t1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        getContentPane().add(t1);
        t1.setBounds(180, 40, 140, 20);

        jPasswordField1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(180, 80, 140, 20);

        b1.setText("Login");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(30, 130, 120, 23);

        b2.setText("Cancle");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2);
        b2.setBounds(200, 130, 120, 23);

        pack();
    }// </editor-fold>                        

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) 
{                                   
 this.dispose();      
    }                                  

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {                                   
   try
           {
            
          
   String uid=t1.getText().toString();
   String passw=jPasswordField1.getText().toString();
   ResultSet res = st.executeQuery("SELECT username FROM login where username='" + uid + "' and pass='" + passw + "'");

	if (res.next()) 
            {
                
	     JOptionPane.showMessageDialog(null,"Login Sucessfully");
		new HotelMenu();
		 this.dispose();      

	
                } else{
                                        JOptionPane.showMessageDialog(this,"Invalid User Name/Passw");
                                }
             
          }
           catch(Exception ee)
           {
             JOptionPane.showMessageDialog(null,"Error is : "+ee);
           }
    }                                  

   
    public static void main(String args[]) 
    {
       
                
                new Login().show();
            
       
    }
              
}
