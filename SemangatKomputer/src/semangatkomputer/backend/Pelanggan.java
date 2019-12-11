package semangatkomputer.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Pelanggan {
    private int idpelanggan;
    private String nama;
    private String email;
    private String telepon;
    
    public Pelanggan(){
        
    }
    public Pelanggan(String nama, String email, String telepon){
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }

    public int getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(int idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    public Pelanggan getById(int id) {
        Pelanggan pel = new Pelanggan();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pelanggan " + " WHERE id_pelanggan = '" + id + "'");

        try {
            while (rs.next()) {
                pel = new Pelanggan();
                pel.setIdpelanggan(rs.getInt("id_pelanggan"));
                pel.setNama(rs.getString("nama_pelanggan"));
                pel.setEmail(rs.getString("email"));
                pel.setTelepon(rs.getString("telepon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pel;
    }

    public ArrayList<Pelanggan> getAll() {
        ArrayList<Pelanggan> ListPelanggan = new ArrayList();

        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pelanggan");

        try {
            while (rs.next()) {
                Pelanggan pel = new Pelanggan();
                pel.setIdpelanggan(rs.getInt("id_pelanggan"));
                pel.setNama(rs.getString("nama_pelanggan"));
                pel.setEmail(rs.getString("email"));
                pel.setTelepon(rs.getString("telepon"));

                ListPelanggan.add(pel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPelanggan;
    }

    public ArrayList<Pelanggan> search(String keyword) {
        ArrayList<Pelanggan> ListPelanggan = new ArrayList();

        String sql = "Select * from pelanggan where " + " nama_pelanggan like '%" + keyword + "%' " + " or email like '%" + keyword + "%' or telepon like '%"+keyword+"'";

        ResultSet rs = Koneksi.selectQuery(sql);

        try {
            while (rs.next()) {
                Pelanggan pel = new Pelanggan();
                pel.setIdpelanggan(rs.getInt("id_pelanggan"));
                pel.setNama(rs.getString("nama_pelanggan"));
                pel.setEmail(rs.getString("email"));
                pel.setTelepon(rs.getString("telepon"));

                ListPelanggan.add(pel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPelanggan;
    }
    
    public void save(){
        if(getById(idpelanggan).getIdpelanggan() == 0){
            String SQL = "Insert into pelanggan (nama_pelanggan, email, telepon) values(" 
                    + " '" +this.nama + "', "
                    + " '" +this.email + "', "
                    + " '"+this.telepon+"' "
                    + " )";
                    this.idpelanggan = Koneksi.insertQueryGetId(SQL);
        }else{
            String SQL = "Update pelanggan set"
                   + " nama_pelanggan = '" +this.nama +"', "
                   + " email = '" +this.email +"', "
                   + " telepon = '"+this.telepon+"' "
                   +"Where id_pelanggan = '"+this.idpelanggan+"'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM pelanggan WHERE id_pelanggan = '"+this.idpelanggan+"'";
        Koneksi.executeQuery(SQL);
    }
    @Override
    public String toString() {
        return nama;
    }
    public ArrayList<Pelanggan> getByNamaAndEmailAndTelepon(String nama, String email, String telepon) {
        ArrayList<Pelanggan> ListPelanggan = new ArrayList();
        ResultSet rs;
        if ((nama.trim().length() > 0) && (email.trim().length() > 0) && (telepon.trim().length() > 0)) {
            rs = Koneksi.selectQuery("SELECT * FROM pelanggan Where nama_pelanggan = '" + nama + "' and email = '" + email + "' and telepon = '" + telepon + "'");
        } else if ((nama.trim().length() > 0) && (email.trim().length() > 0) && (telepon.trim().length() == 0)) {
            rs = Koneksi.selectQuery("SELECT * FROM pelanggan Where nama_pelanggan = '" + nama + "' and email = '" + email + "'");
        } else if ((nama.trim().length() > 0) && (email.trim().length() == 0)) {
            rs = Koneksi.selectQuery("SELECT * FROM pelanggan Where nama_pelanggan = '" + nama +"'");
        } else {
            rs = Koneksi.selectQuery("SELECT * FROM pelanggan Where email = '" + email + "'");
        }
        try {
            while (rs.next()) {
                Pelanggan ang = new Pelanggan();
                ang.setIdpelanggan(rs.getInt("id_pelanggan"));
                ang.setNama(rs.getString("nama_pelanggan"));
                ang.setEmail(rs.getString("email"));
                ang.setTelepon(rs.getString("telepon"));
                ListPelanggan.add(ang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPelanggan;
    }
}
