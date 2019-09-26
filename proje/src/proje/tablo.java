package proje;

public class tablo {
    private int hareketid ;
    private int aracid;
    private String alıstarih;
    private String veritarihi;
    private int aliskm;
    private int veriskm;
    private String alıssaat;
    private String verissaat;
    private int kisiid;
    private String kullaniciadi;

    public tablo(int hareketid, int aracid, String alıstarih, String veritarihi, int aliskm, int veriskm, String alıssaat, String verissaat, int kisiid, String kullaniciadi) {
        this.hareketid = hareketid;
        this.aracid = aracid;
        this.alıstarih = alıstarih;
        this.veritarihi = veritarihi;
        this.aliskm = aliskm;
        this.veriskm = veriskm;
        this.alıssaat = alıssaat;
        this.verissaat = verissaat;
        this.kisiid = kisiid;
        this.kullaniciadi=kullaniciadi;
    }

    tablo(int aInt, int aInt0, String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getHareketid() {
        return hareketid;
    }

    public int getAracid() {
        return aracid;
    }

    public String getAlıstarih() {
        return alıstarih;
    }

    public String getVeritarihi() {
        return veritarihi;
    }

    public int getAliskm() {
        return aliskm;
    }

    public String getVerissaat() {
        return verissaat;
    }

    public int getKisiid() {
        return kisiid;
    }

    public void setHareketid(int hareketid) {
        this.hareketid = hareketid;
    }

    public void setAracid(int aracid) {
        this.aracid = aracid;
    }

    public void setAlıstarih(String alıstarih) {
        this.alıstarih = alıstarih;
    }

    public void setVeritarihi(String veritarihi) {
        this.veritarihi = veritarihi;
    }

    public void setAliskm(int aliskm) {
        this.aliskm = aliskm;
    }

    public void setVerissaat(String verissaat) {
        this.verissaat = verissaat;
    }

    public void setKisiid(int kisiid) {
        this.kisiid = kisiid;
    }

    public void setVeriskm(int veriskm) {
        this.veriskm = veriskm;
    }

    public void setAlıssaat(String alıssaat) {
        this.alıssaat = alıssaat;
    }

    public int getVeriskm() {
        return veriskm;
    }

    public String getAlıssaat() {
        return alıssaat;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }
    
}
