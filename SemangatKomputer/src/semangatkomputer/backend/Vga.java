package semangatkomputer.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Vga {
    private int id_vga;
    private String brand;
    private String memory;
    
    public Vga() {
    }

    public Vga(int id_vga, String brand, String memory) {
        this.id_vga = id_vga;
        this.brand = brand;
        this.memory = memory;
    }

    public int getId_vga() {
        return id_vga;
    }

    public void setId_vga(int id_vga) {
        this.id_vga = id_vga;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
    
    public Vga getById(int id) {
        Vga v = new Vga();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM vga " + " WHERE id_vga = '" + id + "'");

        try {
            while (rs.next()) {
                v = new Vga();
                v.setId_vga(rs.getInt("id_vga"));
                v.setBrand(rs.getString("brand"));
                v.setMemory(rs.getString("memory"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public ArrayList<Vga> getAll() {
        ArrayList<Vga> ListVga = new ArrayList();

        ResultSet rs = Koneksi.selectQuery("SELECT * FROM vga");

        try {
            while (rs.next()) {
                Vga v = new Vga();
                v.setId_vga(rs.getInt("id_vga"));
                v.setBrand(rs.getString("brand"));
                v.setMemory(rs.getString("memory"));

                ListVga.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListVga;
    }

    
    public void save(){
        if(getById(id_vga).getId_vga()== 0){
            String SQL = "Insert into vga (brand,memory) values(" 
                    + " '" +this.brand + "', "
                    + " '"+this.memory+"' "
                    + " )";
                    this.id_vga = Koneksi.insertQueryGetId(SQL);
        }else{
            String SQL = "Update vga set"
                   + " brand = '" +this.brand +"', "
                   + " memory = '"+this.memory+"' "
                   +"Where id_vga = '"+this.id_vga+"'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM vga WHERE id_vga = '"+this.id_vga+"'";
        Koneksi.executeQuery(SQL);
    }
    
    @Override
    public String toString() {
        return brand;
    }
    
}
