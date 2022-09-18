package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.*;

public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton Back;

    Room() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 0, 600, 500);
        add(image);

        table = new JTable();
        table.setBounds(0, 40, 500, 300);
        add(table);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(5, 5, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(110, 5, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(210, 5, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(300, 5, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(400, 5, 100, 20);
        add(l5);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from Room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(100, 350, 100, 30);
        Back.addActionListener(this);
        add(Back);

        setLayout(null);
        setBounds(300, 150, 1000, 550);
        setBackground(Color.white);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Room();
    }
}
