public class Urun {

    private int id;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String raf;

    public Urun(int id, String urunIsmi, String uretici, String birim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = 0;
        this.birim = birim;
        this.raf = "-";
    }

    // Getter ve Setter metodları
    public int getId() {
        return id;
    }
    public String getUrunIsmi() {
        return urunIsmi;
    }
    public String getUretici() {
        return uretici;
    }
    public int getMiktar() {
        return miktar;
    }
    public String getBirim() {
        return birim;
    }
    public String getRaf() {
        return raf;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
    public void setRaf(String raf) {
        this.raf = raf;
    }




}
