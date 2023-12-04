
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class koneksi {
    Connection koneksi;
    public static Connection Koneksi() {
        try {
            Connection koneksi = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/db_reservasi_hotel", "root", "");
            return koneksi;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "lost connection : "+e);
            return null;
        }
    }
    public static void main(String[] args) {
        Koneksi();
    }
}
