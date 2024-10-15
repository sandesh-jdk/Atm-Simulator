package atm.simulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    Pinchange(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 30));
        text.setBounds(210, 220, 400, 40);
        image.add(text);

        JLabel pintext = new JLabel("New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        pintext.setBounds(170, 350, 400, 20);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(320, 350, 150, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        repintext.setBounds(170, 390, 400, 20);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds(320, 390, 150, 25);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(355, 440, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 480, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(1000, 1000);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {

                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin does not Match");
                    return;
                }

                if (npin.equals("")) {

                    JOptionPane.showMessageDialog(null, "Please Enter New Pin");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin ");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "Update  bank set pin = '" + rpin + "'Where pin='" + pinnumber + "'";
                String query2 = "Update Login set pin = '" + rpin + "'Where pin='" + pinnumber + "'";
                String query3 = "Update Signup3 set pin = '" + rpin + "'Where pin='" + pinnumber + "'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Pinchange("").setVisible(true);
    }
}
