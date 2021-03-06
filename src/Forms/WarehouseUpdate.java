/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.JOptionPane;
import sql.go;

/**
 *
 * @author Mohammad
 */
public class WarehouseUpdate extends javax.swing.JFrame {
    
    go g = new go();
    String Name = "";
    private String warehouse;
    private String type;
    private String id;
    
    public WarehouseUpdate() {
        initComponents();         
    }
    
    public WarehouseUpdate(String id,String name, String type, String warehouse)
    {
        initComponents();
        
        this.id = id;
        this.Name = name;
        this.type = type;
        this.warehouse = warehouse;
        
        txtMName.setText(Name);  
        
        fillComboBoxGrop();
        fillComboBoxWarehouse();
    }
    
    public void fillComboBoxGrop()
    {
        cmbGrop.removeAllItems();
        String sql = "SELECT * FROM grop";
        g.fillCombo(cmbGrop,sql);
        
        cmbGrop.setSelectedItem(type);
    }
    public void fillComboBoxWarehouse()
    {
        cmbWarehouse.removeAllItems();
        String sql = "SELECT * FROM warehouse";
        g.fillCombo(cmbWarehouse,sql);
        cmbWarehouse.setSelectedItem(warehouse);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblAddEditItem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMName = new javax.swing.JTextField();
        btnAdd1 = new javax.swing.JButton();
        cmbGrop = new javax.swing.JComboBox<>();
        cmbWarehouse = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(14, 114, 61));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddEditItem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAddEditItem.setForeground(new java.awt.Color(255, 255, 255));
        lblAddEditItem.setText("?????????? ????????????");
        jPanel2.add(lblAddEditItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 35));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("?????? ???????????? :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 90, 30));

        txtMName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMName.setMargin(new java.awt.Insets(2, 2, 2, 5));
        jPanel3.add(txtMName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 220, 30));

        btnAdd1.setBackground(new java.awt.Color(235, 235, 235));
        btnAdd1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(14, 114, 61));
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        btnAdd1.setText("??????????");
        btnAdd1.setBorderPainted(false);
        btnAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd1.setFocusable(false);
        btnAdd1.setIconTextGap(10);
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 180, 40));

        cmbGrop.setBackground(new java.awt.Color(254, 255, 255));
        cmbGrop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(cmbGrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 220, 30));

        cmbWarehouse.setBackground(new java.awt.Color(254, 255, 255));
        cmbWarehouse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(cmbWarehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 220, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("?????????? :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 80, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("???????????? :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 80, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 430, 330));

        setSize(new java.awt.Dimension(430, 406));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
   
        if(txtMName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "???????????? ?????? ?????? ??????????");
        }
        else
        {
            go g = new go();
            String sql = "UPDATE material SET Name ='" + txtMName.getText() + "', Type ='" + cmbGrop.getSelectedItem() + "', WarehouseName ='" + cmbWarehouse.getSelectedItem() + "' WHERE ID ='" + id +"'";
            g.query(sql);
            JOptionPane.showMessageDialog(null, "???? ??????????????");
            
            this.dispose();
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        jPanel3.requestFocus();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtMName.requestFocus();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(WarehouseUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WarehouseUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WarehouseUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WarehouseUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new WarehouseUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JComboBox<String> cmbGrop;
    private javax.swing.JComboBox<String> cmbWarehouse;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblAddEditItem;
    private javax.swing.JTextField txtMName;
    // End of variables declaration//GEN-END:variables
}
