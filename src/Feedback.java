import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Feedback extends JFrame implements ActionListener {
    JButton b;

    Feedback(){
        setSize(10000, 800);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("feedback.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,768, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1500,750);
        add(image);
        setSize(10000, 800);
        setVisible(true);

        b = new JButton("Back to Home");
        b.setBounds(1,1,150,25);
        b.addActionListener(this);

        JLabel l1 = new JLabel("Thanks for sharing your valuable feedback!");
        l1.setBounds(200, 300,1200,100);
        l1.setFont(new Font("Times New Roman",Font.BOLD,50));
        l1.setForeground(Color.white);
        image.add(l1);
        image.add(b);
    }
    public static void main(String[] args) {
        new Feedback();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b){
            new User_Interface().setVisible(true);
            dispose();
        }

    }

}