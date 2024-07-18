import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class PersonalDetails extends JFrame implements ItemListener,ActionListener
{
JLabel i1,i2,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,date,t14,t15;
JRadioButton rd1,rd2,rd3;
JButton b1;
static int count=0;
Connection cn;
Statement st;
ResultSet rs;

PersonalDetails()
{

ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("img/bank.png"));
i1=new JLabel(img1);
i1.setBounds(105,0,100,90);
add(i1);

l1=new JLabel("APPLIOCTION FORM NO.8989"); 
l1.setFont(new Font("Arial Black",Font.BOLD,30));
l1.setBounds(200,18,600,60);
add(l1);


l2=new JLabel("PAGE 1"); 
l2.setFont(new Font("Arial Black",Font.BOLD,20));
l2.setBounds(350,60,300,50);
add(l2);

l3=new JLabel("Personal Details"); 
//l3.setFont(new Font("Arial Black",Font.BOLD,10));
l3.setBounds(330,80,400,50);
add(l3);

l4=new JLabel("Name:"); 
l4.setFont(new Font("Aptos",Font.BOLD,20));
l4.setBounds(110,130,100,50);
add(l4);
t1=new JTextField();
t1.setBounds(300,140,200,30);
add(t1);


l5=new JLabel("Father Name:"); 
l5.setFont(new Font("Aptos",Font.BOLD,20));
l5.setBounds(110,180,200,50);
add(l5);
t2=new JTextField();
t2.setBounds(300,190,200,30);
add(t2);

l6=new JLabel("Mother Name:"); 
l6.setFont(new Font("Aptos",Font.BOLD,20));
l6.setBounds(110,230,200,50);
add(l6);
t3=new JTextField();
t3.setBounds(300,240,200,30);
add(t3);

l7=new JLabel("Gender:"); 
l7.setFont(new Font("Aptos",Font.BOLD,20));
l7.setBounds(110,280,200,50);
add(l7);

rd1=new JRadioButton("Male");
rd2=new JRadioButton("Femal");
rd3=new JRadioButton("Other");
ButtonGroup bg=new ButtonGroup();
add(rd1);
add(rd2);
add(rd3);
bg.add(rd1);
bg.add(rd2);
bg.add(rd3);
rd1.setBounds(300,290,100,30);
rd2.setBounds(400,290,100,30);
rd3.setBounds(500,290,100,30);


rd1.addItemListener(this);
rd2.addItemListener(this);
rd3.addItemListener(this);



l8=new JLabel("Date Of Birth:"); 
l8.setFont(new Font("Aptos",Font.BOLD,20));
l8.setBounds(110,320,200,50);
add(l8);
date=new JTextField();
date.setBounds(300,340,200,30);
add(date);


l9=new JLabel("Address:"); 
l9.setFont(new Font("Aptos",Font.BOLD,20));
l9.setBounds(110,370,200,50);
add(l9);
t5=new JTextField();
t5.setBounds(300,390,200,30);
add(t5);

l10=new JLabel("Nationality:"); 
l10.setFont(new Font("Aptos",Font.BOLD,20));
l10.setBounds(110,420,200,50);
add(l10);
t9=new JTextField();
t9.setBounds(300,440,200,30);
add(t9);


l11=new JLabel("State:"); 
l11.setFont(new Font("Aptos",Font.BOLD,20));
l11.setBounds(110,470,200,50);
add(l11);
t10=new JTextField();
t10.setBounds(300,490,200,30);
add(t10);



l12=new JLabel("Dist:"); 
l12.setFont(new Font("Aptos",Font.BOLD,20));
l12.setBounds(110,520,200,50);
add(l12);
t11=new JTextField();
t11.setBounds(300,540,200,30);
add(t11);

l13=new JLabel("Tal:"); 
l13.setFont(new Font("Aptos",Font.BOLD,20));
l13.setBounds(110,570,200,50);
add(l13);
t12=new JTextField();
t12.setBounds(300,590,200,30);
add(t12);

l14=new JLabel("Pin Code:"); 
l14.setFont(new Font("Aptos",Font.BOLD,20));
l14.setBounds(110,620,200,50);
add(l14);
t13=new JTextField();
t13.setBounds(300,640,200,30);
add(t13);






l16=new JLabel("Mobile No:");
l16.setFont(new Font("Aptos",Font.BOLD,20));
l16.setBounds(110,680,250,50);
add(l16);

t14=new JTextField();
t14.setBounds(300,690,200,30);
add(t14);

l17=new JLabel("Email ID:");
l17.setFont(new Font("Aptos",Font.BOLD,20));
l17.setBounds(110,720,250,50);
add(l17);

t15=new JTextField();
t15.setBounds(300,730,200,30);
add(t15);


b1=new JButton("Next..");
b1.setBounds(600,770,100,30);
b1.addActionListener(this);
add(b1);


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
String gender=null;

if(rd1.isSelected())
   gender="Male";
else if(rd2.isSelected())
   gender="Female";
else if(rd3.isSelected())
    gender="Other";
 
if(ae.getSource()==b1)
{
try
{
st.executeUpdate("Insert into personaldetails(name,fname,mname,gender,bdate,address,nationality,state,dist,tal,pincode,mno,email) values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+gender+"','"+date.getText()+"','"+t5.getText()+"','"+t9.getText()+"','"+t10.getText()+"','"+t11.getText()+"','"+t12.getText()+"',"+t13.getText()+",'"+t14.getText()+"','"+t15.getText()+"')");
count=0;
}
catch(Exception e)
{
count=1;
JOptionPane.showMessageDialog(this,e);
}
  
if(count==0)
{
setVisible(false);
new AdditonalDetails();
}
}
}
public static void main(String atrgs[])
{
new PersonalDetails();
}
}                                                                                                