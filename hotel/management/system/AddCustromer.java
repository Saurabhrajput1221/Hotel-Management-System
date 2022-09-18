package hotel.management.system;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

public class AddCustromer extends JFrame implements ActionListener {

    JTextField FNumber, FCountry, FDeposite, FName;
    JComboBox JbId, JBGender;
    Choice croom;
    JButton Add, Back;
    JLabel CheckInTime;

    AddCustromer() {
        JLabel Title = new JLabel("NEW CUSTOMER FORM");
        Title.setBounds(50, 10, 500, 40);
        Title.setFont(new Font("Tahoma", 300, 20));
        Title.setForeground(Color.blue);
        add(Title);

        JLabel Lid = new JLabel("ID :");
        Lid.setBounds(20, 50, 50, 30);
        add(Lid);

        String str[] = {"Passport", "Adharcard", "Voter id", "Ration Card", "Driving Liecences"};
        JbId = new JComboBox<>(str);
        JbId.setBounds(120, 50, 150, 25);
        add(JbId);

        JLabel LNumber = new JLabel("ID Number :");
        LNumber.setBounds(20, 90, 80, 30);
        add(LNumber);

        FNumber = new JTextField();
        FNumber.setBounds(120, 90, 150, 25);
        add(FNumber);

        JLabel LName = new JLabel("Name :");
        LName.setBounds(20, 130, 80, 30);
        add(LName);

        FName = new JTextField();
        FName.setBounds(120, 130, 150, 25);
        add(FName);

        JLabel LGender = new JLabel("Gender :");
        LGender.setBounds(20, 170, 50, 30);
        add(LGender);

        String str2[] = {"Male", "Female"};
        JBGender = new JComboBox<>(str2);
        JBGender.setBounds(120, 170, 150, 25);
        add(JBGender);

        JLabel LCountry = new JLabel("Country :");
        LCountry.setBounds(20, 210, 80, 30);
        add(LCountry);

        FCountry = new JTextField();
        FCountry.setBounds(120, 210, 150, 25);
        add(FCountry);

        JLabel LAllocatedRoom = new JLabel("Room Number :");
        LAllocatedRoom.setBounds(20, 250, 100, 30);
        add(LAllocatedRoom);

        croom = new Choice();
        croom.setBounds(120, 250, 150, 25);
        add(croom);

        try {
            Conn conn = new Conn();
            String query = "select * from Room where avilability = 'Avilable '";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel LCheckinTime = new JLabel("Checkin Time :");
        LCheckinTime.setBounds(20, 290, 100, 30);
        add(LCheckinTime);

        Date date = new Date();

        CheckInTime = new JLabel(" " + date);
        CheckInTime.setBounds(120, 290, 150, 25);
        add(CheckInTime);

        JLabel LDeposit = new JLabel("Deposit :");
        LDeposit.setBounds(20, 320, 80, 30);
        add(LDeposit);

        FDeposite = new JTextField();
        FDeposite.setBounds(120, 320, 150, 25);
        add(FDeposite);

        Add = new JButton("ADD");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.white);
        Add.setBounds(20, 360, 100, 30);
        Add.addActionListener(this);
        add(Add);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(140, 360, 100, 30);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 300, 400);
        add(image);

        setBounds(400, 150, 700, 450);
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Add) {

            String id = (String) JbId.getSelectedItem();
            String idNumber = FNumber.getText();
            String name = FName.getText();
            String gender = (String) JBGender.getSelectedItem();
            String country = FCountry.getText();
            String roomnumber = croom.getSelectedItem();
            String time = CheckInTime.getText();
            String deposit = FDeposite.getText();
            try {
                String query = "insert into customer values ('" + id + "','" + idNumber + "','" + name + "','" + gender
                        + "', '" + country + "','" + roomnumber + "','" + time + "','" + deposit + "') ";
                
//                 "insert into employees values('" + name + "','" + age + "','" + gender + "', '" + salary
//                    + "', '" + phone + "', '" + email + "','" + job + "') ";
                String query2 = "update Room set avilability = 'Not Avilable' where roomnumber = '" + roomnumber + "' ";

                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer successfully");
                setVisible(false);
                new Reception();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == Back) {
            setVisible(false);
            System.out.println("hello");
            new Reception();
        }

    }

    public static void main(String[] args) {
        new AddCustromer();
    }

}
