package semangatkomputer.backend;

public class Komputer extends Merk implements IJenis{
    public String jenis;
   
    Komputer(){
        
    }
    
    Komputer(String merk, String jenis){
        this.merk = merk;
        this.jenis = jenis;
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
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public String getJenis() {
        return jenis;
    }

    
    
}
