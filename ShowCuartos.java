package GUI;

import DB.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static DB.JavaDataBase.*;


/**
 *
 * @author DOOMSLAYER
 */
public class ShowCuartos extends javax.swing.JFrame implements  Database{

    /**
     * Creates new form ShowCuartos
     */
    public ShowCuartos() {
        initComponents();
        try {
            Connection connection = getConnection();
            DatabaseSearch(connection, null, jTable1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Cuarto", "Estado del Cuarto", "Tipo", "Capacidad", "STATUS_USO", "Huesped"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        ExitButton.setText("Salir");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ExitButton)
                                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ExitButton)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        MainMenu newframe = new MainMenu();
        newframe.setVisible(true);

        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowCuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowCuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowCuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowCuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowCuartos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton ExitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    @Override
    public void DatabaseSearch(Connection connection, String string, JTable table) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from rooms where STATUS_USO = 'OCUPADO'");
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                String RoomNumber = String.valueOf(rs.getInt(1));
                String RoomStatus = rs.getString(2);
                String RoomType = rs.getString(3);
                String capacity = String.valueOf(rs.getInt(4));
                String available = rs.getString(5);
                String host = rs.getString(6);

                String tbData[] = {RoomNumber, RoomStatus, RoomType, capacity, available, host};
                DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
                tblModel.addRow(tbData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // End of variables declaration
}
