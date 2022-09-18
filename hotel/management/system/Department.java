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

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton Back;

    Department() {

        table = new JTable();
        table.setBounds(15, 40, 550, 280);
        add(table);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(50, 5, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(400, 5, 100, 20);
        add(l2);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(250, 330, 100, 30);
        Back.addActionListener(this);
        add(Back);

        setLayout(null);
        setBounds(300, 150, 600, 400);
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
        new Department();
    }
}
