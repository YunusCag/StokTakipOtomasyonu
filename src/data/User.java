/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

public class User {
    private int userNo;
    private String userName;
    private String password;
    private char position;
    private int userLogOn;
    private boolean isLogOn=false;

    public User(int userNo, String userName, String password, char position, int userLogOn) {
        this.userNo = userNo;
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.userLogOn = userLogOn;
    }

    public User(String userName, String password, char position) {
        this.userName = userName;
        this.password = password;
        this.position = position;
    }
    
    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    public int getUserLogOn() {
        return userLogOn;
    }

    public void setUserLogOn(int userLogOn) {
        this.userLogOn = userLogOn;
    }

    public boolean isLogOn() {
        return isLogOn;
    }

    public void setIsLogOn(boolean isTrue) {
        this.isLogOn = isTrue;
    }
    
    
    
}
