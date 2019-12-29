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
public interface IDBConnection {
    public boolean openConnection();
    public boolean closeConnection();
    
}
