/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScrumXP;

import dbUtils.dbConnection;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class Start {

    private static dbConnection conn;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        conn = new dbConnection();

        System.out.println(conn.fetchSingle("SELECT USER_ID, PASSWORD from USER"));

        new LogInGUI().setVisible(true);
    }
}