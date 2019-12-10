package semangatkomputer.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Ram {
    private int id_ram;
    private String type;
    private String kapasitas;
    
    public Ram() {
    }

    public Ram(int id_ram, String type, String kapasitas) {
        this.id_ram = id_ram;
        this.type = type;
        this.kapasitas = kapasitas;
    }
    
    public int getIdRam() {
        return id_ram;
    }

    public void setIdRam(int id_ram) {
        this.id_ram = id_ram;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    public Ram getById(int id) {
        Ram r = new Ram();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM ram " + " WHERE id_ram = '" + id + "'");

        try {
            while (rs.next()) {
                r = new Ram();
                r.setIdRam(rs.getInt("id_ram"));
                r.setType(rs.getString("type"));
                r.setKapasitas(rs.getString("kapasitas"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public ArrayList<Ram> getAll() {
        ArrayList<Ram> ListRam = new ArrayList();

        ResultSet rs = Koneksi.selectQuery("SELECT * FROM ram");

        try {
            while (rs.next()) {
                Ram r = new Ram();
                r.setIdRam(rs.getInt("id_ram"));
                r.setType(rs.getString("type"));
                r.setKapasitas(rs.getString("kapasitas"));

                ListRam.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListRam;
    }

    
    public void save(){
        if(getById(id_ram).getIdRam() == 0){
            String SQL = "Insert into ram (type,kapasitas) values(" 
                    + " '" +this.type + "', "
                    + " '"+this.kapasitas+"' "
                    + " )";
                    this.id_ram = Koneksi.insertQueryGetId(SQL);
        }else{
            String SQL = "Update ram set"
                   + " type = '" +this.type +"', "
                   + " kapasitas = '"+this.kapasitas+"' "
                   +"Where id_ram = '"+this.id_ram+"'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM ram WHERE id_ram = '"+this.id_ram+"'";
        Koneksi.executeQuery(SQL);
    }
    
    @Override
    public String toString() {
        return type;
    }
    
}
