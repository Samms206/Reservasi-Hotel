
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookpro
 */
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
