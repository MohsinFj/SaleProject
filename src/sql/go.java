/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohammad
 */
public class go {
    
    private static Connection con = null;
    ArrayList Name = new ArrayList();
    
    
    public static Connection getConnection()
    {
        try 
        {
            String url="jdbc:mysql://localhost:3306/sellStation?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            
            con = DriverManager.getConnection(url, "root", "mohsinfj");
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return con;
    }
    
    
    public String query(String sqlQuery)
    {
        try 
        {
            getConnection();
            Statement stm=con.createStatement();
            
            stm.executeUpdate(sqlQuery);
            con.close();
        } 
        catch (SQLException e) 
        {
            return e.getMessage();
        }
        
        return "";
    }
    
    public static String[] GetInformation(String sql, int size)
    {
        try 
        {
            getConnection();
            
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData(); //حتى نتعامل مع عدد الاعمدة
            int c=rsmd.getColumnCount();
            
                                      //تمثل عدد المعلمات المراد جلبها من قاعدة البيانات
            String [] row = new String[size];
            
            while(rs.next())
            {
                for(int i=0 ;i<c ;i++)
                {
                    row[i] = rs.getString(i+1);
                }
                //row[i] = rs.getString(i+1);
//                String r2=rs.getString(2);
//                String r3=rs.getString(3);
                
//                row[1] = r1;
//                row[2] = r2;
            }
            
            con.close();
            return row;
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
    public static String getData(String sql)
    {
        try 
        {
            getConnection();
            PreparedStatement pr= con.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            
            
            
            //DefaultTableModel model=(DefaultTableModel)table.getModel();
            String ID = "";
            while(rs.next())
            {
                ID=rs.getString(1);
                //model.addRow(new Object[]{r1,r2,r3,r4});
            }
            
            con.close();
            return ID;
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return "";
    }
    
    public void fillCombo(JComboBox combobox , String sql)
    {
        try 
        {
            getConnection();
            
            PreparedStatement pr= con.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            
            while(rs.next())
            {
                String name=rs.getString("name");
                combobox.addItem(name);
            }
            con.close();
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList autoComplete(String sql)
    {
        try 
        {
            getConnection();
            
            PreparedStatement pr= con.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            
            while(rs.next())
            {
                String name=rs.getString("name");
                Name.add(name);
            }
            con.close();
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return Name;
    }
    
    public  void fillToJTable(String tableNameOrSelectStatement , JTable table)
    {
        try 
        {
            getConnection();
            Statement stm=con.createStatement();
            ResultSet rs;
            String strSelect;  //جملة التنفيذ هل هي اسم جدول ام جملة تنفيذ
            if("select ".equals(tableNameOrSelectStatement.substring(0,7).toLowerCase()))
            {
                strSelect=tableNameOrSelectStatement;
            }
            else
            {
                strSelect="select * From " + tableNameOrSelectStatement;
            }
            
            rs=stm.executeQuery(strSelect);
                                    
                                   //جلب هيكلية البيانات
            ResultSetMetaData rsmd=rs.getMetaData(); //حتى نتعامل مع عدد الاعمدة
            int c=rsmd.getColumnCount();  //جلب عدد الاعمدة 
            
            //نحتاج التعامل مع نموذج جدول
            DefaultTableModel model=(DefaultTableModel)table.getModel();  //حتى نضيف فيه عناصر الصف عند اكمال الفور
            
            //يشبه كلاس الجدول يعني اسمه دوت اضافة اسمه دوت حذف وهكذ
            Vector row=new Vector();    //نملئ الجدول به
            model.setRowCount(0);      //نقوم بتفريغ الجول اي لا يحتوي على اي صف
            
            while(rs.next())
            { 
                row=new Vector(c); //نعطيه عدد الاعمدة في كل دورة
                
                //ندور على كل عمود
                for(int i=1 ;i<=c ;i++)
                {
                    row.add(rs.getString(i));
                }
                model.addRow(row); //هنا قمنا باضافة الصف الى الجول المحدد
            }
            
            //اذا كان عدد الاعمدة من جملة الاستعلام لا تساوي عدد الاعمدة في الجدول نظهر له رسالة خطأ
            if(table.getColumnCount()!=c)
            {
                JOptionPane.showMessageDialog(null,"JTable Culomn Count Not Equal Query Culomn Count !\nJTable CulomnCount = " +table.getColumnCount() + " \nQuery CulomnCount = " + c);
            }
            con.close();
        } 
        catch (SQLException e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public String setting(String sql,String percent, String path)
    {
       try 
       {  
        getConnection();
        PreparedStatement statement = null;
        if(path.equals(""))
        {
            statement = con.prepareStatement(sql);
            statement.setString(1, percent);
            statement.setBinaryStream(2, null);
        }
        else
        {
            FileInputStream inputStream = new FileInputStream(path);
            File image = new File(path);

            statement = con.prepareStatement(sql);
            statement.setString(1, percent);
            statement.setBinaryStream(2, (InputStream)inputStream, (int)(image.length()));
        }

        statement.executeUpdate();
        con.close();
        return "";
       } catch (FileNotFoundException | SQLException e) {
           return e.getMessage();
       }
    }
}

