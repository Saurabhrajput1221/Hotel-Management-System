package hotel.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfsalary, tfphone, tfemail;
    JLabel lblname, lblage, lblsalary, lblphone, lblemail, lblgender, lbljob;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;

    AddEmployee() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);

        lblname = new JLabel("NAME :");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        lblage = new JLabel("AGE :");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        lblgender = new JLabel("GENDER :");
        lblgender.setBounds(60, 120, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 120, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 120, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        lbljob = new JLabel("JOB: ");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbljob);

        String str[] = { "Front desk clerks ", "Poters", " Housekeeping", "Manager", "Waiters", "Kitchen Staff",
                "Room Service" };
        cbjob = new JComboBox<>(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        lblsalary = new JLabel("SALARY :");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        lblphone = new JLabel("PHONE :");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        lblemail = new JLabel("EMAIL :");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(100, 400, 120, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 380);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();

        String gender = null;
        if(name.equals("" ) && age.equals("") && salary.equals("") && phone.equals("")&& email.equals("")){
            JOptionPane.showMessageDialog(null , "somthing is empty fill all the fields");
            return;
        }
        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "FEMALE";
        }

        String job = (String) cbjob.getSelectedItem();

        try {
            Conn conn = new Conn();

            String query = "insert into employees values('" + name + "','" + age + "','" + gender + "', '" + salary
                    + "', '" + phone + "', '" + email + "','" + job + "') ";

            conn.s.executeLargeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added sucessfully");
            System.out.print("hello");
            setVisible(false);
        } catch (Exception ae) {

        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }

}
