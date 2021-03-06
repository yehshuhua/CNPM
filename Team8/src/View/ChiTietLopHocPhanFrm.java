/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ChiTietLopHocPhanDAO;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.table.TableColumn;

/**
 *
 * @author nguyenthang
 */
public class ChiTietLopHocPhanFrm extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ChiTietLopHocPhan
     */
    ThongKeCacLopHocPhanFrm parent;
    ThongKeLopHocPhan tklhp;
    DefaultTableModel tm;
    ArrayList<ChiTietLopHocPhan> ltk=null;
    private ArrayList<JButton> listChiTiet;
    
    public ChiTietLopHocPhanFrm(ThongKeCacLopHocPhanFrm parent, ThongKeLopHocPhan tklhp ) {
        this.parent=parent;
        this.tklhp=tklhp;
        initComponents();
        jLabel14.setText(tklhp.getLopHocPhan());
        jLabel15.setText(tklhp.getGiangVien());
        jLabel16.setText(tklhp.getSySo().toString());
        jLabel17.setText(tklhp.getKyBD());
        jLabel18.setText(tklhp.getKyKT());
        btnQuayLai.addActionListener(this);
        tblResult.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] { "STT", "Tên sinh viên", "Điểm cc", "Điểm lt", "Điểm bt", "Điểm btl","Điểm thi","Trung bình"}));
        tm=(DefaultTableModel) tblResult.getModel();
        ChiTietLopHocPhanDAO tk=new ChiTietLopHocPhanDAO();
        ltk=tk.layDiem(tklhp.getMaLop(), tklhp.getHocKy());
        dienBang(ltk);
        TableColumn col = tblResult.getColumnModel().getColumn(0);
        col.setPreferredWidth(10);
        col = tblResult.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);
        col = tblResult.getColumnModel().getColumn(2);
        col.setPreferredWidth(30);
        col = tblResult.getColumnModel().getColumn(3);
        col.setPreferredWidth(30);
        col = tblResult.getColumnModel().getColumn(4);
        col.setPreferredWidth(30);
        col = tblResult.getColumnModel().getColumn(5);
        col.setPreferredWidth(30);
        col = tblResult.getColumnModel().getColumn(6);
        col.setPreferredWidth(30);
        col = tblResult.getColumnModel().getColumn(6);
        col.setPreferredWidth(20);
        this.setLocation(300,150);
    };
    
    public void actionPerformed(ActionEvent e){
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnQuayLai)){
            btnQuayLaiDuocNhan();
            return;
        }
    }
    private void btnQuayLaiDuocNhan(){
        parent.setVisible(true);
        this.dispose();
    }
    
    private void dienBang(ArrayList<ChiTietLopHocPhan> ltk){
        int stt=0;
        tm.setRowCount(ltk.size());
        for(ChiTietLopHocPhan i:ltk){
            tm.setValueAt(stt+1, stt, 0);
            tm.setValueAt(i.getTenSinhVien(), stt, 1);
            tm.setValueAt(i.getDiemCC(), stt, 2);
            tm.setValueAt(i.getDiemKT(), stt, 3);
            tm.setValueAt(i.getDiemTH(), stt, 4);
            tm.setValueAt(i.getDiemBTL(), stt, 5);
            tm.setValueAt(i.getDiemCK(), stt, 6);
            tm.setValueAt(i.getTrungBinh(), stt, 7);
            stt++;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("CHI TIẾT LỚP HỌC PHẦN");

        jLabel2.setText("Thông tin lớp học phần");

        jLabel3.setText("Tên lớp");

        jLabel4.setText("Tên giảng viên");

        jLabel5.setText("Thông tin thống kê");

        jLabel6.setText("Kì bắt đầu");

        jLabel7.setText("Kì kết thúc");

        jLabel8.setText("Tổng số sinh viên");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnQuayLai.setText("Quay lại");

        jLabel14.setText(" ");

        jLabel17.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnQuayLai)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
}
