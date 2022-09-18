package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {
    JButton AddDriver, Cancel;
    JTextField Namefield, Fcarmodel, Fcompany, Agefield;
    JComboBox Jbavilable, JbGender;

    AddDrivers() {
        JLabel Title = new JLabel("Add Drivers ");
        Title.setBounds(80, 30, 150, 25);
        Title.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(Title);

        JLabel Name = new JLabel("Name :");
        Name.setBounds(30, 70, 100, 25);
        add(Name);

        Namefield = new JTextField();
        Namefield.setBounds(120, 70, 150, 25);
        add(Namefield);

        JLabel Lage = new JLabel("Age :");
        Lage.setBounds(30, 115, 100, 25);
        add(Lage);

        Agefield = new JTextField();
        Agefield.setBounds(120, 115, 150, 25);
        add(Agefield);

        JLabel LGender = new JLabel("Gender :");
        LGender.setBounds(30, 145, 100, 25);
        add(LGender);

        String str2[] = { "Male ", "Female" };
        JbGender = new JComboBox<>(str2);
        JbGender.setBounds(120, 145, 150, 25);
        JbGender.setBackground(Color.WHITE);
        add(JbGender);

        JLabel Lcarmodel = new JLabel("Car Model :");
        Lcarmodel.setBounds(30, 175, 100, 25);
        add(Lcarmodel);

        Fcarmodel = new JTextField();
        Fcarmodel.setBounds(120, 175, 150, 25);
        add(Fcarmodel);

        JLabel Lcompany = new JLabel("Car Company :");
        Lcompany.setBounds(30, 205, 100, 25);
        add(Lcompany);

        Fcompany = new JTextField();
        Fcompany.setBounds(120, 205, 150, 25);
        add(Fcompany);

        JLabel Lavilable = new JLabel("Available :");
        Lavilable.setBounds(30, 235, 100, 25);
        add(Lavilable);

        String str3[] = { "Available ", "Not Available" };
        Jbavilable = new JComboBox<>(str3);
        Jbavilable.setBounds(120, 235, 150, 25);
        Jbavilable.setBackground(Color.WHITE);
        add(Jbavilable);

        AddDriver = new JButton("Add Driver");
        AddDriver.setBounds(30, 300, 120, 30);
        AddDriver.setBackground(Color.BLACK);
        AddDriver.setForeground(Color.white);
        AddDriver.addActionListener(this);
        add(AddDriver);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.setBounds(170, 300, 120, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 5, 450, 380);
        add(image);

        setBounds(350, 200, 800, 450);
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddDriver) {
            // System.out.println("hello");

            String name = Namefield.getText();
            String age = (String) Agefield.getText();
            String Gender = (String) JbGender.getSelectedItem();
            String model = (String) Fcarmodel.getText();
            String company = (String) Fcompany.getText();
            String avilability = (String) Jbavilable.getSelectedItem();

            if(name.equals("" ) && age.equals("") && Gender.equals("") && model.equals("")&& company.equals("")){
            JOptionPane.showMessageDialog(null , "somthing is empty fill all the fields");
            return;
        }

            try {
                Conn conn = new Conn();
                String str = "insert into AddDriver values('" + name + "','" + age +
                        "','" + Gender + "','"
                        + model + "','" + company + "','" + avilability + "')";
                conn.s.executeLargeUpdate(str);
                JOptionPane.showMessageDialog(null, "Added Driver succefully");

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == Cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }

}
