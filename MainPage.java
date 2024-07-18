import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MainPage extends JFrame implements ActionListener
{
JLabel i,l1,l2;
JTextField t1;
JButton b1,b2;



MainPage()
{
ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("img/bank.png"));
i=new JLabel(img1);
i.setBounds(105,20,100,90);
add(i);
l1=new JLabel("Banking System!");
l1.setBounds(200,25,450,80);
l1.setFont(new Font("Arial Black",Font.BOLD,25));
add(l1);


l2=new JLabel("Login as..");
l2.setBounds(150,90,450,80);
l2.setFont(new Font("Arial Black",Font.BOLD,25));
l2.setBackground(Color.blue);
add(l2);

b1=new JButton("admin");
b1.setBounds(80,190,130,40);
b1.addActionListener(this);
b1.setFont(new Font("Arial Black",Font.BOLD,20));
//b1.setBackground(Color.blue);
add(b1);


b2=new JButton("user");
b2.setBounds(240,190,130,40);
b2.addActionListener(this);
b2.setFont(new Font("Arial Black",Font.BOLD,20));
add(b2);
 

setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(600,350);
Color c = new Color(255,150,0);
setBackground(c);
setResizable(false);

}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
new AdminLogin();
}

if(ae.getSource()==b2)
{
new LoginPage();
}
}


public static void main(String args[])
{
new MainPage();
}
}