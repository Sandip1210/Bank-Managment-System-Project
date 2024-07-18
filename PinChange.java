import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date; 
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
class PinChange extends JFrame implements ActionListener 
{
JLabel l1,l2;
JTextField t1,t2;
JButton b1,b2;
Date date;
String oldpin;
int uid;
Connection cn;
Statement st;
ResultSet rs;
public static String accountno=LoginPage.acno;
PinChange()
{
l1=new JLabel("Enter Old PIN");
l1.setBounds(50,50,300,40);
add(l1);
t1=new JTextField();
t1.setBounds(200,60,100,20);
add(t1);


l2=new JLabel("Set New PIN");
l2.setBounds(50,100,300,40);
add(l2);
t2=new JTextField();
t2.setBounds(200,110,100,20);
add(t2);

b1=new JButton("ChangePin");
b1.setBounds(150,140,120,30);
b1.addActionListener(this);
add(b1);



b2=new JButton("Back");
b2.setBounds(250,140,100,30);
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
try
{
ResultSet rs=st.executeQuery("select pin from login where acno='"+accountno+"'");
while(rs.next())
{
oldpin=rs.getString(1);
}


if(oldpin.equals(oldpin))
{
if(Integer.valueOf(t2.getText())<10000 && Integer.valueOf(t2.getText())>999)
{
JOptionPane.showMessageDialog(this,"Sucessfully pin Changed");
setVisible(false);

st.executeUpdate("update login set pin="+t2.getText()+" where acno='"+accountno+"'");

st.executeUpdate("Insert into Transaction(acno,type,date,time,userid)values('"+accountno+"','PinChange','"+date+"','"+java.time.LocalTime.now()+"',"+uid+")");
}


else
{
JOptionPane.showMessageDialog(this,"Enter only 4 number new pin");
}
}

else
JOptionPane.showMessageDialog(this,"Old pin does not match");
}

catch(Exception e)
{
JOptionPane.showMessageDialog(this,"");
}
}
if(ae.getSource()==b2)
{
new Transaction();
}
}

public static void main(String args[])
{
new PinChange();
}

}