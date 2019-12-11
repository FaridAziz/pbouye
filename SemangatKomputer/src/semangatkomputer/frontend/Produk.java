package semangatkomputer.frontend;

import semangatkomputer.backend.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Produk extends javax.swing.JFrame {

    public Produk() {
        initComponents();
        tampilkanData();
        tampilkanCmbProcessor();
        tampilkanCmbRam();
        tampilkanCmbVga();
        kosongkanForm();
    }
    public void kosongkanForm() {
        jTextFieldID.setText("0");
        jTextFieldJenis.setText("");
        jTextFieldMerk.setText("");
        jComboBoxProc.setSelectedIndex(0);
        jComboBoxRam.setSelectedIndex(0);
        jComboBoxVGA.setSelectedIndex(0);
        jTextFieldHarga.setText("");
    }
    
    public void tampilkanData() {
        String[] kolom = {"ID", "Jenis Barang", "Merk Barang", "Processor", "Ram", "VGA", "Harga"};
        ArrayList<Laptop> list = new Laptop().getAll();
        Object rowData[] = new Object[7];
        
        jTable1.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Laptop p : list){
            rowData[0] = p.getId_produk();
            rowData[1] = p.getJenis();
            rowData[2] = p.getMerk();
            rowData[3] = p.getProc().getMerk();
            rowData[4] = p.getRam().getKapasitas();
            rowData[5] = p.getVga().getBrand();
            rowData[6] = p.getHarga();
            
            ((DefaultTableModel)jTable1.getModel()).addRow(rowData);
        }
    }
    
    public void cari(String keyword) {
        String[] kolom = {"ID", "Jenis Barang", "Merk Barang", "Processor", "Ram", "VGA", "Harga"};
        ArrayList<Laptop> list = new Laptop().search(keyword);
        Object rowData[] = new Object[7];
        
        jTable1.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Laptop l : list) {
            rowData[0] = l.getId_produk();
            rowData[1] = l.getJenis();
            rowData[2] = l.getMerk();
            rowData[3] = l.getProc().getMerk();
            rowData[4] = l.getRam().getKapasitas();
            rowData[5] = l.getVga().getBrand();
            rowData[6] = l.getHarga();
            
            ((DefaultTableModel)jTable1.getModel()).addRow(rowData);
        }
    }
    
    public void tampilkanCmbProcessor () {
        jComboBoxProc.setModel(new DefaultComboBoxModel(new Processor().getAll().toArray()));
    }
    public void tampilkanCmbRam () {
        jComboBoxRam.setModel(new DefaultComboBoxModel(new Ram().getAll().toArray()));
    }
    public void tampilkanCmbVga () {
        jComboBoxVGA.setModel(new DefaultComboBoxModel(new Vga().getAll().toArray()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldJenis = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMerk = new javax.swing.JTextField();
        jTextFieldHarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonSimpan = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextFiledCari = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBoxProc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxRam = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxVGA = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("SEMANGAT KOMPUTER");

        jLabel2.setText("ID Produk ");

        jTextFieldID.setEditable(false);

        jLabel3.setText("Jenis Barang");

        jLabel4.setText("Merk Barang");

        jLabel6.setText("Harga");

        jButtonSimpan.setText("SIMPAN");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
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

        jTextFiledCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFiledCariActionPerformed(evt);
            }
        });

        jButtonSearch.setText("CARI");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Jenis Barang", "Merk Barang", "Processor", "Ram", "Vga", "Jumlah", "Harga"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBoxProc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProcActionPerformed(evt);
            }
        });

        jLabel7.setText("Processor");

        jLabel8.setText("Ram");

        jComboBoxRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRamActionPerformed(evt);
            }
        });

        jLabel9.setText("VGA");

        jComboBoxVGA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxVGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVGAActionPerformed(evt);
            }
        });

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Tambah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldJenis)
                                    .addComponent(jTextFieldMerk)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBoxProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(54, 54, 54)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton2)
                                                    .addComponent(jButton1)
                                                    .addComponent(jButton3))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(jComboBoxRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButtonSimpan)
                                                        .addGap(41, 41, 41)
                                                        .addComponent(jButtonAdd)
                                                        .addGap(50, 50, 50)
                                                        .addComponent(jButtonDelete)
                                                        .addGap(50, 50, 50)
                                                        .addComponent(jTextFiledCari, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel9)
                                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(126, 126, 126)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jComboBoxVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextFieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSearch)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(69, 69, 69)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFiledCari, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFiledCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFiledCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFiledCariActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        cari(jTextFiledCari.getText());
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int row = jTable1.getSelectedRow();
        Laptop l = new Laptop();
        
        l = l.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

        jTextFieldID.setText(String.valueOf(l.getId_produk()));
        jTextFieldJenis.setText(l.getJenis());
        jTextFieldMerk.setText(l.getMerk());
        jComboBoxProc.getModel().setSelectedItem(l.getProc());
        jComboBoxRam.getModel().setSelectedItem(l.getRam());
        jComboBoxVGA.getModel().setSelectedItem(l.getVga());
        jTextFieldHarga.setText(String.valueOf(l.getHarga()));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        Laptop l = new Laptop();
        l.setId_produk(Integer.parseInt(jTextFieldID.getText()));
        l.setJenis(jTextFieldJenis.getText());
        l.setMerk(jTextFieldMerk.getText());
        l.setProc((Processor)jComboBoxProc.getSelectedItem());
        l.setRam((Ram)jComboBoxRam.getSelectedItem());
        l.setVga((Vga)jComboBoxVGA.getSelectedItem());
        l.setHarga(Integer.parseInt(jTextFieldHarga.getText())); 
        l.save();
        jTextFieldID.setText(Integer.toString(l.getId_produk()));
        tampilkanData();
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int row = jTable1.getSelectedRow();

        Laptop l = new Laptop().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        l.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxVGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxVGAActionPerformed

    private void jComboBoxProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProcActionPerformed

    private void jComboBoxRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FormProcessor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new FormRam().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new FormVga().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JComboBox<String> jComboBoxProc;
    private javax.swing.JComboBox<String> jComboBoxRam;
    private javax.swing.JComboBox<String> jComboBoxVGA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldHarga;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldJenis;
    private javax.swing.JTextField jTextFieldMerk;
    private javax.swing.JTextField jTextFiledCari;
    // End of variables declaration//GEN-END:variables

}
