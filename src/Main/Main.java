package Main;

import controleur.ControleurPrincipal;
import JDBC.Connexion;

/**
 *
 * @author Djurdjevic Sacha
 */
public class Main {

    public static void main(String[] args) {
        
        new Connexion();
        
        ControleurPrincipal controleurPrincipal;
        controleurPrincipal = new ControleurPrincipal();
        controleurPrincipal.action();
    }

}