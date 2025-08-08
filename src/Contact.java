import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Contact extends JFrame implements ActionListener {

    JButton submitBtn, resetBtn, backBtn;
    JTextField nameField, emailField, phoneField;
    JTextArea messageArea;

    Contact() {
        setSize(1500, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("contact.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(1500, 768, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(scaledImg));
        background.setBounds(0, 0, 1500, 768);
        add(background);

        JLabel title = new JLabel("Contact Us");
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setBounds(550, 10, 1000, 100);

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email id:");
        JLabel phoneLabel = new JLabel("Phone no:");
        JLabel messageLabel = new JLabel("Message:");

        Font labelFont = new Font("Times New Roman", Font.PLAIN, 20);
        nameLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);
        messageLabel.setFont(labelFont);

        nameLabel.setForeground(Color.WHITE);
        emailLabel.setForeground(Color.WHITE);
        phoneLabel.setForeground(Color.WHITE);
        messageLabel.setForeground(Color.WHITE);

        nameLabel.setBounds(370, 100, 100, 25);
        emailLabel.setBounds(370, 150, 150, 25);
        phoneLabel.setBounds(370, 200, 150, 25);
        messageLabel.setBounds(370, 250, 150, 25);

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        messageArea = new JTextArea();

        nameField.setBounds(475, 100, 200, 25);
        emailField.setBounds(475, 150, 200, 25);
        phoneField.setBounds(475, 200, 200, 25);
        messageArea.setBounds(475, 250, 500, 250);

        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");
        backBtn = new JButton("Back to Home");

        submitBtn.setBounds(490, 550, 100, 25);
        resetBtn.setBounds(600, 550, 100, 25);
        backBtn.setBounds(1, 1, 150, 25);

        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        backBtn.addActionListener(this);

        background.add(title);
        background.add(nameLabel);
        background.add(emailLabel);
        background.add(phoneLabel);
        background.add(messageLabel);
        background.add(nameField);
        background.add(emailField);
        background.add(phoneField);
        background.add(messageArea);
        background.add(submitBtn);
        background.add(resetBtn);
        background.add(backBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Contact();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            new User_Interface().setVisible(true);
            dispose();
        } else if (e.getSource() == resetBtn) {
            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
            messageArea.setText("");
        } else if (e.getSource() == submitBtn) {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String message = messageArea.getText().trim();

            if (name.equals("") || email.equals("") || phone.equals("") || message.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are mandatory");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "INSERT INTO `Contact` (`Name`, `Email_id`, `Phone_no`, `Message`) " +
                               "VALUES ('" + name + "', '" + email + "', '" + phone + "', '" + message + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Thank you! Your message has been submitted.");
                new Submitted().setVisible(true);
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }
}
