import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

public class ReservationDetails extends JFrame 
{
    Connection cn;
    PreparedStatement pst,pst1,pst2;
    ResultSet rs,rs1,rs2;
    Statement st;
     JButton b1;
     JButton b2;
     JButton b3;
     JButton b4;
     JButton b5;
     JComboBox cmbbid;
  
     JComboBox cmbpid;
    
     JLabel jLabel1;
   
     JLabel jLabel11;
     JLabel jLabel12;
     JLabel jLabel13;
   
     JLabel jLabel3;
     JLabel jLabel4;
     JLabel jLabel5;
     JLabel jLabel6;
     JLabel jLabel7;
     JLabel jLabel8;
     JLabel jLabel9;
     JTextField txtamt;
     JTextField txtbno;
     JTextField txtbtype;
     JTextField txtcellno;
     JTextField txtdate;
     JTextField txtpname;
     JTextField txtqty;
     JTextField txtrate;
     JTextField txtrid;
 
    public ReservationDetails() 
   {
	  initComponents();
       	setSize(600,600);
	setVisible(true);
	setTitle("Reservation Details");
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
 try
        {
            Class.forName("org.postgresql.Driver");
 cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hotel","postgres","system"); 
            pst=cn.prepareStatement("select rid from Room");
            rs=pst.executeQuery();
          cmbbid.removeAllItems();
            while(rs.next())
            {
               cmbbid.addItem(rs.getInt(1));
            }
            pst=cn.prepareStatement("select cid from Customer");
            rs=pst.executeQuery();
            cmbpid.removeAllItems();
            while(rs.next())
            {
                cmbpid.addItem(rs.getInt(1));
            }
            pst=cn.prepareStatement("select max(rid) from Reservation");
            rs=pst.executeQuery();
            while(rs.next())
            {
                int no=rs.getInt(1);
                no++;
                txtrid.setText(""+no);
            }
            //txtdate.setText("");
            txtbtype.setText("");
          
            txtpname.setText("");
            txtcellno.setText("");
            txtqty.setText("");
            txtrate.setText("");
            txtamt.setText("");
            Calendar cal= Calendar.getInstance();
            SimpleDateFormat dtf=new SimpleDateFormat("dd/MM/yyyy");
            txtdate.setText(""+dtf.format(cal.getTime()));
       
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"Error is:" +ex);
        }	

    }

 
    @SuppressWarnings("unchecked")
               
    private void initComponents()
 {

     
        txtrid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
       
        jLabel3 = new javax.swing.JLabel();
        cmbpid = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        
        jLabel5 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcellno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbbid = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtbtype = new javax.swing.JTextField();
      
        txtqty = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtrate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtamt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

      

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Date");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 20, 50, 17);
        getContentPane().add(txtpname);
        txtpname.setBounds(320, 180, 120, 20);
        getContentPane().add(txtrid);
        txtrid.setBounds(160, 20, 80, 20);
       

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Reservation No");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 20, 110, 17);

        cmbpid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpidActionPerformed(evt);
            }
        });

        getContentPane().add(cmbpid);
        cmbpid.setBounds(130, 180, 60, 20);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Customer Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 180, 100, 17);

   

      
        getContentPane().add(txtdate);
        txtdate.setBounds(410, 20, 120, 20);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Customer Id");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 180, 90, 17);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Cell No");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 210, 70, 17);
        getContentPane().add(txtcellno);
        txtcellno.setBounds(320, 210, 120, 20);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Room ID");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 110, 70, 17);

        cmbbid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbbid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbidActionPerformed(evt);
            }
        });
        getContentPane().add(cmbbid);
        cmbbid.setBounds(130, 110, 60, 20);

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Room Type");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(210, 110, 70, 17);
        getContentPane().add(txtbtype);
        txtbtype.setBounds(320, 110, 120, 20);


        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
       txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
               txtqtyKeyReleased(evt);
            }
        });
   txtrate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
               txtrateKeyReleased(evt);
            }
        });
        getContentPane().add(txtqty);
        txtqty.setBounds(130, 250, 120, 20);

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("No Of Rooms");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 250, 100, 17);
        getContentPane().add(txtrate);
        txtrate.setBounds(320, 250, 120, 20);

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("Rate");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(260, 250, 70, 17);
        getContentPane().add(txtamt);
        txtamt.setBounds(130, 290, 120, 20);

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Total Bill Amount");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 290, 100, 17);

        b1.setText("Save");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(40, 350, 70, 23);

        b2.setText("Update");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2);
        b2.setBounds(120, 350, 80, 23);

        b3.setText("Delete");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3);
        b3.setBounds(210, 350, 80, 23);

        b4.setText("Search");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        getContentPane().add(b4);
        b4.setBounds(300, 350, 80, 23);

        b5.setText("Bill");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        getContentPane().add(b5);
        b5.setBounds(390, 350, 80, 23);

        pack();
    }// </editor-fold>                        

private void txtqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpqtyKeyReleased
        // TODO add your handling code here:
        try
        {
            int qty=Integer.parseInt(txtqty.getText());
            int rate=Integer.parseInt(txtrate.getText());
            int ans=qty*rate;
            txtamt.setText(""+ans);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"Error is:" +ex);
        }
    }//GEN-LAST:event_tpqtyKeyReleased

private void txtrateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpqtyKeyReleased
        // TODO add your handling code here:
        try
        {
            int qty=Integer.parseInt(txtqty.getText());
            int rate=Integer.parseInt(txtrate.getText());
            int ans=qty*rate;
            txtamt.setText(""+ans);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"Error is:" +ex);
        }
    }//GEN-LAST:event_tpqtyKeyReleased


    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {                                       
     
    }      
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {                                   
   try
{     
   pst=cn.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1,Integer.parseInt(txtrid.getText()));
  	pst.setString(2,txtdate.getText());
              	 pst.setInt(3,Integer.parseInt(cmbbid.getSelectedItem().toString()));
                pst.setString(4,txtbtype.getText());
              
	pst.setInt(5,Integer.parseInt(cmbpid.getSelectedItem().toString()));
 	  pst.setString(6,txtpname.getText());
               pst.setString(7,txtcellno.getText());
	  pst.setInt(8,Integer.parseInt(txtqty.getText()));
              pst.setInt(9,Integer.parseInt(txtrate.getText()));
	  pst.setInt(10,Integer.parseInt( txtamt.getText()));
           
                pst.execute();
                JOptionPane.showMessageDialog(this,"Record Inserted");

               txtrid.setText("");
                txtdate.setText("");
                txtbtype.setText("");
             
                txtpname.setText("");
                txtcellno.setText("");
               txtqty.setText("");
                txtrate.setText("");
                txtamt.setText("");
               
                pst=cn.prepareStatement("select max(rid) from reservation");
                rs=pst.executeQuery();
                while(rs.next())
                {
                    int no=rs.getInt(1);
                    no++;
                    txtrid.setText(""+no);
                }
                Calendar cal= Calendar.getInstance();
                SimpleDateFormat dtf=new SimpleDateFormat("dd/MM/yyyy");
                txtdate.setText(""+dtf.format(cal.getTime()));
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
    }                                  

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {                                   
       try
{     
   	pst=cn.prepareStatement("update reservation set rdate=?,rod=?,rtype=?,cid=?,cname=?,cellno=?,qty=?,rate=?,totalamt=? where rid=?");
                pst.setInt(10,Integer.parseInt(txtrid.getText()));
  	pst.setString(1,txtdate.getText());
              	 pst.setInt(2,Integer.parseInt(cmbbid.getSelectedItem().toString()));
	            pst.setString(3,txtbtype.getText());
             
	pst.setInt(4,Integer.parseInt(cmbpid.getSelectedItem().toString()));
 	  pst.setString(5,txtpname.getText());
               pst.setString(6,txtcellno.getText());
 pst.setInt(7,Integer.parseInt(txtqty.getText()));
 pst.setInt(8,Integer.parseInt(txtrate.getText()));
 pst.setInt(9,Integer.parseInt(txtamt.getText()));
	
           
                pst.execute();
                JOptionPane.showMessageDialog(this,"Record Updated");

               txtrid.setText("");
                txtdate.setText("");
                txtbtype.setText("");
               
                txtpname.setText("");
                txtcellno.setText("");
               txtqty.setText("");
                txtrate.setText("");
                txtamt.setText("");
               
                pst=cn.prepareStatement("select max(rid) from reservation");
                rs=pst.executeQuery();
                while(rs.next())
                {
                    int no=rs.getInt(1);
                    no++;
                    txtrid.setText(""+no);
                }
                Calendar cal= Calendar.getInstance();
                SimpleDateFormat dtf=new SimpleDateFormat("dd/MM/yyyy");
                txtdate.setText(""+dtf.format(cal.getTime()));
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
    }                                  

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {                                   
         try
{     
   pst=cn.prepareStatement("delete from reservation where rid=?");
                pst.setInt(1,Integer.parseInt(txtrid.getText()));
  	
           
                pst.execute();
                JOptionPane.showMessageDialog(this,"Record Deleted");

                txtrid.setText("");
                txtdate.setText("");
                txtbtype.setText("");
               
                txtpname.setText("");
                txtcellno.setText("");
                txtqty.setText("");
                txtrate.setText("");
                txtamt.setText("");
               
                pst=cn.prepareStatement("select max(rid) from reservation");
                rs=pst.executeQuery();
                while(rs.next())
                {
                    int no=rs.getInt(1);
                    no++;
                    txtrid.setText(""+no);
                }
                Calendar cal= Calendar.getInstance();
                SimpleDateFormat dtf=new SimpleDateFormat("dd/MM/yyyy");
                txtdate.setText(""+dtf.format(cal.getTime()));
}
catch(Exception e)
{
}
    }                                  

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) 
    {                                   
try
{    
      pst=cn.prepareStatement("select * from reservation where rid=?");
                pst.setInt(1,Integer.parseInt(txtrid.getText()));
                rs=pst.executeQuery();
                if(rs.next())
                {
                     txtdate.setText((rs.getString(2)));
                    txtbtype.setText(rs.getString(4));
                
                    txtpname.setText(rs.getString(6));
                   txtcellno.setText(rs.getString(7));
                    txtqty.setText(rs.getString(8));
                   txtrate.setText(rs.getString(9));
	     txtamt.setText(rs.getString(10));
               
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Record Not Found");
                }
}
catch(Exception e)
{

}
    }                                  

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) 
  {                                   
      new Bill();
    }                                  

    private void cmbbidActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try
        {
            pst1=cn.prepareStatement("select * from Room where rid=?");
            pst1.setInt(1,Integer.parseInt(cmbbid.getSelectedItem().toString()));
            rs1=pst1.executeQuery();
            while(rs1.next())
            {
                txtbtype.setText(rs1.getString(2));
             
              
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"Error is:" +ex);
        }
    }                                      

    private void cmbpidActionPerformed(java.awt.event.ActionEvent evt) {                                       
      try
        {
            pst1=cn.prepareStatement("select * from Customer where cid=?");
            pst1.setInt(1,Integer.parseInt(cmbbid.getSelectedItem().toString()));
            rs1=pst1.executeQuery();
            while(rs1.next())
            {
                txtpname.setText(rs1.getString(2));
                txtcellno.setText(rs1.getString(3));
              
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"Error is:" +ex);
        }
    }                                      

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    
                 
}
