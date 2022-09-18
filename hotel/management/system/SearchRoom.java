package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton Back, Submit;
    JCheckBox checkbox;
    JComboBox JBbedtype;

    SearchRoom() {

        JLabel title = new JLabel("Search Room");
        title.setBounds(450, 20, 400, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(title);

        JLabel LBedType = new JLabel("Bed Type :");
        LBedType.setBounds(30, 100, 100, 25);
        add(LBedType);

        String str3[] = {"Single Bed ", "Double Bed"};
        JBbedtype = new JComboBox<>(str3);
        JBbedtype.setBounds(150, 100, 150, 25);
        JBbedtype.setBackground(Color.WHITE);
        add(JBbedtype);

        checkbox = new JCheckBox();
        checkbox.setBounds(600, 100, 30, 30);
        add(checkbox);

        JLabel Lcheckbox = new JLabel("Only display Available");
        Lcheckbox.setBounds(630, 100, 200, 25);
        add(Lcheckbox);

        table = new JTable();
        table.setBounds(30, 175, 900, 300);
        add(table);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(40, 150, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(210, 150, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(410, 150, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(600, 150, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(760, 150, 100, 20);
        add(l5);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from Room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.white);
        Submit.setBounds(550, 475, 100, 30);
        Submit.addActionListener(this);
        add(Submit);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(400, 475, 100, 30);
        Back.addActionListener(this);
        add(Back);

        setLayout(null);
        setBounds(300, 150, 1000, 550);
        setBackground(Color.white);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Submit) {

            try {

                String query = "select * from Room where bed_type = '" + JBbedtype.getSelectedItem() + "'";
                String query2 = "select * from Room where avilability = 'Avilable ' AND bed_type = '" + JBbedtype.getSelectedItem() + "'";
                                                        
                Conn conn = new Conn();
                ResultSet rs;
                if(checkbox.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else{
                      rs = conn.s.executeQuery(query);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {

            }

        } else if (e.getSource() == Back) {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
