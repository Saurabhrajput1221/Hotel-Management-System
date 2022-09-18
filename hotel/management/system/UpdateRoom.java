package hotel.management.system;

import java.awt.Color;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField FRoomNumber, Favailable, Fclean, Fpaid;
    JButton Check, Update, Back;

    UpdateRoom() {

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(30, 20, 250, 30);
        text.setForeground(Color.blue);
        add(text);

        JLabel lid = new JLabel("Customer Id");
        lid.setBounds(30, 89, 100, 20);
        add(lid);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {

        }

        JLabel lroom = new JLabel("Room Number");
        lroom.setBounds(30, 120, 100, 20);
        add(lroom);

        FRoomNumber = new JTextField();
        FRoomNumber.setBounds(200, 120, 150, 25);
        add(FRoomNumber);

        JLabel lavailable = new JLabel("Availability");
        lavailable.setBounds(30, 160, 100, 20);
        add(lavailable);

        Favailable = new JTextField();
        Favailable.setBounds(200, 160, 150, 25);
        add(Favailable);

        JLabel lcleaning = new JLabel("Cleaning status");
        lcleaning.setBounds(30, 200, 100, 20);
        add(lcleaning);

        Fclean = new JTextField();
        Fclean.setBounds(200, 200, 150, 25);
        add(Fclean);

        Check = new JButton("Check");
        Check.setForeground(Color.white);
        Check.setBackground(Color.black);
        Check.setBounds(30, 300, 100, 30);
        Check.addActionListener(this);
        add(Check);

        Update = new JButton("Update");
        Update.setForeground(Color.white);
        Update.setBackground(Color.black);
        Update.setBounds(150, 300, 100, 30);
        Update.addActionListener(this);
        add(Update);

        Back = new JButton("Back");
        Back.setForeground(Color.white);
        Back.setBackground(Color.black);
        Back.setBounds(270, 300, 100, 30);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(380, 50, 500, 300);
        add(image);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300, 200, 900, 420);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '" + id + "'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while (rs.next()) {
                    FRoomNumber.setText(rs.getString("room"));
                    Favailable.setText(rs.getString("name"));
                }

                ResultSet rs2 = conn.s.executeQuery("select * from Room where roomnumber ='" + FRoomNumber.getText() + "'");
                while (rs2.next()) {

                    Favailable.setText(rs2.getString("avilability"));
                    Fclean.setText(rs2.getString("cleaning_status"));

                }
            } catch (Exception ae) {
            }
        } else if (e.getSource() == Update) {
            String number = ccustomer.getSelectedItem();
            String room = FRoomNumber.getText();
            String available = Favailable.getText();
            String status = Fclean.getText();

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update Room set avilability = '" + available + "' ,cleaning_status ='" + status + "' where roomnumber ='"+room+"' ");
                JOptionPane.showMessageDialog(null, "Data Updated successfully");
                setVisible(false);
                new Reception();

            } catch (Exception qe) {
                //TODO: handle exception
            }

        } else if (e.getSource() == Back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }

}
