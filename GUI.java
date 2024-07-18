import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class GUI extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t3,t4,t5;

JButton b1,b2,b3,b4,b5,b6,b7,b8;
Connection cn;
Statement st;
ResultSet rs;
int status=0;

GUI()
{

l1=new JLabel("UserID:");
l1.setFont(new Font("Arial Black",Font.BOLD,20));
l1.setBounds(80,50,100,50);
add(l1);

t1=new JTextField();
t1.setFont(new Font("Arial Black",Font.BOLD,20));
t1.setBounds(200,60,200,30);
add(t1);




l2=new JLabel("ACNO:");
l2.setFont(new Font("Arial Black",Font.BOLD,20));
l2.setBounds(80,100,100,50);
add(l2);

t2=new JTextField();
t2.setFont(new Font("Arial Black",Font.BOLD,20));
t2.setBounds(200,110,200,30);
add(t2);

l3=new JLabel("PIN:");
l3.setFont(new Font("Arial Black",Font.BOLD,20));
l3.setBounds(80,150,100,50);
add(l3);

t3=new JTextField();
t3.setFont(new Font("Arial Black",Font.BOLD,20));
t3.setBounds(200,160,200,30);
add(t3);

l4=new JLabel("Balance:");
l4.setFont(new Font("Arial Black",Font.BOLD,20));
l4.setBounds(80,200,120,50);
add(l4);

t4=new JTextField();
t4.setFont(new Font("Arial Black",Font.BOLD,20));
t4.setBounds(200,210,200,30);
add(t4);

l5=new JLabel("Date:");
l5.setFont(new Font("Arial Black",Font.BOLD,20));
l5.setBounds(80,250,100,50);
add(l5);

t5=new JTextField();
t5.setFont(new Font("Arial Black",Font.BOLD,20));
t5.setBounds(200,260,200,30);
add(t5);

b1=new JButton("|<");
b1.setBounds(50,300,100,30);
add(b1);

b2=new JButton("<");
b2.setBounds(150,300,100,30);
add(b2);

b3=new JButton(">");
b3.setBounds(250,300,100,30);
add(b3);
b4=new JButton(">|");
b4.setBounds(350,300,100,30);
add(b4);
b5=new JButton("add");
b5.setBounds(50,350,100,30);
add(b5);
b6=new JButton("edit");
b6.setBounds(150,350,100,30);
add(b6);
b7=new JButton("save");
b7.setBounds(250,350,100,30);
add(b7);
b8=new JButton("exit");
b8.setBounds(350,350,100,30);
add(b8);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);





setLayout(null);
setVisible(true);
setSize(600,600);
setResizable(false);



try
{
Class.forName("org.postgresql.Driver");
cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankproject","postgres","Sandy");
st=cn.createStatement();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is "+e);
}

}

void getData()
{
try
{


t1.setText(rs.getString(5));
t2.setText(rs.getString(1));
t3.setText(rs.getString(2));
t4.setText(rs.getString(4));
t5.setText(rs.getString(3));



}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is "+e);
}
}

public void actionPerformed(ActionEvent ae)
{

try
{
if(ae.getSource()==b1)
{
rs=st.executeQuery("select *from login where userid=(select min(userid) from login)" );
rs.next();
getData();

}
/*
if(ae.getSource()==b2)
{
int k=Integer.parseInt(t1.getText());
k--;
rs=st.executeQuery("select *from Login where userid="+k);
if(rs.next())
getData();
else
JOptionPane.showMessageDialog(null,"This is a first Record");
}
if(ae.getSource()==b3)
{
int k=Integer.parseInt(t1.getText());
k++;
rs=st.executeQuery("select *from Login where userid="+k);
if(rs.next())
getData();
else
JOptionPane.showMessageDialog(null,"This is a last Record");
 
}
if(ae.getSource()==b4)
{
rs=st.executeQuery("select *from  login where user=(select max(userid) from Login )");
rs.next();
getData();

}

if(ae.getSource()==b5)
{
new PersonalDetails();
}

if(ae.getSource()==b6)
{
status=2;
}

if(ae.getSource()==b7)
{
if(t2.getText().trim().length()>0 && t3.getText().trim().length()>0)
{
if(status==1)
{
st.executeUpdate("insert into emp values("+t1.getText()+",'"+t2.getText()+"',"+t3.getText()+")");
JOptionPane.showMessageDialog(null,"Record inserted");

}
else
if(status==2)
{
st.executeUpdate("update emp set empname='"+t2.getText()+"',salary="+t3.getText()+" where empcode="+t1.getText());
JOptionPane.showMessageDialog(null,"Record updated");
}
status=0;
}
else
JOptionPane.showMessageDialog(null,"Incorrectb information");
}

if(ae.getSource()==b8)
{
rs.close();
st.close();
cn.close();
dispose();

}
}
*/
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is "+e);
}

}

public static void main(String args[])
{
new GUI();
}

}