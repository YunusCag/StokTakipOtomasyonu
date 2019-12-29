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
public class Calisan {
    private int calisanNo;
    private String fName;
    private String lName;
    private Date dob;
    private char cinsiyet;
    private String position;
    private int salary;

    public Calisan(int calisanNo, String fName, String lName, Date dob, char cinsiyet, String position, int salary) {
        this.calisanNo = calisanNo;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.cinsiyet = cinsiyet;
        this.position = position;
        this.salary = salary;
    }

    public Calisan(String fName, String lName, Date dob, char cinsiyet, String position, int salary) {
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.cinsiyet = cinsiyet;
        this.position = position;
        this.salary = salary;
    }
    

    public int getCalisanNo() {
        return calisanNo;
    }

    public void setCalisanNo(int calisanNo) {
        this.calisanNo = calisanNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public char getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(char cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
    
    
    
}
