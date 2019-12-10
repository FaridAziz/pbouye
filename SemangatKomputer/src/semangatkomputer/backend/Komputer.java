package semangatkomputer.backend;

public class Komputer extends Keamanan{
    String merk;
    
    Komputer(){
        
    }
    Komputer(String merk){
        this.merk = merk;
    }
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    @Override
    public void keamanan() {
        
    }
    
    
}
