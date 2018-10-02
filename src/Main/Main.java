/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controleur.ControleurPrincipal;
import JDBC.Connexion;
import JDBC.CreationTable;
import static JDBC.CreationTable.creationTableBddEvaluation;
import static JDBC.CreationTable.creationTableBddPersonne;
/**
 *
 * @author Elymne
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Connexion();
        
        ControleurPrincipal controleurPrincipal;
        
        controleurPrincipal = new ControleurPrincipal();
        controleurPrincipal.ActiverControleur();
    }

}