
package atm.simulator;
import java.awt.*;// used for image
import javax.swing.*;//used for Jframe package
import java.awt.event.*;//used for ActionListener
import java.sql.*;//used for connection
public class Login extends JFrame implements ActionListener {
    JButton clear,login,signup;
    JTextField cardTextField;
    JPasswordField  pinTextField;
    
    Login(){
        setTitle("Automated teller machine");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(150,10,100,100);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,40,400,40);
        add(text); 
        
        JLabel cardno = new JLabel("Card No");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(180,150,400,40);
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300, 160,280,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(180,220,400,40);
        add(pin);
        
         pinTextField = new  JPasswordField();
        pinTextField.setBounds(300, 230,280,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
         login = new JButton("SIGN IN");
                login.setBounds(300 ,300,100,30);
                login.setBackground(Color.BLACK);
                login.setForeground(Color.WHITE);
                login.addActionListener(this);
                add(login);
        
                clear = new JButton("clear");
              clear.setBounds(480 ,300,100,30);
                clear.setBackground(Color.BLACK);
                clear.setForeground(Color.WHITE);
                clear.addActionListener(this);
                add(clear);
                
                 signup = new JButton("SIGN UP");
              signup.setBounds(300 ,350,280,30);
               signup .setBackground(Color.BLACK);
                signup.setForeground(Color.WHITE);
                signup.addActionListener(this);
                add(signup);
                
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(200 , 100);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        
        }else if (ae.getSource()==login){
            
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
             String query = "select * from Login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transaction( pinnumber).setVisible(true);
                     
                 }else {
                     
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                 }
                
            }catch(Exception e){
                
              
                
                System.out.println(e);
            }
        
        }else if (ae.getSource()==signup){
            setVisible(false);
            new SignupOne() .setVisible(true);
        
        }
    
    
    }
    public static void main (String args[])
    {
      new Login();
    
    
    }
    
}
