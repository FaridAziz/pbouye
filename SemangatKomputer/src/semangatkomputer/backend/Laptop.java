package semangatkomputer.backend;

public class Laptop extends Komputer implements IBenchmark{
    Processor proc;
    Vga vga;
    Ram ram;
    
    Laptop(){
        
    }
    Laptop(String merk, Processor proc, Vga vga, Ram ram){
        this.merk = merk;
        this.proc = proc;
        this.vga = vga;
        this.ram = ram;
    }

    @Override
    public String getMerk() {
        return merk;
    }

    @Override
    public void setMerk(String merk) {
        this.merk = merk;
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

    @Override
    public void highend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lowend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
