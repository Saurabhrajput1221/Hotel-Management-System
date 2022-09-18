package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JButton Addroom, Cancel;
    JTextField Roomfield, Fprice;
    JComboBox Favilable, Fclean, FBed, JbPrice;

    AddRooms() {
        JLabel Title = new JLabel("Add Rooms ");
        Title.setBounds(80, 30, 150, 25);
        Title.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(Title);

        JLabel RoomNo = new JLabel("Room Number :");
        RoomNo.setBounds(30, 70, 100, 25);
        add(RoomNo);

        Roomfield = new JTextField();
        Roomfield.setBounds(150, 70, 150, 25);
        add(Roomfield);

        JLabel laviLabel = new JLabel("Avilable :");
        laviLabel.setBounds(30, 120, 100, 25);
        add(laviLabel);

        String str[] = { "Avilable ", "Not Avilable" };
        Favilable = new JComboBox<>(str);
        Favilable.setBounds(150, 120, 150, 25);
        Favilable.setBackground(Color.WHITE);
        add(Favilable);

        JLabel lstatus = new JLabel("Cleaning Status :");
        lstatus.setBounds(30, 170, 100, 25);
        add(lstatus);

        String str2[] = { "Cleaned ", "Not Cleaned" };
        Fclean = new JComboBox<>(str2);
        Fclean.setBounds(150, 170, 150, 25);
        Fclean.setBackground(Color.WHITE);
        add(Fclean);

        JLabel price = new JLabel("Price :");
        price.setBounds(30, 210, 100, 25);
        add(price);

        String Fprice[] = { "500 ", "700", "900", "1200", "1500" };
        JbPrice = new JComboBox<>(Fprice);
        JbPrice.setBounds(150, 210, 150, 25);
        JbPrice.setBackground(Color.WHITE);
        add(JbPrice);

        JLabel LBedType = new JLabel("Bed Type :");
        LBedType.setBounds(30, 250, 100, 25);
        add(LBedType);

        String str3[] = { "Single Bed ", "Double Bed" };
        FBed = new JComboBox<>(str3);
        FBed.setBounds(150, 250, 150, 25);
        FBed.setBackground(Color.WHITE);
        add(FBed);

        Addroom = new JButton("Add Room");
        Addroom.setBounds(30, 300, 120, 30);
        Addroom.setBackground(Color.BLACK);
        Addroom.setForeground(Color.white);
        Addroom.addActionListener(this);
        add(Addroom);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.setBounds(170, 300, 120, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(320, 5, 450, 350);
        add(image);

        setBounds(350, 200, 800, 450);
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Addroom) {
            // System.out.println("hello");

            String roomnumber = Roomfield.getText();
            String avilability = (String) Favilable.getSelectedItem();
            String status = (String) Fclean.getSelectedItem();
            String price = (String) JbPrice.getSelectedItem();
            String type = (String) FBed.getSelectedItem();

            try {
                Conn conn = new Conn();
                String str = "insert into Room values('" + roomnumber + "','" + avilability + "','" + status + "','"
                        + price + "','" + type + "')";
                conn.s.executeLargeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room added succefully");

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == Cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }

}
