
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Conection {

    private Connection conexion = null;
    private ResultSet rs = null;
    private Statement s = null;


    public Connection getConexion() {
        return conexion;
    }

    public boolean conexion() {
        /* if (conexion != null) {
            return;
        }*/
        String host = "localhost";
        String DB = "Register";
        String user = "postgres";
        String pass = "Micho137";

        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + DB, user, pass);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Ocurrio el problema: \n" + e);
            return false;
        }
    }


    public void Registro(String name, int age, String id, String gen, String semester, String username, String pass) {
        try {
            s = conexion.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Student\"(\"name\", \"age\", \"id\", \"gen\", \"semester\", \"Username\", \"Pass\")"
                    + "\nVALUES ('" + name + "', '" + age + "', '" + id + "', '" + gen + "', '" + semester + "', '" + username + "', '" + pass + "')");
            if (z == 1) {
            } else {

                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Anuel
    public void RegistroDoc(String name,String email, String level, String schedule, String pass, String username, int code, String pnumber) {

        try {
            s = conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO \"Teacher\"(\"name\", \"email\", \"level\", \"schedule\", \"Password\", \"Username\", \"code\", \"pnumber\")"
                    + "\nVALUES ('" + name + "', '" + email + "', '" + level + "', '" + schedule + "', '" + pass + "', '" + username + "', '" + code + "', '" + pnumber + "')");
            if (z == 1) {
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Docente registrado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void Registro3(String name, int code, String duration, String modality, int credits) {
        try {
            s = conexion.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Course\"(\"name\", \"code\", \"duration\", \"modality\", \"credits\")"
                    + "\nVALUES ('" + name + "', '" + code + "', '" + duration + "', '" + modality + "', '" + credits + "')");
            if (z == 1) {
            } else {

                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Curso registrado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void mostrarEstudiantes(DefaultTableModel tab) {


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
