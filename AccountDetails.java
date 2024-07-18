//package MyProject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;
import java.util.Date;  


class AccountDetails extends JFrame implements ActionListener
{
JLabel i1,i2,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
JButton b1,b2;
Date date;
int uid;
String acno1,pin;

Connection cn;
Statement st;
ResultSet rs;
long acno;



    private void generateAccountNumber() {
      acno= System.currentTimeMillis();
}


 private  int  generateRandomPin() {
        Random random = new Random();
        // Generate a random 4-digit number (between 1000 and 9999)
        return 1000 + random.nextInt(9000);

}
AccountDetails()
{
//this.acno=acno;


//int p=generateRandomPin();
pin=Integer.toString(generateRandomPin());
 acno1=Long.toString(System.currentTimeMillis());
ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("img/bank.png"));
i1=new JLabel(img1);
i1.setBounds(105,0,100,90);
add(i1);

l1=new JLabel("Account Details"); 
l1.setFont(new Font("Arial Black",Font.BOLD,30));
l1.setBounds(200,18,600,60);
add(l1);

l2=new JLabel("Page3"); 
l2.setFont(new Font("Arial Black",Font.BOLD,15));
l2.setBounds(250,50,600,60);
add(l2);


l4=new JLabel("AC Number:"); 
l4.setFont(new Font("Aptos",Font.BOLD,20));
l4.setBounds(110,100,200,50);
add(l4);

l5=new JLabel(acno1);
l5.setFont(new Font("Aptos",Font.BOLD,20));
l5.setBounds(300,100,200,50);
add(l5);
l6=new JLabel("PIN:"); 
l6.setFont(new Font("Aptos",Font.BOLD,20));
l6.setBounds(110,150,200,50);
add(l6);
l7=new JLabel(pin);
l7.setFont(new Font("Aptos",Font.BOLD,20));
l7.setBounds(300,150,200,50);
add(l7);

b1=new JButton("submit");
b1.setBounds(150,200,80,50);
add(b1);

b2=new JButton("cancel");
b2.setBounds(250,200,80,50);
add(b2);
b1.addActionListener(this);
b2.addActionListener(this);

setLayout(null);
setVisible(true);
setTitle("Account Details");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(750,500);
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

}

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
try
{
st.executeUpdate("Insert into Login values("+acno+","+pin+",'"+date+"','0',"+uid+")");
JOptionPane.showMessageDialog(this,"Account Successfully Created\nACNO:\t"+acno1+"\nPIN:\t"+pin);
new Transaction();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is ="+e);
}
}
if(ae.getSource()==b2)
{
setVisible(false);
new LoginPage();
}




}
public static void main(String args[]) 
{
new AccountDetails();
}
}