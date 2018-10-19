package modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import modele.metier.Evaluation;
import modele.metier.Personne;

/**
 *
 * @author Djurdjevic Sacha
 * @author Allain Mathys
 */
public class EvaluationDao {

    /**
     *
     * Permet de faire une selection d'une évaluation en cherchant l'id de celle-ci 
     * sur la base de données dbbSQLite.
     * 
     * @param id
     * @return Object Evaluation
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws ParseException
     */
    public static Evaluation selectOneById(int id) throws ClassNotFoundException, SQLException, ParseException {
        Evaluation evaluation = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM EVALUATION WHERE ID = ?;";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            evaluation = EvaluationDao.evaluationFromResultSet(rs);
        }
        rs.close();
        pstmt.close();

        c.close();
        return evaluation;
    }

    /**
     *
     * Permet de faire une selection d'une évaluation en cherchant l'id de la personne 
     * sur la base de données dbbSQLite.
     * 
     * @param id
     * @return Object Evaluation
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws ParseException
     */
    public static Evaluation selectOneByIdPersonne(int id) throws ClassNotFoundException, SQLException, ParseException {
        Evaluation evaluation = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM EVALUATION WHERE IDPERSONNE = ?;";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            evaluation = EvaluationDao.evaluationFromResultSet(rs);
        }
        rs.close();
        pstmt.close();

        c.close();
        return evaluation;
    }

    /**
     *
     * Permet de sélectionner toutes les évaluations dans la base de données bddSQLite.
     * 
     * @return List of Object Evaluation
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public static ArrayList<Evaluation> selectAll() throws SQLException, ClassNotFoundException, ParseException {
        ArrayList<Evaluation> listeEvaluations = new ArrayList<Evaluation>();
        Evaluation evaluation = null;

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "SELECT * FROM EVALUATION;";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                evaluation = EvaluationDao.evaluationFromResultSet(rs);
                listeEvaluations.add(evaluation);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.close();
        return listeEvaluations;
    }

    /**
     *
     * Permet d'insérer une nouvelle évaluation dans la bddSqlite.
     * 
     * @param evaluationTourDeTaille
     * @param evaluationActiviteSportive
     * @param evaluationTraitement
     * @param evaluationFamillePositive
     * @param evaluationMasse
     * @param evaluationConsoLegume
     * @param evaluationATCDGlycemie
     * @param evaluationPersonne
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void insert(double evaluationTourDeTaille, boolean evaluationActiviteSportive, boolean evaluationTraitement, boolean evaluationFamillePositive, double evaluationMasse, int evaluationConsoLegume, boolean evaluationATCDGlycemie, Personne evaluationPersonne) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "INSERT INTO EVALUATION (TOURDETAILLE,ACTIVITESPORTIVE,TRAITEMENT,FAMILLEPOSITIVE,MASSE,CONSOLEGUME,ATCDGLYCEMIE,IDPERSONNE) "
                + "VALUES (?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setDouble(1, evaluationTourDeTaille);
            pstmt.setInt(2, evaluationActiviteSportive ? 1 : 0);
            pstmt.setInt(3, evaluationTraitement ? 1 : 0);
            pstmt.setInt(4, evaluationFamillePositive ? 1 : 0);
            pstmt.setDouble(5, evaluationMasse);
            pstmt.setInt(6, evaluationConsoLegume);
            pstmt.setInt(7, evaluationATCDGlycemie ? 1 : 0);
            pstmt.setInt(8, evaluationPersonne.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.commit();
        c.close();
    }

    /**
     *
     * Permet de modifier une évaluation dans la bddSQLite.
     * 
     * @param id
     * @param evaluationTourDeTaille
     * @param evaluationActiviteSportive
     * @param evaluationTraitement
     * @param evaluationFamillePositive
     * @param evaluationMasse
     * @param evaluationConsoLegume
     * @param evaluationATCDGlycemie
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void update(int id, double evaluationTourDeTaille, int evaluationActiviteSportive, boolean evaluationTraitement, boolean evaluationFamillePositive, double evaluationMasse, int evaluationConsoLegume, boolean evaluationATCDGlycemie) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "UPDATE EVALUATION set"
                + " TOURDETAILLE = ?,"
                + " ACTIVITESPORTIVE = ?,"
                + " TRAITEMENT = ?,"
                + " FAMILLEPOSITIVE = ?,"
                + " MASSE = ?,"
                + " CONSOLEGUME = ?,"
                + " ATCDGLYCEMIE = ?"
                + " where ID = ?;";
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {
            pstmt.setInt(8, id);
            pstmt.setDouble(1, evaluationTourDeTaille);
            pstmt.setInt(2, evaluationActiviteSportive);
            pstmt.setBoolean(3, evaluationTraitement);
            pstmt.setBoolean(4, evaluationFamillePositive);
            pstmt.setDouble(5, evaluationMasse);
            pstmt.setInt(6, evaluationConsoLegume);
            pstmt.setBoolean(7, evaluationATCDGlycemie);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        c.commit();
        c.close();
    }

    /**
     *
     * Permet de supprimer une évaluation dans la bddSQLite.
     * 
     * @param id
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void delete(int id) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:dbbSQLite.db");
        c.setAutoCommit(false);
        String sql = "DELETE from EVALUATION where ID = ?;";
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

    private static Evaluation evaluationFromResultSet(ResultSet rs) throws SQLException, ClassNotFoundException, ParseException {
        Evaluation clt = null;
        int id = rs.getInt("ID");
        double evaluationTourDeTaille = rs.getInt("TOURDETAILLE");
        boolean evaluationActiviteSportive = rs.getInt("ACTIVITESPORTIVE") != 0;
        boolean evaluationTraitement = rs.getInt("TRAITEMENT") != 0;
        boolean evaluationFamillePositive = rs.getInt("FAMILLEPOSITIVE") != 0;
        double evaluationMasse = rs.getInt("MASSE");
        int evaluationConsoLegume = rs.getInt("CONSOLEGUME");
        boolean evaluationATCDGlycemie = rs.getInt("ATCDGLYCEMIE") != 0;
        int idPersonne = rs.getInt("IDPERSONNE");
        Personne evaluationPersonne = PersonneDao.selectOneById(idPersonne);
        clt = new Evaluation(id, evaluationTourDeTaille, evaluationActiviteSportive, evaluationTraitement, evaluationFamillePositive, evaluationMasse, evaluationConsoLegume, evaluationATCDGlycemie, evaluationPersonne);
        return clt;
    }

}
