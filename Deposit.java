import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date; 
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
class Deposit extends JFrame implements ActionListener 
{
JLabel l1;
JTextField t1;
JButton b1,b2;
Date date;
int balance,uid;


Connection cn;
Statement st;
ResultSet rs;
public static String accountno=LoginPage.acno;

Deposit()
{
l1=new JLabel("Enter Amount to Deposit");
l1.setBounds(50,50,350,40);

add(l1);
t1=new JTextField();
t1.setBounds(200,60,100,20);
add(t1);

b1=new JButton("Deposit");
b1.setBounds(100,120,100,30);
b1.addActionListener(this);
add(b1);



b2=new JButton("Back");
b2.setBounds(200,120,100,30);
b2.addActionListener(this);
add(b2);



setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(400,300);
getContentPane().setBackground(Color.orange);
setResizable(false);

date = new Date();

try
{
Class.forName("org.postgresql.Driver");
Connection cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankproject","postgres","Sandy");
st=cn.createStatement();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is ="+e);
}

}
public void actionPerformed(ActionEvent ae)
{

try
{
ResultSet rs=st.executeQuery("select max(userid) from personaldetails ");
while(rs.next())
{
uid=rs.getInt(1);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is ="+e);
}

if(ae.getSource()==b1)
{

if(Integer.valueOf(t1.getText())<=100)
{
JOptionPane.showMessageDialog(this,"Minimum Deposited Amount is 100Rs");
}
else
{
JOptionPane.showMessageDialog(this,""+t1.getText()+"Amount Deposited Sucessfully");
try
{
ResultSet rs=st.executeQuery("select balance from login where acno='"+accountno+"'");
while(rs.next())
{
 balance=(Integer.valueOf(rs.getString(1)))+(Integer.valueOf(t1.getText()));
}

st.executeUpdate("update login set balance='"+Integer.toString(balance)+"' where acno='"+accountno+"'");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is ="+e);
}

try
{
st.executeUpdate("Insert into Transaction (acno,amount,type,date,time,userid)values('"+accountno+"','"+t1.getText()
+"','Deposit','"+date+"','"+java.time.LocalTime.now()+"',"+uid+")");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is ="+e);
}


}
}
if(ae.getSource()==b2)
{
new Transaction();
}
}
public static void main(String args[])
{
new Deposit();
}

}