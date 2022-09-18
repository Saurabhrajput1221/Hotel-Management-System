package hotel.management.system;

import java.awt.Color;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener {

    Choice ccustomer;
    JLabel lroomNumber, lcheckintime, lcheckoutTime;
    JButton checkout, back;

    CheckOut() {
        JLabel text = new JLabel("CheckOut");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        JLabel lid = new JLabel("CheckOut");
        lid.setBounds(30, 80, 100, 30);
        add(lid);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);

        JLabel lroom = new JLabel("Room Number");
        lroom.setBounds(30, 130, 100, 30);
        add(lroom);

        lroomNumber = new JLabel();
        lroomNumber.setBounds(150, 130, 100, 30);
        add(lroomNumber);

        JLabel lcheckin = new JLabel("Check In Time");
        lcheckin.setBounds(30, 180, 100, 30);
        add(lcheckin);

        lcheckintime = new JLabel();
        lcheckintime.setBounds(150, 180, 100, 30);
        add(lcheckintime);

        JLabel lcheckout = new JLabel("Check Out");
        lcheckout.setBounds(30, 230, 100, 30);
        add(lcheckout);

        lcheckoutTime = new JLabel();
        lcheckoutTime.setBounds(150, 230, 100, 30);
        add(lcheckoutTime);

        Date date = new Date();
        lcheckoutTime = new JLabel("" + date);
        lcheckoutTime.setBounds(150, 230, 150, 30);
        add(lcheckoutTime);

        checkout = new JButton("CheckOut");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
                lroomNumber.setText(rs.getString("room"));
                lcheckintime.setText(rs.getString("checkin"));
            }
        } catch (Exception e) {

        }

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(335, 40, 450, 300);
        add(image2);

        setBounds(300, 200, 805, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkout) {

            String query = "delete from customer where number = '" + ccustomer.getSelectedItem() + "' ";
//     System.out.print("checkout");
            String query2 = "update Room set avilability = 'Available' where roomnumber = '" + lroomNumber.getText() + "'";

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                System.out.print("checkout");

                JOptionPane.showMessageDialog(null, "CheckOut done 👍");
                setVisible(false);
                new Reception();

            } catch (Exception ae) {
                // TODO: handle exception
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }

}
