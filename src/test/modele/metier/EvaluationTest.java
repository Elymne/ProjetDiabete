/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.metier.Evaluation;
import modele.metier.Personne;

/**
 *
 * @author Elymne
 */
public class EvaluationTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Personne personne = new Personne(1,"jean","truc","m","0214444","7477885");
        System.out.println(personne.toString());
        Evaluation evaluation = new Evaluation(1,2.14,1,false,false,94.14,0,false,personne);
        System.out.println(evaluation.toString());
        
        int myInt = evaluation.isEvaluationFamillePositive() ? 1 : 0;
        System.out.println(myInt);
        boolean b = myInt != 0;
        System.out.println(b);
    }
    
}
