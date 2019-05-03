/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.GiangVienDAO;
import Control.KipHocDAO;
import Control.LichGiangDayDAO;
import Control.MonHocDAO;
import Control.NguoiDungDAO;
import Control.PhongHocDAO;
import Model.GiangVien;
import Model.KipHoc;
import Model.LichGiangDay;
import Model.LopHocPhan;
import Model.MonHoc;
import Model.NguoiDung;
import Model.PhongHoc;
import Model.SinhVien;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author ntnhu
 */
public class XemLichFrm extends javax.swing.JFrame implements ActionListener{
    private SinhVien SV;
    private LopHocPhan LHP;
    private ArrayList<LichGiangDay> ListLGD;
    private ArrayList<LopHocPhan> ListDK;
    DefaultTableModel tm;
    /**
     * Creates new form XemLichFrm
     */

    public XemLichFrm(SinhVien SV, LopHocPhan LHP,ArrayList<LopHocPhan> ListDK) {
        this.SV = SV;
        this.LHP = LHP;
        this.ListDK=ListDK;
        initComponents();
        btnDangKy.addActionListener(this);
        btnQuayLai.addActionListener(this);
        lblMaLop.setText(lblMaLop.getText()+LHP.getMaLop());
        lblTenLop.setText(lblTenLop.getText()+LHP.getTen());
        LichGiangDayDAO lgdDAO=new LichGiangDayDAO();
        ListLGD=lgdDAO.TimLichTheoIdLop(LHP.getLopHocPhanId());
        fillTable(ListLGD);
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
        lblMaLop = new javax.swing.JLabel();
        lblTenLop = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Thông Tin Lịch Giảng Dạy");

        lblMaLop.setText("Mã Lớp Học Phần : ");

        lblTenLop.setText("Tên Lớp Học Phần : ");

        jLabel4.setText("Chi Tiết Lịch Giảng Dạy:");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tuần Bắt Đầu", "Tuần Kết Thúc", "Thời Gian", "Thứ", "Phòng Học", "Giảng Viên"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnQuayLai.setText("Quay Lại");

        btnDangKy.setText("Đăng Ký");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuayLai)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenLop)
                            .addComponent(lblMaLop)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnDangKy)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnDangKy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnQuayLai)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnQuayLaiClicked(){
        MonHoc MH=new MonHocDAO().TimMonHocTheoId(LHP.getMonHocId());
        new TimLopFrm(MH, SV, ListDK).setVisible(true);
        this.dispose();
    }
    private void btnDangKyClicked(){
        if(CheckTrungLich()==false){
            JOptionPane.showMessageDialog(this, "Trùng Lịch");
            MonHoc MH=new MonHocDAO().TimMonHocTheoId(LHP.getMonHocId());
            new TimLopFrm(MH, SV, ListDK).setVisible(true);
            this.dispose();
        }
        else{
            ListDK.add(LHP);
            new DangKyTinChiFrm(SV, ListDK).setVisible(true);
            this.dispose();
        }
    }
    /**
     * @param args the command line arguments
     */
    public void fillTable(ArrayList<LichGiangDay> ListLGD){
        int stt=0;
        tm=(DefaultTableModel)tblResult.getModel();
        tm.setRowCount(ListLGD.size());
        for(LichGiangDay i:ListLGD){
            tm.setValueAt(i.getTuanBatDau(), stt, 0);
            tm.setValueAt(i.getTuanKetThuc(), stt, 1);
            KipHoc KH=new KipHocDAO().TimKipHocTheoId(i.getTblKipHocId());
            tm.setValueAt(KH.getGioBatDau()+"h - "+KH.getGioKetThuc()+"h", stt, 2);
            tm.setValueAt(KH.getThu(), stt, 3);
            PhongHoc PH=new PhongHocDAO().TimPhongHocTheoId(i.getTblPhongHocId());
            tm.setValueAt(PH.getTenPhong(), stt, 4);
            GiangVien GV=new GiangVienDAO().TimGiangVienTheoId(i.getTblGiangVientblNguoiDungId());
            NguoiDung nd=new NguoiDungDAO().TimNguoiDungTheoId(GV.getTblNguoiDungId());
            tm.setValueAt(nd.getHoTen(), stt, 5);
            stt++;
        }
    }
    private boolean CheckTrungLich(){
        ArrayList<LichGiangDay> tempListLGD=new ArrayList<>();
        for(LopHocPhan lhp : ListDK)tempListLGD.addAll(new LichGiangDayDAO().TimLichTheoIdLop(lhp.getLopHocPhanId()));
        for(LichGiangDay templgd : tempListLGD){
            for(LichGiangDay lgd : ListLGD){
                if(templgd.getTuanBatDau()>lgd.getTuanKetThuc()||templgd.getTuanKetThuc()<lgd.getTuanBatDau()){
                    
                }
                else{
                    if(templgd.getTblKipHocId()==lgd.getTblKipHocId()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaLop;
    private javax.swing.JLabel lblTenLop;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked =(JButton)e.getSource();
        if(btnClicked.equals(btnQuayLai)){
            btnQuayLaiClicked();
        }
        if(btnClicked.equals(btnDangKy)){
            btnDangKyClicked();
        }
    }
}
