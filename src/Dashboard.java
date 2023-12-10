
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private ResultSet res;
    private Statement stat;
    private PreparedStatement prepared;
    Connection conn = koneksi.Koneksi();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    DefaultTableModel model4 = new DefaultTableModel();
    String id_trans = "0";
    
    public Dashboard() {
        initComponents();
        DateToday();
        tampil_kamar();
        list_nomorKamar();
        tampil_karyawan();
        tampil_checkin();
        history();
    }
    
    void history(){
        Object[] kolom = {
            "ID","Nama", "Nomor kamar", "Email", "No Hp", "Gender", "Tanggal CheckIn", "Tanggal CheckOut", "Kasur", "Tipe", "Harga"
        };
        model4 = new DefaultTableModel(null, kolom);
        tbl_history.setModel(model4);
        try {
          stat = conn.createStatement();
          res = stat.executeQuery("SELECT * FROM customer");
          while (res.next()) {
            Object[] data = {
              res.getString("id"),
              res.getString("nama"),
              res.getString("nokamar"),
              res.getString("email"),
              res.getString("nohp"),
              res.getString("gender"),
              res.getString("tgl_checkin"),
              res.getString("tgl_checkout"),
              res.getString("kasur"),
              res.getString("tipe"),
              res.getString("harga")
            };
              model4.addRow(data);
          }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void DateToday(){
        LocalDate currentDate = LocalDate.now();
        // Format the date using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = currentDate.format(formatter);
        eTglHariini.setText(today);
        eTglck.setText(today);
    }
    
    void list_nomorKamar(){
        try {
            eNomorKamar.removeAllItems();
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT nomor_kamar FROM kamar WHERE status IS NULL");
            while (res.next()) {
                String nomorKamar = res.getString("nomor_kamar");
                eNomorKamar.addItem(nomorKamar);
            }
        } catch (SQLException e) {
        }
        eNomorKamar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomorkamar = (String) eNomorKamar.getSelectedItem();
                displayData(nomorkamar);
            }
        });
    }
    private void displayData(String nomorKamar) {
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT * FROM kamar WHERE nomor_kamar = '" + nomorKamar + "'");
            if (res.next()) {
                int harga = res.getInt("harga");
                String tipe = res.getString("tipe");
                String kasur = res.getString("kasur");
                eHarga.setText(String.valueOf(harga));
                eTipe.setText(tipe);
                eKasur.setText(kasur);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void tampil_checkin(){
        Object[] kolom = {
            "ID","Nama", "Nomor kamar", "Email", "No Hp", "Gender", "Tanggal CheckIn", "Tanggal CheckOut"
        };
        model3 = new DefaultTableModel(null, kolom);
        tbl_checkin.setModel(model3);
        try {
          stat = conn.createStatement();
          res = stat.executeQuery("SELECT * FROM customer");
          while (res.next()) {
            Object[] data = {
              res.getString("id"),
              res.getString("nama"),
              res.getString("nokamar"),
              res.getString("email"),
              res.getString("nohp"),
              res.getString("gender"),
              res.getString("tgl_checkin"),
              res.getString("tgl_checkout"),
            };
              model3.addRow(data);
          }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        eCustomer = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        eNohp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        eEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ewanita = new javax.swing.JRadioButton();
        epria = new javax.swing.JRadioButton();
        eTglHariini = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        eNomorKamar = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        eHarga = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        eKasur = new javax.swing.JTextField();
        eTipe = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        eNamack = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        eNohpck = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        eTglchekinck = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_checkin = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        eTglck = new javax.swing.JTextField();
        eNokamarck = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dtNomorKamar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dt_tipe = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dt_kasur = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dt_harga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_kamar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        eAlamatkry = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_kry = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        eNamakry = new javax.swing.JTextField();
        eConfPasskry = new javax.swing.JPasswordField();
        ePasskry = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_history = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 255, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(579, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("RESERVASI KAMAR HOTEL");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 580, -1));

        jLabel22.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("SISTEM INFORMASI");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 580, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel.jpeg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(579, 400));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        jTabbedPane1.addTab("Dashboard", jPanel2);

        jPanel6.setBackground(new java.awt.Color(0, 255, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(579, 400));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nama Customer");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel6.add(eCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nomor HP");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel6.add(eNohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 250, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel6.add(eEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 250, 40));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gender");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        buttonGroup1.add(ewanita);
        ewanita.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        ewanita.setForeground(new java.awt.Color(255, 255, 255));
        ewanita.setText("Wanita");
        jPanel6.add(ewanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        buttonGroup1.add(epria);
        epria.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        epria.setForeground(new java.awt.Color(255, 255, 255));
        epria.setText("Pria");
        jPanel6.add(epria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        eTglHariini.setEditable(false);
        eTglHariini.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel6.add(eTglHariini, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 250, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tanggal Chek In");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nomor Kamar");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Kasur");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        eNomorKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        jPanel6.add(eNomorKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 260, 40));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tipe kamar");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Harga");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        eHarga.setEditable(false);
        jPanel6.add(eHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 260, 40));

        jButton7.setText("Check In");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 130, 40));

        jButton8.setText("Clear");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 130, 40));

        eKasur.setEditable(false);
        jPanel6.add(eKasur, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 250, 40));

        eTipe.setEditable(false);
        jPanel6.add(eTipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 250, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel.jpeg"))); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(579, 400));
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        jTabbedPane1.addTab("Check In", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 255, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(579, 400));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(eNamack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 250, 40));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nama Customer");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Nomor HP");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel7.add(eNohpck, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 250, 40));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tanggal Chek In");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        eTglchekinck.setEditable(false);
        eTglchekinck.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel7.add(eTglchekinck, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 250, 40));

        jButton9.setText("Clear");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 120, 40));

        jButton10.setText("Check Out");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 120, 40));

        tbl_checkin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_checkin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_checkinMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_checkin);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 560, 130));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Tanggal Chek Out");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        eTglck.setEditable(false);
        eTglck.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel7.add(eTglck, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 250, 40));
        jPanel7.add(eNokamarck, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 40));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nomor Kamar");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel.jpeg"))); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(579, 400));
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        jTabbedPane1.addTab("Check Out", jPanel7);

        jPanel3.setBackground(new java.awt.Color(102, 0, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nomor Kamar");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel3.add(dtNomorKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipe kamar");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        dt_tipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "AC", "Non AC" }));
        jPanel3.add(dt_tipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 260, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kasur");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        dt_kasur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Singel", "Double", "Triple" }));
        jPanel3.add(dt_kasur, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Harga");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));
        jPanel3.add(dt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 260, 40));

        tabel_kamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_kamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kamarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_kamar);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 420, 190));

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 100, 40));

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 100, 40));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 100, 40));

        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 100, 40));

        jTabbedPane1.addTab("Data Kamar", jPanel3);

        jPanel4.setBackground(new java.awt.Color(102, 0, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel4.add(eAlamatkry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Alamat");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        tabel_kry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_kry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_kry);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 420, 180));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Konfirmasi Password");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jButton4.setText("Simpan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 100, 40));

        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 100, 40));

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 100, 40));
        jPanel4.add(eNamakry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 40));
        jPanel4.add(eConfPasskry, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 260, 40));
        jPanel4.add(ePasskry, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 260, 40));

        jTabbedPane1.addTab("Data Karyawan", jPanel4);

        jPanel5.setBackground(new java.awt.Color(102, 0, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbl_history);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 560, 280));

        jButton12.setText("Cetak");
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 110, 40));

        jTabbedPane1.addTab("History Reservasi", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 600, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void clear(){
        eCustomer.setText("");
        eNohp.setText("");
        eEmail.setText("");
        buttonGroup1.clearSelection();
        eNomorKamar.setSelectedIndex(0);
        eKasur.setText("");
        eTipe.setText("");
        eHarga.setText("");
    }
    
    void tampil_kamar(){
        Object[] kolom = {
            "Nomor", "Tipe", "Kasur", "Harga", "Status"
        };
        model1 = new DefaultTableModel(null, kolom);
        tabel_kamar.setModel(model1);
        try {
          stat = conn.createStatement();
          res = stat.executeQuery("SELECT * FROM kamar");
          while (res.next()) {
            Object[] data = {
              res.getString("nomor_kamar"),
              res.getString("tipe"),
              res.getString("kasur"),
              res.getString("harga"),
              res.getString("status")
            };
              model1.addRow(data);
          }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    void tampil_karyawan(){
        Object[] kolom = {
            "ID", "Username", "Password", "Alamat"
        };
        model2 = new DefaultTableModel(null, kolom);
        tabel_kry.setModel(model2);
        try {
          stat = conn.createStatement();
          res = stat.executeQuery("SELECT * FROM karyawan");
          while (res.next()) {
            Object[] data = {
              res.getString("id"),
              res.getString("username"),
              res.getString("password"),
              res.getString("alamat")
            };
              model2.addRow(data);
          }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String gender = "Pria";
        if (ewanita.isSelected()) {
            gender = "Wanita";
        }
        if (eCustomer.getText().equals("") || eNohp.getText().equals("") || eEmail.getText().equals("") || eHarga.getText().equals("") || eNomorKamar.getSelectedItem().toString().equals("Pilih") || eKasur.getText().equals("Pilih") || eTipe.getText().equals("Pilih")) {
            JOptionPane.showMessageDialog(this, "Form Input Masih Kosong");
        }else{
            try {
                String query = "INSERT INTO customer"
                    + "(nama,nohp,email,gender,tgl_checkin,nokamar,kasur,tipe,harga) "
                    + "VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?)";
                prepared = conn.prepareStatement(query);
                prepared.setString(1, eCustomer.getText());
                prepared.setString(2, eNohp.getText());
                prepared.setString(3, eEmail.getText());
                prepared.setString(4, gender);
                prepared.setString(5, eTglHariini.getText());
                prepared.setString(6, eNomorKamar.getSelectedItem().toString());
                prepared.setString(7, eKasur.getText());
                prepared.setString(8, eTipe.getText());
                prepared.setString(9, eHarga.getText());
                prepared.executeUpdate();
                update_statatus(eNomorKamar.getSelectedItem().toString());
                JOptionPane.showMessageDialog(this, "Berhasil Check In");
                clear();
                list_nomorKamar();
                tampil_checkin();
                tampil_kamar();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    void clear_checkout(){
        eNokamarck.setText("");
        eNamack.setText("");
        eNohpck.setText("");
        eTglchekinck.setText("");
        id_trans = "0";
    }
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        clear_checkout();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if (eNamack.getText().equals("") 
            || eNohpck.getText().equals("") 
            || eTglchekinck.getText().equals("") 
            || eTglck.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Form Inputan masih kosong");
        }else{
            try {
                String query = "UPDATE kamar "
                    + "SET status = NULL "
                    + "WHERE nomor_kamar="+eNokamarck.getText();
                prepared = conn.prepareStatement(query);
                prepared.executeUpdate();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Eror 1 "+e.getMessage());
            }
            try {
                System.out.println(eTglck.getText() +" | "+id_trans);
                String sql = "UPDATE customer SET tgl_checkout=? WHERE id=?";
                prepared = conn.prepareStatement(sql);
                prepared.setString(1, eTglck.getText());
                prepared.setString(2, id_trans);
                prepared.executeUpdate();
                JOptionPane.showMessageDialog(this, "Berhasil Chekout Kamar!");
                clear_checkout();
                list_nomorKamar();
                tampil_kamar();
                tampil_checkin();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Eror 2 "+e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    void bersih_kamar(){
        dtNomorKamar.setText("");
        dt_harga.setText("");
        dt_kasur.setSelectedIndex(0);
        dt_tipe.setSelectedIndex(0);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (dtNomorKamar.getText().equals("") 
            || dt_harga.getText().equals("") 
            || dt_kasur.getSelectedItem().equals("Pilih")
            || dt_tipe.getSelectedItem().equals("Pilih")) {
            JOptionPane.showMessageDialog(this, "Form Inputan masih kosong");
        }else{
            try {
                String query = "INSERT INTO kamar"
                    + "(nomor_kamar,tipe,kasur,harga) "
                    + "VALUES (?, ? ,?, ?)";
                prepared = conn.prepareStatement(query);
                prepared.setString(1, dtNomorKamar.getText());
                prepared.setString(2, dt_tipe.getSelectedItem().toString());
                prepared.setString(3, dt_kasur.getSelectedItem().toString());
                prepared.setString(4, dt_harga.getText());
                prepared.executeUpdate();
                JOptionPane.showMessageDialog(this, "Berhasil Menambahkan Kamar!");
                bersih_kamar();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (dtNomorKamar.getText().equals("") 
            || dt_harga.getText().equals("") 
            || dt_kasur.getSelectedItem().equals("Pilih")
            || dt_tipe.getSelectedItem().equals("Pilih")) {
            JOptionPane.showMessageDialog(this, "Form Inputan masih kosong");
        }else{
            try {
                String query = "UPDATE kamar "
                    + "SET tipe=?,kasur=?,harga=? "
                    + "WHERE nomor_kamar=?";
                prepared = conn.prepareStatement(query);
                prepared.setString(1, dt_tipe.getSelectedItem().toString());
                prepared.setString(2, dt_kasur.getSelectedItem().toString());
                prepared.setString(3, dt_harga.getText());
                prepared.setString(4, dtNomorKamar.getText());
                prepared.executeUpdate();
                JOptionPane.showMessageDialog(this, "Berhasil Mengupdate Kamar!");
                bersih_kamar();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (dtNomorKamar.getText().equals("") 
            || dt_harga.getText().equals("") 
            || dt_kasur.getSelectedItem().equals("Pilih")
            || dt_tipe.getSelectedItem().equals("Pilih")) {
            JOptionPane.showMessageDialog(this, "Form Inputan masih kosong");
        }else{
            try {
                String query = "DELETE FROM kamar "
                    + "WHERE nomor_kamar=?";
                prepared = conn.prepareStatement(query);
                prepared.setString(1, dtNomorKamar.getText());
                prepared.executeUpdate();
                JOptionPane.showMessageDialog(this, "Berhasil Menghapus Kamar!");
                bersih_kamar();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        bersih_kamar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabel_kamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kamarMouseClicked
        // TODO add your handling code here:
        int row = tabel_kamar.getSelectedRow();
        dtNomorKamar.setText(model1.getValueAt(row, 0).toString());
        dt_tipe.setSelectedItem(model1.getValueAt(row, 1).toString());
        dt_kasur.setSelectedItem(model1.getValueAt(row, 2).toString());
        dt_harga.setText(model1.getValueAt(row, 3).toString());
        
    }//GEN-LAST:event_tabel_kamarMouseClicked

    private void tabel_kryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kryMouseClicked
        // TODO add your handling code here:
        int row = tabel_kry.getSelectedRow();
        idkaryawan = model2.getValueAt(row, 0).toString();
        eNamakry.setText(model2.getValueAt(row, 1).toString());
        ePasskry.setText(model2.getValueAt(row, 2).toString());
        eAlamatkry.setText(model2.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tabel_kryMouseClicked
    String idkaryawan = "";
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (eNamakry.getText().equals("") 
            || ePasskry.getText().equals("") 
            || eConfPasskry.getText().equals("") 
            || eAlamatkry.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Form Inputan masih kosong");
        }else{
            if (!ePasskry.getText().equals(eConfPasskry.getText())) {
                JOptionPane.showMessageDialog(this, "Password Tidak sama");
            }else{
                try {
                    String query = "UPDATE karyawan "
                        + "SET username=?,password=?,alamat=? "
                        + "WHERE id =" +idkaryawan;
                    prepared = conn.prepareStatement(query);
                    prepared.setString(1, eNamakry.getText());
                    prepared.setString(2, ePasskry.getText());
                    prepared.setString(3, eAlamatkry.getText());
                    prepared.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Berhasil");
                    bersih_karyawan();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    void bersih_karyawan(){
        eNamakry.setText("");
        ePasskry.setText("");
        eConfPasskry.setText("");
        eAlamatkry.setText("");
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (eNamakry.getText().equals("") 
            || ePasskry.getText().equals("") 
            || eConfPasskry.getText().equals("") 
            || eAlamatkry.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Form Inputan masih kosong");
        }else{
            if (!ePasskry.getText().equals(eConfPasskry.getText())) {
                JOptionPane.showMessageDialog(this, "Password Tidak sama");
            }else{
                try {
                    String query = "INSERT INTO karyawan"
                        + "(username,password,alamat) "
                        + "VALUES (?, ? ,?)";
                    prepared = conn.prepareStatement(query);
                    prepared.setString(1, eNamakry.getText());
                    prepared.setString(2, ePasskry.getText());
                    prepared.setString(3, eAlamatkry.getText());
                    prepared.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Berhasil");
                    bersih_karyawan();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (eNamakry.getText().equals("") 
            || ePasskry.getText().equals("") 
            || eConfPasskry.getText().equals("") 
            || eAlamatkry.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Form Inputan masih kosong");
        }else{
            if (!ePasskry.getText().equals(eConfPasskry.getText())) {
                JOptionPane.showMessageDialog(this, "Password Tidak sama");
            }else{
                try {
                    String query = "DELETE FROM karyawan "
                        + "WHERE id =" +idkaryawan;
                    prepared.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Berhasil");
                    bersih_karyawan();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tbl_checkinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_checkinMouseClicked
        // TODO add your handling code here:
        try {
            int row = tbl_checkin.getSelectedRow();
            TableModel model = tbl_checkin.getModel();
            id_trans = (model.getValueAt(row, 0).toString());
            eNamack.setText(model.getValueAt(row, 1).toString());
            eNokamarck.setText(model.getValueAt(row, 2).toString());
            eNohpck.setText(model.getValueAt(row, 4).toString());
            eTglchekinck.setText(model.getValueAt(row, 5).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_checkinMouseClicked
    void update_statatus(String nokamar){
        try {
                String query = "UPDATE kamar SET status = 'Booked' "
                    + "WHERE nomor_kamar = " + nokamar;
                prepared = conn.prepareStatement(query);
                prepared.executeUpdate();
                System.out.println("kamar berhasil di Booking!");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Eror "+e.getMessage());
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstatate="collaprepareded" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, statay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dtNomorKamar;
    private javax.swing.JTextField dt_harga;
    private javax.swing.JComboBox<String> dt_kasur;
    private javax.swing.JComboBox<String> dt_tipe;
    private javax.swing.JTextField eAlamatkry;
    private javax.swing.JPasswordField eConfPasskry;
    private javax.swing.JTextField eCustomer;
    private javax.swing.JTextField eEmail;
    private javax.swing.JTextField eHarga;
    private javax.swing.JTextField eKasur;
    private javax.swing.JTextField eNamack;
    private javax.swing.JTextField eNamakry;
    private javax.swing.JTextField eNohp;
    private javax.swing.JTextField eNohpck;
    private javax.swing.JTextField eNokamarck;
    private javax.swing.JComboBox<String> eNomorKamar;
    private javax.swing.JPasswordField ePasskry;
    private javax.swing.JTextField eTglHariini;
    private javax.swing.JTextField eTglchekinck;
    private javax.swing.JTextField eTglck;
    private javax.swing.JTextField eTipe;
    private javax.swing.JRadioButton epria;
    private javax.swing.JRadioButton ewanita;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabel_kamar;
    private javax.swing.JTable tabel_kry;
    private javax.swing.JTable tbl_checkin;
    private javax.swing.JTable tbl_history;
    // End of variables declaration//GEN-END:variables
}
