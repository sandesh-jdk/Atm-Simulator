
package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fast extends JFrame implements ActionListener{
    
    JButton hundred,five,two,one,ten,fifty,back;
    String  pinnumber;
    Fast(String pinnumber){
       this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount ");
        text.setBounds(210,160,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
       hundred = new JButton("RS 100");
        hundred.setBounds(160,345,100,30);
        hundred.addActionListener(this);
        image.add(hundred);
        
         five = new JButton("Rs 500");
         five.setBounds(380,345,130,30);
        five.addActionListener(this);
        image.add(five);
        
          one = new JButton("RS 1000");
        one.setBounds(160,390,100,30);
        one.addActionListener(this);
        image.add(one);
        
          two= new JButton("RS 2000");
          two.setBounds(380,390,130,30);
          two.addActionListener(this);
        image.add(two);
        
        
        
         fifty= new JButton("Rs 5000");
          fifty.setBounds(160,440,100,30);
          fifty.addActionListener(this);
        image.add(fifty);
        
        
         ten= new JButton("Rs 10000");
         ten.setBounds(380,440,130,30);
          ten.addActionListener(this);
        image.add(ten);
        
        
         back= new JButton("Back");
          back.setBounds(380,490,130,30);
         back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); 
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance = 0; 
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                 Date date = new Date();
                 String query =("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
              
                 
                 
                     
                         setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
                
                
            }catch (Exception e){
                System.out.println(e);
            }
        }
            
    }
   
    public static void main(String args[]) {
        
        new Fast("");
        
    }
}
