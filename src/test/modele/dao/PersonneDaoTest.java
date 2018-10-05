package test.modele.dao;

import JDBC.Connexion;
import java.sql.SQLException;
import java.util.List;
import modele.dao.PersonneDao;
import modele.metier.Personne;

/**
 *
 * @author Elymne
 */
public class PersonneDaoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_Insert(1, "nomRandom", "prenomRandom", "sexeRandom", "2014-12-01", "securitéSocialeRandom");
            System.out.println("Test1 effectué : Insertion de données PERSONNE avec comme référence d'id : 1\n");
            test2_SelectUnique(1);
            System.out.println("Test2 effectué : Selection de l'id 1\n");
            test3_SelectUniqueName("nomRandom", "prenomRandom");
            System.out.println("Test3 effectué : sélection Unique par nom de personne\n");
            test4_SelectMultiple();
            System.out.println("Test4 effectué : Sélection Multiple\n");
            test5_Update(1, "nomMoinsRandomMODIFIE", "prenomMoinsRandomMODIFIE", "sexeMoinsRandomMODIFIE", "0000-00-00", "securitéSocialeMoinsRandomMODIFIE");
            System.out.println("Test5 effectué : Modification des données dans la table Personne (Ligne id = 1 )\n");
            test6_Delete(1);
            test4_SelectMultiple();
            System.out.println("Test6 effectué : Supression des données dont l'id est 1\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        }
    }

    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        new Connexion();
    }

    public static void test1_Insert(int id, String nom, String prenom, String sexe, String dateNaissance, String securiteSociale) throws SQLException, ClassNotFoundException {
        PersonneDao.insert(nom, prenom, sexe, dateNaissance, securiteSociale);
    }

    public static void test2_SelectUnique(int id) throws SQLException, ClassNotFoundException {
        Personne personne = PersonneDao.selectOneById(id);
        System.out.println("Personne n° : " + id + " : " + personne.toString());
    }

    public static void test3_SelectUniqueName(String nom, String prenom) throws SQLException, ClassNotFoundException {
        Personne personne = PersonneDao.selectOneByNomAndPrenom(nom,prenom);
        System.out.println("Personne de nom : " + nom + " : " + personne.toString());
    }

    public static void test4_SelectMultiple() throws SQLException, ClassNotFoundException {
        List<Personne> desPersonnes = PersonneDao.selectAll();
        System.out.println("Les Personnes {");
        for (Personne personne : desPersonnes) {
            System.out.println("Representation : " + personne.toString());
        }
        System.out.println("}");
    }

    public static void test5_Update(int id, String nom, String prenom, String sexe, String dateNaissance, String securiteSociale) throws SQLException, ClassNotFoundException {
        PersonneDao.update(id, nom, prenom, sexe, dateNaissance, securiteSociale);
        Personne personne = PersonneDao.selectOneById(id);
        System.out.println("Personne n° : " + id + " : " + personne.toString());
    }

    public static void test6_Delete(int id) throws SQLException, ClassNotFoundException {
        PersonneDao.delete(id);
    }

}
