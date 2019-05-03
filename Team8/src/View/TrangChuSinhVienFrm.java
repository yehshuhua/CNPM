/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.SinhVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author ntnhu
 */
public class TrangChuSinhVienFrm extends javax.swing.JFrame implements ActionListener{
    private SinhVien SV;
    /**
     * Creates new form TrangChuSinhVienFrm
     */
    public TrangChuSinhVienFrm(SinhVien SV) {
        this.SV = SV;        
        initComponents();
        btnDangKyTinChi.addActionListener(this);
        btnDangXuat.addActionListener(this);
        lblMaSinhVien.setText(lblMaSinhVien.getText()+SV.getTenDangNhap());
        lblHoTen.setText(lblHoTen.getText()+SV.getHoTen());        
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
        lblMaSinhVien = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        btnDangKyTinChi = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Trang Chủ Sinh Viên");

        lblMaSinhVien.setText("Mã Sinh Viên : ");

        lblHoTen.setText("Họ Và Tên : ");

        btnDangKyTinChi.setText("Đăng Ký Tín Chỉ");

        btnDangXuat.setText("Đăng Xuất");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoTen)
                            .addComponent(lblMaSinhVien)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnDangKyTinChi)))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDangXuat)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaSinhVien)
                .addGap(18, 18, 18)
                .addComponent(lblHoTen)
                .addGap(18, 18, 18)
                .addComponent(btnDangKyTinChi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(btnDangXuat)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnDangXuatClicked(){
        new DangNhapFrm().setVisible(true);
        this.dispose();
    }
    private void btnDangKyTinChiClicked(){
        new DangKyTinChiFrm(SV).setVisible(true);
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKyTinChi;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaSinhVien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked =(JButton)e.getSource();
        if(btnClicked.equals(btnDangKyTinChi)){
            btnDangKyTinChiClicked();
        }
        if(btnClicked.equals(btnDangXuat)){
            btnDangXuatClicked();
        }
    }
}
