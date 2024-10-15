
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{

   
    JTextField pan,aadhar; 
    JRadioButton senior,senior2,existing,existing2;
    JButton next;   
    JComboBox religion,category,income,occupation,education;
    String formno;
    Signup2(String formno)
    {
        this.formno=formno;
      setLayout(null);
      
      setTitle("New Application Form - Page 2");
        
       
                
         JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
      additionalDetails.setBounds(290,40,400,30);
        add(additionalDetails);
        
        
        JLabel Religion = new JLabel("Religion :");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,100,100,30);
        add(Religion);
        
        String valreligion[] = {"Hindu","Sikh","Christian","Other"};
      religion = new JComboBox(valreligion);
        religion.setBounds(260, 100, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        
        JLabel Category = new JLabel("Category :");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,155,200,30);
        add(Category);
        
        String valcategory[] = {"General","OBC","NT-A","NT-B","NT-D","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(260, 155, 400, 30);
         category.setBackground(Color.WHITE);
        add(category);
        
        JLabel Income = new JLabel("Income :");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,210,200,30);
        add(Income);
        
         String incomecategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
         income = new JComboBox(incomecategory);
        income.setBounds(260,210,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
    
        JLabel Educational = new JLabel("Educational ");
        Educational.setFont(new Font("Raleway",Font.BOLD,20));
        Educational.setBounds(100,260,200,30);
        add(Educational);
       
         JLabel Qualification = new JLabel("Qualification :");
        Qualification.setFont(new Font("Raleway",Font.BOLD,20));
        Qualification.setBounds(100,285,200,30);
        add(Qualification);
        
         String educationvalues[] = {"Non-Graduation","Graduation","Post-Graduation","Phd","Others"};
         education = new JComboBox(educationvalues);
        education.setBounds(260,285,400,30);
       education.setBackground(Color.WHITE);
        add(education);
        
       
        
        JLabel occupational = new JLabel("Occupation :");
       occupational.setFont(new Font("Raleway",Font.BOLD,20));
        occupational.setBounds(100,360,200,30);
        add(occupational);
        
       String occupationvalues[] = {"Business","Self-Employed","Salaried","Student","Retired"};
         occupation = new JComboBox( occupationvalues);
        occupation.setBounds(260,360,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);      
        
        
        JLabel Pan = new JLabel("Pan NO :");
        Pan.setFont(new Font("Raleway",Font.BOLD,20));
         Pan.setBounds(100,410,200,30);
        add(Pan);
        
        
        
         pan = new JTextField();
       pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(260, 410, 400, 30);
        add(pan);
        
        JLabel Aadhar = new JLabel("Aadhar No:");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
       Aadhar.setBounds(100,460,200,30);
        add(Aadhar);
        
         aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
      aadhar.setBounds(260, 460, 400, 30);
        add(aadhar);
        
        JLabel Senior = new JLabel("Senior Citizen :");
       Senior.setFont(new Font("Raleway",Font.BOLD,20));
       Senior.setBounds(100,510,200,30);
        add(Senior);
        
         senior=new JRadioButton("Yes");
        senior.setBounds(260, 510, 60, 30);
        senior.setBackground(Color.WHITE);
        add(senior);
        
         senior2=new JRadioButton("NO");
        senior2.setBounds(360, 510, 120, 30);
        senior2.setBackground(Color.WHITE);
        add(senior2);    
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(senior);
        gendergroup.add(senior2);
        
          
        
        JLabel Existing = new JLabel("Existing Acc :");
      Existing.setFont(new Font("Raleway",Font.BOLD,20));
    Existing.setBounds(100,560,200,30);
        add(Existing);
        
         existing=new JRadioButton("Yes");
        existing.setBounds(260, 560, 60, 30);
        existing.setBackground(Color.WHITE);
        add(existing);
        
         existing2=new JRadioButton("No");
        existing2.setBounds(360, 560, 120, 30);
        existing2.setBackground(Color.WHITE);
        add(existing2);    
        
        ButtonGroup gendergroup2 = new ButtonGroup();
        gendergroup2.add(existing);
        gendergroup2.add(existing2);      
        
         
        
       next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(580,600,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
      
        String Religion = (String)religion.getSelectedItem();
        String Category = (String)category.getSelectedItem();
        String Income = (String)income.getSelectedItem();
        String Education =(String)education.getSelectedItem();
         String Occupation =(String)occupation.getSelectedItem();
          String Senior =null;
        if (senior.isSelected()){
            Senior = "Yes";
        }
        else if (senior2.isSelected()){
            Senior= "NO";
        }
      
        String Existing  = null;
        if (existing.isSelected()){
            Existing  = "Yes";
        }
        else if (existing2.isSelected()){
            Existing  = "No";
        }
        String Aadhar = aadhar.getText();
        String Pan = pan.getText();
         
        
        try{
                Conn c =  new Conn();
                String query = "insert into signup2 values('"+formno+"','"+Religion+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+Pan+"','"+Aadhar+"','"+Senior+"','"+Existing+"')";
               c.s.executeUpdate(query);
               setVisible(false);
               new Signup3(formno).setVisible(true);
            } 
             
        
            catch (Exception e){
            System.out.println(e);
        }
        
         
    }
   
    public static void main(String args[]) 
    {
            new Signup2("").setVisible(true);
         
    }
}
