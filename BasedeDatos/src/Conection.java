
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Conection {

    private Connection conexion = null;
    private ResultSet rs = null;
    private Statement s = null;
<<<<<<< Updated upstream

    public Connection getConexion() {
        return conexion;
    }

    public boolean conexion() {
        /* if (conexion != null) {
            return;
        }*/
=======
    
    
    public boolean conexion() {
        //  if (conexion != null) {
        //          return;
        //    }
>>>>>>> Stashed changes
        String host = "localhost";
        String DB = "Register";
        String user = "postgres";
        String pass = "Micho137";
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + DB, user, pass);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Ocurrio el problema: \n" + e);
            return false;
        }
    }
<<<<<<< Updated upstream

    public void Registro(String username, String pass) {
        try {
            s = conexion.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Student\"(\"Username\", \"Pass\")"
                    + "\nVALUES ('" + username + "', '" + pass + "')");
            if (z == 1) {
            } else {
=======
    
    

    public void Registro(String username, String pass) {

        try {
            s = conexion.createStatement();
            int z = s.executeUpdate("INSERT INTO \"NewStudent\"(\"Username\", \"Pass\")"
                    + "\nVALUES ('" + username + "', '" + pass + "')");
            if (z == 1) {

            } else {

>>>>>>> Stashed changes
                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void RegistroDoc(String username, String pass) {

        try {
            s = conexion.createStatement();
<<<<<<< Updated upstream
            int z = s.executeUpdate("INSERT INTO \"Teacher\"(\"Username\", \"Password\")"
                    + "\nVALUES ('" + username + "', '" + pass + "')");
            if (z == 1) {
            } else {
=======
            int z = s.executeUpdate("INSERT INTO \"NewDoc\"(\"Username\", \"Password\")"
                    + "\nVALUES ('" + username + "', '" + pass + "')");
            if (z == 1) {

            } else {

>>>>>>> Stashed changes
                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Docente registrado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

<<<<<<< Updated upstream
    public void mostrarEstudiantes(DefaultTableModel tab) {
=======
    public void mostrarEstudiantes(JTable tab1, DefaultTableModel tab) {
>>>>>>> Stashed changes

        try {
            s = conexion.createStatement();
            rs = s.executeQuery("SELECT * FROM Student");
            int cont = 0;
            while (rs.next()) {
                tab.setRowCount(cont + 1);
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
