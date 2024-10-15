
package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,mini,fast,balanceenquiry,pinchange,exit;
    String  pinnumber;
    Transaction(String pinnumber){
       this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction ");
        text.setBounds(210,160,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
       deposit = new JButton("Deposit");
        deposit.setBounds(160,345,100,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Cash Withdrawl");
         withdrawl.setBounds(380,345,130,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
           fast= new JButton("Fast Cash ");
          fast.setBounds(160,390,100,30);
         fast.addActionListener(this);
        image.add(fast);
        
          mini= new JButton("Mini Statement");
          mini.setBounds(380,390,130,30);
          mini.addActionListener(this);
        image.add(mini);
        
        
        
         pinchange= new JButton("PinChange");
          pinchange.setBounds(160,440,100,30);
          pinchange.addActionListener(this);
        image.add(pinchange);
        
        
          balanceenquiry= new JButton("Balance Enquiry");
          balanceenquiry.setBounds(380,440,130,30);
          balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
          exit= new JButton("Exit");
          exit.setBounds(380,490,130,30);
         exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(1000,1000);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()==exit){
            System.exit(0);
        }else if (ae.getSource()==deposit){
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()== fast){
            setVisible(false);
            new Fast(pinnumber).setVisible(true);
            
    }else if (ae.getSource()== pinchange){
        setVisible(false);
        new Pinchange(pinnumber).setVisible(true);
    }else if (ae.getSource()== balanceenquiry){
        setVisible(false);
        new Balanceenquiry(pinnumber).setVisible(true);
        
    }else if (ae.getSource()== mini){
        new Ministatement(pinnumber).setVisible(true);

    }
    }
   
    public static void main(String args[]) {
        
        new Transaction("");
        
    }
}
