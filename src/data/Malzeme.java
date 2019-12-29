/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Yunus
 */
public class Malzeme {
    private int malzemeNo;
    private String malzemeAdi;
    private String malzemeCinsi;
    private String imagePath;

    public Malzeme(int malzemeNo, String malzemeAdi, String malzemeCinsi, String imagePath) {
        this.malzemeNo = malzemeNo;
        this.malzemeAdi = malzemeAdi;
        this.malzemeCinsi = malzemeCinsi;
        this.imagePath = imagePath;
    }

    public Malzeme(String malzemeAdi, String malzemeCinsi, String imagePath) {
        this.malzemeAdi = malzemeAdi;
        this.malzemeCinsi = malzemeCinsi;
        this.imagePath = imagePath;
    }

    public int getMalzemeNo() {
        return malzemeNo;
    }

    public void setMalzemeNo(int malzemeNo) {
        this.malzemeNo = malzemeNo;
    }

    public String getMalzemeAdi() {
        return malzemeAdi;
    }

    public void setMalzemeAdi(String malzemeAdi) {
        this.malzemeAdi = malzemeAdi;
    }

    public String getMalzemeCinsi() {
        return malzemeCinsi;
    }

    public void setMalzemeCinsi(String malzemeCinsi) {
        this.malzemeCinsi = malzemeCinsi;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
}
