
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


    public void Registro(String username, String pass, int age, String name, String id, String gen, String semester) {
        try {
            s = conexion.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Student\"(\"name\", \"age\", \"id\", \"gen\", \"semester\", \"username\", \"pass\")"
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

    public void RegistroDoc(String username, String pass, String name, int code, String email, String pnumber, String level, String schedule) {

        try {
            s = conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO \"Teacher\"(\"Username\", \"Password\")"
                    + "\nVALUES ('" + name + "', '" + code + "', '" + email + "', '" + pnumber + "', '" + level + "', '" + schedule + "', '" + username + "', '" + pass + "')");
            if (z == 1) {
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
            JOptionPane.showMessageDialog(null, "Docente registrado exitosamente");
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
