import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class movies extends javax.swing.JFrame {
    public movies() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLayeredPane1 = new javax.swing.JLayeredPane();
        name = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        screenc = new javax.swing.JComboBox();
        rating = new javax.swing.JComboBox();
        current = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLayeredPane1.setBackground(new java.awt.Color(204, 204, 255));
        jLayeredPane1.setOpaque(true);

        name.setBounds(220, 20, 60, 20);
        jLayeredPane1.add(name, javax.swing.JLayeredPane.DEFAULT_LAYER);

        date.setBounds(220, 140, 80, 20);
        jLayeredPane1.add(date, javax.swing.JLayeredPane.DEFAULT_LAYER);
        date.addActionListener(evt -> dateActionPerformed(evt));

        add.setFont(new java.awt.Font("Tahoma", 1, 11));
        add.setText("add");
        add.addActionListener(evt -> addActionPerformed(evt));
        add.setBounds(40, 200, 70, 23);
        jLayeredPane1.add(add, javax.swing.JLayeredPane.DEFAULT_LAYER);

        clear.setFont(new java.awt.Font("Tahoma", 1, 11));
        clear.setText("clear");
        clear.addActionListener(evt -> clearActionPerformed(evt));
        clear.setBounds(140, 200, 80, 23);
        jLayeredPane1.add(clear, javax.swing.JLayeredPane.DEFAULT_LAYER);

        back.setFont(new java.awt.Font("Tahoma", 1, 11));
        back.setText("back");
        back.addActionListener(evt -> backActionPerformed(evt));
        back.setBounds(370, 200, 80, 23);
        jLayeredPane1.add(back, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("MOVIE NAME:");
        jLabel1.setBounds(120, 20, 80, 20);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("SELECT SCREEN:");
        jLabel2.setBounds(100, 60, 100, 20);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("RATING:");
        jLabel3.setBounds(140, 100, 70, 20);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("DATE:");
        jLabel4.setBounds(150, 140, 60, 20);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        screenc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "screen 1", "screen 2", "screen 3", "screen 4" }));
        screenc.setBounds(220, 60, 100, 20);
        jLayeredPane1.add(screenc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        rating.setFont(new java.awt.Font("Tahoma", 1, 14));
        rating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*****", "****", "***", "**", "*" }));
        rating.setBounds(220, 100, 100, 20);
        jLayeredPane1.add(rating, javax.swing.JLayeredPane.DEFAULT_LAYER);

        current.setFont(new java.awt.Font("Tahoma", 1, 11));
        current.setText("current bookings");
        current.addActionListener(evt -> currentActionPerformed(evt));
        current.setBounds(227, 200, 140, 23);
        jLayeredPane1.add(current, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("YYYY-MM-DD");
        jLabel5.setBounds(230, 170, 80, 14);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "TITLE", "GENRE", "RATING", "DATE"
            }
        ));
        jScrollPane1.setViewportView(table);
        jScrollPane1.setBounds(30, 260, 452, 160);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) {
        Conn c = new Conn();
        try {
            String selectedRating = rating.getSelectedItem().toString();
            int ratingValue = selectedRating.length(); 

            String sql = "INSERT INTO movies (title, genre, duration, language, rating) VALUES ('"
                    + name.getText() + "','"
                    + screenc.getSelectedItem() + "','"
                    + "N/A','"
                    + date.getText() + "',"
                    + ratingValue + ")"; 

            c.s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Details are stored !!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        try {
            String sql = "SELECT title, genre, rating, language FROM movies";
            c.rs = c.s.executeQuery(sql);
            while (c.rs.next()) {
                dtm.addRow(new Object[] {
                        c.rs.getString("title"),
                        c.rs.getString("genre"),
                        c.rs.getString("rating"),
                        c.rs.getString("language")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage());
        }
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new Login().setVisible(true);
    }

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {
        name.setText("");
        date.setText("");
    }

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {
    
    }

    private void currentActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new User_Interface().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new movies().setVisible(true));
    }

    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JButton current;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox rating;
    private javax.swing.JComboBox screenc;
    private javax.swing.JTable table;
}
