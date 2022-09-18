package hotel.management.system;

import java.awt.Color;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.*;

public class EmployeeInfro extends JFrame implements ActionListener {

    JTable table;
    JButton Back;

    EmployeeInfro() {

        table = new JTable();
        table.setBounds(0, 40, 950, 400);
        add(table);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 5, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(180, 5, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(310, 5, 100, 20);
        add(l3);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(460, 5, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(600, 5, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(730, 5, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Job");
        l8.setBounds(860, 5, 100, 20);
        add(l8);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employees");
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
        new EmployeeInfro();
    }
}
