import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JButton b, b1;
    JTextField t1;
    JPasswordField p1;

    Login() {
        JLabel l1 = new JLabel("Username: ");
        JLabel l2 = new JLabel("Password: ");
        JLabel l3 = new JLabel("Login here");

        t1 = new JTextField();
        p1 = new JPasswordField();
        b = new JButton("LOGIN");
        b1 = new JButton("Sign up");

        l1.setBounds(490, 100, 150, 25);
        l2.setBounds(490, 150, 150, 25);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);

        l3.setBounds(600, 10, 1000, 100);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 35));
        l3.setForeground(Color.white);

        t1.setBounds(600, 100, 200, 25);
        p1.setBounds(600, 150, 200, 25);

        b.setBounds(640, 200, 100, 25);
        b.addActionListener(this);

        b1.setBounds(640, 250, 100, 25);
        b1.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/image/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1500, 750);
        add(image);

        setSize(1500, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        image.add(l1);
        image.add(l2);
        image.add(l3);
        image.add(t1);
        image.add(p1);
        image.add(b);
        image.add(b1);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            String email = t1.getText().trim();
            String password = new String(p1.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are mandatory");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM users WHERE email = ? AND password = ?";
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, email);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    new User_Interface().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }

        if (e.getSource() == b1) {
            new Signup().setVisible(true);
            dispose();
        }
    }
}

