package hotel.management.system;

import java.awt.Color;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton Back;

    CustomerInfo() {

        table = new JTable();
        table.setBounds(0, 40, 950, 400);
        add(table);

        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 5, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Id Number");
        l2.setBounds(130, 5, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(250, 5, 100, 20);
        add(l3);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(370, 5, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(490, 5, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Room Number");
        l7.setBounds(610, 5, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Check In");
        l8.setBounds(740, 5, 100, 20);
        add(l8);
        
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(860, 5, 100, 20);
        add(l9);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(450, 450, 100, 30);
        Back.addActionListener(this);
        add(Back);

        setLayout(null);
        setBounds(200, 150, 1000, 550);
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
        new CustomerInfo();
    }
}
