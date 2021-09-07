
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
        con.conexion();
        return true;
    }

    public boolean Login(String name, String pass) {

        if (!validador()) {
            JOptionPane.showMessageDialog(null, "Connection fail");
        } else {

            try {
                ps = con.getConexion().prepareStatement("SELECT * FROM user WHERE Name = ?");
                ps.setString(1, name);

                rs = ps.executeQuery();

                if (rs.next()) {
                    if (rs.getString("name").equals(name) && rs.getString("password").equals(pass)) {
                        JOptionPane.showMessageDialog(null, "Inicio Valido");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
                        return false;
                    }
                }

            } catch (SQLException ex) {
                return false;
            }

        }
        return false;
    }
}
