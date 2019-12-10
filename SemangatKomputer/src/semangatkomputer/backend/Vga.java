package semangatkomputer.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Vga {
    private int id_vga;
    private String merk;
    private String memory;
    
    public Vga() {
    }

    public Vga(int id_vga, String merk, String memory) {
        this.id_vga = id_vga;
        this.merk = merk;
        this.memory = memory;
    }
    
    public int getIdVga() {
        return id_vga;
    }

    public void setIdVga(int id_vga) {
        this.id_vga = id_vga;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
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
                v.setIdVga(rs.getInt("id_vga"));
                v.setMerk(rs.getString("merk"));
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
                v.setIdVga(rs.getInt("id_vga"));
                v.setMerk(rs.getString("merk"));
                v.setMemory(rs.getString("memory"));

                ListVga.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListVga;
    }

    
    public void save(){
        if(getById(id_vga).getIdVga() == 0){
            String SQL = "Insert into vga (merk,memory) values(" 
                    + " '" +this.merk + "', "
                    + " '"+this.memory+"' "
                    + " )";
                    this.id_vga = Koneksi.insertQueryGetId(SQL);
        }else{
            String SQL = "Update vga set"
                   + " merk = '" +this.merk +"', "
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
        return merk;
    }
    
}
