package Main;

import controleur.ControleurPrincipal;
import JDBC.Connexion;
import static JDBC.CreationTable.creationTableBddEvaluation;
import static JDBC.CreationTable.creationTableBddPersonne;
import java.io.File;

/**
 *
 * @author Djurdjevic Sacha
 * @author Allain Mathys
 */
public class Main {

    public static void main(String[] args) {

        File f = new File("dbbSQLite.db");
        if (f.isFile()) {

            new Connexion();
            ControleurPrincipal controleurPrincipal;
            controleurPrincipal = new ControleurPrincipal();
            controleurPrincipal.action();
        } else {
            creationTableBddPersonne();
            creationTableBddEvaluation();

            new Connexion();
            ControleurPrincipal controleurPrincipal;
            controleurPrincipal = new ControleurPrincipal();
            controleurPrincipal.action();
        }

    }

}
