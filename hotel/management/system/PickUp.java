package hotel.management.system;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class PickUp extends JFrame implements ActionListener {

    JButton Back;

    PickUp() {

        setLayout(null);
        setBounds(300, 150, 800, 400);
        setBackground(Color.white);
        setVisible(true);
        
        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setBounds(50, 50, 300, 30);
        add(l1);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(250, 300, 100, 30);
        Back.addActionListener(this);
        add(Back);

        JLabel text = new JLabel("Soory Pickup service is not available!");
        text.setForeground(Color.red);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(100, 100, 400, 30);
        add(text);

        while (true) {
            text.setVisible(true);
            try {
                Thread.sleep(500);
                text.setVisible(false);
                Thread.sleep(500);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new PickUp();
    }
}
