package hotel.management.system;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    JButton Newcustomer, Rooms, Department, AllEmp, customerInfo, mangerInfo, chekcout, updateState, RoomStatus,
            Pickupservice, SearchRoom, LogOut;

    Reception() {
        setLayout(null);
        setBounds(350, 150, 800, 500);
        setBackground(Color.WHITE);

        Newcustomer = new JButton("New Customer Form");
        Newcustomer.setBackground(Color.black);
        Newcustomer.setForeground(Color.white);
        Newcustomer.setBounds(5, 30, 200, 30);
        Newcustomer.addActionListener(this);
        add(Newcustomer);

        Rooms = new JButton("Rooms");
        Rooms.setBackground(Color.black);
        Rooms.setForeground(Color.white);
        Rooms.setBounds(5, 65, 200, 30);
        Rooms.addActionListener(this);
        add(Rooms);

        Department = new JButton("Department");
        Department.setBackground(Color.black);
        Department.setForeground(Color.white);
        Department.setBounds(5, 100, 200, 30);
        Department.addActionListener(this);
        add(Department);

        AllEmp = new JButton("All Employees");
        AllEmp.setBackground(Color.black);
        AllEmp.setForeground(Color.white);
        AllEmp.setBounds(5, 135, 200, 30);
        AllEmp.addActionListener(this);
        add(AllEmp);

        customerInfo = new JButton("Customer Info");
        customerInfo.setBackground(Color.black);
        customerInfo.setForeground(Color.white);
        customerInfo.setBounds(5, 170, 200, 30);
        customerInfo.addActionListener(this);
        add(customerInfo);

        mangerInfo = new JButton("Manager Info");
        mangerInfo.setBackground(Color.black);
        mangerInfo.setForeground(Color.white);
        mangerInfo.setBounds(5, 205, 200, 30);
        mangerInfo.addActionListener(this);
        add(mangerInfo);

        chekcout = new JButton("Checkout");
        chekcout.setBackground(Color.black);
        chekcout.setForeground(Color.white);
        chekcout.setBounds(5, 240, 200, 30);
        chekcout.addActionListener(this);
        add(chekcout);

        updateState = new JButton("Update Status");
        updateState.setBackground(Color.black);
        updateState.setForeground(Color.white);
        updateState.setBounds(5, 275, 200, 30);
        updateState.addActionListener(this);
        add(updateState);

        RoomStatus = new JButton("Update Room Status");
        RoomStatus.setBackground(Color.black);
        RoomStatus.setForeground(Color.white);
        RoomStatus.setBounds(5, 310, 200, 30);
        RoomStatus.addActionListener(this);
        add(RoomStatus);

        Pickupservice = new JButton("Pickup Service");
        Pickupservice.setBackground(Color.black);
        Pickupservice.setForeground(Color.white);
        Pickupservice.setBounds(5, 345, 200, 30);
        add(Pickupservice);

        SearchRoom = new JButton("Search Room");
        SearchRoom.setBackground(Color.black);
        SearchRoom.setForeground(Color.white);
        SearchRoom.setBounds(5, 380, 200, 30);
        SearchRoom.addActionListener(this);
        add(SearchRoom);

        LogOut = new JButton("LogOut");
        LogOut.setForeground(Color.white);
        LogOut.setBackground(Color.BLACK);
        LogOut.setBounds(5, 415, 200, 30);
        LogOut.addActionListener(this);
        add(LogOut);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel i2 = new JLabel(i1);
        i2.setBounds(250, 30, 500, 400);
        add(i2);
        
        setVisible(true);
        
//        while (true) {
//            LogOut.setVisible(true);
//            try {
//                Thread.sleep(500);
//
//                LogOut.setVisible(false);
//                Thread.sleep(500);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Newcustomer) {
            setVisible(false);
            new AddCustromer();
        } else if (e.getSource() == Rooms) {
            setVisible(false);
            new Room();
        } else if (e.getSource() == Department) {
            setVisible(false);
            new Department();
        } else if (e.getSource() == AllEmp) {
            setVisible(false);
            new EmployeeInfro();
        } else if (e.getSource() == mangerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (e.getSource() == customerInfo) {
            setVisible(false);
            new CustomerInfo();
        } else if (e.getSource() == SearchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (e.getSource() == updateState) {
            setVisible(false);
            new UpdateCheck();
        } else if (e.getSource() == RoomStatus) {
            setVisible(false);
            new UpdateRoom();
        } else if (e.getSource() == chekcout) {
            setVisible(false);
            new CheckOut();
        } else if (e.getSource() == LogOut) {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
