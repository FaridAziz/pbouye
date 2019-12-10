package semangatkomputer.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Processor {
    private int id_processor;
    private String merk;
    private String speed;
    
   public Processor() {
    }

    public Processor(int id_processor, String merk, String speed) {
        this.id_processor = id_processor;
        this.merk = merk;
        this.speed = speed;
    }
    
    public int getIdProcessor() {
        return id_processor;
    }

    public void setIdProcessor(int id_processor) {
        this.id_processor = id_processor;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
    
    public Processor getById(int id) {
        Processor p = new Processor();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM processor " + " WHERE id_processor = '" + id + "'");

        try {
            while (rs.next()) {
                p = new Processor();
                p.setIdProcessor(rs.getInt("id_processor"));
                p.setMerk(rs.getString("merk"));
                p.setSpeed(rs.getString("speed"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<Processor> getAll() {
        ArrayList<Processor> ListProcessor = new ArrayList();

        ResultSet rs = Koneksi.selectQuery("SELECT * FROM processor");

        try {
            while (rs.next()) {
                Processor p = new Processor();
                p.setIdProcessor(rs.getInt("id_processor"));
                p.setMerk(rs.getString("merk"));
                p.setSpeed(rs.getString("speed"));

                ListProcessor.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListProcessor;
    }

    
    public void save(){
        if(getById(id_processor).getIdProcessor() == 0){
            String SQL = "Insert into processor (merk,speed) values(" 
                    + " '" +this.merk + "', "
                    + " '"+this.speed+"' "
                    + " )";
                    this.id_processor = Koneksi.insertQueryGetId(SQL);
        }else{
            String SQL = "Update processor set"
                   + " merk = '" +this.merk +"', "
                   + " speed = '"+this.speed+"' "
                   +"Where id_processor = '"+this.id_processor+"'";
            Koneksi.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM processor WHERE id_processor = '"+this.id_processor+"'";
        Koneksi.executeQuery(SQL);
    }
    
    @Override
    public String toString() {
        return merk;
    }
    
}
