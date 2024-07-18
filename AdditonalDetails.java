import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class AdditonalDetails extends JFrame implements ItemListener,ActionListener
{
JLabel i1,i2,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
JRadioButton rd1,rd2,rd3,rd4,rd5,rd6;
JButton b1;
JComboBox cb1;
Connection cn;
Statement st;
ResultSet rs;
int uid;
String str1[]={" ","<50000","<100000","<150000","Upto1000000","Above1000000"};



AdditonalDetails()
{
ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("img/bank.png"));
i1=new JLabel(img1);
i1.setBounds(105,0,100,90);
add(i1);

l1=new JLabel("Additonal Details"); 
l1.setFont(new Font("Arial Black",Font.BOLD,30));
l1.setBounds(200,18,600,60);
add(l1);


l2=new JLabel("PAGE 2"); 
l2.setFont(new Font("Arial Black",Font.BOLD,20));
l2.setBounds(350,60,300,50);
add(l2);


l4=new JLabel("Rellgion:"); 
l4.setFont(new Font("Aptos",Font.BOLD,20));
l4.setBounds(110,130,100,50);
add(l4);
t1=new JTextField();
t1.setBounds(300,140,200,30);
add(t1);


l5=new JLabel("Category:"); 
l5.setFont(new Font("Aptos",Font.BOLD,20));
l5.setBounds(110,180,200,50);
add(l5);
t2=new JTextField();
t2.setBounds(300,190,200,30);
add(t2);

l6=new JLabel("Income:"); 
l6.setFont(new Font("Aptos",Font.BOLD,20));
l6.setBounds(110,230,200,50);
add(l6);
cb1=new JComboBox(str1);
cb1.setFont(new Font("Aptos",Font.BOLD,20));
cb1.setBounds(300,240,200,30);
add(cb1);


l7=new JLabel("Educational"); 
l7.setFont(new Font("Aptos",Font.BOLD,20));
l7.setBounds(110,280,200,50);
add(l7);
l8=new JLabel("Qualification:"); 
l8.setFont(new Font("Aptos",Font.BOLD,20));
l8.setBounds(110,300,200,50);
add(l8);
t3=new JTextField();
t3.setBounds(300,290,200,30);
add(t3);

l9=new JLabel("Occuption:"); 
l9.setFont(new Font("Aptos",Font.BOLD,20));
l9.setBounds(110,350,200,50);
add(l9);
t4=new JTextField();
t4.setFont(new Font("Aptos",Font.BOLD,20));
t4.setBounds(300,360,200,30);
add(t4);

l10=new JLabel("PAN Number:"); 
l10.setFont(new Font("Aptos",Font.BOLD,20));
l10.setBounds(110,400,200,50);
add(l10);
t5=new JTextField();
t5.setFont(new Font("Aptos",Font.BOLD,20));
t5.setBounds(300,410,200,30);
add(t5);

l11=new JLabel("Aadhar Number:"); 
l11.setFont(new Font("Aptos",Font.BOLD,20));
l11.setBounds(110,450,200,50);
add(l11);
t6=new JTextField();
t6.setFont(new Font("Aptos",Font.BOLD,20));
t6.setBounds(300,460,200,30);
add(t6);


l12=new JLabel("Senior Citizen:"); 
l12.setFont(new Font("Aptos",Font.BOLD,20));
l12.setBounds(110,500,200,50);
add(l12);
rd1=new JRadioButton("Yes");
rd2=new JRadioButton("No");
ButtonGroup bg=new ButtonGroup();
add(rd1);
add(rd2);
bg.add(rd1);
bg.add(rd2);
rd1.setBounds(300,510,100,50);
rd2.setBounds(400,510,100,50);
rd1.addItemListener(this);
rd2.addItemListener(this);


l13=new JLabel("Existing Account:"); 
l13.setFont(new Font("Aptos",Font.BOLD,20));
l13.setBounds(110,550,200,50);
add(l13);
rd3=new JRadioButton("Yes");
rd4=new JRadioButton("No");
ButtonGroup bg1=new ButtonGroup();
add(rd3);
add(rd4);
bg1.add(rd3);
bg1.add(rd4);
rd3.setBounds(300,560,100,50);
rd4.setBounds(400,560,100,50);
rd3.addItemListener(this);
rd4.addItemListener(this);


b1=new JButton("Next..");
b1.setBounds(600,700,100,30);
b1.addActionListener(this);
add(b1);

l16=new JLabel("Account type:"); 
l16.setFont(new Font("Aptos",Font.BOLD,20));
l16.setBounds(110,600,200,50);
add(l16);
rd5=new JRadioButton("Saving");
rd6=new JRadioButton("Current");
ButtonGroup bg2=new ButtonGroup();
add(rd5);
add(rd6);
bg2.add(rd5);
bg2.add(rd6);
rd5.setBounds(300,600,100,40);
rd6.setBounds(400,600,100,40);
rd5.addItemListener(this);
rd6.addItemListener(this);


ImageIcon img2=new ImageIcon(ClassLoader.getSystemResource("img/bank3.jpg"));
i2=new JLabel(img2);
i2.setBounds(0,120,800,700);
add(i2);


l15=new JLabel("Note:Fill All Information Correctly..");
l15.setFont(new Font("Arial Black",Font.ITALIC,20));
l15.setBounds(150,820,500,50);
add(l15);


setLayout(null);
setVisible(true);
setTitle("Personal Details");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(750,900);
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
public void itemStateChanged(ItemEvent ie)
{
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String scitizen=null,exac=null,actype=null;

if(rd1.isSelected())
   scitizen="Yes";
else if(rd2.isSelected())
   scitizen="No";

if(rd3.isSelected())
   exac="Yes";
else if(rd4.isSelected())
  exac="No";

if(rd5.isSelected())
  actype="Saving";
else if(rd6.isSelected())
   actype="Current";

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


try
{
st.executeUpdate("Insert into additionaldetails values('"+t1.getText()+"','"+t2.getText()+"','"+cb1.getSelectedItem()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"',"+t6.getText()+",'"+scitizen+"','"+exac+"','"+actype+"',"+uid+")");
}
catch(Exception e)
{

JOptionPane.showMessageDialog(this,e);
}
setVisible(false);
new AccountDetails();
}
}

public static void main(String atrgs[])
{
new AdditonalDetails();
}
}



