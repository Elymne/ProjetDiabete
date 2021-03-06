package test.modele.metier;

import java.text.ParseException;
import modele.metier.Evaluation;
import modele.metier.Personne;

/**
 *
 * @author Djurdjevic Sacha
 * @author Allain Mathys
 */
public class EvaluationTest {

    public static void main(String[] args) throws ParseException {
        
        Personne personne = new Personne(1,"jean","truc","m","0214444","7477885",45);
        System.out.println(personne.toString());
        Evaluation evaluation = new Evaluation(1,2.14,false,false,false,94.14,0,false,personne);
        System.out.println(evaluation.toString());
        
        int myInt = evaluation.getEvaluationFamillePositive() ? 1 : 0;
        System.out.println(myInt);
        boolean b = myInt != 0;
        System.out.println(b);
    }
    
}
