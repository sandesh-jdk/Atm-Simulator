
package atm.simulator;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Ministatement extends JFrame {
    
    
    Ministatement(String pinnumber){
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
         mini.setBounds(20,200,400,200);
        add(mini);
        
        JLabel bank = new JLabel("State Bank Of India");
        bank.setBounds(150,60,180,60);
        add(bank);
        
        JLabel card = new JLabel();
      card.setBounds(20,150,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,280,20);
        add(balance);
        
        try{
            Conn conn = new Conn();
            
           ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
           while(rs.next()){
               
               card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12));
         
           
           }
         
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{
            
            Conn conn = new Conn();
            int bal =0;
            String query = "select * from bank where pin = '"+pinnumber+"' order by date desc limit 4";
            System.out.println("My Mini stmt Query is "+query);
            ResultSet rs =conn.s.executeQuery(query);
            while(rs.next()){
                
                mini.setText( mini.getText() + "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>" );
             if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }    
            
            }
             balance.setText("Your current account balance is Rs" + bal);
            
            
        }catch (Exception e){
            
            System.out.println(e);
        }
        
       
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]) {
       
        new Ministatement("");
        
    }
}
