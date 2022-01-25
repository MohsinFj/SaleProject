/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.io.File;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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
public class reports extends javax.swing.JFrame {

    go g = new go();
    String dollar = "";
    public reports() {
        initComponents();
        btnSale.setBackground(new Color(14,114,61));
        
        setAll();
        txtSearchSell.requestFocus();
        
        
        fillTable("SELECT export.Date,CONCAT(FORMAT(export.Debt, 0), ' د.ع'),CONCAT(FORMAT(export.PaidPrice, 0), ' د.ع'),CONCAT(FORMAT(export.TotalPrice, 0), ' د.ع'),client.Name,export.ID FROM export JOIN client WHERE export.ClientID = client.ID AND export.Currency = 'د.ع' ORDER BY export.ID ASC", tblSell);
        
        String sql1 = "SELECT dollar FROM setting LIMIT 1";
        dollar = go.getData(sql1).replace(".0", "");
        
        cmbSale.setVisible(false);
        cmbBuy.setVisible(false);
        cmbDebt.setVisible(false);
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
        
        tableHeader(tblDebt);
        headerColor(tblDebt);
        setCellsAlignment(tblDebt, SwingConstants.CENTER);
        tblDebt.setDefaultEditor(Object.class, null);
        
        tableHeader(tblProfits);
        headerColor(tblProfits);
        setCellsAlignment(tblProfits, SwingConstants.CENTER);
        tblProfits.setDefaultEditor(Object.class, null);
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
    
    void fillTotal(JTable table, int index , JLabel text , JComboBox cmb)
    {
       
        int r = table.getRowCount();
        int total = 0;
        int price = 0;
        int quantity = 0;
        
        if(table == tblSell || table == tblBuy)
        {
            for (int i = 0; i < r; i++) 
            {
               
                price = Integer.parseInt(table.getValueAt(i, 1).toString().replace(",", "").replace(" د.ع", "").replace("$ ", ""));
                quantity = Integer.parseInt(table.getValueAt(i, 2).toString());
                total += price * quantity;
            }
        }
        else
        {
            for (int i = 0; i < r; i++) 
            {
                total += Integer.parseInt(table.getValueAt(i, index).toString().replace(",", "").replace(" د.ع", "").replace("$ ", ""));
            }
        }
        
        float Total = Float.parseFloat(String.valueOf(total));
        String comma = String.format ("%,.0f", Total);
        
        if(cmb.getSelectedIndex() == 0)
        {
            text.setText(comma + " د.ع");
        }
        else
        {
            text.setText("$ " + comma);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSell = new javax.swing.JTable();
        btnPrintSell = new javax.swing.JButton();
        txtSearchSell = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbSale = new javax.swing.JComboBox<>();
        cmbPercentSale = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuy = new javax.swing.JTable();
        btnPrintBuy = new javax.swing.JButton();
        txtSearchBuy = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbBuy = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDebt = new javax.swing.JTable();
        btnPrintDebt = new javax.swing.JButton();
        txtSearchDebt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbDebt = new javax.swing.JComboBox<>();
        cmbDebtPaid = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblProfits = new javax.swing.JTable();
        btnPrintProfits = new javax.swing.JButton();
        cmbBenifit = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lblTotalProfits = new javax.swing.JLabel();
        cmbBenifitCurrency = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSale = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        btnDibt = new javax.swing.JButton();
        btnBenifit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 114, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("التقارير");
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
                "التاريخ", "الباقي", "الواصل", "السعر الكلي", "اسم الزبون", "رقم الوصل"
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 870, 410));

        btnPrintSell.setBackground(new java.awt.Color(235, 235, 235));
        btnPrintSell.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPrintSell.setForeground(new java.awt.Color(14, 114, 61));
        btnPrintSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer.png"))); // NOI18N
        btnPrintSell.setText("طباعة");
        btnPrintSell.setBorderPainted(false);
        btnPrintSell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintSell.setFocusPainted(false);
        btnPrintSell.setFocusable(false);
        btnPrintSell.setIconTextGap(10);
        btnPrintSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintSellActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrintSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 200, 40));

        txtSearchSell.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchSell.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSearchSell.setMargin(new java.awt.Insets(2, 2, 2, 5));
        txtSearchSell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSellKeyReleased(evt);
            }
        });
        jPanel2.add(txtSearchSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 220, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("العملة :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 60, 40));

        cmbSale.setBackground(new java.awt.Color(254, 255, 255));
        cmbSale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbSale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "رقم الوصل", "اسم الزبون", "اسم المادة", "التاريخ" }));
        jPanel2.add(cmbSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 90, 40));

        cmbPercentSale.setBackground(new java.awt.Color(254, 255, 255));
        cmbPercentSale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbPercentSale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "د.ع", "$" }));
        cmbPercentSale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPercentSaleItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbPercentSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 50, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifying-glass.png"))); // NOI18N
        jLabel5.setText("البحث ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 110, 40));

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
                "التاريخ", "الباقي", "الواصل", "السعر الكلي", "اسم المزود", "رقم الوصل"
            }
        ));
        tblBuy.setFocusable(false);
        tblBuy.setRowHeight(26);
        tblBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBuy);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 870, 410));

        btnPrintBuy.setBackground(new java.awt.Color(235, 235, 235));
        btnPrintBuy.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPrintBuy.setForeground(new java.awt.Color(14, 114, 61));
        btnPrintBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer.png"))); // NOI18N
        btnPrintBuy.setText("طباعة");
        btnPrintBuy.setBorderPainted(false);
        btnPrintBuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintBuy.setFocusable(false);
        btnPrintBuy.setIconTextGap(10);
        btnPrintBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBuyActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrintBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 200, 40));

        txtSearchBuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchBuy.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSearchBuy.setMargin(new java.awt.Insets(2, 2, 2, 5));
        txtSearchBuy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBuyKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearchBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 220, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifying-glass.png"))); // NOI18N
        jLabel8.setText("البحث ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 110, 40));

        cmbBuy.setBackground(new java.awt.Color(254, 255, 255));
        cmbBuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbBuy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "رقم الوصل", "اسم المزود", "اسم المادة", "التاريخ" }));
        jPanel3.add(cmbBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 90, 40));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDebt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDebt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "تاريخ تسديد الدين", "المبلغ الذي تم تسديده", "الديون الكلية للزبون", "اسم الزبون"
            }
        ));
        tblDebt.setFocusable(false);
        tblDebt.setRowHeight(26);
        jScrollPane4.setViewportView(tblDebt);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 870, 410));

        btnPrintDebt.setBackground(new java.awt.Color(235, 235, 235));
        btnPrintDebt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPrintDebt.setForeground(new java.awt.Color(14, 114, 61));
        btnPrintDebt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer.png"))); // NOI18N
        btnPrintDebt.setText("طباعة");
        btnPrintDebt.setBorderPainted(false);
        btnPrintDebt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintDebt.setFocusable(false);
        btnPrintDebt.setIconTextGap(10);
        btnPrintDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintDebtActionPerformed(evt);
            }
        });
        jPanel6.add(btnPrintDebt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 200, 40));

        txtSearchDebt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchDebt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSearchDebt.setMargin(new java.awt.Insets(2, 2, 2, 5));
        txtSearchDebt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDebtKeyReleased(evt);
            }
        });
        jPanel6.add(txtSearchDebt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 220, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifying-glass.png"))); // NOI18N
        jLabel10.setText("البحث ");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 110, 40));

        cmbDebt.setBackground(new java.awt.Color(254, 255, 255));
        cmbDebt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbDebt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اسم الزبون", "تاريخ تسديد الدين" }));
        jPanel6.add(cmbDebt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 150, 40));

        cmbDebtPaid.setBackground(new java.awt.Color(254, 255, 255));
        cmbDebtPaid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbDebtPaid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "د.ع", "$" }));
        cmbDebtPaid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDebtPaidItemStateChanged(evt);
            }
        });
        jPanel6.add(cmbDebtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 50, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("العملة :");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 60, 40));

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProfits.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblProfits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "الارباح", "سعر البيع", "سعر السلعة", "السلعة", "التاريخ"
            }
        ));
        tblProfits.setFocusable(false);
        tblProfits.setRowHeight(26);
        jScrollPane5.setViewportView(tblProfits);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 870, 410));

        btnPrintProfits.setBackground(new java.awt.Color(235, 235, 235));
        btnPrintProfits.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPrintProfits.setForeground(new java.awt.Color(14, 114, 61));
        btnPrintProfits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer.png"))); // NOI18N
        btnPrintProfits.setText("طباعة");
        btnPrintProfits.setBorderPainted(false);
        btnPrintProfits.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintProfits.setFocusable(false);
        btnPrintProfits.setIconTextGap(10);
        btnPrintProfits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintProfitsActionPerformed(evt);
            }
        });
        jPanel7.add(btnPrintProfits, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 200, 40));

        cmbBenifit.setBackground(new java.awt.Color(254, 255, 255));
        cmbBenifit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbBenifit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "الارباح الكلية", "الشهر السابق", "السنة السابقة" }));
        cmbBenifit.setBorder(null);
        cmbBenifit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbBenifit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBenifitItemStateChanged(evt);
            }
        });
        jPanel7.add(cmbBenifit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("مجموع الارباح :");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 130, 40));

        lblTotalProfits.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalProfits.setForeground(new java.awt.Color(14, 114, 61));
        lblTotalProfits.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalProfits.setText("0");
        lblTotalProfits.setToolTipText("");
        jPanel7.add(lblTotalProfits, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 150, 40));

        cmbBenifitCurrency.setBackground(new java.awt.Color(254, 255, 255));
        cmbBenifitCurrency.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbBenifitCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "د.ع", "$" }));
        cmbBenifitCurrency.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBenifitCurrencyItemStateChanged(evt);
            }
        });
        jPanel7.add(cmbBenifitCurrency, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 50, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("العملة :");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 60, 40));

        jTabbedPane1.addTab("tab4", jPanel7);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 25, 890, 600));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSale.setBackground(new java.awt.Color(245, 245, 245));
        btnSale.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSale.setForeground(new java.awt.Color(255, 255, 255));
        btnSale.setText("المبيعات");
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
        btnBuy.setText("المشتريات");
        btnBuy.setBorderPainted(false);
        btnBuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        btnDibt.setBackground(new java.awt.Color(245, 245, 245));
        btnDibt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnDibt.setForeground(new java.awt.Color(14, 114, 61));
        btnDibt.setText("تسديد الدين");
        btnDibt.setBorderPainted(false);
        btnDibt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDibt.setFocusable(false);
        btnDibt.setIconTextGap(8);
        btnDibt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDibtMouseClicked(evt);
            }
        });
        btnDibt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDibtActionPerformed(evt);
            }
        });
        jPanel5.add(btnDibt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, 50));

        btnBenifit.setBackground(new java.awt.Color(245, 245, 245));
        btnBenifit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBenifit.setForeground(new java.awt.Color(14, 114, 61));
        btnBenifit.setText("الارباح");
        btnBenifit.setBorderPainted(false);
        btnBenifit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBenifit.setFocusable(false);
        btnBenifit.setIconTextGap(8);
        btnBenifit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBenifitMouseClicked(evt);
            }
        });
        btnBenifit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBenifitActionPerformed(evt);
            }
        });
        jPanel5.add(btnBenifit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, 50));

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
        btnDibt.setBackground(new Color(245,245,245));
        btnBenifit.setBackground(new Color(245,245,245));
        
        btnSale.setForeground(Color.WHITE);
                
        btnBuy.setForeground(new Color(14,114,61));
        btnDibt.setForeground(new Color(14,114,61));
        btnBenifit.setForeground(new Color(14,114,61));
        
        jTabbedPane1.setSelectedIndex(0);
        tblSell.clearSelection();
    }//GEN-LAST:event_btnSaleMouseClicked

    private void btnBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseClicked
        btnBuy.setBackground(new Color(14,114,61));
        
        btnSale.setBackground(new Color(245,245,245));
        btnDibt.setBackground(new Color(245,245,245));
        btnBenifit.setBackground(new Color(245,245,245));
        
        btnBuy.setForeground(Color.WHITE);
                
        btnSale.setForeground(new Color(14,114,61));
        btnDibt.setForeground(new Color(14,114,61));
        btnBenifit.setForeground(new Color(14,114,61));
        
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnBuyMouseClicked

    private void btnDibtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDibtMouseClicked
        btnDibt.setBackground(new Color(14,114,61));
        
        btnBuy.setBackground(new Color(245,245,245));
        btnSale.setBackground(new Color(245,245,245));
        btnBenifit.setBackground(new Color(245,245,245));
        
        btnDibt.setForeground(Color.WHITE);
                
        btnBuy.setForeground(new Color(14,114,61));
        btnSale.setForeground(new Color(14,114,61));
        btnBenifit.setForeground(new Color(14,114,61));
        
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnDibtMouseClicked

    private void btnBenifitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBenifitMouseClicked
        btnBenifit.setBackground(new Color(14,114,61));
        
        btnBuy.setBackground(new Color(245,245,245));
        btnSale.setBackground(new Color(245,245,245));
        btnDibt.setBackground(new Color(245,245,245));
        
        btnBenifit.setForeground(Color.WHITE);
                
        btnBuy.setForeground(new Color(14,114,61));
        btnDibt.setForeground(new Color(14,114,61));
        btnSale.setForeground(new Color(14,114,61));
        
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnBenifitMouseClicked

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        
//        String sql = "SELECT export.Date,CONCAT('$ ', FORMAT(export.Debt, 0)),CONCAT('$ ',FORMAT(export.PaidPrice, 0)),CONCAT('$ ',FORMAT(export.TotalPrice, 0)),client.Name,export.ID FROM export JOIN client WHERE export.ClientID=client.ID AND export.Currency = '$' ORDER BY export.ID ASC";
//            fillTable(sql, tblSell);
        
//        String sql = "SELECT importt.Date,CONCAT('$ ', FORMAT(importtitem.Price, 0)),importtitem.Quantity,material.Name AS 'Material Name',provider.Name,importt.ID FROM importt JOIN importtitem JOIN provider JOIN material WHERE importt.ID=importtitem.ImportID AND importt.ProviderID=provider.ID AND importtitem.MateriaID=material.ID ORDER BY importt.ID ASC";
//        fillTable(sql, tblBuy);
        
        String sql = "SELECT importt.Date,CONCAT('$ ', FORMAT(importt.Debt, 0)),CONCAT('$ ',FORMAT(importt.PaidPrice, 0)),CONCAT('$ ',FORMAT(importt.TotalPrice, 0)),provider.Name,importt.ID FROM importt JOIN provider WHERE  importt.ProviderID=provider.ID ORDER BY importt.ID ASC";
        fillTable(sql, tblBuy);
        
        txtSearchBuy.requestFocus();
        
        //fillTotal(tblBuy, 1, lblTotalBuy);
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnDibtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDibtActionPerformed
        String sql = "SELECT debthistorypaid.DatePaid,CONCAT(FORMAT(debthistorypaid.DebtPaid, 0), ' د.ع'),CONCAT(FORMAT(debthistorypaid.TotalDebt, 0), ' د.ع'),client.Name FROM client JOIN debthistorypaid WHERE client.ID = debthistorypaid.ClientID AND client.Currency = 'د.ع' ORDER BY debthistorypaid.DatePaid ASC";
        fillTable(sql, tblDebt);
        txtSearchDebt.requestFocus();
        
        //fillTotal(tblDebt, 0, lblTotalDebt);
    }//GEN-LAST:event_btnDibtActionPerformed

    private void btnBenifitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBenifitActionPerformed
        String sql = "SELECT CONCAT(FORMAT((exportitem.Price - material.Price)*exportitem.Quantity, 0), ' د.ع') , CONCAT(FORMAT(exportitem.Price,0), ' د.ع'),CONCAT(FORMAT(material.Price * "+dollar+",0), ' د.ع'), material.Name, export.Date FROM export JOIN exportitem JOIN material JOIN setting WHERE export.ID=exportitem.exportID AND exportitem.MateriaID=material.ID AND export.Currency = 'د.ع' ORDER BY export.Date ASC";
        fillTable(sql, tblProfits);
        setCellsAlignment(tblProfits, SwingConstants.CENTER);
        cmbBenifit.setSelectedIndex(0);
        
        fillTotal(tblProfits,0,lblTotalProfits , cmbBenifitCurrency);
    }//GEN-LAST:event_btnBenifitActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        tblProfits.clearSelection();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void btnPrintProfitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintProfitsActionPerformed
        
        try {
            
            
            MessageFormat header = new MessageFormat("تقرير الارباح");
            MessageFormat footer = new MessageFormat("");
            tblProfits.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
//try 
//        { 
//            JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsoluteFile()+"/src/IReports/Debt.jrxml");
//            
//            JasperPrint jp = JasperFillManager.fillReport(jr,null, go.getConnection());
//            
//            JasperViewer.viewReport(jp , false);
//        } catch (JRException ex) {
//            System.out.println(ex.getMessage());
//        }
        } catch (PrinterException ex) {
            System.out.println(ex.getMessage());
        }
        
        
//        String profit = lblTotalProfits.getText();
//        
//        DefaultTableModel model=(DefaultTableModel)tblProfits.getModel();
//        int r = model.getRowCount();
//        Object data[];
//
//        for (int i = 0; i < r; i++) 
//        {
//            data = new Object[3];
//            for (int j = 0; j < 3; j++) 
//            {
//                data[j] = model.getValueAt(i, j);
//            }
//            String sql6 = "INSERT INTO `profits`(`Date`, `Buys`, `profits`) VALUES "
//            + "('" + data[2] + "','" + data[1].toString().replace(",", "") + "','" + data[0].toString().replace(",", "") + "')";
//            g.query(sql6);
//        }
//        
//        try 
//        { 
//            JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsoluteFile()+"/src/IReports/Profits.jrxml");
//
//            //JRDataSource datasource = new JREmptyDataSource();
//
//            Map<String, Object> parameters = new HashMap<String, Object>();
//            parameters.put("Profit", profit);
//
//            JasperPrint jp = JasperFillManager.fillReport(jr,parameters, go.getConnection());
//            //JasperExportManager.exportReportToPdfFile(jp,"C:\\Users\\Mohammad\\Desktop\\test.pdf");
//
//            JasperViewer.viewReport(jp , false);
//        } catch (JRException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        String sql = "TRUNCATE profits";
//        g.query(sql);
        
    }//GEN-LAST:event_btnPrintProfitsActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        tblDebt.clearSelection();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void txtSearchDebtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDebtKeyReleased
        String query = txtSearchDebt.getText();
//        int index = cmbBuy.getSelectedIndex();
//        if(index == 0)
//        {
//            index = 3;
//        }
//        else if(index == 1)
//        {
//            index = 0;
//        }
        filter(query,tblDebt);
    }//GEN-LAST:event_txtSearchDebtKeyReleased

    private void btnPrintDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintDebtActionPerformed
        
          try {
            
            
            MessageFormat header = new MessageFormat("تقرير تسديد الديون");
            MessageFormat footer = new MessageFormat("");
            tblDebt.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
//try 
//        { 
//            JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsoluteFile()+"/src/IReports/Debt.jrxml");
//            
//            JasperPrint jp = JasperFillManager.fillReport(jr,null, go.getConnection());
//            
//            JasperViewer.viewReport(jp , false);
//        } catch (JRException ex) {
//            System.out.println(ex.getMessage());
//        }
        } catch (PrinterException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }//GEN-LAST:event_btnPrintDebtActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        tblBuy.clearSelection();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void txtSearchBuyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBuyKeyReleased
        String query = txtSearchBuy.getText();
//        int index = cmbBuy.getSelectedIndex();
//        if(index == 0)
//        {
//            index = 5;
//        }
//        else if(index == 1)
//        {
//            index = 4;
//        }
//        else if(index == 2)
//        {
//            index = 3;
//        }
//        else if(index == 3)
//        {
//            index = 0;
//        }
        filter(query,tblBuy);
    }//GEN-LAST:event_txtSearchBuyKeyReleased

    private void btnPrintBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBuyActionPerformed
        
        try {
            
            
            MessageFormat header = new MessageFormat("تقرير الشراء");
            MessageFormat footer = new MessageFormat("");
            tblBuy.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
//            try 
//            { 
//                JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsoluteFile()+"/src/IReports/Buys.jrxml");
//
//                JasperPrint jp = JasperFillManager.fillReport(jr,null, go.getConnection());
//
//                JasperViewer.viewReport(jp , false);
//            } catch (JRException ex) {
//                System.out.println(ex.getMessage());
//            }
        } catch (PrinterException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }//GEN-LAST:event_btnPrintBuyActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        tblSell.clearSelection();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txtSearchSellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSellKeyReleased
        String query = txtSearchSell.getText();
//        int index = cmbSale.getSelectedIndex();
//        if(index == 0)
//        {
//            index = 5;
//        }
//        else if(index == 1)
//        {
//            index = 4;
//        }
//        else if(index == 2)
//        {
//            index = 3;
//        }
//        else if(index == 3)
//        {
//            index = 0;
//        }
        filter(query,tblSell);
    }//GEN-LAST:event_txtSearchSellKeyReleased

    private void btnPrintSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSellActionPerformed
        
            
        try {
            
            
            MessageFormat header = new MessageFormat("تقرير البيع");
            MessageFormat footer = new MessageFormat("");
            tblSell.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
//        try
//        {
//            JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsoluteFile()+"/src/IReports/Sells.jrxml");
//            
//            JasperPrint jp = JasperFillManager.fillReport(jr,null, go.getConnection());
//            
//            JasperViewer.viewReport(jp , false);
//        } catch (JRException ex) {
//            System.out.println(ex.getMessage());
//        }
        } catch (PrinterException ex) {
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_btnPrintSellActionPerformed

    private void cmbBenifitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBenifitItemStateChanged
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        //int day = today.getDayOfMonth();
        String sql = "";
        
        switch (cmbBenifit.getSelectedIndex()) 
        {
            case 1:
                {if(month == 12)
                    {
                        month = 1;
                    }
                    else
                    {
                        month -= 1;
                        if(month<10)
                            sql = year+"-0"+month;
                        else
                            sql = year+"-"+month;
                    }
                }
                break;
            case 2:
                {
                    year -= 1;
                    sql = String.valueOf(year);
                }
                break;
            default:
                break;
        }
        filter(sql, tblProfits);
        fillTotal(tblProfits,0,lblTotalProfits , cmbBenifitCurrency);
    }//GEN-LAST:event_cmbBenifitItemStateChanged

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaleActionPerformed

    private void tblSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSellMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) 
        {
            evt.consume();
            int r = tblSell.getSelectedRow();
            String id = tblSell.getValueAt(r, 5).toString();
            new ReportSale(id).setVisible(true);
        }
    }//GEN-LAST:event_tblSellMouseClicked

    private void tblBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuyMouseClicked
        if(evt.getClickCount() == 2 && !evt.isConsumed())
        {
            evt.consume();
            int r = tblBuy.getSelectedRow();
            String id = tblBuy.getValueAt(r, 5).toString();
            new ReportBuy(id).setVisible(true);
        }
    }//GEN-LAST:event_tblBuyMouseClicked

    private void cmbPercentSaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPercentSaleItemStateChanged
        int currency = cmbPercentSale.getSelectedIndex();
        String sql = "";
        
        if(currency == 0)
        {
            sql = "SELECT export.Date,CONCAT(FORMAT(export.Debt, 0), ' د.ع'),CONCAT(FORMAT(export.PaidPrice, 0), ' د.ع'),CONCAT(FORMAT(export.TotalPrice, 0), ' د.ع'),client.Name,export.ID FROM export JOIN client WHERE export.ClientID=client.ID AND export.Currency = 'د.ع' ORDER BY export.ID ASC";
        }
        else
        {
            sql = "SELECT export.Date,CONCAT('$ ', FORMAT(export.Debt, 0)),CONCAT('$ ',FORMAT(export.PaidPrice, 0)),CONCAT('$ ',FORMAT(export.TotalPrice, 0)),client.Name,export.ID FROM export JOIN client WHERE export.ClientID=client.ID AND export.Currency = '$' ORDER BY export.ID ASC";
        }
        
        fillTable(sql, tblSell);
    }//GEN-LAST:event_cmbPercentSaleItemStateChanged

    private void cmbDebtPaidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDebtPaidItemStateChanged
        
        int currency = cmbDebtPaid.getSelectedIndex();
        String sql = "";
        
        if(currency == 0)
        {
            sql = "SELECT debthistorypaid.DatePaid,CONCAT(FORMAT(debthistorypaid.DebtPaid, 0), ' د.ع'),CONCAT(FORMAT(debthistorypaid.TotalDebt, 0), ' د.ع'),client.Name FROM client JOIN debthistorypaid WHERE client.ID = debthistorypaid.ClientID AND client.Currency = 'د.ع' ORDER BY debthistorypaid.DatePaid ASC";
        }
        else
        {
            sql = "SELECT debthistorypaid.DatePaid,CONCAT('$ ', FORMAT(debthistorypaid.DebtPaid, 0)),CONCAT('$ ', FORMAT(debthistorypaid.TotalDebt, 0)),client.Name FROM client JOIN debthistorypaid WHERE client.ID = debthistorypaid.ClientID AND client.Currency = '$' ORDER BY debthistorypaid.DatePaid ASC";
            
        }
        
        fillTable(sql, tblDebt);
    }//GEN-LAST:event_cmbDebtPaidItemStateChanged

    private void cmbBenifitCurrencyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBenifitCurrencyItemStateChanged
        
        int currency = cmbBenifitCurrency.getSelectedIndex();
        String sql = "";
        
        if(currency == 0)
        {
            sql = "SELECT CONCAT(FORMAT((exportitem.Price - material.Price)*exportitem.Quantity, 0), ' د.ع') , CONCAT(FORMAT(exportitem.Price,0), ' د.ع'),CONCAT(FORMAT(material.Price * "+dollar+",0), ' د.ع'), material.Name, export.Date FROM export JOIN exportitem JOIN material WHERE export.ID=exportitem.exportID AND exportitem.MateriaID=material.ID AND export.Currency = 'د.ع' ORDER BY export.Date ASC";
            
        }
        else
        {
            sql = "SELECT CONCAT('$ ', FORMAT((exportitem.Price - material.Price)*exportitem.Quantity, 0)) , CONCAT('$ ', FORMAT(exportitem.Price,0)),CONCAT('$ ', FORMAT(material.Price,0)), material.Name, export.Date FROM export JOIN exportitem JOIN material WHERE export.ID=exportitem.exportID AND exportitem.MateriaID=material.ID AND export.Currency = '$' ORDER BY export.Date ASC";
        }
        
        fillTable(sql, tblProfits);
        fillTotal(tblProfits,0,lblTotalProfits , cmbBenifitCurrency);
    }//GEN-LAST:event_cmbBenifitCurrencyItemStateChanged

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
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBenifit;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnDibt;
    private javax.swing.JButton btnPrintBuy;
    private javax.swing.JButton btnPrintDebt;
    private javax.swing.JButton btnPrintProfits;
    private javax.swing.JButton btnPrintSell;
    private javax.swing.JButton btnSale;
    private javax.swing.JComboBox<String> cmbBenifit;
    private javax.swing.JComboBox<String> cmbBenifitCurrency;
    private javax.swing.JComboBox<String> cmbBuy;
    private javax.swing.JComboBox<String> cmbDebt;
    private javax.swing.JComboBox<String> cmbDebtPaid;
    private javax.swing.JComboBox<String> cmbPercentSale;
    private javax.swing.JComboBox<String> cmbSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTotalProfits;
    private javax.swing.JTable tblBuy;
    private javax.swing.JTable tblDebt;
    private javax.swing.JTable tblProfits;
    private javax.swing.JTable tblSell;
    private javax.swing.JTextField txtSearchBuy;
    private javax.swing.JTextField txtSearchDebt;
    private javax.swing.JTextField txtSearchSell;
    // End of variables declaration//GEN-END:variables
}
