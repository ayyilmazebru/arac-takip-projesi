package proje;
import com.mysql.jdbc.Connection;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.Choice;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class islemler {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public islemler (){
        String url = "jdbc:mysql://"+ database.host + ":" + database.port + "/" + database.dbIsmi;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
                System.out.println("Driver Bulunamadı!");
        }
        try {
            con =  (Connection) DriverManager.getConnection(url, database.kullaniciAdi, database.parola);
            //JOptionPane.showConfirmDialog(null, "Veritabanı bağlandı");        
        } catch (SQLException ex) {
            //System.out.println("Bağlanti Başarısız!");
            ex.printStackTrace();
        }
    }
    
    public boolean girisYap(String isim, String parola){
        String sorgu = "Select * From kisiler ";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if(rs.getString("kullaniciadi").equals(isim) && rs.getString("sifre").equals(parola) ){
                    int id = rs.getInt("kisiid");
                    girisEkle(id,isim);
                    return true;
                } 
            }
            return false; 
        } catch (SQLException ex) {
            Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void girisEkle(int id, String isim){
        String sorgu = "INSERT INTO girishareketleri(girisid,kullaniciid,kullaniciadi) VALUES (NULL,?,?) ";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,isim);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String benKimim(){
        String ad=null;
        String sorgu = "Select * From girishareketleri";
        try {
            statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if(rs.last()){
                    ad=rs.getString("kullaniciadi");
                }
                return ad;
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad;
    }
    
    public ArrayList<tablo> verileriGetir(){
        ArrayList<tablo> cikti = new ArrayList<tablo>();
        ArrayList<tablo> geri = new ArrayList<tablo>();
        geri.add(new tablo(0,0,null,null,0,0,null,null,0,null));
        String sorgu2 = "Select * From araclar";
        try {
            int a=1;
            statement =con.createStatement();
            ResultSet rs2 = statement.executeQuery(sorgu2);
            while(rs2.next()){
                geri.add(new tablo(0,0,null,null,0,0,null,null,0,null));
            }
            String sorgu = "Select * From hareketler";
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                int hareketid= rs.getInt("hareketid");
                int aracid= rs.getInt("aracid");
                String alıstarihi= rs.getString("alıstarihi");
                String veristarihi= rs.getString("veristarihi");
                int aliskm = rs.getInt("aliskm");
                int veriskm = rs.getInt("veriskm");
                String alissaat = rs.getString("alissaat");
                String verissaat = rs.getString("verissaat");
                int kisiid= rs.getInt("kisiid");
                
                cikti.add(new tablo(hareketid,aracid,alıstarihi,veristarihi,aliskm,veriskm,alissaat,verissaat,kisiid,ad_al(kisiid)));
            }
            for (tablo t : cikti){
                int hi=t.getAracid();
                geri.set(hi-1, new tablo(t.getHareketid(),t.getAracid(),t.getAlıstarih(),t.getVeritarihi(),t.getAliskm(),t.getVeriskm(),t.getAlıssaat(),t.getVerissaat(),t.getKisiid(),ad_al(t.getKisiid())));
            }
            return geri;   
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int kisi_id_al(String ad){
        int id=0;
        try {
            statement = con.createStatement();
            String sorgu="Select * From kisiler";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                if (ad.equals(rs.getString("kullaniciadi"))){
                    id= rs.getInt("kisiid");
                }
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
      
    public void isimGuncelle(int id, String Eski_kullaniciAdi, String Yeni_kullaniciAdi, String sifre){
        
        String sorgu = "Update kisiler Set kullaniciadi=?  Where kisiid=? and sifre=?";
        
        try {
            statement =con.createStatement();
            String sorgu3 = "Select * From kisiler";
            ResultSet rs2 = statement.executeQuery(sorgu3);
            
            while(rs2.next()){
                if(rs2.getString("kullaniciadi").equals(Yeni_kullaniciAdi)){
                    JOptionPane.showConfirmDialog(null,"Bu kullanıcı adına sahip bir kullanıcı var.\nLütfen farklı bir isim kullanınız.");
                    return;
                }
            }
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,Yeni_kullaniciAdi);
            preparedStatement.setInt(2,id);
            preparedStatement.setString(3,sifre);
            preparedStatement.executeUpdate();
            
            
            String sorgu2 = "Select * From kisiler";
            ResultSet rs = statement.executeQuery(sorgu2);
            
            while(rs.next()){
                if(rs.getInt("kisiid")==id){
                    if(rs.getString("kullaniciadi").equals(Eski_kullaniciAdi)){
                        JOptionPane.showConfirmDialog(null,"Kullanıcı adınızı kontrol ediniz...");
                    } else {
                        JOptionPane.showConfirmDialog(null,"İşlem Başarılı...");
                    }
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sifreGuncelle(int id, String Eski_kullaniciAdi, String Eski_sifre, String Yeni_sifre){
        
        String sorgu = "Update kisiler Set sifre=? Where kisiid=? and sifre=?";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, Yeni_sifre);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, Eski_sifre);
            
            preparedStatement.executeUpdate();
            
            statement = con.createStatement();
            String sorgu2 = "Select * From kisiler";
            ResultSet rs = statement.executeQuery(sorgu2);
            while(rs.next()){
                if(rs.getInt("kisiid")==id){
                    if(!rs.getString("sifre").equals(Yeni_sifre)){
                        JOptionPane.showConfirmDialog(null, "Eski şifreniz yanlış.");
                        return;
                    }
                    else {
                        JOptionPane.showConfirmDialog(null, "Şifreniz değiştirildi.");
                        return;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void ChoiceExample(JComboBox k,int a){ 
        if( a==1){
            try {
                int t=0;
                statement =con.createStatement();
                String sorgu = "Select marka From araclar";
                ResultSet rs = statement.executeQuery(sorgu);
                k.addItem("Seçiniz..");
                try {
                    ArrayList<String> liste1 = new ArrayList<String>();
                    while(rs.next()){
                        String marka1 = rs.getString("marka");
                        if(t==0){
                            liste1.add(marka1);
                            k.addItem(marka1);
                            t++;
                        }
                        else if(!liste1.contains(marka1)){
                            k.addItem(marka1);
                            liste1.add(marka1);
                        }
                    }
                }
                catch (SQLException ex) {
                    Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch (SQLException ex) {
                Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if( a==2){
            try {
                int t=0;
                statement =con.createStatement();
                String sorgu = "Select model From araclar";
                ResultSet rs = statement.executeQuery(sorgu);
                //k.addItem("Seçiniz.");
                ArrayList<String> liste2 = new ArrayList<String>();
                while(rs.next()){
                    String mode11 = rs.getString("model");
                    if(t==0){
                        liste2.add(mode11);
                        k.addItem(mode11);
                        t++;
                    } else if( !liste2.contains(mode11)){
                       liste2.add(mode11);
                       k.addItem(mode11);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if( a==3){
            try {
               int t=0;
               statement =con.createStatement();
               String sorgu = "Select plaka From araclar";
               ResultSet rs = statement.executeQuery(sorgu);
               k.addItem("Seçiniz.");

                while(rs.next()){
                    ArrayList<String> liste3 = new ArrayList<String>();
                    String plaka1 = rs.getString("plaka");
                    if(t==0){
                        liste3.add(plaka1);
                        k.addItem(plaka1);
                        t++;
                    }else if( !liste3.contains(plaka1)){
                        liste3.add(plaka1);
                        k.addItem(plaka1);
                    }
                }
            } catch (SQLException ex) {
                    Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
    public void hareketEkle(int kisiid,String ad,String marka, String model, String plaka,String alisTarihi,String alisSaat, String alisKm){
        int aracid=0;
        String aracKm = null;
        
        if(!ad.equals(benKimim())){
            JOptionPane.showConfirmDialog(null, "Kullanıcı adınızı kontrol ediniz.");
            return;
        }
        if (!aracKontrol()){
            JOptionPane.showConfirmDialog(null, "Size teslim edilmiş bir araç bulunmaktadır. Onu teslim etmeden ikinci aracı alamazsınız.");
            return; 
        }
        String sorgu1 = "Select * From araclar";

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu1);

            while(rs.next()){
                if(marka.equals(rs.getString("marka")) && model.equals(rs.getString("model")) && plaka.equals(rs.getString("plaka"))){
                    aracid=rs.getInt("aracid");
                    aracKm=rs.getString("sonkm");
                }
            }
            String sorgu3 = "Select * From hareketler";
            statement=con.createStatement();
            ResultSet rsd = statement.executeQuery(sorgu3);
            while (rsd.next()){
                if (rsd.getInt("aracid")==aracid && rsd.getString("veriskm").equals("0")){
                    JOptionPane.showConfirmDialog(null,"Araç şu an da başka bir çalışanda.");
                    return;
                }
            }
            if(aracid==0){
                JOptionPane.showConfirmDialog(null,"Böyle bir araç bulunmamaktadır.");
            }
            else if(!aracKm.equals(alisKm)){
                JOptionPane.showConfirmDialog(null,"Son km'yi kontrol ediniz.");
            }
            else {
                String sorgu2 = "Insert Into hareketler(hareketid,aracid,alistarihi,veristarihi,aliskm,veriskm,alissaat,verissaat,kisiid) Values(NULL, ?, ?, ?, ?, ?, ?,?, ?) ";

                preparedStatement = con.prepareStatement(sorgu2);
                preparedStatement.setInt(1, aracid);
                preparedStatement.setString(2, alisTarihi);
                preparedStatement.setString(3, " ");
                preparedStatement.setString(4, alisKm);
                preparedStatement.setString(5, "0");
                preparedStatement.setString(6, alisSaat);
                preparedStatement.setString(7, " ");
                preparedStatement.setInt(8, kisiid);
                preparedStatement.executeUpdate();

                JOptionPane.showConfirmDialog(null,"Araç teslim alınmıştır.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void aracBirak(String ad,int id,int aracId,String alisTarihi,String verisTarihi,String verisSaati,String verisKm){
        String sorgu1 ="Update hareketler Set veristarihi=?,veriskm=?, verissaat=? Where hareketid=? ";
        if (!ad.equals(benKimim())){
            JOptionPane.showConfirmDialog(null, "Kullanıcı adınızı kontrol ediniz.");
            return;
        }
        try {
            preparedStatement = con.prepareStatement(sorgu1);
            preparedStatement.setString(1,verisTarihi);
            preparedStatement.setString(2,verisKm);
            preparedStatement.setString(3,verisSaati);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();

            JOptionPane.showConfirmDialog(null,"Araç bırakılmıştır.");
            
            String sorgu2 = "Update araclar Set sonkm=? Where aracid=?";
            preparedStatement= con.prepareStatement(sorgu2);
            preparedStatement.setString(1, verisKm);
            preparedStatement.setInt(2, aracId);
            preparedStatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    public String ad_al(int id){
        String sorgu = "Select * From kisiler";
        
        try {
            statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if(id==rs.getInt("kisiid")){
                    return rs.getString("kullaniciadi");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public ArrayList<tablo> dolulariGetir(){
        ArrayList<tablo> cikti = new ArrayList<tablo>();
        try {
            statement = con.createStatement();
            String sorgu = "Select * From hareketler Where veriskm='0' ";
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                int hareketid=rs.getInt("hareketid");
                int aracid= rs.getInt("aracid");
                String alıstarihi= rs.getString("alıstarihi");
                String veristarihi= rs.getString("veristarihi");
                int aliskm = rs.getInt("aliskm");
                int veriskm = rs.getInt("veriskm");
                String alissaat = rs.getString("alissaat");
                String verissaat = rs.getString("verissaat");
                int kisiid= rs.getInt("kisiid");
                
                cikti.add(new tablo(hareketid,aracid,alıstarihi,veristarihi,aliskm,veriskm,alissaat,verissaat,kisiid,ad_al(kisiid)));
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void mmp (int arid,JComboBox a,JComboBox b,JComboBox c){
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From araclar ";               
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if(rs.getInt("aracid")==arid){
                    a.removeAll();
                    b.removeAll();
                    c.removeAll();
                    a.setSelectedItem(rs.getString("marka"));
                    b.setSelectedItem(rs.getString("model"));
                    c.setSelectedItem(rs.getString("plaka"));  
                }
            }  
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public int aracId(String marka, String model, String plaka){
        String sorgu = "Select * From araclar";
        try {
            statement=con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if(marka.equals(rs.getString("marka")) && model.equals(rs.getString("model")) && plaka.equals(rs.getString("plaka"))){
                    return rs.getInt("aracid");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ArrayList<tablo> secili_olan(int aracId){
        ArrayList<tablo> cikti = new ArrayList<tablo>();
        try {
            String sorgu = "Select * From hareketler";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if(rs.getInt("aracid")==aracId){
                    int hareketid=rs.getInt("hareketid");
                    int aracid= rs.getInt("aracid");
                    String alıstarihi= rs.getString("alıstarihi");
                    String veristarihi= rs.getString("veristarihi");
                    int aliskm = rs.getInt("aliskm");
                    int veriskm = rs.getInt("veriskm");
                    String alissaat = rs.getString("alissaat");
                    String verissaat = rs.getString("verissaat");
                    int kisiid= rs.getInt("kisiid");
                    cikti.add(new tablo(hareketid,aracid,alıstarihi,veristarihi,aliskm,veriskm,alissaat,verissaat,kisiid,ad_al(kisiid)));
                }   
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }
    
    public int alverkm ( int arid  ){
        try {
            String sorgu = "Select * From araclar";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if(rs.getInt("aracid")==arid){
                    
                  return rs.getInt("sonkm");
                    
                }   
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int tarihs( String at,String vt,String as,String vs){
        Date c1 = convertToDate(1,at);
        Date c2 =  convertToDate(1,vt);
        if( c2.after(c1)){
            return 1;
        } else if(c2.equals(c1)){
            if(saats(as,vs)){
            return 1;
        } 
            return -1; 
        } else{
            return -1;
        } 
    }
    
    public  Date convertToDate(int a,String tarih_zaman) {
        if(a==1){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		ParsePosition pos = new ParsePosition(0);
		Date d = dateFormat.parse(tarih_zaman, pos);
		return d;
        } else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            Date d = dateFormat.parse(tarih_zaman, pos);
            return d;
        }
    }
    
    public void modelgetir (JComboBox a,JComboBox b,JComboBox c){
        try {
            String sorgu = "Select * From araclar";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            ArrayList<String> liste3 = new ArrayList<String>();
            b.removeAllItems();
            c.removeAllItems();
            b.addItem("Seçiniz..");
            c.addItem("Seçiniz..");
            int t=0;
            while(rs.next()){
                if( rs.getString("marka").equals(a.getSelectedItem())){
                    String mark = rs.getString("model");
                    if(t==0){
                        liste3.add(mark);
                        b.addItem(mark);
                        c.addItem(rs.getString("plaka")); 
                        t++;
                    }else if( !liste3.contains(mark)){
                        liste3.add(mark);
                        b.addItem(mark);
                        c.addItem(rs.getString("plaka")); 
                    }else {
                        c.addItem(rs.getString("plaka")); 
                    }
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void plakagetir(JComboBox a,JComboBox b){
        try {
            String sorgu = "Select * From araclar";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                if( rs.getString("model").equals(a.getSelectedItem())){
                    b.setSelectedItem(rs.getString("plaka"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean saats (String a, String b){
        String[] ayiralis =a.split(":");
        String part1a = ayiralis[0];
        String part2a = ayiralis[1];
        String[] ayirveris = b.split(":");
        String part1v = ayirveris[0];
        String part2v = ayirveris[1];

        int part1aInt = Integer.parseInt(part1a);
        int part2aInt = Integer.parseInt(part2a);
        int part3vInt = Integer.parseInt(part1v);
        int part4vInt = Integer.parseInt(part2v);
        if(part3vInt > part1aInt){return true;}
        else if(part3vInt == part1aInt ){
            if( part4vInt >part2aInt){
            return true;
            } else {
                return false;
            } 
        }
        else return false;
    }
    
    public boolean aracKontrol(){
        ArrayList<tablo> d = dolulariGetir();
        int id=kisi_id_al(benKimim());
        
        for (tablo t : d){
            if(t.getKisiid()==id){
                return false;
            }
        }
        return true;
    }
    
    
}
