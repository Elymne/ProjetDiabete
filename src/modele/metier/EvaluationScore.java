package modele.metier;

/**
 *
 * @author Djurdjevic Sacha
 * @author Allain Mathys
 */
public class EvaluationScore {

    private Evaluation evaluation;
    private int scoreTotal;

    public EvaluationScore(Evaluation evaluation) {
        this.evaluation = evaluation;
        this.scoreTotal = getEvaluationTourDeTaille()
                + getEvaluationActiviteSportive()
                + getEvaluationTraitement()
                + getEvaluationFamillePositive()
                + getEvaluationMasse()
                + getEvaluationConsoLegume()
                + getEvaluationATCD()
                + getEvaluationATCDGlycemie()
                + getEvaluationAge();
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public int getEvaluationTourDeTaille() {
        int score = 0;

        if (getEvaluation().getEvaluationPersonne().getSexe() == "Homme") {
            if (getEvaluation().getEvaluationTourDeTaille() > 94 && getEvaluation().getEvaluationTourDeTaille() < 102) {
                score = 3;
            } else {
                if (getEvaluation().getEvaluationTourDeTaille() > 102) {
                    score = 4;
                }
            }
        } else {
            if (getEvaluation().getEvaluationTourDeTaille() > 80 && getEvaluation().getEvaluationTourDeTaille() < 88) {
                score = 3;
            } else {
                if (getEvaluation().getEvaluationTourDeTaille() > 88) {
                    score = 4;
                }
            }
        }

        return score;
    }

    public int getEvaluationActiviteSportive() {
        int score = 0;
        if (!getEvaluation().getEvaluationActiviteSportive()) {
            score = 2;
        }
        return score;
    }

    public int getEvaluationTraitement() {
        int score = 0;
        if (getEvaluation().getEvaluationTraitement()) {
            score = 2;
        }
        return score;
    }

    public int getEvaluationFamillePositive() {
        int score = 0;
        if (getEvaluation().getEvaluationFamillePositive()) {
            score = 3;
        }
        return score;
    }

    public int getEvaluationMasse() {
        int score = 0;
        if (getEvaluation().getEvaluationMasse() > 25 && getEvaluation().getEvaluationMasse() < 30) {
            score = 1;
        } else {
            if (getEvaluation().getEvaluationMasse() > 30) {
                score = 3;
            }
        }
        return score;
    }

    public int getEvaluationConsoLegume() {
        int score = 0;
        if (getEvaluation().getEvaluationConsoLegume() == 2) {
            score = 2;
        } else {
            if (getEvaluation().getEvaluationConsoLegume() == 1) {
                score = 1;
            }
        }
        return score;
    }

    public int getEvaluationATCD() {
        int score = 0;
        if (getEvaluation().getEvaluationATCDGlycemie()) {
            score = 2;
        }
        return score;
    }

    public int getEvaluationATCDGlycemie() {
        int score = 0;
        if (getEvaluation().getEvaluationATCDGlycemie()) {
            score = 5;
        }
        return score;
    }

    public int getEvaluationAge() {
        int score = 0;
        int age = getEvaluation().getEvaluationPersonne().getAge();
        if (age > 45 && age < 54) {
            score = 2;
        } else {
            if (age > 54 && age < 64) {
                score = 3;
            } else {
                if (age > 54) {
                    score = 4;
                }
            }
        }
        return score;
    }

}
