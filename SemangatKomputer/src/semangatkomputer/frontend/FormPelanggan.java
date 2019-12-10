package semangatkomputer.frontend;

import semangatkomputer.backend.Pelanggan;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FormPelanggan extends javax.swing.JFrame {

    public FormPelanggan() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }
    public void kosongkanForm(){
        jTextFieldID.setText("0");
        jTextFieldNama.setText("");
        jTextFieldEmail.setText("");
        jTextFieldTelp.setText("");
    }
    
    public void tampilkanData(){
        String[] kolom = {"ID", "Nama", "Email", "Telepon"};
        ArrayList<Pelanggan> list = new Pelanggan().getAll();
        Object rowData[] = new Object[4];
        
        jTable1.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Pelanggan A : list){
            rowData[0] = A.getIdpelanggan();
            rowData[1] = A.getNama();
            rowData[2] = A.getEmail();
            rowData[3] = A.getTelepon();
            
            ((DefaultTableModel)jTable1.getModel()).addRow(rowData);
        }
    }
    
    public void cari(String keyword){
        String[] kolom = {"ID", "Nama", "Email", "Telepon"};
        ArrayList<Pelanggan> list = new Pelanggan().search(keyword);
        Object rowData[] = new Object[4];
        
        jTable1.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Pelanggan A : list){
            rowData[0] = A.getIdpelanggan();
            rowData[1] = A.getNama();
            rowData[2] = A.getEmail();
            rowData[3] = A.getTelepon();
            
            ((DefaultTableModel)jTable1.getModel()).addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTelp = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldCari = new javax.swing.JTextField();
        jButtonCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("SEMANGAT KOMPUTER");

        jLabel2.setText("ID Pelanggan");

        jTextFieldID.setEditable(false);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Pelanggan");

        jLabel4.setText("Email");

        jLabel5.setText("Telepon");

        jButtonSave.setText("SIMPAN");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonAdd.setText("TAMBAH BARU");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setText("HAPUS");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTextFieldCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCariActionPerformed(evt);
            }
        });

        jButtonCari.setText("CARI");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonSave))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldNama)
                                            .addComponent(jTextFieldEmail)
                                            .addComponent(jTextFieldTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jButtonAdd)
                                        .addGap(33, 33, 33)
                                        .addComponent(jButtonDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                        .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCari)))))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCari, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jTextFieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCariActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        Pelanggan A = new Pelanggan();
        A.setIdpelanggan(Integer.parseInt(jTextFieldID.getText()));
        A.setNama(jTextFieldNama.getText());
        A.setEmail(jTextFieldEmail.getText());
        A.setTelepon(jTextFieldTelp.getText());
        A.save();
        jTextFieldID.setText(Integer.toString(A.getIdpelanggan()));
        tampilkanData();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int row = jTable1.getSelectedRow();
        
        Pelanggan A = new Pelanggan().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        A.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        cari(jTextFieldCari.getText());
    }//GEN-LAST:event_jButtonCariActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int row = jTable1.getSelectedRow();
        
        jTextFieldID.setText(model.getValueAt(row, 0).toString());
        jTextFieldNama.setText(model.getValueAt(row, 1).toString());
        jTextFieldEmail.setText(model.getValueAt(row, 2).toString());
        jTextFieldTelp.setText(model.getValueAt(row, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCari;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldTelp;
    // End of variables declaration//GEN-END:variables
}