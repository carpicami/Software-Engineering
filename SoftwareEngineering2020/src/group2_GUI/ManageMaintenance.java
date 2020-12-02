/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2_GUI;

import group2.*;
import static group2_JDBC.DBProject.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.regex.*;
import static java.util.regex.Pattern.matches;

/**
 *
 * @author maria
 */
public class ManageMaintenance extends javax.swing.JFrame {

    private static List<String> activity_description = new ArrayList();
    private static List<Competencies> skills_needed = new ArrayList();
    private static List<String> skills_for_activity = new ArrayList();

    private static List<Maintainer> maintainer_pl = new ArrayList();
    private static List<Maintainer> maintainer_up = new ArrayList();
    public static List<PlannedActivity> planned_a = new ArrayList();
    public static List<UnplannedActivity> unplanned_a = new ArrayList();

    private static ManageMaintenance instance = null;  /*inizio implementazione SINGLETON PATTERN*/

    public ManageMaintenance() {
        initComponents();
    }

    public static ManageMaintenance getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new ManageMaintenance();
        }
        return instance;
    }  /*fine implementazione SINGLETON PATTERN*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ShowButton = new javax.swing.JButton();
        WeekText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ActivityTable = new javax.swing.JTable();
        Select1Button = new javax.swing.JButton();
        Select2Button = new javax.swing.JButton();
        Select3Button = new javax.swing.JButton();
        Select4Button = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Activity Selection");
        jLabel1.setToolTipText("");

        ShowButton.setBackground(new java.awt.Color(153, 153, 153));
        ShowButton.setText("Show");
        ShowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowButtonActionPerformed(evt);
            }
        });

        WeekText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeekTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Week n°");

        ActivityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "AREA", "TYPE", "ESTIMATED TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ActivityTable.setToolTipText("");
        ActivityTable.setName(""); // NOI18N
        ActivityTable.setRowHeight(29);
        jScrollPane1.setViewportView(ActivityTable);
        ActivityTable.getAccessibleContext().setAccessibleName("");

        Select1Button.setBackground(new java.awt.Color(153, 153, 153));
        Select1Button.setText("Select1");
        Select1Button.setMaximumSize(new java.awt.Dimension(73, 33));
        Select1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select1ButtonActionPerformed(evt);
            }
        });

        Select2Button.setBackground(new java.awt.Color(153, 153, 153));
        Select2Button.setText("Select2");
        Select2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select2ButtonActionPerformed(evt);
            }
        });

        Select3Button.setBackground(new java.awt.Color(153, 153, 153));
        Select3Button.setText("Select3");
        Select3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select3ButtonActionPerformed(evt);
            }
        });

        Select4Button.setBackground(new java.awt.Color(153, 153, 153));
        Select4Button.setText("Select4");
        Select4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select4ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Select3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Select4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Select2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Select1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(WeekText, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(ShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WeekText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Select1Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Select2Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Select3Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Select4Button))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WeekTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeekTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WeekTextActionPerformed

    private void Select1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select1ButtonActionPerformed
        int id_button = 1;
        selectEvent(id_button);
        getListOfMaintainer(id_button);
    }//GEN-LAST:event_Select1ButtonActionPerformed

    private void ShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowButtonActionPerformed
        String week = WeekText.getText();

        if (!matches("-?\\d+(\\.\\d+)?", week)) {
            JOptionPane p = new JOptionPane();
            JOptionPane.showMessageDialog(p, "ERRORE, hai inserito una stringa, non un numero", "ERROR!", JOptionPane.ERROR_MESSAGE);
            WeekText.setText("");
        } else {
            int w = Integer.parseInt(week);
            int row = 0;
            if ((w < 0 || w > 52) && matches("-?\\d+(\\.\\d+)?", week)) {
                JOptionPane p = new JOptionPane();
                JOptionPane.showMessageDialog(p, "ERRORE, non hai inserito il numero di settimana correttamente. Inserisci un numero tra 0 e 52", "ERROR!", JOptionPane.ERROR_MESSAGE);
                WeekText.setText("");
            }
            planned_a = popolaPlannedActivity(w);
            unplanned_a = popolaUnplannedActivity(w);

            ActivityTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String[]{
                        "ID", "AREA", "TYPE", "ESTIMATED TIME"
                    }
            ));
            for (int i = 0; i < planned_a.size(); i++) {
                PlannedActivity pa = planned_a.get(i);

                //ActivityTable da rivedere
                ActivityTable.setValueAt(pa.getID(), row, 0);
                ActivityTable.setValueAt(pa.getArea(), row, 1);
                ActivityTable.setValueAt(pa.getTipology(), row, 2);
                ActivityTable.setValueAt(pa.getEstimatedTime(), row, 3);
                activity_description.add(pa.getDescription());

                skills_needed = popolaSkillsPlanned(pa.getID());
                skills_for_activity.add(row, getSkillsActivity(skills_needed));
                row++;
            }
            for (int i = 0; i < unplanned_a.size(); i++) {
                UnplannedActivity up = unplanned_a.get(i);

                //ActivityTable da rivedere
                ActivityTable.setValueAt(up.getID(), row, 0);
                ActivityTable.setValueAt(up.getArea(), row, 1);
                ActivityTable.setValueAt(up.getTipology(), row, 2);
                ActivityTable.setValueAt(up.getEstimatedTime(), row, 3);
                activity_description.add(up.getDescription());

                skills_needed = popolaSkillsUnplanned(up.getID());
                skills_for_activity.add(row, getSkillsActivity(skills_needed));
                row++;
            }
        }
    }//GEN-LAST:event_ShowButtonActionPerformed

    private void Select2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select2ButtonActionPerformed
        int id_button = 2;
        selectEvent(id_button);
        getListOfMaintainer(id_button);
    }//GEN-LAST:event_Select2ButtonActionPerformed

    private void Select3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select3ButtonActionPerformed
        int id_button = 3;
        selectEvent(id_button);
        getListOfMaintainer(id_button);
    }//GEN-LAST:event_Select3ButtonActionPerformed

    private void Select4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Select4ButtonActionPerformed
        int id_button = 4;
        selectEvent(id_button);
        getListOfMaintainer(id_button);
    }//GEN-LAST:event_Select4ButtonActionPerformed

    private String getSkillsActivity(List<Competencies> s) {
        String a = "";
        for (int i = 0; i < s.size(); i++) {
            Competencies c = s.get(i);
            a += c.toString() + "\n";
        }
        return a;
    }

    private void selectEvent(int id_button) {
        String col = " ";
        MaintenanceActivityVerification mav = MaintenanceActivityVerification.getInstance(); //chiama singleton
        mav.setVisible(true);
        mav.WeekText2.setText(WeekText.getText());
        mav.WeekText2.setEditable(false);
        for (int i = 0; i < 3; i++) {
            col += "-" + (String) ActivityTable.getValueAt(id_button - 1, i);
        }
        col += "-" + ActivityTable.getValueAt(id_button - 1, 3);
        mav.ActivityText1.setText(col); //da finire
        mav.ActivityText1.setEditable(false);
        mav.DescriptionText.setText(activity_description.get(id_button - 1));
        mav.DescriptionText.setEditable(false);
        mav.SkillsText1.setText(skills_for_activity.get(id_button - 1));
        mav.SkillsText1.setEditable(false);
    }

    private void getListOfMaintainer(int id_button) { //da fare controllo su stesso nome perchè ha più di 1 competenza 
        MaintainerAvailability ma = MaintainerAvailability.getInstance(); //chiamata al singleton
        List<String> id_activity = new ArrayList();
        int row = 0;
        
        String id = (String) ActivityTable.getValueAt(id_button - 1, 0);

        for (int i = 0; i < planned_a.size(); i++) {
            if (planned_a.get(i).getID().equals(id)) {
                maintainer_pl = popolaMaintainerPlanned(planned_a.get(i).getID());
                for (int j = 0; j < maintainer_pl.size(); j++) {
                    Maintainer m = maintainer_pl.get(j);
                    ma.AvailabilityTable.setValueAt(m.getName(), row, 0);
                    row++;
                }
            }
        }
        
        for (int i = 0; i < unplanned_a.size(); i++) {
            if (unplanned_a.get(i).getID().equals(id)) {
                maintainer_up = popolaMaintainerUnplanned(unplanned_a.get(i).getID());
                for (int j = 0; j < maintainer_up.size(); j++) {
                    Maintainer m = maintainer_up.get(j);
                    ma.AvailabilityTable.setValueAt(m.getName(), row, 0);
                    row++;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {  //la gui deve sempre essere connessa al DB
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
            java.util.logging.Logger.getLogger(ManageMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageMaintenance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable ActivityTable;
    private javax.swing.JButton Select1Button;
    private javax.swing.JButton Select2Button;
    private javax.swing.JButton Select3Button;
    private javax.swing.JButton Select4Button;
    private javax.swing.JButton ShowButton;
    private javax.swing.JTextField WeekText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
