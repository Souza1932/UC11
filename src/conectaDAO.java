
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
       
        
        
        
    String url = "jdbc:mysql://localhost:3306/newschema?**useSSL=false**";  
    String user = "root";
    String password = "235410@Clo!??";
    
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
            
        } catch (SQLException  | ClassNotFoundException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO");
            return null;
        }
        
    }
    
}
