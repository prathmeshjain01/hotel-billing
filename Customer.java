import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Customer extends JFrame 
{

   JButton jButton1;
   JButton jButton2;
   JButton jButton3;
   JButton jButton4;
   JButton jButton5;
   JLabel l1;
   JLabel l2;
   JLabel l3;
    JLabel l4;
   JTextField t1;
    JTextField t2;
    JTextField t3;
   JTextField t4;
    Connection cn=null;
   Statement st=null;
   PreparedStatement pst;
   ResultSet rs;
    public Customer () 
    {
        initComponents();
 setSize(550,300);
	setVisible(true);
	setTitle("Customer Details");
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
               
    private void initComponents() {

        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        l1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        l1.setText("Cust Code");
        getContentPane().add(l1);
        l1.setBounds(30, 20, 90, 17);

        l2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        l2.setText("Cust Name");
        getContentPane().add(l2);
        l2.setBounds(30, 60, 100, 17);

        l3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        l3.setText("Cell No");
        getContentPane().add(l3);
        l3.setBounds(30, 100, 120, 17);

        l4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        l4.setText("Address");
        getContentPane().add(l4);
        l4.setBounds(30, 140, 130, 17);
        getContentPane().add(t1);
        t1.setBounds(200, 20, 90, 20);
        getContentPane().add(t2);
        t2.setBounds(200, 60, 190, 20);
        getContentPane().add(t3);
        t3.setBounds(200, 100, 160, 20);
        getContentPane().add(t4);
        t4.setBounds(200, 140, 160, 20);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 190, 90, 23);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 190, 90, 23);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(230, 190, 90, 23);

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(330, 190, 90, 23);

    jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(430, 190, 90, 23);

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
{                                         
        try
       {
          pst=cn.prepareStatement("insert into customer values(?,?,?,?)");
           int id=Integer.parseInt(t1.getText());
          pst.setInt(1,id);
           
          pst.setString(2,t2.getText());
           
	 pst.setString(3,t3.getText());
      
             pst.setString(4,t4.getText());
        
         pst.execute();
         JOptionPane.showMessageDialog(null,"Client Added.... ");
    t1.setText("");
    t2.setText("");
    t3.setText("");
    t4.setText("");
    
 
    }
     catch(Exception e)
     {
     JOptionPane.showMessageDialog(null,"Error = "+e);

     }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     try
   {
       pst=cn.prepareStatement("update customer set cname=?, cellno=?, addr=?where cid=?");
        pst.setString(1,t2.getText());
        
  pst.setString(2,t3.getText());
     
  pst.setString(3,t4.getText());
        
    int id=Integer.parseInt(t1.getText());
    pst.setInt(4,id); 
    int k= pst.executeUpdate();
   JOptionPane.showMessageDialog(null,"Recordd updatedd...") ;   
 
}

   catch(Exception e)
  {
   JOptionPane.showMessageDialog(null,"Error in edit = "+e);

  }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try
   {
       pst=cn.prepareStatement("delete  from customer where cid=?");
        
     int id=Integer.parseInt(t1.getText());
    pst.setInt(1,id); 
    int k=pst.executeUpdate();
   JOptionPane.showMessageDialog(null,"Record Deleted.....") ;
   t1.setText("");
   t2.setText("");
   t3.setText("");
   t4.setText("");
 
   }

   catch(Exception e)
  {
   JOptionPane.showMessageDialog(null,"Error in edit = "+e);

  }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     setVisible(false);
    }                                        
 private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     try
    {
    pst=cn.prepareStatement(" select * from customer where cid=? ");   
      int id=Integer.parseInt(t1.getText());
     pst.setInt(1,id);
     rs=pst.executeQuery();
       if(rs.next())
     {
         t2.setText(rs.getString(2));
         t3.setText(rs.getString(3));
         t4.setText(rs.getString(4));
      
     
     } 
     else
    {
   JOptionPane.showMessageDialog(null,"Record not found... ");

    }
   }    
     catch(Exception e)
    {
   JOptionPane.showMessageDialog(null,"Error = "+e);

    }
    }   
  
    public static void main(String args[]) {
       
                new Customer ().setVisible(true);
       
    }

                 

    
}
