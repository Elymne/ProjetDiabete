package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.EvaluationDao;
import modele.metier.Evaluation;
import modele.metier.EvaluationScore;
import vue.VueStatistique;

/**
 *
 * @author Djurdjevic Sacha
 */
public class ControleurStatistique extends ControleurGenerique implements ActionListener, WindowListener {

    private ArrayList<Evaluation> lesEvaluations;

    public ControleurStatistique(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueStatistique();
        vue.addWindowListener(this);
        ((VueStatistique) vue).getjPanelStatistique().setVisible(false);
        ((VueStatistique) vue).getjButtonRetour().addActionListener(this);
        ((VueStatistique) vue).getjButtonValider().addActionListener(this);
    }

    @Override
    public VueStatistique getVue() {
        return (VueStatistique) vue;
    }

    public void afficherStatistique() throws SQLException, ClassNotFoundException, ParseException {
        lesEvaluations = selectionSexe();
        lesEvaluations = selectionAge();
        selectionStatistique();
        ((VueStatistique) vue).getjPanelStatistique().setVisible(true);
        
    }

    public ArrayList<Evaluation> selectionSexe() throws SQLException, ClassNotFoundException, ParseException {
        lesEvaluations = EvaluationDao.selectAll();
        ArrayList<Evaluation> results = new ArrayList<>();
        if (((VueStatistique) vue).getjComboBoxSexe().getSelectedItem() == "Tous") {
            results = lesEvaluations;
        } else {
            if (((VueStatistique) vue).getjComboBoxSexe().getSelectedItem() == "Femmes") {
                for (Evaluation evaluation : lesEvaluations) {
                    if (evaluation.getEvaluationPersonne().getSexe().equals("Femme")) {
                        results.add(evaluation);
                    }
                }
            } else {
                if (((VueStatistique) vue).getjComboBoxSexe().getSelectedItem() == "Hommes") {
                    for (Evaluation evaluation : lesEvaluations) {
                        if (evaluation.getEvaluationPersonne().getSexe().equals("Homme")) {
                            results.add(evaluation);
                        }
                    }
                }
            }
        }
        return results;
    }

    public ArrayList<Evaluation> selectionAge() {
        ArrayList<Evaluation> results = new ArrayList<>();
        if (((VueStatistique) vue).getjComboBoxAge().getSelectedItem() == "Moins de 45 ans") {
            for (Evaluation evaluation : lesEvaluations) {
                if (evaluation.getEvaluationPersonne().getAge() < 45) {
                    results.add(evaluation);
                }
            }
        } else {
            if (((VueStatistique) vue).getjComboBoxAge().getSelectedItem() == "Entre 45 et 54 ans") {
                for (Evaluation evaluation : lesEvaluations) {
                    if (evaluation.getEvaluationPersonne().getAge() > 45
                            && evaluation.getEvaluationPersonne().getAge() < 54) {
                        results.add(evaluation);
                    }
                }
            } else {
                if (((VueStatistique) vue).getjComboBoxAge().getSelectedItem() == "Entre 54 et 64 ans") {
                    for (Evaluation evaluation : lesEvaluations) {
                        if (evaluation.getEvaluationPersonne().getAge() > 54
                                && evaluation.getEvaluationPersonne().getAge() < 64) {
                            results.add(evaluation);
                        }
                    }
                } else {
                    if (((VueStatistique) vue).getjComboBoxAge().getSelectedItem() == "Plus de 64 ans") {
                        for (Evaluation evaluation : lesEvaluations) {
                            if (evaluation.getEvaluationPersonne().getAge() > 64) {
                                results.add(evaluation);
                            }
                        }
                    }else{
                        results = lesEvaluations;
                    }
                }
            }
        }
        return results;
    }
    
    public void selectionStatistique() {
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "Tous") {
            selectionStatistiqueTous();
        }
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "Tour de Taille") {
            selectionStatistiqueTourTaille();
        }
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "IMC") {
            selectionStatistiqueIMC();
        }
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "Part des légumes verts dans l'alimentation") {
            selectionStatistiqueLegume();
        }
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "Activite physique") {
            selectionStatistiqueActiviteSportive();
        }
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "Antécédent de traitement anti-HTA") {
            selectionStatistiqueTraitement();
        }
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "Antécédent familial de diabète") {
            selectionStatistiqueFamilleDiabete();
        }
        if (((VueStatistique) vue).getjComboBoxSelectionStat().getSelectedItem() == "Antécédent de glycémie supérieur à la normale") {
            selectionStatistiqueGlycemie();
        }
    }
    
    public int[] isFemme(){
        int result[] = new int[2];
        for(Evaluation evaluation : lesEvaluations){
            if(evaluation.getEvaluationPersonne().getSexe() == "Femme"){
                result[0] = 80;
                result[1] = 88;
            }else{
                result[0] = 94;
                result[1] = 102;
            }
        }
        return result;
    }
    
    public void selectionStatistiqueActiviteSportive(){
        affichage_2();
        int score1 = 0;
        int score2 = 0;
        int nombre = 0;
        double moyenne = 0;
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            if (evaluation.getEvaluationActiviteSportive() == false) {
                ++score1;
            } else {
                if (evaluation.getEvaluationActiviteSportive() == true) {
                    ++moyenne;
                    ++score2;
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Activité Sportive");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjLabelStat1().setText("Ne pratique pas du sport 30 minutes par jour");
        ((VueStatistique) vue).getjLabelStat2().setText("Pratique pas du sport 30 minutes par jour");
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }
    
    public void selectionStatistiqueTraitement(){
        affichage_2();
        int score1 = 0;
        int score2 = 0;
        int nombre = 0;
        double moyenne = 0;
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            if (evaluation.getEvaluationTraitement()== false) {
                ++score1;
            } else {
                if (evaluation.getEvaluationTraitement() == true) {
                    ++moyenne;
                    ++score2;
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Antécédent de traitement anti-HTA");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjLabelStat1().setText("N'a pas des antécédents de traitement anti-HTA");
        ((VueStatistique) vue).getjLabelStat2().setText("A des antécédents de traitement anti-HTA");
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }
    
    public void selectionStatistiqueFamilleDiabete(){
        affichage_2();
        int score1 = 0;
        int score2 = 0;
        int nombre = 0;
        double moyenne = 0;
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            if (evaluation.getEvaluationFamillePositive()== false) {
                ++score1;
            } else {
                if (evaluation.getEvaluationFamillePositive() == true) {
                    ++moyenne;
                    ++score2;
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Antécédent familial de diabète");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjLabelStat1().setText("N'a pas des antécédents familial de diabète");
        ((VueStatistique) vue).getjLabelStat2().setText("A des antécédents familial de diabète");
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }
    
    public void selectionStatistiqueGlycemie(){
        affichage_2();
        int score1 = 0;
        int score2 = 0;
        int nombre = 0;
        double moyenne = 0;
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            if (evaluation.getEvaluationATCDGlycemie()== false) {
                ++score1;
            } else {
                if (evaluation.getEvaluationATCDGlycemie()== true) {
                    ++moyenne;
                    ++score2;
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Antécédent de glycémie supérieur à la normale");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjLabelStat1().setText("N'a pas des antécédents de glycémie supérieur à la normale");
        ((VueStatistique) vue).getjLabelStat2().setText("A des antécédents de glycémie supérieur à la normale");
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }
    
    public void selectionStatistiqueTourTaille() {
        affichage_3();
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        int nombre = 0;
        double moyenne = 0;
        int[] results = isFemme();
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            if (evaluation.getEvaluationMasse() <= results[0]) {
                moyenne += evaluation.getEvaluationMasse();
                ++score1;
            } else {
                if (evaluation.getEvaluationMasse() > results[0]
                        && evaluation.getEvaluationMasse() <= results[1]) {
                    moyenne += evaluation.getEvaluationMasse();
                    ++score2;
                } else {
                    if (evaluation.getEvaluationMasse() > results[1]) {
                        moyenne += evaluation.getEvaluationMasse();
                        ++score3;
                    }
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Tour de Taille");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjTextFieldStat3().setText(Integer.toString(score3));
        ((VueStatistique) vue).getjLabelStat1().setText("Tour de taille (cm) < " + Integer.toString(results[0]));
        ((VueStatistique) vue).getjLabelStat2().setText("Tour de taille (cm) " + Integer.toString(results[0]) + " - " + Integer.toString(results[1]));
        ((VueStatistique) vue).getjLabelStat3().setText("Tour de taille (cm) > " +Integer.toString(results[1]));
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }
    
    public void selectionStatistiqueLegume() {
        affichage_3();
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        int nombre = 0;
        double moyenne = 0;
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            if (evaluation.getEvaluationConsoLegume() == 0) {
                moyenne += evaluation.getEvaluationConsoLegume();
                ++score1;
            } else {
                if (evaluation.getEvaluationConsoLegume() == 1) {
                    moyenne += evaluation.getEvaluationConsoLegume();
                    ++score2;
                } else {
                    if (evaluation.getEvaluationConsoLegume() == 2) {
                        moyenne += evaluation.getEvaluationConsoLegume();
                        ++score3;
                    }
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Consommation de Legume");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjTextFieldStat3().setText(Integer.toString(score3));
        ((VueStatistique) vue).getjLabelStat1().setText("Tous les jours");
        ((VueStatistique) vue).getjLabelStat2().setText("Pas tout les jours");
        ((VueStatistique) vue).getjLabelStat3().setText("Non");
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }
    
    public void selectionStatistiqueIMC() {
        affichage_3();
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        int nombre = 0;
        double moyenne = 0;
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            if (evaluation.getEvaluationMasse()<= 94) {
                moyenne += evaluation.getEvaluationMasse();
                ++score1;
            } else {
                if (evaluation.getEvaluationMasse() > 94
                        && evaluation.getEvaluationMasse() <= 102) {
                    moyenne += evaluation.getEvaluationMasse();
                    ++score2;
                } else {
                    if (evaluation.getEvaluationMasse() > 102) {
                        moyenne += evaluation.getEvaluationMasse();
                        ++score3;
                    }
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Tour de Taille");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjTextFieldStat3().setText(Integer.toString(score3));
        ((VueStatistique) vue).getjLabelStat1().setText("Indice de masse corporelle(kg/m²) < 25 ");
        ((VueStatistique) vue).getjLabelStat2().setText("Indice de masse corporelle(kg/m²) 25-30");
        ((VueStatistique) vue).getjLabelStat3().setText("Indice de masse corporelle(kg/m²) > 30");
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }

    public void selectionStatistiqueTous() {
        affichage_5();
        EvaluationScore evaluationScore;
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        int score4 = 0;
        int score5 = 0;
        int nombre = 0;
        double moyenne = 0;
        for (Evaluation evaluation : lesEvaluations) {
            ++nombre;
            evaluationScore = new EvaluationScore(evaluation);
            if (evaluationScore.getScoreTotal() <= 7) {
                moyenne += evaluationScore.getScoreTotal();
                ++score1;
            } else {
                if (evaluationScore.getScoreTotal() > 7 && evaluationScore.getScoreTotal() <= 11) {
                    moyenne += evaluationScore.getScoreTotal();
                    ++score2;
                } else {
                    if (evaluationScore.getScoreTotal() > 11 && evaluationScore.getScoreTotal() <= 14) {
                        moyenne += evaluationScore.getScoreTotal();
                        ++score3;
                    } else {
                        if (evaluationScore.getScoreTotal() > 14 && evaluationScore.getScoreTotal() <= 20) {
                            moyenne += evaluationScore.getScoreTotal();
                            ++score4;
                        } else {
                            if (evaluationScore.getScoreTotal() > 20) {
                                moyenne += evaluationScore.getScoreTotal();
                                ++score5;
                            }
                        }
                    }
                }
            }
        }
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setText("Tous");
        ((VueStatistique) vue).getjTextFieldStat1().setText(Integer.toString(score1));
        ((VueStatistique) vue).getjTextFieldStat2().setText(Integer.toString(score2));
        ((VueStatistique) vue).getjTextFieldStat3().setText(Integer.toString(score3));
        ((VueStatistique) vue).getjTextFieldStat4().setText(Integer.toString(score4));
        ((VueStatistique) vue).getjTextFieldStat5().setText(Integer.toString(score5));
        ((VueStatistique) vue).getjLabelStat1().setText("Risque faible (= 1%)");
        ((VueStatistique) vue).getjLabelStat2().setText("Risque légèrement élevé (= 4%)");
        ((VueStatistique) vue).getjLabelStat3().setText("Risque modéré (= 17%)");
        ((VueStatistique) vue).getjLabelStat4().setText("Risque élevé (= 33%)");
        ((VueStatistique) vue).getjLabelStat5().setText("Risque très élevé (= 50%)");
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setText(Double.toString(moyenne/nombre));
        ((VueStatistique) vue).getjTextFieldStatNombre().setText(Integer.toString(nombre));
    }
    
    public void affichage_5(){
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStatNombre().setVisible(true);
        ((VueStatistique) vue).getjLabelStat1().setVisible(true);
        ((VueStatistique) vue).getjLabelStat2().setVisible(true);
        ((VueStatistique) vue).getjLabelStat3().setVisible(true);
        ((VueStatistique) vue).getjLabelStat4().setVisible(true);
        ((VueStatistique) vue).getjLabelStat5().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat1().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat2().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat3().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat4().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat5().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat3().setEnabled(true);
        ((VueStatistique) vue).getjTextFieldStat4().setEnabled(true);
        ((VueStatistique) vue).getjTextFieldStat5().setEnabled(true);
    }
    
    public void affichage_3(){
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStatNombre().setVisible(true);
        ((VueStatistique) vue).getjLabelStat1().setVisible(true);
        ((VueStatistique) vue).getjLabelStat2().setVisible(true);
        ((VueStatistique) vue).getjLabelStat3().setVisible(true);
        ((VueStatistique) vue).getjLabelStat4().setText("");
        ((VueStatistique) vue).getjLabelStat5().setText("");
        ((VueStatistique) vue).getjTextFieldStat1().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat2().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat3().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat3().setEnabled(true);
        ((VueStatistique) vue).getjTextFieldStat4().setText("");
        ((VueStatistique) vue).getjTextFieldStat5().setText("");
        ((VueStatistique) vue).getjTextFieldStat4().setEnabled(false);
        ((VueStatistique) vue).getjTextFieldStat5().setEnabled(false);
    }
    
    public void affichage_2(){
        ((VueStatistique) vue).getjLabelStatistiqueTitre().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStatMoyenne().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStatNombre().setVisible(true);
        ((VueStatistique) vue).getjLabelStat1().setVisible(true);
        ((VueStatistique) vue).getjLabelStat2().setVisible(true);
        ((VueStatistique) vue).getjLabelStat3().setText("");
        ((VueStatistique) vue).getjLabelStat4().setText("");
        ((VueStatistique) vue).getjLabelStat5().setText("");
        ((VueStatistique) vue).getjTextFieldStat1().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat2().setVisible(true);
        ((VueStatistique) vue).getjTextFieldStat3().setText("");
        ((VueStatistique) vue).getjTextFieldStat4().setText("");
        ((VueStatistique) vue).getjTextFieldStat5().setText("");
        ((VueStatistique) vue).getjTextFieldStat3().setEnabled(false);
        ((VueStatistique) vue).getjTextFieldStat4().setEnabled(false);
        ((VueStatistique) vue).getjTextFieldStat5().setEnabled(false);
    }

    public void quitterStatistique() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().action(EnumAction.QUITTER_STATISTIQUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(((VueStatistique) vue).getjButtonRetour())) {
            try {
                quitterStatistique();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(((VueStatistique) vue).getjButtonValider())) {
            try {
                afficherStatistique();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            quitterStatistique();
        } catch (SQLException ex) {
            Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
