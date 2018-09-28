package test.modele.dao;

import JDBC.Connexion;
import java.sql.SQLException;
import java.util.List;
import modele.dao.EvaluationDao;
import modele.dao.PersonneDao;
import modele.metier.Evaluation;
import modele.metier.Personne;

/**
 *
 * @author Elymne
 */
public class EvaluationDaoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_InsertPersonne(1, "Jean", "Bonisseur de Labatte", "m", "1927-01-24", "0547777");
            Personne personne_1 = test1_SelectUniquePersonne(1);
            test1_InsertPersonne(2, "Sara", "Sve", "m", "1927-05-21", "0577777");
            Personne personne_2 = test1_SelectUniquePersonne(2);
            test1_Insert(1, 10.50, 1, true, false, 90.47, 0, false, personne_1);
            test1_Insert(2, 24.36, 3, true, true, 90.47, 0, true, personne_2);
            System.out.println("Test1 effectué : Insertion de données PERSONNE avec comme référence d'id : 1 et 2\n");
            test2_SelectUnique(1);
            System.out.println("Test2 effectué : Selection de l'id 1\n");
            test4_SelectMultiple();
            System.out.println("Test4 effectué : Sélection Multiple\n");
            test5_Update(2, 10, 0, false, false, 90.47, 0, false);
            System.out.println("Test5 effectué : Modification des données dans la table Evaluation (Ligne id = 2 )\n");
            test_Delete(1);
            test_Delete(2);
            test4_SelectMultiple();
            System.out.println("Test6 effectué : Supression des données dont l'id est 1 et 2\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        }
    }

    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        new Connexion();
    }

    public static void test1_Insert(int id, double evaluationTourDeTaille, int evaluationActiviteSportive, boolean evaluationTraitement, boolean evaluationFamillePositive, double evaluationMasse, int evaluationConsoLegume, boolean evaluationATCDGlycemie, Personne evaluationPersonne) throws SQLException, ClassNotFoundException {
        EvaluationDao.insert(id, evaluationTourDeTaille, evaluationActiviteSportive, evaluationTraitement, evaluationFamillePositive, evaluationMasse, evaluationConsoLegume, evaluationATCDGlycemie, evaluationPersonne);
    }

    public static void test2_SelectUnique(int id) throws SQLException, ClassNotFoundException {
        Evaluation evaluation = EvaluationDao.selectOneById(id);
        System.out.println("Evaluation n° : " + id + " : " + evaluation.toString());
    }

    public static void test4_SelectMultiple() throws SQLException, ClassNotFoundException {
        List<Evaluation> desEvaluation = EvaluationDao.selectAll();
        System.out.println("Les évaluations {");
        for (Evaluation evaluation : desEvaluation) {
            System.out.println("Evaluation : " + evaluation.toString());
        }
        System.out.println("}");
    }

    public static void test5_Update(int id, double evaluationTourDeTaille, int evaluationActiviteSportive, boolean evaluationTraitement, boolean evaluationFamillePositive, double evaluationMasse, int evaluationConsoLegume, boolean evaluationATCDGlycemie) throws SQLException, ClassNotFoundException {
        EvaluationDao.update(id, evaluationTourDeTaille, evaluationActiviteSportive, evaluationTraitement, evaluationFamillePositive, evaluationMasse, evaluationConsoLegume, evaluationATCDGlycemie);
        Evaluation evaluation = EvaluationDao.selectOneById(id);
        System.out.println("Personne n° : " + id + " : " + evaluation.toString());
    }

    public static void test_Delete(int id) throws SQLException, ClassNotFoundException {
        EvaluationDao.delete(id);
    }

    public static Personne test1_SelectUniquePersonne(int id) throws SQLException, ClassNotFoundException {
        Personne personne = PersonneDao.selectOneById(id);
        return personne;
    }

    public static void test1_InsertPersonne(int id, String nom, String prenom, String sexe, String dateNaissance, String securiteSociale) throws SQLException, ClassNotFoundException {
        PersonneDao.insert(id, nom, prenom, sexe, dateNaissance, securiteSociale);
    }

}
