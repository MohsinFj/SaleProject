/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellstation;

import Forms.*;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import sql.*;
/**
 *
 * @author Mohsin
 */
public class SellStation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try 
        {
            StartForm sf = new StartForm();
            sf.setVisible(true);
            
            Thread.sleep(2500);
            
            String sql1 = "SELECT Quantity FROM `material` WHERE Quantity < 5";
            String result = go.getData(sql1);
            if(!result.equals(""))
            {
                JOptionPane.showMessageDialog(null,"بعض السلع على وشك النفاذ الرجاء التحقق من المخزن");
            }
            
            sf.dispose();
            
            new MainForm().setVisible(true);
            
        } 
        catch (InterruptedException | HeadlessException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        //new MainForm().setVisible(true);
        //new Warehouse().setVisible(true);
       
        //new Buy().setVisible(true);
        //new Clinets().setVisible(true);
        //new ClientsAndProvider().setVisible(true);
        //new Sale().setVisible(true);
        //new reports().setVisible(true);
        //new Setting().setVisible(true);
        
        //new Return().setVisible(true);

        
        //new go().getConnection();

    }
    
}
