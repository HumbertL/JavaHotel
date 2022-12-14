package GUI;

import DB.DatabaseUpdates;
import HotelRelated.Reservacion;

import static DB.JavaDataBase.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author DOOMSLAYER
 */
public class ReservationModify extends javax.swing.JFrame implements DatabaseUpdates {

    /**
     * Creates new form ReservationModify
     */
    public ReservationModify(Reservacion reservacion) {
        setReservation(reservacion);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ExitDateDay = new javax.swing.JSpinner(new SpinnerNumberModel(reservation.getEnd().getDayOfMonth(), reservation.getEnd().getDayOfMonth(),31, 1));
        ModifyExit = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        ExitDateMonth = new javax.swing.JSpinner(new SpinnerNumberModel(reservation.getEnd().getMonthValue(), reservation.getEnd().getMonthValue(), 12, 1));
        ExitYearSpinner = new javax.swing.JSpinner(new SpinnerNumberModel(reservation.getEnd().getYear(), reservation.getEnd().getYear(), 2023, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambiar Fechas");

        jLabel2.setText("Check-Out");

        ModifyExit.setBackground(new java.awt.Color(102, 102, 102));
        ModifyExit.setText("Modificar");
        ModifyExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyExitActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Cancelar)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ExitDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ExitDateMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ExitYearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(ModifyExit)))
                                .addContainerGap(29, Short.MAX_VALUE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(ExitDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ExitDateMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ExitYearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Cancelar)
                                        .addComponent(ModifyExit))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }// </editor-fold>

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
    }

    private void ModifyExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int modifyday = (Integer) ExitDateDay.getValue();
        int modifymonth = (Integer) ExitDateMonth.getValue();
        int ModifyYear = (Integer) ExitYearSpinner.getValue();
        try {
            LocalDate localDate = LocalDate.of(ModifyYear, modifymonth, modifyday);
            Connection connection = getConnection();
            ReservationChangeCheckOut(connection, localDate, reservation.getReservationNumber());

            System.out.println(localDate);
        }
        catch (DateTimeException dateTimeException)
        {
            JOptionPane.showMessageDialog(null, "Fecha erronea", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }


    public void setReservation(Reservacion reservation) {
        this.reservation = reservation;
    }

    // Variables declaration - do not modify
    private Reservacion reservation;
    private javax.swing.JButton Cancelar;
    private javax.swing.JSpinner ExitDateDay;
    private javax.swing.JSpinner ExitDateMonth;
    private javax.swing.JSpinner ExitYearSpinner;
    private javax.swing.JButton ModifyExit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;

    @Override
    public void ChangeDates(Connection connection, LocalDate NewCheckOut, int ReservationNumber) {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement( "UPDATE hosts SET Salida = ? where ID_COMPRA = ?");
            preparedStatement.setDate(1, Date.valueOf(NewCheckOut));
            preparedStatement.setInt(2, ReservationNumber);
            preparedStatement.executeUpdate();
            PreparedStatement statement = connection.prepareStatement( "UPDATE reservations SET ExitDate = ? where ReservationID = ?");
            statement.setDate(1, Date.valueOf(NewCheckOut));
            statement.setInt(2, ReservationNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // End of variables declaration
}
