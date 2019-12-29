/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author Yunus
 */
public class Stok {
    private int stokNo;
    private int malzemeNo;
    private int calisanNo;
    private Date kayitTarihi;
    private int miktar;
    public Calisan calisan;
    public Malzeme malzeme;

    public Stok(int stokNo, int malzemeNo, int calisanNo, Date kayitTarihi, int miktar, Calisan calisan, Malzeme malzeme) {
        this.stokNo = stokNo;
        this.malzemeNo = malzemeNo;
        this.calisanNo = calisanNo;
        this.kayitTarihi = kayitTarihi;
        this.miktar = miktar;
        this.calisan = calisan;
        this.malzeme = malzeme;
    }

    public Stok(int stokNo, int malzemeNo, int calisanNo, Date kayitTarihi, int miktar) {
        this.stokNo = stokNo;
        this.malzemeNo = malzemeNo;
        this.calisanNo = calisanNo;
        this.kayitTarihi = kayitTarihi;
        this.miktar = miktar;
    }

    public Stok(int malzemeNo, int calisanNo, Date kayitTarihi, int miktar) {
        this.malzemeNo = malzemeNo;
        this.calisanNo = calisanNo;
        this.kayitTarihi = kayitTarihi;
        this.miktar = miktar;
    }

    public int getStokNo() {
        return stokNo;
    }

    public void setStokNo(int stokNo) {
        this.stokNo = stokNo;
    }

    public int getMalzemeNo() {
        return malzemeNo;
    }

    public void setMalzemeNo(int malzemeNo) {
        this.malzemeNo = malzemeNo;
    }

    public int getCalisanNo() {
        return calisanNo;
    }

    public void setCalisanNo(int calisanNo) {
        this.calisanNo = calisanNo;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
    
    
    
}
