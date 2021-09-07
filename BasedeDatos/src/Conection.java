
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Conection {

    private Connection conexion = null;
    private ResultSet rs = null;
    private Statement s = null;

    public void connectDatabase() {
        
    }

    public void conexion() {
        if (conexion != null) {
        
        return;
    }
    String host = "localhost";
    String DB = "Register";
    String user = "postgres";
    String pass = "Micho137";

    
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + DB, user, pass);
        
        
    }catch(Exception e){
    
        System.out.println(e);
        JOptionPane.showMessageDialog(null, "Ocurrio el problema: \n" + e);
    }
}
    
    public void Registro(String username, String pass){
    
        try {
            s = conexion.createStatement();
            int z = s.executeUpdate("INSERT INTO \"NewStudent\"(\"Username\", \"Pass\")"
                    + "\nVALUES ('"+username+"', '"+pass+"')");
            if (z==1){
            
                
            }else{
            
                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void RegistroDoc(String username, String pass){
    
        try {
            s = conexion.createStatement();
            int z = s.executeUpdate("INSERT INTO \"NewDoc\"(\"Username\", \"Password\")"
                    + "\nVALUES ('"+username+"', '"+pass+"')");
            if (z==1){
            
                
            }else{
            
                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Docente registrado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void mostrarEstudiantes(DefaultTableModel tab){
    
        try {
            s = conexion.createStatement();
            rs = s.executeQuery("SELECT * FROM Student");
            int cont = 0;
            while(rs.next()){
            tab.setRowCount(cont+1);
            tab.setValueAt(rs.getString("name"), cont, 0);
            tab.setValueAt(rs.getString("age"), cont, 1);
            tab.setValueAt(rs.getString("id"), cont, 2);
            tab.setValueAt(rs.getString("gen"), cont, 3);
            tab.setValueAt(rs.getString("semester"), cont, 4);
            cont++;
            }
        } catch (Exception e) {
        }
    }

}