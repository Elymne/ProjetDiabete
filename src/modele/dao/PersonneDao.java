/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modele.metier.Personne;

/**
 *
 * @author Elymne
 */
public class PersonneDao {

    public static Personne selectOneById(int id) throws ClassNotFoundException, SQLException {
        Personne personne = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM PERSONNE WHERE ID = ?;";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            personne = PersonneDao.personneFromResultSet(rs);
        }
        rs.close();
        pstmt.close();

        c.close();
        return personne;
    }

    public static Personne selectOneByNomAndPrenom(String nom, String prenom) throws ClassNotFoundException, SQLException {

        Personne personne = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM PERSONNE WHERE NOM = ? AND PRENOM = ?;";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setString(1, nom);
        pstmt.setString(2, prenom);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            personne = PersonneDao.personneFromResultSet(rs);
        }
        rs.close();
        pstmt.close();

        c.close();
        return personne;
    }

    public static ArrayList<Personne> selectAll() throws SQLException, ClassNotFoundException {
        ArrayList<Personne> listePersonnes = new ArrayList<Personne>();
        Personne personne = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM PERSONNE;";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                personne = PersonneDao.personneFromResultSet(rs);
                listePersonnes.add(personne);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.close();
        return listePersonnes;
    }

    public static ArrayList<Personne> selectAllByNom(String nom) throws SQLException, ClassNotFoundException {
        ArrayList<Personne> listePersonnes = new ArrayList<Personne>();
        Personne personne = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM PERSONNE WHERE NOM = ?;";

        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setString(1, nom);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            personne = PersonneDao.personneFromResultSet(rs);
            listePersonnes.add(personne);
        }
        rs.close();
        pstmt.close();

        c.close();
        return listePersonnes;
    }

    public static ArrayList<Personne> selectAllOrderByNameASC() throws SQLException, ClassNotFoundException {
        ArrayList<Personne> listePersonnes = new ArrayList<Personne>();
        Personne personne = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM PERSONNE order by NOM ASC;";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                personne = PersonneDao.personneFromResultSet(rs);
                listePersonnes.add(personne);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.close();
        return listePersonnes;
    }

    public static ArrayList<Personne> selectAllOrderByNameDESC() throws SQLException, ClassNotFoundException {
        ArrayList<Personne> listePersonnes = new ArrayList<Personne>();
        Personne personne = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM PERSONNE order by NOM DESC;";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                personne = PersonneDao.personneFromResultSet(rs);
                listePersonnes.add(personne);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.close();
        return listePersonnes;
    }

    public static void insert(String nom, String prenom, String sexe, String dateNaissance, String securiteSociale) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "INSERT INTO PERSONNE (NOM,PRENOM,SEXE,DATENAISSANCE,SECURITESOCIALE) "
                + "VALUES (?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
                
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, sexe);
            pstmt.setString(4, dateNaissance);
            pstmt.setString(5, securiteSociale);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.commit();
        c.close();
    }

    public static void update(int id, String nom, String prenom, String sexe, String dateNaissance, String securiteSociale) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "UPDATE PERSONNE set"
                + " NOM = ?,"
                + " PRENOM = ?,"
                + " SEXE =  ?,"
                + " DATENAISSANCE = ?,"
                + " SECURITESOCIALE = ?"
                + " where ID=?;";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, sexe);
            pstmt.setString(4, dateNaissance);
            pstmt.setString(5, securiteSociale);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.commit();
        c.close();
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "DELETE from PERSONNE where ID = ?;";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.commit();
        c.close();
    }

    private static Personne personneFromResultSet(ResultSet rs) throws SQLException {
        Personne clt = null;
        int id = rs.getInt("ID");
        String nom = rs.getString("NOM");
        String prenom = rs.getString("PRENOM");
        String sexe = rs.getString("SEXE");
        String dateNaissance = rs.getString("DATENAISSANCE");
        String securiteSociale = rs.getString("SECURITESOCIALE");
        clt = new Personne(id, nom, prenom, sexe, dateNaissance, securiteSociale);
        return clt;
    }
}
