
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

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
}
