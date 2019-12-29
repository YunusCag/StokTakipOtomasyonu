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
public class CinsStok {
    private String cinsAdi;
    private int toplamAdet;

    public CinsStok(String cinsAdi, int toplamAdet) {
        this.cinsAdi = cinsAdi;
        
        if(cinsAdi.equals("Gıda")){
            this.toplamAdet=toplamAdet/20;
        }else{
            this.toplamAdet = toplamAdet;
        }
    }

    public String getCinsAdi() {
        return cinsAdi;
    }

    public void setCinsAdi(String cinsAdi) {
        this.cinsAdi = cinsAdi;
    }

    public int getToplamAdet() {
        return toplamAdet;
    }

    public void setToplamAdet(int toplamAdet) {
        this.toplamAdet = toplamAdet;
    }
    
    
    
}
