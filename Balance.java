import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class Balance extends JFrame implements ActionListener
{
JLabel l1,l2;
Connection cn;
Statement st;
ResultSet rs;
String ba;
public static String accountno=LoginPage.acno;

Balance()
{
l1=new JLabel("Current Account Balance");
l1.setBounds(80,60,300,30);
l1.setFont(new Font("Arial Black",Font.BOLD,20));
add(l1);



setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(500,300);
getContentPane().setBackground(Color.orange);
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
try
{
ResultSet rs=st.executeQuery("select balance from login where acno='"+accountno+"'");
while(rs.next())
{
ba=rs.getString(1);
}
}

catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is ="+e);
}

l2=new JLabel(ba+"Rs");
l2.setBounds(150,100,300,30);
l2.setFont(new Font("Arial Black",Font.BOLD,20));
add(l2);
}
public void actionPerformed(ActionEvent ae)
{
}
public static void main(String args[])
{
new Balance();
}
} 