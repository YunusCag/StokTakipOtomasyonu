/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSource implements IDBConnection{
    public static final String DB_NAME="XE";
    public static final String CONNECTING_STRING="jdbc:oracle:thin:@localhost:1521:"+DB_NAME;
    public static final String DB_USER = "system";
    public static final String DB_PASS = "123456";
    
    public static final String TABLE_USER="evrak_user";
    public static final String USER_COLUMN_USERID="userNo";
    public static final String USER_COLUMN_USER_NAME="user_name";
    public static final String USER_COLUMN_USER_PASSWORD="user_password";
    public static final String USER_COLUMN_POSITION="position";
    public static final String USER_COLUMN_USER_LOGON="user_logOn";
    
    
    public static final String TABLE_CALISANLAR="calisanlar";
    public static final String CALISANLAR_COLUMN_CALISAN_NO="calisanno";
    public static final String CALISANLAR_COLUMN_FNAME="fName";
    public static final String CALISANLAR_COLUMN_LNAME="lName";
    public static final String CALISANLAR_COLUMN_DOB="dob";
    public static final String CALISANLAR_COLUMN_SEX="sex";
    public static final String CALISANLAR_COLUMN_POSITION="position";
    public static final String CALISANLAR_COLUMN_SALARY="salary";
    
    public static final String TABLE_MALZEMELER="malzemeler";
    public static final String MALZEMELER_COLUMN_MALZEMENO="malzemeNo";
    public static final String MALZEMELER_COLUMN_MALZEMEADI="malzemaAdi";
    public static final String MALZEMELER_COLUMN_MALZEMECINSI="malzemeCinsi";
    public static final String MALZEMELER_COLUMN_IMAGEPATH="image_path";
    
    public static final String TABLE_STOK="stok";
    public static final String STOK_COLUMN_STOKNO="stokNo";
    public static final String STOK_COLUMN_MALZEMENO="malzemeNo";
    public static final String STOK_COLUMN_CALISANNO="calisanNo";
    public static final String STOK_COLUMN_MIKTAR="miktar";
    public static final String STOK_COLUMN_KAYIT_TARIHI="kayit_tarihi";
    

    
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private CallableStatement callableStatement;
   
    @Override
    public  boolean openConnection(){
        try {
            connection=DriverManager.getConnection(CONNECTING_STRING,DB_USER,DB_PASS);
            System.out.println("Veritabanına Bağlanıldı.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Veritabanına bağlanılamadı!!!");
            return false;
        }
    }
    @Override
    public  boolean closeConnection(){
        try {
            if(connection!=null){
                 connection.close();
            }
            System.out.println("Veritabanı kapatıldı.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Veritabanı Kapatılamadı!!!!!");
            return false;
        }
    }
    
    //USER TABLE PROCESS
    public User userLogOn(User user){
        User temp=null;
        String sql="Select * from Gazi."+TABLE_USER+" Where "
                +USER_COLUMN_USER_NAME+"=?"
                +" AND "+USER_COLUMN_USER_PASSWORD+"=?"
                +" AND "+USER_COLUMN_POSITION+"=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getPosition()+"");
            
            ResultSet result=preparedStatement.executeQuery();
            
            while(result.next()){
                int id=result.getInt(USER_COLUMN_USERID);
                String name=result.getString(USER_COLUMN_USER_NAME);
                String password=result.getString(USER_COLUMN_USER_PASSWORD);
                String position=result.getString(USER_COLUMN_POSITION);
                temp=new User(id, name, password,position.charAt(0),0);
                System.out.println("Id:"+id+"name:"+name+"password:"+password+"position:"+position);
            }
        } catch (SQLException ex) {
            System.out.println("Evrak user tablosuna ulaşılamadı");
            ex.printStackTrace();
        }
        if(temp!=null){
           temp.setIsLogOn(true);
            setLogOn(temp.getUserNo());
            temp.setUserLogOn(1);
        }
        return temp;
    }
    private void setLogOn(int id){
        String sql="UPDATE Gazi."+TABLE_USER+" Set "
                +USER_COLUMN_USER_LOGON+"=1"
                +" Where "+USER_COLUMN_USERID+"=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet result=preparedStatement.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Evrak user tablosuna ulaşılamadı");
            ex.printStackTrace();
            
        }
      
    }
    public ArrayList<User> getAllEvrakUsers(String userName){
        ArrayList<User> allUsers=new ArrayList<>();
        User temp=null;
        userName="%"+userName+"%";
        String sql="Select * from Gazi."+TABLE_USER
                +" Where "+USER_COLUMN_USER_NAME+" LIKE ?";
        
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            ResultSet result=preparedStatement.executeQuery();
            
            while(result.next()){
                int id=result.getInt(USER_COLUMN_USERID);
                String name=result.getString(USER_COLUMN_USER_NAME);
                String password=result.getString(USER_COLUMN_USER_PASSWORD);
                String position=result.getString(USER_COLUMN_POSITION);
                temp=new User(id, name, password,position.charAt(0),0);
                allUsers.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("Evrak user tablosuna ulaşılamadı");
            ex.printStackTrace();
        }
        return allUsers;
     
    }
    public boolean updateUser(User user){
        String sql="UPDATE Gazi."+TABLE_USER+" Set "
                +USER_COLUMN_USER_NAME+"=?"
                +","+USER_COLUMN_USER_PASSWORD+"=?"
                +" Where "+USER_COLUMN_USERID+"=?";
        boolean control=false;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3, user.getUserNo());
            int row=preparedStatement.executeUpdate();
            control=row>0;
            
        } catch (SQLException ex) {
            System.out.println("Evrak user tablosuna ulaşılamadı");
            ex.printStackTrace();
            
        }
        return control;
    } 
    public boolean deleteUser(int id){
       String sql="Delete FROM Gazi."+TABLE_USER+" Where "+USER_COLUMN_USERID+"=?";
       boolean control=false;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    public boolean addUser(User user){
        String sql="INSERT INTO Gazi."+TABLE_USER+"("
                +USER_COLUMN_USER_NAME+","
                +USER_COLUMN_USER_PASSWORD+","
                +USER_COLUMN_POSITION+","
                +USER_COLUMN_USER_LOGON+")"
                +" VALUES(?,?,?,?)";
        boolean control=false;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getPosition()+"");
            preparedStatement.setInt(4,user.getUserLogOn());
            
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    //CALISANLAR TABLE PROCESS
    public ArrayList<Calisan> getAllCalisan(String search){
        Calisan calisan=null;
        ArrayList<Calisan> allCalisan=new ArrayList<>();
        Calisan temp=null;
        search="%"+search+"%";
        String sql="Select * from Gazi."+TABLE_CALISANLAR
                +" Where "+CALISANLAR_COLUMN_FNAME+" LIKE ?"
                +" OR "+CALISANLAR_COLUMN_LNAME+" LIKE ?"
                +" OR "+CALISANLAR_COLUMN_POSITION+" LIKE ?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,search);
            preparedStatement.setString(2,search);
            preparedStatement.setString(3,search);
            ResultSet result=preparedStatement.executeQuery();
            
            while (result.next()) {
                int id=result.getInt(CALISANLAR_COLUMN_CALISAN_NO);
                String fName=result.getString(CALISANLAR_COLUMN_FNAME);
                String lName=result.getString(CALISANLAR_COLUMN_LNAME);
                Date kayitTarihi=new Date(result.getDate(CALISANLAR_COLUMN_DOB).getTime());
                char cinsiyet=result.getString(CALISANLAR_COLUMN_SEX).charAt(0);
                String position=result.getString(CALISANLAR_COLUMN_POSITION);
                int salary=result.getInt(CALISANLAR_COLUMN_SALARY);
                calisan=new Calisan(id, fName, lName, kayitTarihi, cinsiyet, position, salary);
                allCalisan.add(calisan);
            }
           
            
        } catch (SQLException ex) {
            System.out.println("Çalışan tablosuna ulaşılamadı");
            ex.printStackTrace();
        }
        return allCalisan;
    }
    public boolean deleteCalisan(int id){
        
        boolean control=false;
        try {
            String sql="DELETE FROM Gazi."+TABLE_CALISANLAR
                    +" WHERE "+CALISANLAR_COLUMN_CALISAN_NO
                    +"="+id;
            preparedStatement=connection.prepareCall(sql);
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    public boolean updateCalisan(Calisan calisan){
        
        boolean control=false;
        try {
            String sql="UPDATE Gazi."+TABLE_CALISANLAR
                    +" SET "+CALISANLAR_COLUMN_FNAME+"=?,"
                    +CALISANLAR_COLUMN_LNAME+"=?,"
                    +CALISANLAR_COLUMN_POSITION+"=?,"
                    +CALISANLAR_COLUMN_DOB+"=?,"
                    +CALISANLAR_COLUMN_SALARY+"=?,"
                    +CALISANLAR_COLUMN_SEX+"=?"
                    +" WHERE "+CALISANLAR_COLUMN_CALISAN_NO
                    +"="+calisan.getCalisanNo();
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,calisan.getfName());
            preparedStatement.setString(2,calisan.getlName());
            preparedStatement.setString(3,calisan.getPosition());
            preparedStatement.setDate(4, new java.sql.Date(calisan.getDob().getTime()));
            preparedStatement.setInt(5,calisan.getSalary());
            preparedStatement.setString(6,calisan.getCinsiyet()+"");
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    public boolean addCalisan(Calisan calisan){
        
        boolean control=false;
        try {
            String sql="INSERT INTO Gazi."+TABLE_CALISANLAR
                    +"("+CALISANLAR_COLUMN_FNAME+","
                    +CALISANLAR_COLUMN_LNAME+","
                    +CALISANLAR_COLUMN_POSITION+","
                    +CALISANLAR_COLUMN_DOB+","
                    +CALISANLAR_COLUMN_SALARY+","
                    +CALISANLAR_COLUMN_SEX+") VALUES(?,?,?,?,?,?)";
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,calisan.getfName());
            preparedStatement.setString(2,calisan.getlName());
            preparedStatement.setString(3,calisan.getPosition());
            preparedStatement.setDate(4, new java.sql.Date(calisan.getDob().getTime()));
            preparedStatement.setInt(5,calisan.getSalary());
            preparedStatement.setString(6,calisan.getCinsiyet()+"");
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    //MALZEME TABLE PROCESS
    public ArrayList<Malzeme> getAllMalzemeler(String search){
        search="%"+search+"%";
        String sql="SELECT * FROM Gazi."+TABLE_MALZEMELER
                +" WHERE ("+MALZEMELER_COLUMN_MALZEMEADI+" LIKE ? ) OR ("
                +MALZEMELER_COLUMN_MALZEMECINSI+" LIKE ?)";
        Malzeme malzeme=null;
        ArrayList<Malzeme> allMalzeme=new ArrayList<>();
        
        try {
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,search);
            preparedStatement.setString(2,search);
            ResultSet result=preparedStatement.executeQuery();
            while (result.next()) {
                int malzemeNo=result.getInt(MALZEMELER_COLUMN_MALZEMENO);
                String malzemeAdi=result.getString(MALZEMELER_COLUMN_MALZEMEADI);
                String malzemeCinsi=result.getString(MALZEMELER_COLUMN_MALZEMECINSI);
                String imagePath=result.getString(MALZEMELER_COLUMN_IMAGEPATH);
                malzeme=new Malzeme(malzemeNo, malzemeAdi, malzemeCinsi, imagePath);
                allMalzeme.add(malzeme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMalzeme;
    }
    public boolean deleteMalzeme(int malzemeNo){
        String sql="DELETE FROM Gazi."+TABLE_MALZEMELER
                +" WHERE "+MALZEMELER_COLUMN_MALZEMENO
                +"="+malzemeNo;
        
        boolean control=false;
        
        try {
            preparedStatement=connection.prepareCall(sql);
            int row=preparedStatement.executeUpdate();
            control=row>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    public boolean updateMalzeme(Malzeme malzeme){
        String sql="UPDATE Gazi."+TABLE_MALZEMELER
                +" SET "+MALZEMELER_COLUMN_MALZEMEADI+"=?,"
                +MALZEMELER_COLUMN_MALZEMECINSI+"=?,"
                +MALZEMELER_COLUMN_IMAGEPATH+"=?"
                +" WHERE "+MALZEMELER_COLUMN_MALZEMENO
                +"="+malzeme.getMalzemeNo();
        
        boolean control=false;
        
        try {
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,malzeme.getMalzemeAdi());
            preparedStatement.setString(2,malzeme.getMalzemeCinsi());
            preparedStatement.setString(3,malzeme.getImagePath());
            int row=preparedStatement.executeUpdate();
            control=row>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    public boolean addMalzeme(Malzeme malzeme){
        String sql="INSERT INTO Gazi."+TABLE_MALZEMELER
                +"("+MALZEMELER_COLUMN_MALZEMEADI+","
                +MALZEMELER_COLUMN_MALZEMECINSI+","
                +MALZEMELER_COLUMN_IMAGEPATH+") VALUES(?,?,?)";
        
        boolean control=false;
        
        try {
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,malzeme.getMalzemeAdi());
            preparedStatement.setString(2,malzeme.getMalzemeCinsi());
            preparedStatement.setString(3,malzeme.getImagePath());
            int row=preparedStatement.executeUpdate();
            control=row>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    //STOK TABLE PROCESS
    public ArrayList<Stok> getAllStok(String search){
        
        search="%"+search+"%";
        ArrayList<Stok> allStok=new ArrayList<>();
        Malzeme malzeme=null;
        Calisan calisan=null;
        Stok stok=null;
        String sql="SELECT s.*,m.*,c.* FROM Gazi."
                +TABLE_STOK+" s,"
                +"Gazi."+TABLE_MALZEMELER+" m,"
                +"Gazi."+TABLE_CALISANLAR+" c"
                +" WHERE ( (s."+STOK_COLUMN_MALZEMENO
                +"= m."+MALZEMELER_COLUMN_MALZEMENO+") AND ("
                +"s."+STOK_COLUMN_CALISANNO+"=c."
                +CALISANLAR_COLUMN_CALISAN_NO+" ))AND(m."
                +MALZEMELER_COLUMN_MALZEMEADI+" LIKE ? OR m."
                +MALZEMELER_COLUMN_MALZEMECINSI+" LIKE ? OR c."
                +CALISANLAR_COLUMN_FNAME+" LIKE ? OR c."
                +CALISANLAR_COLUMN_LNAME+" LIKE ?)";
        
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,search);
            preparedStatement.setString(2,search);
            preparedStatement.setString(3,search);
            preparedStatement.setString(4,search);
            
            ResultSet result=preparedStatement.executeQuery();
            while(result.next()){
                //Stok
                int stokNo=result.getInt(STOK_COLUMN_STOKNO);
                int malzemeNo=result.getInt(STOK_COLUMN_MALZEMENO);
                int calisanNo=result.getInt(STOK_COLUMN_CALISANNO);
                Date kayit_tarihi=new Date(result.getDate(STOK_COLUMN_KAYIT_TARIHI).getTime());
                int miktar=result.getInt(STOK_COLUMN_MIKTAR);
                //Calisan
                String fName=result.getString(CALISANLAR_COLUMN_FNAME);
                String lName=result.getString(CALISANLAR_COLUMN_LNAME);
                Date dob=new Date(result.getDate(CALISANLAR_COLUMN_DOB).getTime());
                char cinsiyet=result.getString(CALISANLAR_COLUMN_SEX).charAt(0);
                String position=result.getString(CALISANLAR_COLUMN_POSITION);
                int salary=result.getInt(CALISANLAR_COLUMN_SALARY);
                //Malzeme
                String malzemeAdi=result.getString(MALZEMELER_COLUMN_MALZEMEADI);
                String malzemeCinsi=result.getString(MALZEMELER_COLUMN_MALZEMECINSI);
                String imagePath=result.getString(MALZEMELER_COLUMN_IMAGEPATH);
                
                calisan=new Calisan(calisanNo, fName, lName, dob, cinsiyet, position, salary);
                malzeme=new Malzeme(malzemeNo, malzemeAdi, malzemeCinsi, imagePath);
                stok=new Stok(stokNo, malzemeNo, calisanNo, kayit_tarihi, miktar, calisan, malzeme);
                allStok.add(stok);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allStok;
    }
    public boolean deleteStok(int stokNo){
        String sql="DELETE FROM Gazi."+TABLE_STOK
                +" WHERE "+STOK_COLUMN_STOKNO+"=?";
        boolean control=false;
        
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, stokNo);
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean  updateStok(Stok stok){
        String sql="UPDATE Gazi."+TABLE_STOK
                +" SET "+STOK_COLUMN_MALZEMENO+"=?,"
                +STOK_COLUMN_CALISANNO+"=?,"
                +STOK_COLUMN_MIKTAR+"=?,"
                +STOK_COLUMN_KAYIT_TARIHI+"=? WHERE "
                +STOK_COLUMN_STOKNO+"=?";
        boolean control=false;
        
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, stok.getMalzemeNo());
            preparedStatement.setInt(2, stok.getCalisanNo());
            preparedStatement.setInt(3, stok.getMiktar());
            preparedStatement.setDate(4,new java.sql.Date(stok.getKayitTarihi().getTime()));
            preparedStatement.setInt(5,stok.getStokNo());
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    public boolean addStok(Stok stok){
        String sql="INSERT INTO Gazi."+TABLE_STOK
                +"("+STOK_COLUMN_MALZEMENO+","
                +STOK_COLUMN_CALISANNO+","
                +STOK_COLUMN_MIKTAR+","
                +STOK_COLUMN_KAYIT_TARIHI+") VALUES(?,?,?,?)";
        boolean control=false;
        
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, stok.getMalzemeNo());
            preparedStatement.setInt(2, stok.getCalisanNo());
            preparedStatement.setInt(3, stok.getMiktar());
            preparedStatement.setDate(4,new java.sql.Date(stok.getKayitTarihi().getTime()));
            int row=preparedStatement.executeUpdate();
            control=row>0;
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return control;
    }
    public ArrayList<CinsStok> getCinsStoks(){
        ArrayList<CinsStok> allCinsStok=new ArrayList<>();
        String sql="SELECT m.malzemeCinsi,SUM(s.miktar) AS toplamAdet "
                + "FROM Gazi."+TABLE_STOK+" s,"
                +"Gazi."+TABLE_MALZEMELER+" m"
                +" WHERE (s."+STOK_COLUMN_MALZEMENO
                +"= m."+MALZEMELER_COLUMN_MALZEMENO+")"
                +" GROUP BY m."+MALZEMELER_COLUMN_MALZEMECINSI;
 
        try {
            preparedStatement=connection.prepareStatement(sql);
            ResultSet result=preparedStatement.executeQuery();
            
            while (result.next()) {
                String cinsAdi=result.getString(MALZEMELER_COLUMN_MALZEMECINSI);
                int toplamAdet=result.getInt("toplamAdet");
                allCinsStok.add(new CinsStok(cinsAdi, toplamAdet));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCinsStok;
    }
    
    
    
}
