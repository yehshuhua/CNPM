/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.LopHocPhanDAO;
import Model.GiangVien;
import Model.LopHocPhan;
import Model.MonHoc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author TaDuyHieu
 */
public class DanhSachLHPFrm extends javax.swing.JFrame implements ActionListener{
    private GiangVien GV;
    private TimMonTheoKyFrm parent;
    private ArrayList<LopHocPhan> listSubject;
    private ArrayList<JButton> listSelect;
    int idSubject;
    private MonHoc MH;
    private String hocKy;
    
    public DanhSachLHPFrm(GiangVien GV, String hocKy, MonHoc MH, TimMonTheoKyFrm parent) {
        this.MH = MH;
        this.GV = GV;
        this.hocKy = hocKy;
        this.parent = parent;
        listSubject = new ArrayList<LopHocPhan>();
        listSelect = new ArrayList<JButton>();
        initComponents();
        labelGV.setText("Lớp học phần của giảng viên : " + this.GV.getHoTen());
        labelHK.setText("Học kì : " + this.hocKy);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnBack.addActionListener(this);
        tableDSLHP.setModel(new DanhSachLHPFrm.DanhSachTableModel());
        TableCellRenderer btnRenderer = new JTableButtonRenderer();
        tableDSLHP.getColumn("Thao tác").setCellRenderer(btnRenderer);
        tableDSLHP.addMouseListener(new JTableButtonMouseListener(tableDSLHP));
        fillTable();
        this.setLocation(300,150);
    }
    public DanhSachLHPFrm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDanhSachLopHocPhan = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSLHP = new javax.swing.JTable();
        labelGV = new javax.swing.JLabel();
        labelHK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Demo Nhóm 8");

        labelDanhSachLopHocPhan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelDanhSachLopHocPhan.setForeground(new java.awt.Color(0, 0, 102));
        labelDanhSachLopHocPhan.setText("Danh sách lớp học phần");

        btnBack.setText("Quay lại");

        tableDSLHP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tableDSLHP);

        labelGV.setText(" ");

        labelHK.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelGV, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelHK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelDanhSachLopHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelDanhSachLopHocPhan)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGV)
                    .addComponent(labelHK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void fillTable(){
        LopHocPhanDAO lhpd = new LopHocPhanDAO();
        listSubject = lhpd.getLopHocPhanTheoMonHoc(this.MH, this.hocKy, this.GV);
        listSelect.clear();
        for(LopHocPhan lhp: listSubject){
            JButton tmp = new JButton("Nhập điểm");
            tmp.addActionListener(this);
            listSelect.add(tmp);
        }
        tableDSLHP.setRowHeight(25);
        TableColumn col = tableDSLHP.getColumnModel().getColumn(0);
        col.setPreferredWidth(30);
        col = tableDSLHP.getColumnModel().getColumn(1);
        col.setPreferredWidth(60);
        col = tableDSLHP.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
        for(int i = 0; i < 3; i++){
            TableColumnModel columnModel = tableDSLHP.getColumnModel();
            TableColumn column = columnModel.getColumn(i); 
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            column.setCellRenderer(renderer);
        }
        ((DefaultTableModel)tableDSLHP.getModel()).fireTableDataChanged();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnBack)){
            btnBackClick();
            return;
        }
        for(int i = 0; i < listSelect.size(); i++){
            if(btnClicked.equals(listSelect.get(i))){
                btnSelectClick(i);
                return;
            }
        }
    }
    
    private void btnBackClick(){
        parent.setVisible(true);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    private void btnSelectClick(int i){
        this.setVisible(false);
        (new NhapDiemFrm(this.GV, listSubject.get(i), this.MH, this.hocKy,  this)).setVisible(true);
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDanhSachLopHocPhan;
    private javax.swing.JLabel labelGV;
    private javax.swing.JLabel labelHK;
    private javax.swing.JTable tableDSLHP;
    // End of variables declaration//GEN-END:variables

    class DanhSachTableModel extends DefaultTableModel{
        private final String[] columnNames = {"STT", "Mã lớp", "Tên môn học", "Thao tác"};
        private final Class<?>[] columnTypes = new Class<?>[]{Integer.class, String.class, String.class, JButton.class};
        
        @Override public int getColumnCount() {
            return columnNames.length;
        }
 
        @Override public int getRowCount() {
            return listSubject.size();
        }
 
        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }
 
        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
        
        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
                /*Adding components*/
            switch (columnIndex) {
                case 0: 
                    return rowIndex+1;
                case 1: 
                    return listSubject.get(rowIndex).getMaLop();
                case 2: 
                    return listSubject.get(rowIndex).getTenMon();             
                case 3: 
                    return listSelect.get(rowIndex);     
                default: return "Error";
            }
        } 
    }
}
