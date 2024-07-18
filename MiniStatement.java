import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
    
public class MiniStatement extends JFrame 
{    
Connection cn;
Statement st;
ResultSet rs;
int i,j;
String a[][]=new String[100][7];
public static String accountno=LoginPage.acno;
MiniStatement()
{   
try
{
Class.forName("org.postgresql.Driver");
cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankproject","postgres","Sandy");
st=cn.createStatement();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Error is"+e);
}
try
{
/*
rs=st.executeQuery("select max(userid) from personaldetails");
rs.next();
int uid=rs.getInt(1);
  */  
for(i=0;i<25;i++)
{
rs=st.executeQuery("select * from transaction where srno="+(i+1));
while(rs.next())
{

if(accountno.equals(rs.getString(2)))

{

for(j=0;j<7;j++)
{
a[i][j]=rs.getString(j+1);
}//for
}//if
}//if next
rs.next();
}//for
  
    String column[]={"srno","AccountNo","Amount","type","date","time","userid"};
    JTable jt=new JTable(a,column);
    jt.setBounds(100,100,200,300);
    add(jt);          
    JScrollPane sp=new JScrollPane(jt);
    add(sp);          
    setSize(800,400);    
    setVisible(true);
    setLocation(330,430);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    rs.close();
    st.close();
    cn.close();   
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is"+e);
}
}     

public static void main(String[] args) {    
    new MiniStatement();    
}    
}


