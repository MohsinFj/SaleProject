/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import com.mysql.cj.xdevapi.Result;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import sql.go;


/**
 *
 * @author Mohammad
 */
public class Return extends javax.swing.JFrame {

    go g = new go();
    
    public Return() {
        initComponents();
        btnSale.setBackground(new Color(14,114,61));
        
        setAll();
        txtSearchSellID.requestFocus();
        btnBuy.setVisible(false);
    }

    void setAll()
    {
        tableHeader(tblSell);
        headerColor(tblSell);
        setCellsAlignment(tblSell, SwingConstants.CENTER);
        tblSell.setDefaultEditor(Object.class, null);
        
        tableHeader(tblBuy);
        headerColor(tblBuy);
        setCellsAlignment(tblBuy, SwingConstants.CENTER);
        tblBuy.setDefaultEditor(Object.class, null);
    }
    void tableHeader(JTable table)
    {
        table.getTableHeader().setReorderingAllowed(false);
    }
    
    void headerColor(JTable table)
    {
        JTableHeader header = table.getTableHeader();
        header.setForeground(new Color(14,114,61));
        header.setFont(new Font("Tahoma" , Font.BOLD , 16));
    }
    
    private  void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
    
    private void fillTable(String sql, JTable table)
    {
        g.fillToJTable(sql, table);
    }
    
    void filter(String query,JTable table)
    {
        DefaultTableModel model= (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    void fillTotal(JTable table, int index , JLabel text)
    {
       
        int r = table.getRowCount();
        int total = 0;
        int price = 0;
        int quantity = 0;
        
        if(table == tblSell || table == tblBuy)
        {
            for (int i = 0; i < r; i++) 
            {
               
                price = Integer.parseInt(table.getValueAt(i, 1).toString().replace(",", "").replace("د.ع", ""));
                quantity = Integer.parseInt(table.getValueAt(i, 2).toString());
                total += price * quantity;
            }
        }
        else
        {
            for (int i = 0; i < r; i++) 
            {
                total += Integer.parseInt(table.getValueAt(i, index).toString().replace(",", "").replace("د.ع", ""));
            }
        }
        
        
        float Total = Float.parseFloat(String.valueOf(total));
        String comma = String.format ("%,.0f", Total);
        text.setText(comma + " د.ع");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSell = new javax.swing.JTable();
        txtSellItemName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();
        txtSearchSellID = new javax.swing.JTextField();
        lblClientName = new javax.swing.JLabel();
        btnBack3 = new javax.swing.JButton();
        txtReturnItemNum = new javax.swing.JTextField();
        lblSellItemNum = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuy = new javax.swing.JTable();
        txtSearchBuy = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSale = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 114, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("استرجاع");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 120, 30));

        btnBack1.setBackground(new java.awt.Color(235, 235, 235));
        btnBack1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(14, 114, 61));
        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        btnBack1.setText("الرجوع");
        btnBack1.setBorderPainted(false);
        btnBack1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack1.setFocusable(false);
        btnBack1.setIconTextGap(8);
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 50));

        jTabbedPane1.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSell.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblSell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "التاريخ", "سعر البيع", "كمية البيع", "اسم المادة"
            }
        ));
        tblSell.setFocusable(false);
        tblSell.setRowHeight(26);
        tblSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSellMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSell);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 870, 380));

        txtSellItemName.setEditable(false);
        txtSellItemName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSellItemName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSellItemName.setMargin(new java.awt.Insets(2, 2, 2, 5));
        jPanel2.add(txtSellItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 190, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("اسم المادة :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 90, 40));

        btnBack2.setBackground(new java.awt.Color(235, 235, 235));
        btnBack2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBack2.setForeground(new java.awt.Color(14, 114, 61));
        btnBack2.setText("ارجاع");
        btnBack2.setBorderPainted(false);
        btnBack2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack2.setFocusable(false);
        btnBack2.setIconTextGap(8);
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 130, 60));

        txtSearchSellID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchSellID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSearchSellID.setMargin(new java.awt.Insets(2, 2, 2, 5));
        jPanel2.add(txtSearchSellID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 220, 40));

        lblClientName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClientName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lblClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 40));

        btnBack3.setBackground(new java.awt.Color(235, 235, 235));
        btnBack3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBack3.setForeground(new java.awt.Color(14, 114, 61));
        btnBack3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifying-glass.png"))); // NOI18N
        btnBack3.setText("بحث");
        btnBack3.setBorderPainted(false);
        btnBack3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack3.setFocusable(false);
        btnBack3.setIconTextGap(8);
        btnBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack3ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBack3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 110, 40));

        txtReturnItemNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtReturnItemNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtReturnItemNum.setMargin(new java.awt.Insets(2, 2, 2, 5));
        jPanel2.add(txtReturnItemNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 80, 40));

        lblSellItemNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSellItemNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lblSellItemNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 90, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("رقم الوصل");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 110, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("اسم الزبون :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 80, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("الكمية المراد ارجاعها :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 140, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("العدد :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 40, 40));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblBuy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "التاريخ", "السعر الشراء", "كمية الشراء", "اسم المادة", "اسم المزود", "رقم الوصل"
            }
        ));
        tblBuy.setFocusable(false);
        tblBuy.setRowHeight(26);
        jScrollPane2.setViewportView(tblBuy);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 870, 410));

        txtSearchBuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchBuy.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSearchBuy.setMargin(new java.awt.Insets(2, 2, 2, 5));
        txtSearchBuy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBuyKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearchBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 220, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifying-glass.png"))); // NOI18N
        jLabel8.setText("البحث ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 110, 40));

        jTabbedPane1.addTab("tab2", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 25, 890, 600));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSale.setBackground(new java.awt.Color(245, 245, 245));
        btnSale.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSale.setForeground(new java.awt.Color(255, 255, 255));
        btnSale.setText("البيع");
        btnSale.setBorder(null);
        btnSale.setBorderPainted(false);
        btnSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSale.setFocusable(false);
        btnSale.setIconTextGap(8);
        btnSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaleMouseClicked(evt);
            }
        });
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });
        jPanel5.add(btnSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 50));

        btnBuy.setBackground(new java.awt.Color(245, 245, 245));
        btnBuy.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(14, 114, 61));
        btnBuy.setText("الشراء");
        btnBuy.setBorderPainted(false);
        btnBuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuy.setEnabled(false);
        btnBuy.setFocusable(false);
        btnBuy.setIconTextGap(8);
        btnBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuyMouseClicked(evt);
            }
        });
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 50));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 140, 570));

        setSize(new java.awt.Dimension(1024, 648));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        this.dispose();
        new MainForm().setVisible(true);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseClicked
        btnSale.setBackground(new Color(14,114,61));
        btnBuy.setBackground(new Color(245,245,245));
        btnSale.setForeground(Color.WHITE);
        btnBuy.setForeground(new Color(14,114,61));
        
        jTabbedPane1.setSelectedIndex(0);
        tblSell.clearSelection();
    }//GEN-LAST:event_btnSaleMouseClicked

    private void btnBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseClicked
        btnBuy.setBackground(new Color(14,114,61));
        
        btnSale.setBackground(new Color(245,245,245));
       
        btnBuy.setForeground(Color.WHITE);
                
        btnSale.setForeground(new Color(14,114,61));
        
        
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnBuyMouseClicked

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        String sql = "SELECT importt.Date, CONCAT(FORMAT(importtitem.Price, 0),'د.ع'), importtitem.Quantity, material.Name, provider.Name, importt.ID FROM importt JOIN importtitem JOIN provider JOIN material WHERE importt.ID=importtitem.ImportID AND importt.ProviderID=provider.ID AND importtitem.MateriaID=material.ID";
        fillTable(sql, tblBuy);
        txtSearchBuy.requestFocus();
        
       
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaleActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        tblBuy.clearSelection();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void txtSearchBuyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBuyKeyReleased
        String query = txtSearchBuy.getText();
        filter(query,tblBuy);
    }//GEN-LAST:event_txtSearchBuyKeyReleased

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        tblSell.clearSelection();
        txtSellItemName.setText("");
        lblSellItemNum.setText(""); 
    }//GEN-LAST:event_jPanel2MouseClicked

    private void btnBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack3ActionPerformed
        String searchSell = txtSearchSellID.getText();
        
        if(!searchSell.equals(""))
        {
            String info[] = go.GetInformation("SELECT client.Name,client.Currency FROM client JOIN export WHERE export.ID = '" +searchSell+ "' AND export.ClientID = client.ID", 2);
            if(info[0] != null)
            {    
                String name = info[0];
                String currency = info[1];
                String sql;
                if(currency.equals("د.ع"))
                {
                     sql = "SELECT export.Date, CONCAT(FORMAT(exportitem.Price, 0), ' د.ع'), exportitem.Quantity, material.Name "
                        + "From material JOIN exportitem JOIN export "
                        + "WHERE material.ID = exportitem.MateriaID AND export.ID = exportitem.exportID AND exportitem.exportID = '"+searchSell+"'";
                }
                else
                {
                    sql = "SELECT export.Date,CONCAT('$ ', FORMAT(exportitem.Price, 0)),exportitem.Quantity,material.Name "
                        + "From material JOIN exportitem JOIN export "
                        + "WHERE material.ID = exportitem.MateriaID AND export.ID = exportitem.exportID AND exportitem.exportID = '"+searchSell+"'";
                }
                fillTable(sql, tblSell);

                lblClientName.setText(name);
                txtSellItemName.setText("");
                lblSellItemNum.setText("");
                txtReturnItemNum.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "رقم الوصل غير صحيح");
                txtSearchSellID.setText("");
                txtSearchSellID.requestFocus();
            }
        }
    }//GEN-LAST:event_btnBack3ActionPerformed

    private void tblSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSellMouseClicked
        
        int row = tblSell.getSelectedRow();
        String name = tblSell.getValueAt(row, 3).toString();
        String num = tblSell.getValueAt(row, 2).toString();
        
        txtSellItemName.setText(name);
        lblSellItemNum.setText(num);
        txtReturnItemNum.requestFocus();
    }//GEN-LAST:event_tblSellMouseClicked

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        
        String id = txtSearchSellID.getText(); //رقم الوصل
        String CName = lblClientName.getText(); //اسم الزبون
        
        String itemName = txtSellItemName.getText(); //اسم المادة المراد ارجاعها
        String itemN = lblSellItemNum.getText(); // عدد المواد الاصلية
        
        String returnN = txtReturnItemNum.getText(); // عدد المواد المراد ارجاعها
        
        if(itemName.equals("") || itemN.equals(""))
        {
            JOptionPane.showMessageDialog(null, "الرجاء تحديد اسم المادة المراد ارجاعها");
        }
        else
        {
            if(returnN.equals(""))
            {
                JOptionPane.showMessageDialog(null, "الرجاء ادخال عدد المواد المراد ارجاعها");
            }
            else
            {
                if(id.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "الرجاء ادخال رقم الوصل");
                    txtSearchSellID.requestFocus();
                    return;
                }
                
                int itemNum = Integer.parseInt(itemN); // عدد المواد الاصلية
                int returnNum = Integer.parseInt(returnN); // عدد المواد المراد ارجاعها
                
                if(returnNum > itemNum)
                {
                    JOptionPane.showMessageDialog(null, "العدد المراد ارجاعه اكبر من العدد المحدد");
                    txtReturnItemNum.setText("0");
                    txtReturnItemNum.requestFocus();
                }
                else
                {
                    String sql = "SELECT TotalPrice, PaidPrice, Debt, Currency FROM export WHERE ID = '" +id+ "'";
                    String[] exportInfo = go.GetInformation(sql, 4);
                    
                    int total = Integer.parseInt(exportInfo[0]); //الكلي
                    int paid = Integer.parseInt(exportInfo[1]); //الواصل
                    int debt = Integer.parseInt(exportInfo[2]); //الباقي
                    String currency = exportInfo[3];
                    
                    String sql1 = "SELECT Debt FROM client WHERE name = '"+CName+"'";
                    int Cdebt = Integer.parseInt(go.getData(sql1));
                    
//                    System.out.println(total + ": الكلي");
//                    System.out.println(paid + ": الواصل");
//                    System.out.println(debt + ": الباقي");
//                    System.out.println(Cdebt + ": ديون الزبون قبل");
//                    System.out.println();
                    
                    //جلب سعر الارجاع
                    int row = tblSell.getSelectedRow();
                    int itemPrice = Integer.parseInt(tblSell.getValueAt(row, 1).toString().replace("$ ", "").replace(" د.ع", "").replace(",", "")); //سعر الارجاع
                    
                    int returnPrice = itemPrice * returnNum;  // سعر الارجاع
                    total = total - returnPrice;  //تغير السعر الكلي بعد الارجاع
                    
                    int clientPriceReturn = 0; // المبلغ المدفوع للزبون
                    int Ld; // ناتج طرح الدين
                    
                    String sql2 = "";
                    String sql3 = "";
                    String sql4 = "";
                    String sql5 = "";
                    
                    if(returnPrice <= debt) 
                    {   //الاحتمال الاول
                        debt = debt - returnPrice;
                        Ld = returnPrice;
                        clientPriceReturn = 0;
                    }
                    else 
                    {
                        paid -= returnPrice - debt;
                        clientPriceReturn = returnPrice - debt;
                        Ld = debt;
                        debt = 0;
                    }
                    
                    if(Ld > Cdebt)
                    {
                        clientPriceReturn += Ld - Cdebt;
                        Cdebt = 0;
                    }
                    else
                    {
                        Cdebt -= Ld;
                    }
                    
//                    System.out.println(total + ": الكلي بعد");
//                    System.out.println(paid + ": الواصل بعد");
//                    System.out.println(debt + ": الباقي بعد");
//                    System.out.println(Cdebt + ": ديون الزبون بعد");
//                    System.out.println(clientPriceReturn + ": المبلغ المدفوع للزبون");
//                    System.out.println("--------------------------------------------");
                    if(clientPriceReturn > 0)
                    {
                        String txt;
                        
                        float quan = clientPriceReturn;
                        String comma = String.format ("%,.0f", quan);
                        
                        if(currency.equals("د.ع"))
                        {   
                            txt = "يجب ارجاع مبلغ "+ comma + "د.ع للزبون";
                            JLabel label = new JLabel(txt);
                            label.setFont(new Font("Arial", Font.BOLD, 14));
                            JOptionPane.showMessageDialog(null, label);
                        }
                        else
                        {
                            txt = "يجب ارجاع مبلغ "+ comma + "$ للزبون";
                            JLabel label = new JLabel(txt);
                            label.setFont(new Font("Arial", Font.BOLD, 14));
                            JOptionPane.showMessageDialog(null, label);
                        }
                    }
                    
                    sql1 = "UPDATE export SET PaidPrice ='"+ paid+ "',Debt ='"+debt+"', TotalPrice = TotalPrice -'"+total+"'  WHERE ID = '"+ id + "'";
                    
                    sql2 = "UPDATE client SET Debt = '"+ Cdebt+ "', WHERE Name = '" + CName + "'";
                    
                    sql3 = "UPDATE exportitem SET Quantity = Quantity - '" + returnNum +"' WHERE exportID = '"+ id +"'";

                    sql4 = "UPDATE material SET Quantity = Quantity + '" + returnNum +"' WHERE Name = '" + itemName +"'";
                    
                    g.query(sql1);
                    g.query(sql2);
                    g.query(sql3);
                    g.query(sql4);
                    
                    JOptionPane.showMessageDialog(null, "تمت العملية بنجاح");
                }
            }
        }
        
    }//GEN-LAST:event_btnBack2ActionPerformed

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
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JLabel lblSellItemNum;
    private javax.swing.JTable tblBuy;
    private javax.swing.JTable tblSell;
    private javax.swing.JTextField txtReturnItemNum;
    private javax.swing.JTextField txtSearchBuy;
    private javax.swing.JTextField txtSearchSellID;
    private javax.swing.JTextField txtSellItemName;
    // End of variables declaration//GEN-END:variables
}