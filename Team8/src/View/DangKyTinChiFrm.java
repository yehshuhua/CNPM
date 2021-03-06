/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.LopHocPhanDAO;
import Control.PhieuDangKyDAO;
import Model.LopHocPhan;
import Model.PhieuDangKy;
import Model.SinhVien;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author ntnhu
 */
public class DangKyTinChiFrm extends javax.swing.JFrame implements ActionListener{
    private SinhVien SV;
    private ArrayList<LopHocPhan> ListDK=new ArrayList<>();
    private DefaultTableModel tm;
    /**
     * Creates new form DangKyTinChiFrm
     */
    public DangKyTinChiFrm(SinhVien SV) {
        this.SV = SV;
        initComponents();
        btnLuu.addActionListener(this);
        btnThem.addActionListener(this);
        btnQuayLai.addActionListener(this);
        lblMaSinhVien.setText(lblMaSinhVien.getText()+SV.getTenDangNhap());
        lblHoTen.setText(lblHoTen.getText()+SV.getHoTen());
        lblKhoa.setText(lblKhoa.getText()+SV.getKhoa());
        lblNganh.setText(lblNganh.getText()+SV.getNganh());
    }

    public DangKyTinChiFrm(SinhVien SV, ArrayList<LopHocPhan> ListDK) {
        this.SV = SV;
        this.ListDK = ListDK;
        initComponents();
        btnLuu.addActionListener(this);
        btnThem.addActionListener(this);
        btnQuayLai.addActionListener(this);
        lblMaSinhVien.setText(lblMaSinhVien.getText()+SV.getTenDangNhap());
        lblHoTen.setText(lblHoTen.getText()+SV.getHoTen());
        lblKhoa.setText(lblKhoa.getText()+SV.getKhoa());
        lblNganh.setText(lblNganh.getText()+SV.getNganh());
        int stc=0;
        for(LopHocPhan i:ListDK)stc+=i.getSoTinChi();
        lblStcDaDangKy.setText(lblStcDaDangKy.getText()+stc);
        if(stc>=14)btnLuu.setEnabled(true);
        fillTable(ListDK);
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
        lblKhoa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblStcDaDangKy = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        lblNganh = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Đăng Ký Tín Chỉ");

        lblMaSinhVien.setText("Mã Sinh Viên : ");

        lblHoTen.setText("Họ Và Tên : ");

        lblKhoa.setText("Khoa : ");

        jLabel5.setText("Số tín chỉ tối thiểu cần đăng ký : 14");

        lblStcDaDangKy.setText("Số tín chỉ đã đăng ký : ");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Môn Học", "Tên Môn Học", "STC", "Mã Lớp ", "Tên Lớp"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnQuayLai.setText("Quay Lại");

        btnLuu.setText("Lưu Kết Quả Đăng Ký");
        btnLuu.setEnabled(false);

        btnThem.setText("Đăng Ký Thêm");

        lblNganh.setText("Ngành : ");

        lblTrangThai.setText("Trạng thái: Chưa lưu vào CSDL, cần chọn ít nhất 14 tín chỉ.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLuu)
                        .addGap(33, 33, 33)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuayLai)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKhoa)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHoTen)
                                    .addComponent(lblMaSinhVien))
                                .addGap(280, 280, 280)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStcDaDangKy)
                                    .addComponent(jLabel5)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai)
                            .addComponent(lblNganh))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSinhVien)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoTen)
                    .addComponent(lblStcDaDangKy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNganh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblTrangThai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuayLai)
                    .addComponent(btnLuu)
                    .addComponent(btnThem))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnLuuClicked(){
        ArrayList<PhieuDangKy> ListPDK=new ArrayList<>();
        for(LopHocPhan lhp:ListDK){
            PhieuDangKy pdk=new PhieuDangKy();
            pdk.setHocPhi(435000);
            pdk.setTblLopHocPhanId(lhp.getLopHocPhanId());
            pdk.setTblSinhVienId(SV.getSinhVienId());
            java.util.Date Date=new java.util.Date();
            pdk.setThoiGian(Date.toString());
            ListPDK.add(pdk);
        }
        PhieuDangKyDAO pdkDAO=new PhieuDangKyDAO();
        pdkDAO.LuuDanhSachPDK(ListPDK);
        lblTrangThai.setText("Trạng thái: Đã xóa PDK cũ->Đã lưu PDK mới vào CSDL!");
        btnLuu.setEnabled(false);        
    }
    
    public void btnThemClicked(){
        new TimMonFrm(SV,ListDK).setVisible(true);
        this.dispose();        
    }
    
    public void btnQuayLaiClicked(){
        if(JOptionPane.showConfirmDialog(this, "Xác nhận kết thúc việc đăng ký?", "", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            new TrangChuSinhVienFrm(SV).setVisible(true);
            this.dispose();     
        }        
    }
    /**
     * @param args the command line arguments
     */
    public void fillTable(ArrayList<LopHocPhan> ListDK){
        int stt=0;
        tm=(DefaultTableModel)tblResult.getModel();
        tm.setRowCount(ListDK.size());
        for(LopHocPhan i:ListDK){
            tm.setValueAt(stt+1, stt, 0);
            tm.setValueAt(i.getMaMon(), stt, 1);
            tm.setValueAt(i.getTenMon(), stt, 2);
            tm.setValueAt(i.getSoTinChi(), stt, 3);
            tm.setValueAt(i.getMaLop(), stt, 4);
            tm.setValueAt(i.getTen(), stt, 5);
            stt++;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblKhoa;
    private javax.swing.JLabel lblMaSinhVien;
    private javax.swing.JLabel lblNganh;
    private javax.swing.JLabel lblStcDaDangKy;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked =(JButton)e.getSource();
        if(btnClicked.equals(btnLuu)){
            btnLuuClicked();
        }
        if(btnClicked.equals(btnThem)){
            btnThemClicked();
        }
        if(btnClicked.equals(btnQuayLai)){
            btnQuayLaiClicked();
        }
    }
}
