/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Elymne
 */
public class CreationTable {

    public static void creationTableBddPersonne() {

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
            System.out.println("Ouverture de la base de données");

            stmt = c.createStatement();
            String sql = "CREATE TABLE PERSONNE "
                    + "(ID INTEGER PRIMARY KEY    NOT NULL,"
                    + " NOM    TEXT    NOT NULL, "
                    + " PRENOM    TEXT    NOT NULL, "
                    + " SEXE    CHAR(1), "
                    + " DATENAISSANCE    DATE, "
                    + " SECURITESOCIALE TEXT"
                    + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void creationTableBddEvaluation() {

        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
            System.out.println("Ouverture de la base de données");

            stmt = c.createStatement();
            String sql = "CREATE TABLE EVALUATION "
                    + "(ID INTEGER PRIMARY KEY    NOT NULL,"
                    + " TOURDETAILLE    REAL, "
                    + " ACTIVITESPORTIVE    INTEGER,"
                    + " TRAITEMENT    INTEGER,"
                    + " FAMILLEPOSITIVE    INTEGER,"
                    + " MASSE    REAL,"
                    + " CONSOLEGUME    INTEGER,"
                    + " ATCDGLYCEMIE    INTEGER,"
                    + " IDPERSONNE    INTEGER,"
                    + " FOREIGN KEY(IDPERSONNE) REFERENCES PERSONNE(ID)"
                    + ")";

            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

}
