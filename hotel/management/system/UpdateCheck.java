package hotel.management.system;

import java.awt.Color;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField FRoomNumber, Fname, FcheckIn, Fpaid, Fpending;
    JButton Check, Update, Back;

    UpdateCheck() {

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
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

        JLabel lname = new JLabel("Name");
        lname.setBounds(30, 160, 100, 20);
        add(lname);

        Fname = new JTextField();
        Fname.setBounds(200, 160, 150, 25);
        add(Fname);

        JLabel lcheckIn = new JLabel("Check In Time");
        lcheckIn.setBounds(30, 200, 100, 20);
        add(lcheckIn);

        FcheckIn = new JTextField();
        FcheckIn.setBounds(200, 200, 150, 25);
        add(FcheckIn);

        JLabel lpaid = new JLabel("Amount Paid");
        lpaid.setBounds(30, 240, 100, 20);
        add(lpaid);

        Fpaid = new JTextField();
        Fpaid.setBounds(200, 240, 150, 25);
        add(Fpaid);

        JLabel lpending = new JLabel("Pending Amount");
        lpending.setBounds(30, 280, 100, 20);
        add(lpending);

        Fpending = new JTextField();
        Fpending.setBounds(200, 280, 150, 25);
        add(Fpending);

        Check = new JButton("Check");
        Check.setForeground(Color.white);
        Check.setBackground(Color.black);
        Check.setBounds(30, 340, 100, 30);
        Check.addActionListener(this);
        add(Check);

        Update = new JButton("Update");
        Update.setForeground(Color.white);
        Update.setBackground(Color.black);
        Update.setBounds(150, 340, 100, 30);
        Update.addActionListener(this);
        add(Update);

        Back = new JButton("Back");
        Back.setForeground(Color.white);
        Back.setBackground(Color.black);
        Back.setBounds(270, 340, 100, 30);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300, 200, 980, 500);
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
                    Fname.setText(rs.getString("name"));
                    FcheckIn.setText(rs.getString("checkIn"));
                    Fpaid.setText(rs.getString("deposit"));
                }

                ResultSet rs2 = conn.s.executeQuery("select * from Room where roomnumber ='"+FRoomNumber.getText()+"'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountpaid = Integer.parseInt(price) - Integer.parseInt(Fpaid.getText());
                     System.out.print(amountpaid);
                    Fpending.setText("0" + amountpaid);
                
                }
            } catch (Exception ae) {
            }
        } else if (e.getSource() == Update) {
            String number = ccustomer.getSelectedItem();
            String room = FRoomNumber.getText();
            String name = Fname.getText();
            String checkin = FcheckIn.getText();
            String deposit = Fpaid.getText();

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update customer set room = '" + room + "' ,name ='" + name + "' ,checkin='" + checkin + "',deposite='" + deposit + "' where number = '"+number+ "' ");
                JOptionPane.showMessageDialog(null, "Data Updated successfully");
                setVisible(false);
                new Reception();

            } catch (Exception qe) {
            }

        } else if (e.getSource() == Back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }

}
