package semangatkomputer.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Laptop extends Komputer{
    private int id_produk;
    private int harga;
    private Processor proc = new Processor();
    private Vga vga = new Vga();
    private Ram ram = new Ram();
    
    public Laptop(){
        
    }
    public Laptop(String merk, Processor proc, Vga vga, Ram ram, int harga){
        this.merk = merk;
        this.proc = proc;
        this.vga = vga;
        this.ram = ram;
        this.harga = harga;
    }

    @Override
    public String getMerk() {
        return merk;
    }

    @Override
    public void setMerk(String merk) {
        this.merk = merk;
    }

    @Override
    public String getJenis() {
        return jenis;
    }

    @Override
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public Processor getProc() {
        return proc;
    }

    public void setProc(Processor proc) {
        this.proc = proc;
    }

    public Vga getVga() {
        return vga;
    }

    public void setVga(Vga vga) {
        this.vga = vga;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }
    
    public Laptop getById(int id) {
        Laptop l = new Laptop();
        ResultSet rs = Koneksi.selectQuery("SELECT "
                                            + " p.id_produk AS id_produk,"
                                            + " p.jenis_barang AS jenis_barang,"
                                            + " p.merk_barang AS merk_barang,"
                                            + " pr.id_processor AS id_processor,"
                                            + " pr.merk AS merk,"
                                            + " pr.speed AS speed,"
                                            + " r.id_ram AS id_ram,"
                                            + " r.type AS type,"
                                            + " r.kapasitas AS kapasitas,"
                                            + " v.id_vga AS id_vga,"
                                            + " v.brand AS brand,"
                                            + " v.memory AS memory,"
                                            + " p.harga AS harga"
                                            + " FROM produk p"
                                            + " JOIN processor pr ON p.id_processor = pr.id_processor"
                                            + " JOIN ram r ON p.id_ram = r.id_ram"
                                            + " JOIN vga v ON p.id_vga = v.id_vga"
                                            + " WHERE p.id_produk = '" + id + "'");
        try {
            while(rs.next()) {
                l = new Laptop();
                l.setId_produk(rs.getInt("id_produk"));
                l.setJenis(rs.getString("jenis_barang"));
                l.setMerk(rs.getString("merk_barang"));
                l.getProc().setIdProcessor(rs.getInt("id_processor"));
                l.getProc().setMerk(rs.getString("merk"));
                l.getProc().setSpeed(rs.getString("speed"));
                l.getRam().setIdRam(rs.getInt("id_ram"));
                l.getRam().setType(rs.getString("type"));
                l.getRam().setKapasitas(rs.getString("kapasitas"));
                l.getVga().setId_vga(rs.getInt("id_vga"));
                l.getVga().setBrand(rs.getString("brand"));
                l.getVga().setMemory(rs.getString("memory"));
                l.setHarga(rs.getInt("harga"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
    
    public ArrayList<Laptop> getAll() {
        ArrayList<Laptop> ListProduk = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT "
                                            + " p.id_produk AS id_produk,"
                                            + " p.jenis_barang AS jenis_barang,"
                                            + " p.merk_barang AS merk_barang,"
                                            + " pr.id_processor AS id_processor,"
                                            + " pr.merk AS merk,"
                                            + " pr.speed AS speed,"
                                            + " r.id_ram AS id_ram,"
                                            + " r.type AS type,"
                                            + " r.kapasitas AS kapasitas,"
                                            + " v.id_vga AS id_vga,"
                                            + " v.brand AS brand,"
                                            + " v.memory AS memory,"
                                            + " p.harga AS harga"
                                            + " FROM produk p"
                                            + " JOIN processor pr ON p.id_processor = pr.id_processor"
                                            + " JOIN ram r ON p.id_ram = r.id_ram"
                                            + " JOIN vga v ON p.id_vga = v.id_vga");
                                            
        try {
            while(rs.next()) {
                Laptop l = new Laptop();
                l.setId_produk(rs.getInt("id_produk"));
                l.setJenis(rs.getString("jenis_barang"));
                l.setMerk(rs.getString("merk_barang"));
                l.getProc().setIdProcessor(rs.getInt("id_processor"));
                l.getProc().setMerk(rs.getString("merk"));
                l.getProc().setSpeed(rs.getString("speed"));
                l.getRam().setIdRam(rs.getInt("id_ram"));
                l.getRam().setType(rs.getString("type"));
                l.getRam().setKapasitas(rs.getString("kapasitas"));
                l.getVga().setId_vga(rs.getInt("id_vga"));
                l.getVga().setBrand(rs.getString("brand"));
                l.getVga().setMemory(rs.getString("memory"));
                l.setHarga(rs.getInt("harga"));
                
                ListProduk.add(l);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListProduk;
    }
    
    public ArrayList<Laptop> search(String keyword) {
        ArrayList<Laptop> ListProduk = new ArrayList();
        ResultSet rs = Koneksi.selectQuery("SELECT "
                                            + " p.id_produk AS id_produk,"
                                            + " p.jenis_barang AS jenis_barang,"
                                            + " p.merk_barang AS merk_barang,"
                                            + " pr.id_processor AS id_processor,"
                                            + " pr.merk AS merk,"
                                            + " pr.speed AS speed,"
                                            + " r.id_ram AS id_ram,"
                                            + " r.type AS type,"
                                            + " r.kapasitas AS kapasitas,"
                                            + " v.id_vga AS id_vga,"
                                            + " v.brand AS brand,"
                                            + " v.memory AS memory,"
                                            + " p.harga AS harga"
                                            + " FROM produk p"
                                            + " JOIN processor pr ON p.id_processor = pr.id_processor"
                                            + " JOIN ram r ON p.id_ram = r.id_ram"
                                            + " JOIN vga v ON p.id_vga = v.id_vga"
                                            + " WHERE p.jenis_barang LIKE '%" + keyword + "%'"
                                                    + " OR p.merk_barang LIKE '%" + keyword + "%'");
        try {
            while(rs.next()) {
                Laptop l = new Laptop();
                l.setId_produk(rs.getInt("id_produk"));
                l.setJenis(rs.getString("jenis_barang"));
                l.setMerk(rs.getString("merk_barang"));
                l.getProc().setIdProcessor(rs.getInt("id_processor"));
                l.getProc().setMerk(rs.getString("merk"));
                l.getProc().setSpeed(rs.getString("speed"));
                l.getRam().setIdRam(rs.getInt("id_ram"));
                l.getRam().setType(rs.getString("type"));
                l.getRam().setKapasitas(rs.getString("kapasitas"));
                l.getVga().setId_vga(rs.getInt("id_vga"));
                l.getVga().setBrand(rs.getString("brand"));
                l.getVga().setMemory(rs.getString("memory"));
                l.setHarga(rs.getInt("harga"));
                
                ListProduk.add(l);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListProduk;
    }
    
    public void save() {
        if(getById(id_produk).getId_produk()== 0) {
            String SQL = "INSERT INTO produk (jenis_barang, merk_barang, id_processor, id_ram, id_vga, harga) VALUES("
                        + "'" + this.jenis + "', "
                        + "'" + this.merk + "', "
                        + "'" + this.getProc().getIdProcessor() + "', "
                        + "'" + this.getRam().getIdRam()+ "', "
                        + "'" + this.getVga().getId_vga()+ "', "
                        + "'" + this.harga + "'"
                        + ")";
            this.id_produk = Koneksi.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE produk SET"
                        + " jenis_barang = '" + this.jenis + "', "
                        + " merk_barang = '" + this.merk + "', "
                        + " id_processor = '" + this.getProc().getIdProcessor()+ "', "
                        + " id_ram = '" + this.getRam().getIdRam() + "', "
                        + " id_vga = '" + this.getVga().getId_vga()+ "', "
                        + " harga = '" + this.harga + "' "
                        + " WHERE idbuku = '" + this.id_produk + "'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM produk WHERE id_produk = '" + this.id_produk + "'";
        Koneksi.executeQuery(SQL);
    }
    @Override
    public String toString() {
        return merk;
    }
    
}
