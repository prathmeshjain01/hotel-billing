import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class HotelMenu extends JFrame implements ActionListener 
{
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9;
	
	HotelMenu ()
	{
		setSize(1366,730);
		//setLocation(325,0);
		setLayout(null);
		setTitle("Hotel Reservation System");
		
		jmb=new JMenuBar();
		
		jm1=new JMenu("Master        ");
		jm2=new JMenu("Transaction        ");
		jm3=new JMenu("Report           ");
		
		jm4=new JMenu("Exit");
		
JLabel ll=new JLabel( new ImageIcon("g.jpg"));
		ll.setBounds(-70,-70,1300,800);
		add(ll);	

		

		i1=new JMenuItem("Room");
		i2=new JMenuItem("Customer");
		i3=new JMenuItem("Employee");
		i4=new JMenuItem("Reservation Details");
		i5=new JMenuItem("Room Details Report");
		i6=new JMenuItem("Customer Details Report ");
		i7=new JMenuItem("Employee Details Report");
		i8=new JMenuItem("BillReport");
		i9=new JMenuItem("Exit");
		
		jmb.add(jm1);
				
			jm1.add(i1);
			jm1.add(i2);
			jm1.add(i3);
		
		
		jmb.add(jm2);
			jm2.add(i4);
			
		jmb.add(jm3);
			jm3.add(i5);
			jm3.add(i6);
			jm3.add(i7);
			jm3.add(i8);
		
			
		jmb.add(jm4);
			jm4.add(i9);
	
			
		jmb.setBounds(0,0,1366,40);
		add(jmb);
		
		
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		i7.addActionListener(this);
		i8.addActionListener(this);
		i9.addActionListener(this);
		
		
		setVisible(true);
	
	}
		
	public static void main(String arg[])
	{
			new HotelMenu();
	}
		
	

        public void actionPerformed(ActionEvent e)
        {
    	        if(e.getSource()==i1)
		{
			Room r=new Room ();
			

		}
		if(e.getSource()==i2)
		{
			Customer  c=new Customer  ();
			

		}
		if(e.getSource()==i3)
		{
			Employee t=new Employee ();
			
		}
		if(e.getSource()==i4)
		{
		ReservationDetails rd=new ReservationDetails();
			
		}
		if(e.getSource()==i5)
		{
			try
			{
			Runtime r=Runtime.getRuntime();
			r.exec("explorer RoomReport.html");
			}
		catch(Exception ae)
		{
			System.out.print("\n Error="+ae);
		}
		

		}
		if(e.getSource()==i6)
		{
			try
			{
			Runtime r=Runtime.getRuntime();
			r.exec("explorer CustomerReport.html");
			}
		catch(Exception ae)
		{
			System.out.print("\n Error="+ae);
		}
		

		}
		if(e.getSource()==i7)
		{
			try
			{
			Runtime r=Runtime.getRuntime();
			r.exec("explorer EmployeeReport.html");
			}
		catch(Exception ae)
		{
			System.out.print("\n Error="+ae);
		}
			

		}
		if(e.getSource()==i8)
		{
			try
			{
			Runtime r=Runtime.getRuntime();
			r.exec("explorer Bill.html");
			}
		catch(Exception ae)
		{
			System.out.print("\n Error="+ae);
		}

			

		}
		if(e.getSource()==i9)
		{
			int option;
			option=JOptionPane.showConfirmDialog(null,"Do You Really Want To EXIT!!!","ok",JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION)
			{
	
				System.exit(0);
			}
			

		}
		
		
		
		
	}
}
		
				
				
		
	

