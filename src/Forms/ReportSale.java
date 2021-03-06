/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sql.go;


/**
 *
 * @author Mohammad
 */
public class ReportSale extends javax.swing.JFrame {

    go g = new go();
    
    public ReportSale()
    {
        initComponents();
    }
    
    public ReportSale(String id) {
        initComponents();
        
        String sql1 = "SELECT ClientID,TotalPrice,PaidPrice,Debt,Currency FROM export WHERE ID = '" + id + "'";
        String exportInfo[] = go.GetInformation(sql1,5);
        
        String CName = exportInfo[0];
        String total = exportInfo[1];
        String paid = exportInfo[2];
        String debt = exportInfo[3];
        String currency = exportInfo[4];
        
        String sql2 = "SELECT Name FROM client WHERE ID = '" + CName + "'";
        String ClientName = go.getData(sql2);
        
        lblID.setText(id);
        lblCName.setText(ClientName);
        
        if(currency.equals("د.ع"))
        {
            fillTable("SELECT export.Date,CONCAT(FORMAT(exportitem.Price, 0), ' د.ع'),exportitem.Quantity,material.Name FROM export JOIN exportitem JOIN material WHERE export.ID = exportitem.exportID AND exportitem.MateriaID = material.ID AND exportitem.exportID = '"+ id +"' ORDER BY export.ID ASC", tblSell);
            fillText(lblTotal, total, " د.ع");
            fillText(lblPaidPrice, paid, " د.ع");
            fillText(lblDebt, debt, " د.ع");
        }
        else
        {
            fillTable("SELECT export.Date,CONCAT('$ ', FORMAT(exportitem.Price, 0)),exportitem.Quantity,material.Name FROM export JOIN exportitem JOIN material WHERE export.ID = exportitem.exportID AND exportitem.MateriaID = material.ID AND exportitem.exportID = '"+ id +"' ORDER BY export.ID ASC", tblSell);
            fillText(lblTotal, total, "$ ");
            fillText(lblPaidPrice, paid, "$ ");
            fillText(lblDebt, debt, "$ ");
        }
        setAll();
    }

    void setAll()
    {
        tableHeader(tblSell);
        headerColor(tblSell);
        setCellsAlignment(tblSell, SwingConstants.CENTER);
        tblSell.setDefaultEditor(Object.class, null);
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
    
    private void fillText(JLabel text , String value , String currency)
    {
        float price = Float.parseFloat(String.valueOf(value));
        String comma = String.format ("%,.0f", price);
        
        if(currency.equals(" د.ع"))
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
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSell = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNameCP = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblDebt = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPaidPrice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 114, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("كشف بيع ");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 190, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jScrollPane1.setViewportView(tblSell);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, 740, 410));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("الباقي :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 50, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("المبلغ الكلي :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 80, 30));

        lblCName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lblCName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("الواصل :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 50, 30));

        lblID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 130, 40));

        lblNameCP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNameCP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameCP.setText("اسم الزبون :");
        jPanel2.add(lblNameCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 110, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("رقم الوصل :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 110, 40));

        lblDebt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDebt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lblDebt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 130, 30));

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 490, 150, 30));

        lblPaidPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPaidPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lblPaidPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 160, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 770, 540));

        setSize(new java.awt.Dimension(774, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ReportSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCName;
    private javax.swing.JLabel lblDebt;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNameCP;
    private javax.swing.JLabel lblPaidPrice;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblSell;
    // End of variables declaration//GEN-END:variables
}
