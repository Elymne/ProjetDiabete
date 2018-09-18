/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author Elymne
 */
public class Connexion {

    private String urlSQLite;
    private Driver driverSQLite;
    private Connection conSQLite;

    public Connexion() {
        urlSQLite = "jdbc:sqlite:dbbSQLite.db";

        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("Driver for SQLite downloaded.");
        } catch (Exception e) {
            System.out.println("Problem with download driver for SQLite: " + e.getMessage());
        }

        try {
            conSQLite = DriverManager.getConnection(urlSQLite);
            System.out.println("Connection to SQLite is done.");
        } catch (Exception e) {
            System.out.println("Problem with connection to SQLite: " + e.getMessage());
        }
    }

    public void deconnexion() {
        try {
            if (!conSQLite.isClosed()) {
                conSQLite.close();
                System.out.println("Connection to SQLite closed.");
            }
        } catch (Exception e) {
            System.out.println("Problem with close connection of SQLite");
        }
    }
}
