import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Suggestion extends JFrame implements ActionListener {

    JButton submitButton, resetButton, backButton;
    JTextField movieNameField;
    JTextArea descriptionArea;

    Suggestion() {
        setSize(1500, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("suggestion.png"));
        Image i2 = i1.getImage().getScaledInstance(1500, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1500, 768);
        add(background);

    
        JLabel titleLabel = new JLabel("Add Your Suggestions Here");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(350, 10, 1000, 100);

        JLabel nameLabel = new JLabel("Name of the Movie:");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(100, 100, 200, 25);

        JLabel descriptionLabel = new JLabel("Describe your thoughts below:");
        descriptionLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setBounds(100, 150, 300, 25);

        movieNameField = new JTextField(20);
        movieNameField.setBounds(290, 100, 200, 25);

        descriptionArea = new JTextArea();
        descriptionArea.setBounds(100, 200, 500, 400);


        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 650, 100, 25);
        submitButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setBounds(320, 650, 100, 25);
        resetButton.addActionListener(this);

        backButton = new JButton("Back to Home");
        backButton.setBounds(1, 1, 150, 25);
        backButton.addActionListener(this);

        background.add(titleLabel);
        background.add(nameLabel);
        background.add(descriptionLabel);
        background.add(movieNameField);
        background.add(descriptionArea);
        background.add(submitButton);
        background.add(resetButton);
        background.add(backButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Suggestion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            movieNameField.setText("");
            descriptionArea.setText("");
        }

        if (e.getSource() == backButton) {
            new User_Interface().setVisible(true);
            dispose();
        }

        if (e.getSource() == submitButton) {
            String movie = movieNameField.getText().trim();
            String desc = descriptionArea.getText().trim();

            if (movie.equals("") || desc.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are mandatory.");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "INSERT INTO `Suggestion` (`select_movie`, `des`) VALUES ('" + movie + "', '" + desc + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thank you! Your suggestion has been submitted.");
                new Feedback().setVisible(true);
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }
}

