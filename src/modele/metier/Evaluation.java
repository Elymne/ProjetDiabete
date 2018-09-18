/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.sql.Time;

/**
 *
 * @author Elymne
 */
public class Evaluation {

    private double evaluationTourDeTaille;
    private Time evaluationActiviteSportive;
    private boolean evaluationTraitement;
    private boolean evaluationFamillePositive;
    private double evaluationMasse;
    private int evaluationConsoLegume;
    private boolean evaluationATCDGlycemie;
    private Personne evaluationPersonne;

    public Evaluation(double evaluationTourDeTaille, Time evaluationActiviteSportive, boolean evaluationTraitement, boolean evaluationFamillePositive, double evaluationMasse, int evaluationConsoLegume, boolean evaluationATCD, Personne evaluationPersonne) {
        this.evaluationTourDeTaille = evaluationTourDeTaille;
        this.evaluationActiviteSportive = evaluationActiviteSportive;
        this.evaluationTraitement = evaluationTraitement;
        this.evaluationFamillePositive = evaluationFamillePositive;
        this.evaluationMasse = evaluationMasse;
        this.evaluationConsoLegume = evaluationConsoLegume;
        this.evaluationATCDGlycemie = evaluationATCD;
        this.evaluationPersonne = evaluationPersonne;
    }

    public double getEvaluationTourDeTaille() {
        return evaluationTourDeTaille;
    }

    public void setEvaluationTaille(int evaluationTourDeTaille) {
        this.evaluationTourDeTaille = evaluationTourDeTaille;
    }

    public Time getEvaluationActiviteSportive() {
        return evaluationActiviteSportive;
    }

    public void setEvaluationActiviteSportive(Time evaluationActiviteSportive) {
        this.evaluationActiviteSportive = evaluationActiviteSportive;
    }

    public boolean isEvaluationTraitement() {
        return evaluationTraitement;
    }

    public void setEvaluationTraitement(boolean evaluationTraitement) {
        this.evaluationTraitement = evaluationTraitement;
    }

    public boolean isEvaluationFamillePositive() {
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

    public boolean isEvaluationATCD() {
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

}
