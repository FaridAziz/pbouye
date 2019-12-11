package semangatkomputer.frontend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import semangatkomputer.backend.*;


public class FormPembelian extends javax.swing.JFrame {

   
    public FormPembelian() {
        initComponents();
        tampilkanCmbPelanggan();
        tampilkanCmbProduk();
        kosongkanForm();
        tampilkanData();
        showTable();
    }
    
    void showTable(){
        DefaultTableModel model = new DefaultTableModel();
        tbpembelian.setModel(model);
        
        model.addColumn("ID_PEMBELIAN");
        model.addColumn("ID_PELANGGAN");
        model.addColumn("ID_PRODUK");
        model.addColumn("Tanggal Pembelian");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        Connection connection = Koneksi.getConnection();
        
        try{
            Statement s = connection.createStatement();
            String sql = "SELECT * FROM pembelian";
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                Object[] rowData = new Object[4];
                rowData[0] = rs.getInt("id_pembelian");
                rowData[1] = rs.getInt("id_pelanggan");
                rowData[2] = rs.getInt("id_produk");
                rowData[3] = rs.getString("tanggal_pembelian");
                
                model.addRow(rowData);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
     public void kosongkanForm() {
        txtid.setText("0");
        cmbidPelanggan.setSelectedIndex(0);
        cmbidProduk.setSelectedIndex(0);
        txttanggal.setText("");
    }

    public void cari(String keyword) {
        String[] kolom = {"ID_PEMBELIAN", "ID_PELANGGAN", "ID_PRODUK", "Tanggal Pembelian"};
        ArrayList<Pembelian> list = new Pembelian().search(keyword);
        Object rowData[] = new Object[4];
        
        tbpembelian.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Pembelian p : list) {
            rowData[0] = p.getId_pembelian();
            rowData[1] = p.getpelanggan().getNama();
            rowData[2] = p.getproduk().getMerk();
            rowData[3] = p.getTanggal_pembelian();
            
            ((DefaultTableModel)tbpembelian.getModel()).addRow(rowData);
        }
    }
    
    public void tampilkanCmbPelanggan () {
        cmbidPelanggan.setModel(new DefaultComboBoxModel(new Pelanggan().getAll().toArray()));
    }
    public void tampilkanCmbProduk () {
        cmbidProduk.setModel(new DefaultComboBoxModel(new Laptop().getAll().toArray()));
    }
    
    public void tampilkanData() {
        String[] kolom = {"ID_PEMBELIAN", "ID_PELANGGAN", "ID_PRODUK", "Tanggal Pembelian"};
        ArrayList<Pembelian> list = new Pembelian().getAll();
        Object rowData[] = new Object[4];
        
        tbpembelian.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Pembelian A : list){
            rowData[0] = A.getId_pembelian();
            rowData[1] = A.getpelanggan().getNama();
            rowData[2] = A.getproduk().getMerk();
            rowData[3] = A.getTanggal_pembelian();
            
            ((DefaultTableModel)tbpembelian.getModel()).addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbidPelanggan = new javax.swing.JComboBox<>();
        cmbidProduk = new javax.swing.JComboBox<>();
        txtid = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpembelian = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID_PEMBELIAN");

        jLabel2.setText("ID_PELANGGAN");

        jLabel3.setText("ID_PRODUK");

        jLabel4.setText("Tanggal Pembelian");

        cmbidPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbidProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtid.setEditable(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        tambah.setText("Tambah Baru");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jLabel8.setText("Format: YYYY/MM/DD");

        tbpembelian.setModel(new javax.swing.table.DefaultTableModel(
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
        tbpembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpembelianMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbpembelian);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(simpan)
                                .addGap(33, 33, 33))
                            .addComponent(tambah))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbidPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbidProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(hapus)
                                .addGap(54, 54, 54)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbidPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(cmbidProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(44, 44, 44)
                .addComponent(tambah)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(hapus)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        DefaultTableModel model = (DefaultTableModel)tbpembelian.getModel();
        int row = tbpembelian.getSelectedRow();

        Pembelian p = new Pembelian().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        p.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        cari(txtcari.getText());
    }//GEN-LAST:event_cariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        Pembelian p = new Pembelian();
        
        p.setId_pembelian(Integer.parseInt(txtid.getText()));
        p.setpelanggan((Pelanggan)cmbidPelanggan.getSelectedItem());
        p.setproduk((Laptop)cmbidProduk.getSelectedItem());
        p.setTanggal_pembelian(txttanggal.getText());
        p.save();
        txtid.setText(Integer.toString(p.getId_pembelian()));
        tampilkanData();
    }//GEN-LAST:event_simpanActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_tambahActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void tbpembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpembelianMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbpembelian.getModel();
        int row = tbpembelian.getSelectedRow();
        Pembelian l = new Pembelian();
        
        l = l.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

        txtid.setText(String.valueOf(l.getId_pembelian()));
        cmbidPelanggan.getModel().setSelectedItem(l.getpelanggan());
        cmbidProduk.getModel().setSelectedItem(l.getproduk());
        txttanggal.setText(l.getTanggal_pembelian());
    }//GEN-LAST:event_tbpembelianMouseClicked

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
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cari;
    private javax.swing.JComboBox<String> cmbidPelanggan;
    private javax.swing.JComboBox<String> cmbidProduk;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tbpembelian;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txttanggal;
    // End of variables declaration//GEN-END:variables

}
