import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener {
    JButton b, b1, b2;
    JTextField t1, t2, t3, t4;
    JPasswordField t5, t6;

    Signup() {
        setSize(1500, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Signup1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1500, 750);
        add(image);

        JLabel l7 = new JLabel("Create your account here");
        JLabel l1 = new JLabel("Name: ");
        JLabel l2 = new JLabel("Email id ");
        JLabel l3 = new JLabel("Contact number: ");
        JLabel l4 = new JLabel("PRN no: ");
        JLabel l5 = new JLabel("Password: ");
        JLabel l6 = new JLabel("Confirm password: ");

        l7.setBounds(550, 10, 1000, 100);
        l1.setBounds(500, 100, 100, 25);
        l2.setBounds(500, 150, 100, 25);
        l3.setBounds(440, 200, 200, 25);
        l4.setBounds(500, 250, 100, 25);
        l5.setBounds(480, 300, 150, 25);
        l6.setBounds(420, 350, 200, 25);

        Font font = new Font("Times New Roman", Font.BOLD, 20);
        Color white = Color.WHITE;

        l1.setFont(font); l1.setForeground(white);
        l2.setFont(font); l2.setForeground(white);
        l3.setFont(font); l3.setForeground(white);
        l4.setFont(font); l4.setForeground(white);
        l5.setFont(font); l5.setForeground(white);
        l6.setFont(font); l6.setForeground(white);
        l7.setFont(new Font("Times New Roman", Font.BOLD, 30)); l7.setForeground(white);

        t1 = new JTextField(20); 
        t2 = new JTextField(30); 
        t3 = new JTextField(12); 
        t4 = new JTextField(5); 
        t5 = new JPasswordField(50); 
        t6 = new JPasswordField(10); 

        t1.setBounds(600, 100, 200, 25);
        t2.setBounds(600, 150, 200, 25);
        t3.setBounds(600, 200, 200, 25);
        t4.setBounds(600, 250, 200, 25);
        t5.setBounds(600, 300, 200, 25);
        t6.setBounds(600, 350, 200, 25);

        b = new JButton("Submit");
        b.setBounds(580, 450, 100, 25);
        b.addActionListener(this);

        b1 = new JButton("Reset");
        b1.setBounds(700, 450, 100, 25);
        b1.addActionListener(this);

        b2 = new JButton("Back to Login");
        b2.setBounds(1, 1, 150, 25);
        b2.addActionListener(this);

        image.add(l1); image.add(l2); image.add(l3); image.add(l4);
        image.add(l5); image.add(l6); image.add(l7);
        image.add(t1); image.add(t2); image.add(t3); image.add(t4); image.add(t5); image.add(t6);
        image.add(b); image.add(b1); image.add(b2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b) {
        String name = t1.getText().trim();
        String email = t2.getText().trim();
        String contact = t3.getText().trim();
        String prn = t4.getText().trim();
        String password = new String(t5.getPassword());
        String confirmPassword = new String(t6.getPassword());

        if (name.isEmpty() || email.isEmpty() || contact.isEmpty() || prn.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are mandatory");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match!");
            return;
        }

        try {
            Conn c = new Conn();

            String query = "INSERT INTO users (name, email, contact_number, prn_no, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, contact);
            pstmt.setString(4, prn);
            pstmt.setString(5, password); 

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Successfully Signed up");
            new Login().setVisible(true);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    if (e.getSource() == b1) {
        t1.setText(""); t2.setText(""); t3.setText("");
        t4.setText(""); t5.setText(""); t6.setText("");
    }

    if (e.getSource() == b2) {
        new Login().setVisible(true);
        dispose();
    }
}
}
