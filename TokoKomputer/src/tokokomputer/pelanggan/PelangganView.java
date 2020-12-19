
package tokokomputer.pelanggan;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tokokomputer.pengaturan.Koneksi;
/**
 *
 * @author Smoothies
 */
public class PelangganView extends javax.swing.JInternalFrame {

    /**
     * Creates new form PelangganView
     */
    public PelangganView() {
        initComponents();
        ulang();
    }
    PreparedStatement pst;
    ResultSet rs;
    Connection conn = new Koneksi().getKoneksi();
    String status, sql;
    
    private void tampil_data(){
        try {
            String[]judul = {"ID Pelanggan","Nama Pelanggan","Alamat","No Telepon"};
            DefaultTableModel dtm = new DefaultTableModel(null,judul);
            tabelPelanggan.setModel(dtm);
            if(textCari.getText().isEmpty()){
                sql = "select * from tb_pelanggan";
            }else{
                sql = "select * from tb_pelanggan where nama_pelanggan like '%"+textCari.getText()+ "%'";
            }
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] data = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
}
    
    private void ulang(){
        textID.setEnabled(false);
        textNama.setEnabled(false);
        textAlamat.setEnabled(false);
        textTelp.setEnabled(false);
        buttonSimpan.setEnabled(false);
        buttonUbah.setEnabled(false);
        buttonHapus.setEnabled(false);
        buttonTambah.setEnabled(true);
        
        textID.setText("");
        textNama.setText("");
        textAlamat.setText("");
        textTelp.setText("");
        tampil_data();
    }
    
    private void id_otomatis(){
       try{
        sql = "select id_pelanggan from tb_pelanggan order by id_pelanggan desc limit 1";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            int kode = Integer.parseInt(rs.getString(1).substring(4)) + 1;
            textID.setText("PLG-"+ kode);
        }else{
            textID.setText("PLG-1000");
        }
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null, e.toString());
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        textNama = new javax.swing.JTextField();
        textAlamat = new javax.swing.JTextField();
        textTelp = new javax.swing.JTextField();
        buttonTambah = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonUlang = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();
        buttonHapus = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Form Pelanggan");

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setText("ID PELANGGAN");

        jLabel2.setText("NAMA PELANGGAN");

        jLabel3.setText("ALAMAT");

        jLabel4.setText("NO TELEPON");

        buttonTambah.setText("TAMBAH");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonSimpan.setText("SIMPAN");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonUbah.setText("UBAH");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonUlang.setText("ULANG");
        buttonUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUlangActionPerformed(evt);
            }
        });

        buttonKeluar.setText("KELUAR");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cari Pelanggan");

        textCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCariActionPerformed(evt);
            }
        });
        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCariKeyReleased(evt);
            }
        });

        jLabel6.setText("FORM PELANGGAN");

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPelanggan);

        buttonHapus.setText("HAPUS");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNama)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textAlamat)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonTambah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonSimpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonUbah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonUlang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonKeluar))
                                    .addComponent(textTelp)
                                    .addComponent(textCari)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambah)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonUbah)
                    .addComponent(buttonUlang)
                    .addComponent(buttonKeluar)
                    .addComponent(buttonHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUlangActionPerformed
    ulang();    
    // TODO add your handling code here:
    }//GEN-LAST:event_buttonUlangActionPerformed

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        textID.setEnabled(false);
        textNama.setEnabled(true);
        textAlamat.setEnabled(true);
        textTelp.setEnabled(true);
        buttonTambah.setEnabled(false);
        buttonSimpan.setEnabled(true);
        status = "tambah";
        id_otomatis();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        textID.setEnabled(false);
        textNama.setEnabled(true);
        textAlamat.setEnabled(true);
        textTelp.setEnabled(true);
        buttonSimpan.setEnabled(true);
        buttonUbah.setEnabled(false);
        status = "ubah";
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if(textNama.getText().isEmpty() || textAlamat.getText().isEmpty() || textTelp.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Inputan ada yang belum diisi");
    }else{
            try {
                if(status.equals("tambah")){
                sql = "insert into tb_pelanggan values (?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, textID.getText());
                pst.setString(2, textNama.getText());
                pst.setString(3, textAlamat.getText());
                pst.setString(4, textTelp.getText());
                    }else if(status.equals("ubah")){
                sql = "update tb_pelanggan set nama_pelanggan=?, alamat=?, no_telepon=? where id_pelanggan =?";
                    pst = conn.prepareStatement(sql);
                pst.setString(1, textNama.getText());
                pst.setString(2, textAlamat.getText());
                pst.setString(3, textTelp.getText());
                pst.setString(4, textID.getText());
            }
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data pelanggan berhasil ditambahkanb");
            ulang();
            } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            }
            }                                           
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        int konf = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data pelanggan ini?","Hapus Data?",JOptionPane.YES_NO_OPTION);
        if(konf==0){
            try {
                pst = conn.prepareStatement("delete from tb_pelanggan where id_pelanggan = ?");
                pst.setString(1, textID.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data pelanggan berhasil dihapus");
                ulang();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
    dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void textCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyReleased
    tampil_data();        // TODO add your handling code here:
    }//GEN-LAST:event_textCariKeyReleased

    private void tabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPelangganMouseClicked
    int baris = tabelPelanggan.getSelectedRow();
    String id = tabelPelanggan.getValueAt(baris, 0).toString();
    if(!id.isEmpty()){
        textID.setText(id);
        textNama.setText(tabelPelanggan.getValueAt(baris, 1).toString());
        textAlamat.setText(tabelPelanggan.getValueAt(baris, 2).toString());
        textTelp.setText(tabelPelanggan.getValueAt(baris, 3).toString());
        buttonTambah.setEnabled(false);
        buttonSimpan.setEnabled(false);
        buttonHapus.setEnabled(true);
        buttonUbah.setEnabled(true); 
        }
    }//GEN-LAST:event_tabelPelangganMouseClicked

    private void textCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JButton buttonUlang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPelanggan;
    private javax.swing.JTextField textAlamat;
    private javax.swing.JTextField textCari;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textTelp;
    // End of variables declaration//GEN-END:variables
}
