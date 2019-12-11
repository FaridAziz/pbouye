package semangatkomputer.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Pembelian {
    private int id_pembelian;
    private Pelanggan pelanggan = new Pelanggan();
    private Laptop produk = new Laptop();
    private String tanggal_pembelian;
    
    public Pembelian(){
        
    }
    
    public Pembelian(Pelanggan pelanggan, Laptop produk, String tanggal_pembelian){
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.tanggal_pembelian = tanggal_pembelian;
    }

    public int getId_pembelian() {
        return id_pembelian;
    }

    public void setId_pembelian(int id_pembelian) {
        this.id_pembelian = id_pembelian;
    }

    public Pelanggan getpelanggan() {
        return pelanggan;
    }

    public void setpelanggan(Pelanggan idpelanggan) {
        this.pelanggan = idpelanggan;
    }

    public Laptop getproduk() {
        return produk;
    }

    public void setproduk(Laptop id_produk) {
        this.produk = id_produk;
    }

    public String getTanggal_pembelian() {
        return tanggal_pembelian;
    }

    public void setTanggal_pembelian(String tanggal_pembelian) {
        this.tanggal_pembelian = tanggal_pembelian;
    }

       
    public Pembelian getById(int id) {
        Pembelian pem = new Pembelian();
        ResultSet rs = Koneksi.selectQuery("SELECT "
                                            + " p.id_pembelian AS id_pembelian,"
                                            + " pl.id_pelanggan AS id_pelanggan,"
                                            + " pl.nama_pelanggan AS nama_pelanggan,"
                                            + " pl.email AS email,"
                                            + " pl.telepon AS telepon,"
                                            + " pr.id_produk AS id_produk,"
                                            + " pr.jenis_barang AS jenis_barang,"
                                            + " pr.merk_barang AS merk_barang,"
                                            + " pr.id_processor AS id_processor,"
                                            + " pr.id_ram AS id_ram,"
                                            + " pr.id_vga AS id_vga,"
                                            + " pr.harga AS harga,"
                                            + " p.tanggal_pembelian AS tanggal_pembelian"
                                            + " FROM pembelian p"
                                            + " LEFT JOIN produk pr ON p.id_produk = pr.id_produk"
                                            + " LEFT JOIN pelanggan pl ON p.id_pelanggan = pl.id_pelanggan"
                                            + " WHERE p.id_pembelian = '" + id + "'");
        try {
            while(rs.next()) {
                pem = new Pembelian();
                pem.setId_pembelian(rs.getInt("id_pembelian"));
                pem.getpelanggan().setIdpelanggan(rs.getInt("id_pelanggan"));
                pem.getpelanggan().setNama(rs.getString("nama_pelanggan"));
                pem.getpelanggan().setEmail(rs.getString("email"));
                pem.getpelanggan().setTelepon(rs.getString("telepon"));
                pem.getproduk().setId_produk(rs.getInt("id_produk"));
                pem.getproduk().setJenis(rs.getString("jenis_barang"));
                pem.getproduk().setMerk(rs.getString("merk_barang"));
                pem.getproduk().getProc().setIdProcessor(rs.getInt("id_processor"));
                pem.getproduk().getRam().setIdRam(rs.getInt("id_ram"));
                pem.getproduk().getVga().setId_vga(rs.getInt("id_vga"));
                pem.getproduk().setHarga(rs.getInt("harga"));
                pem.setTanggal_pembelian(rs.getString("tanggal_pembelian"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pem;
    }
    
    public ArrayList<Pembelian> getAll() {
        ArrayList<Pembelian> ListPembelian = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT "
                                            + " p.id_pembelian AS id_pembelian,"
                                            + " pl.id_pelanggan AS id_pelanggan,"
                                            + " pl.nama_pelanggan AS nama_pelanggan,"
                                            + " pl.email AS email,"
                                            + " pl.telepon AS telepon,"
                                            + " pr.id_produk AS id_produk,"
                                            + " pr.jenis_barang AS jenis_barang,"
                                            + " pr.merk_barang AS merk_barang,"
                                            + " pr.id_processor AS id_processor,"
                                            + " pr.id_ram AS id_ram,"
                                            + " pr.id_vga AS id_vga,"
                                            + " pr.harga AS harga,"
                                            + " p.tanggal_pembelian AS tanggal_pembelian"
                                            + " FROM pembelian p"
                                            + " LEFT JOIN produk pr ON p.id_produk = pr.id_produk "
                                            + " LEFT JOIN pelanggan pl ON p.id_pelanggan = pl.id_pelanggan");
                                            
        try {
            while(rs.next()) {
                Pembelian pem = new Pembelian();
                pem.setId_pembelian(rs.getInt("id_pembelian"));
//                pem.getpelanggan().setIdpelanggan(rs.getInt("id_pelanggan"));
                pem.getpelanggan().setNama(rs.getString("nama_pelanggan"));
//                pem.getpelanggan().setEmail(rs.getString("email"));
//                pem.getpelanggan().setTelepon(rs.getString("telepon"));
//                pem.getproduk().setId_produk(rs.getInt("id_produk"));
//                pem.getproduk().setJenis(rs.getString("jenis_barang"));
                pem.getproduk().setMerk(rs.getString("merk_barang"));
//                pem.getproduk().getProc().setIdProcessor(rs.getInt("id_processor"));
//                pem.getproduk().getRam().setIdRam(rs.getInt("id_ram"));
//                pem.getproduk().getVga().setId_vga(rs.getInt("id_vga"));
//                pem.getproduk().setHarga(rs.getInt("harga"));
                pem.setTanggal_pembelian(rs.getString("tanggal_pembelian"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListPembelian;
    }
    
    public ArrayList<Pembelian> search(String keyword) {
        ArrayList<Pembelian> ListPembelian = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT "
                                            + " p.id_pembelian AS id_pembelian,"
                                            + " pl.id_pelanggan AS id_pelanggan,"
                                            + " pl.nama_pelanggan AS nama_pelanggan,"
                                            + " pl.email AS email,"
                                            + " pl.telepon AS telepon,"
                                            + " pr.id_produk AS id_produk,"
                                            + " pr.jenis_barang AS jenis_barang,"
                                            + " pr.merk_barang AS merk_barang,"
                                            + " pr.id_processor AS id_processor,"
                                            + " pr.id_ram AS id_ram,"
                                            + " pr.id_vga AS id_vga,"
                                            + " pr.harga AS harga,"
                                            + " p.tanggal_pembelian AS tanggal_pembelian"
                                            + " FROM pembelian p"
                                            + " LEFT JOIN produk pr ON p.id_produk = pr.id_produk"
                                            + " LEFT JOIN pelanggan pl ON p.id_pelanggan = pl.id_pelanggan");
        try {
            while(rs.next()) {
                Pembelian pem = new Pembelian();
                pem.setId_pembelian(rs.getInt("id_pembelian"));
                pem.getpelanggan().setIdpelanggan(rs.getInt("id_pelanggan"));
                pem.getpelanggan().setNama(rs.getString("nama_pelanggan"));
                pem.getpelanggan().setEmail(rs.getString("email"));
                pem.getpelanggan().setTelepon(rs.getString("telepon"));
                pem.getproduk().setId_produk(rs.getInt("id_produk"));
                pem.getproduk().setJenis(rs.getString("jenis_barang"));
                pem.getproduk().setMerk(rs.getString("merk_barang"));
                pem.getproduk().getProc().setIdProcessor(rs.getInt("id_processor"));
                pem.getproduk().getRam().setIdRam(rs.getInt("id_ram"));
                pem.getproduk().getVga().setId_vga(rs.getInt("id_vga"));
                pem.getproduk().setHarga(rs.getInt("harga"));
                pem.setTanggal_pembelian(rs.getString("tanggal_pembelian"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListPembelian;
    }
    
    public void save() {
        if(getById(id_pembelian).getId_pembelian()== 0) {
            String SQL = "INSERT INTO pembelian (id_pelanggan, id_produk, tanggal_pembelian) VALUES("
                        + "'" + this.getpelanggan().getIdpelanggan()+ "', "
                        + "'" + this.getproduk().getId_produk() + "', "
                        + "'" + this.tanggal_pembelian + "'"
                        + ")";
            this.id_pembelian = Koneksi.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE pembelian SET"
                        + " id_pelanggan = '" + this.getpelanggan().getIdpelanggan() + "', "
                        + " id_produk = '" + this.getproduk().getId_produk() + "', "
                        + " tanggal_pembelian = '" + tanggal_pembelian + "'"
                        + " WHERE id_pembelian = '" + this.id_pembelian + "'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM pembelian WHERE id_pembelian = '" + this.id_pembelian + "'";
        Koneksi.executeQuery(SQL);
    }
    
    @Override
    public String toString() {
        return tanggal_pembelian;
    }
}
