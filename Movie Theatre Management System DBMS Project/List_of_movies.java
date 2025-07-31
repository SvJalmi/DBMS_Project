import javax.swing.*;
import java.sql.*;

public class List_of_movies extends JFrame {


    public List_of_movies() {
        initComponents();
    }
    private void initComponents() {

        jLabel6 = new JLabel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jComboBox3 = new JComboBox<>();
        jComboBox4 = new JComboBox<>();
        jLabel5 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MOVIE DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Algerian", 1, 36), new java.awt.Color(0, 204, 204))); 
        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); 

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jLabel1.setText("SELECT MOVIE:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jLabel2.setText("SELECT  THEATRE:");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Avengers ", "Thor", "Spider man" }));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inox", "City pride", "Bund garden", "PVR" }));

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00AM", "11:00AM", "2:00PM", "6:00PM", "9:00PM" }));

        jComboBox4.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20-04-2025", "20-04-2025", "20-04-2025", "20-04-2025" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jLabel5.setText("SELECT DATE:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jLabel3.setText("SELECT TIME:");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 24)); 

        jButton1.setFont(new java.awt.Font("Algerian", 1, 24)); 
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); 
        jLabel4.setText("NO OF TICKETS:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(190, 190, 190)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(74, 74, 74)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(206, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel5))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jButton1)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // --- YOUR NEW CODE STARTS HERE ---

    int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to book the tickets?", "Confirm Booking", JOptionPane.YES_NO_OPTION);

    if (confirmation == JOptionPane.YES_OPTION) {
        // This code only runs if the user clicks "Yes"
        workWithDatabase();
    }

    // --- YOUR NEW CODE ENDS HERE ---
}
    public void workWithDatabase()
    {
        String a=(String) jComboBox1.getSelectedItem();
        String b=(String) jComboBox2.getSelectedItem();
        String e=(String) jComboBox3.getSelectedItem();
        String f=(String) jComboBox4.getSelectedItem();
        String d=jTextField1.getText();


        Connection c=null;
        Statement  s=null;

        ResultSet rs=null;
        int flag=0;

        String N=jTextField1.getText();
        int N1=Integer.parseInt(N);
        int N2=N1;
        N1*=100;

        if(N2<10 && N2>0)

        {
            this.setVisible(false);  new recepit(a,b,e,d,N1,f).setVisible(true);

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql:///movie_ticket_management_system_CP","root","12345");
                s=c.createStatement();
                b=(String) jComboBox2.getSelectedItem();
                e=(String) jComboBox3.getSelectedItem();
                String q1=b;
                String q2=e;
                rs=s.executeQuery("select tickets from table3 where theatre="+"'"+q1+"'"+" and shows="+"'"+q2+"'");
                String bid=jTextField1.getText();
                int id=Integer.parseInt(bid);
                rs=s.executeQuery("select tickets from table3 where theatre="+"'"+q1+"'"+" and shows="+"'"+q2+"'");
                while(rs.next())
                {
                    String id1=rs.getString("tickets");
                    int id2=Integer.parseInt(id1);

                    id2=id2-N2;

                    s.executeUpdate("Update table3 set tickets="+id2+" where theatre="+"'"+q1+"'"+" and shows="+"'"+q2+"'");
                }

                while(rs.next())
                {
                    String tickets1=rs.getString("tickets");
                    String q3 = tickets1;


                }
        
            }
            catch(SQLException | ClassNotFoundException e1)
            {
                System.out.println(e1);
            }

        }


    }

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(List_of_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_of_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_of_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_of_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_of_movies().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
  
}