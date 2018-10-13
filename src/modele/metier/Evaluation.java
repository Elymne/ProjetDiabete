package modele.metier;

import java.text.ParseException;

/**
 *
 * @author Djurdjevic Sacha
 */
public class Evaluation {

    private int id;
    private double evaluationTourDeTaille;
    private boolean evaluationActiviteSportive;
    private boolean evaluationTraitement;
    private boolean evaluationFamillePositive;
    private double evaluationMasse;
    private int evaluationConsoLegume;
    private boolean evaluationATCDGlycemie;
    private Personne evaluationPersonne;

    public Evaluation(int id, double evaluationTourDeTaille, boolean evaluationActiviteSportive, boolean evaluationTraitement, boolean evaluationFamillePositive, double evaluationMasse, int evaluationConsoLegume, boolean evaluationATCD, Personne evaluationPersonne) throws ParseException {
        this.id = id;
        this.evaluationTourDeTaille = evaluationTourDeTaille;
        this.evaluationActiviteSportive = evaluationActiviteSportive;
        this.evaluationTraitement = evaluationTraitement;
        this.evaluationFamillePositive = evaluationFamillePositive;
        this.evaluationMasse = evaluationMasse;
        this.evaluationConsoLegume = evaluationConsoLegume;
        this.evaluationATCDGlycemie = evaluationATCD;
        this.evaluationPersonne = evaluationPersonne;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "id=" + id + ", evaluationTourDeTaille=" + evaluationTourDeTaille + ", evaluationActiviteSportive=" + evaluationActiviteSportive + ", evaluationTraitement=" + evaluationTraitement + ", evaluationFamillePositive=" + evaluationFamillePositive + ", evaluationMasse=" + evaluationMasse + ", evaluationConsoLegume=" + evaluationConsoLegume + ", evaluationATCDGlycemie=" + evaluationATCDGlycemie + ", evaluationPersonne=" + evaluationPersonne.toString() + '}';
    }

    public double getEvaluationTourDeTaille() {
        return evaluationTourDeTaille;
    }

    public void setEvaluationTaille(int evaluationTourDeTaille) {
        this.evaluationTourDeTaille = evaluationTourDeTaille;
    }

    public boolean getEvaluationActiviteSportive() {
        return evaluationActiviteSportive;
    }

    public void setEvaluationActiviteSportive(boolean evaluationActiviteSportive) {
        this.evaluationActiviteSportive = evaluationActiviteSportive;
    }

    public boolean getEvaluationTraitement() {
        return evaluationTraitement;
    }

    public void setEvaluationTraitement(boolean evaluationTraitement) {
        this.evaluationTraitement = evaluationTraitement;
    }

    public boolean getEvaluationFamillePositive() {
        return evaluationFamillePositive;
    }

    public void setEvaluationFamillePositive(boolean evaluationFamillePositive) {
        this.evaluationFamillePositive = evaluationFamillePositive;
    }

    public double getEvaluationMasse() {
        return evaluationMasse;
    }

    public void setEvaluationMasse(double evaluationMasse) {
        this.evaluationMasse = evaluationMasse;
    }

    public int getEvaluationConsoLegume() {
        return evaluationConsoLegume;
    }

    public void setEvaluationConsoLegume(int evluationConsoLegume) {
        this.evaluationConsoLegume = evluationConsoLegume;
    }

    public boolean getEvaluationATCD() {
        return evaluationATCDGlycemie;
    }

    public void setEvaluationATCD(boolean evaluationATCD) {
        this.evaluationATCDGlycemie = evaluationATCD;
    }

    public Personne getEvaluationPersonne() {
        return evaluationPersonne;
    }

    public void setEvaluationPersonne(Personne evaluationPersonne) {
        this.evaluationPersonne = evaluationPersonne;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getEvaluationATCDGlycemie() {
        return evaluationATCDGlycemie;
    }

    public void setEvaluationATCDGlycemie(boolean evaluationATCDGlycemie) {
        this.evaluationATCDGlycemie = evaluationATCDGlycemie;
    }
}
