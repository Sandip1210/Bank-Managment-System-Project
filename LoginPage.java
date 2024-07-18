import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class LoginPage extends JFrame implements ActionListener 
{
public static String acno;
JFrame frame=new JFrame();
JPasswordField t2;
JLabel i,i1,l1,l2,l3;
JTextField t1;
JButton b1,b2;
Connection cn;
Statement st;
ResultSet rs;



LoginPage()
{
ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("img/bank.png"));
i=new JLabel(img1);
i.setBounds(105,20,100,90);
add(i);

l1=new JLabel("Welcome To Banking System!");
l1.setBounds(200,25,450,80);
l1.setFont(new Font("Arial Black",Font.BOLD,25));
add(l1);

l2=new JLabel("ACNO:-");
l2.setBounds(250,135,180,89);
l2.setFont(new Font("Arial Black",Font.BOLD,20));
add(l2);
t1=new JTextField();
t1.setBounds(350,167,150,30);
add(t1);

l3=new JLabel("Password:-");
l3.setBounds(250,185,200,89);
l3.setFont(new Font("Arial Black",Font.BOLD,20));
add(l3);
t2=new JPasswordField();
t2.setBounds(380,210,160,30);
add(t2);

b1=new JButton("sign in");
b1.setBounds(310,270,80,40);
b1.setBackground(new Color(198,198,198));
b2=new JButton("sign up");
b2.setBounds(430,270,80,40);
b2.setBackground(Color.white);
add(b1);
add(b2);
b1.addActionListener(this);
b2.addActionListener(this);

ImageIcon img2=new ImageIcon(ClassLoader.getSystemResource("img/Bank.jpg"));
i1=new JLabel(img2);
i1.setBounds(-5,-5,800,800);
add(i1);

setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(800,550);
setResizable(false);


try
{
Class.forName("org.postgresql.Driver");
cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankproject","postgres","Sandy");
st=cn.createStatement();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is ="+e);
}

}


public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
acno=t1.getText();
try
{
if(t1.getText().trim().length()>0)
{
if(t2.getText().trim().length()>0)
{
ResultSet rs=st.executeQuery("select pin from Login where acno='"+ t1.getText()+"'");
 if(rs.next())
{
if(rs.getString(1).equals(t2.getText()))
{
new Transaction();
dispose();
}
else
JOptionPane.showMessageDialog(null,"Invalid Password");

}
else
{
JOptionPane.showMessageDialog(null,"Invalid User Name");
}

}
else
{
JOptionPane.showMessageDialog(null,"Plz Enter Password");
}

}
else
{
JOptionPane.showMessageDialog(null,"Plz Enter User name");
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is="+e);
}
}

if(ae.getSource()==b2)
{
new PersonalDetails();
setVisible(false);
}

}



public static void main(String args[])
{
new LoginPage();
}
}

