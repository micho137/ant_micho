
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario {

    Conection con = new Conection();
    private ResultSet rs;
    private PreparedStatement ps;

    public Usuario() {

        this.rs = null;
        this.ps = null;
    }

    public boolean validador() {

        return con.conexion();

    }

    public String[] namesStudent(String Username) {
        String vec[] = new String[2];

        try {
//            ps = con.getConexion().prepareStatement("SELECT name , \"Username\" FROM \"Student\" WHERE \"Username\" = '" + Username + "';");
            ps = con.getConexion().prepareStatement("SELECT name FROM \"Student\" WHERE \"Username\" = '" + Username + "';");
            rs = ps.executeQuery();
            if (rs.next()) {
                vec[0] = rs.getString("name");
                vec[1] = rs.getString("\"Username\"");
                JOptionPane.showMessageDialog(null, "Inicio Valido");
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return vec;
    }

    public boolean Login(String name, String pass) {

        if (!validador()) {
            JOptionPane.showMessageDialog(null, "Connection fail");
        } else {

            try {
                ps = con.getConexion().prepareStatement("SELECT * FROM \"Student\" WHERE \"Username\" ='" + name + "' AND \"Pass\" = '" + pass + "';");

                rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Inicio Valido");
                    return true;

                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
                    return false;
                }
            } catch (SQLException ex) {
                return false;
            }
        }
        return false;
    }

    public boolean Login2(String username, String password) {

        if (!validador()) {
            JOptionPane.showMessageDialog(null, "Connection fail");
        } else {

            try {
                ps = con.getConexion().prepareStatement("SELECT * FROM \"Teacher\" WHERE \"Username\" ='" + username + "' AND \"Password\" = '" + password + "';");
                rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Inicio Valido");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
                    return false;
                }
            } catch (SQLException ex) {
                return false;
            }
        }
        return false;
    }

    public DefaultTableModel mostrarEstudiantes(DefaultTableModel tab) {
        if (!validador()) {
            JOptionPane.showMessageDialog(null, "Connection fail");
        } else {
            try {
                ps = con.getConexion().prepareStatement("SELECT * FROM Student");
                ps = con.getConexion().prepareStatement("SELECT * FROM \"Student\"");
                rs = ps.executeQuery();
                int cont = 0;
                while (rs.next()) {
                    tab.setRowCount(cont + 1);
                    tab.setValueAt(rs.getString("name"), cont, 0);
                    tab.setValueAt(rs.getString("age"), cont, 1);
                    tab.setValueAt(rs.getInt("age"), cont, 1);
                    tab.setValueAt(rs.getString("id"), cont, 2);
                    tab.setValueAt(rs.getString("gen"), cont, 3);
                    tab.setValueAt(rs.getString("semester"), cont, 4);
                }
            } catch (Exception e) {

            }
        }
        return tab;
    }

    public DefaultTableModel mostrarCursos(DefaultTableModel tab) {
        if (!validador()) {
            JOptionPane.showMessageDialog(null, "Connection fail");
        } else {
            try {

                ps = con.getConexion().prepareStatement("SELECT * FROM \"Course\"");
                rs = ps.executeQuery();
                int cont = 0;
                while (rs.next()) {
                    tab.setRowCount(cont + 1);
                    tab.setValueAt(rs.getString("name"), cont, 0);
                    tab.setValueAt(rs.getInt("code"), cont, 1);
                    tab.setValueAt(rs.getString("duration"), cont, 2);
                    tab.setValueAt(rs.getString("modality"), cont, 3);
                    tab.setValueAt(rs.getInt("credits"), cont, 4);
                    cont++;
                }
            } catch (Exception e) {

            }
        }
        return tab;
    }

    public DefaultTableModel mostrarDocentes(DefaultTableModel tab) {
        if (!validador()) {
            JOptionPane.showMessageDialog(null, "Connection fail");
        } else {
            try {

                ps = con.getConexion().prepareStatement("SELECT * FROM \"Teacher\"");
                rs = ps.executeQuery();
                int cont = 0;
                while (rs.next()) {
                    tab.setRowCount(cont + 1);
                    tab.setValueAt(rs.getString("name"), cont, 0);
                    tab.setValueAt(rs.getString("email"), cont, 1);
                    tab.setValueAt(rs.getString("level"), cont, 2);
                    tab.setValueAt(rs.getString("shedule"), cont, 3);
                    tab.setValueAt(rs.getInt("code"), cont, 4);
                    tab.setValueAt(rs.getInt("pnumber"), cont, 5);
                    cont++;
                }
            } catch (Exception e) {

            }
        }
        return tab;
    }
}
