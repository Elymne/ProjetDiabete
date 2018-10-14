package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.EvaluationDao;
import modele.metier.Evaluation;
import modele.metier.EvaluationScore;
import vue.VueListeDiagnostique;

/**
 *
 * @author Djurdjevic Sacha
 */
public class ControleurListeDiagnostique extends ControleurGenerique implements ActionListener, WindowListener, MouseListener {

    private ArrayList<Evaluation> lesEvaluations;
    private Evaluation evaluation;

    public ControleurListeDiagnostique(ControleurPrincipal controleurPrincipal) throws SQLException, ClassNotFoundException {
        super(controleurPrincipal);
        vue = new VueListeDiagnostique();
        vue.addWindowListener(this);
        afficherListeInformation();
        afficherListeId();
        ((VueListeDiagnostique) vue).getjButtonRetour().addActionListener(this);
        ((VueListeDiagnostique) vue).getjButtonSupprimer().addActionListener(this);
        ((VueListeDiagnostique) vue).getjTableId().addMouseListener(this);
    }

    @Override
    public VueListeDiagnostique getVue() {
        return (VueListeDiagnostique) vue;
    }

    public void afficherListeInformation() {
        ((VueListeDiagnostique) vue).getModeleTableListeInformation().setRowCount(0);
        String[] titresColonnesListeInformation = {"Nom", "Prenom"};
        ((VueListeDiagnostique) vue).getModeleTableListeInformation().setColumnIdentifiers(titresColonnesListeInformation);
        try {
            String[] ligneDonnees = new String[2];
            lesEvaluations = EvaluationDao.selectAll();
            for (Evaluation evaluation : lesEvaluations) {
                ligneDonnees[0] = evaluation.getEvaluationPersonne().getNom();
                ligneDonnees[1] = evaluation.getEvaluationPersonne().getPrenom();
                ((VueListeDiagnostique) vue).getModeleTableListeInformation().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            String msg = "Erreur dans la methode afficherListeEvaluation" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, "", msg, JOptionPane.ERROR_MESSAGE);
        }
    }

    

    public void afficherListeId() throws SQLException, ClassNotFoundException {
        ((VueListeDiagnostique) vue).getModeleTableId().setRowCount(0);
        String[] titresColonnesId = {"Id Evaluation"};
        ((VueListeDiagnostique) vue).getModeleTableId().setColumnIdentifiers(titresColonnesId);
        try {
            String[] ligneDonnees = new String[1];
            lesEvaluations = EvaluationDao.selectAll();
            for (Evaluation evaluation : lesEvaluations) {
                ligneDonnees[0] = Integer.toString(evaluation.getId());
                ((VueListeDiagnostique) vue).getModeleTableId().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            String msg = "Erreur dans la methode afficherListeEvaluation" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, "", msg, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void afficherInformationEvaluation() throws ClassNotFoundException, SQLException, ParseException {
        int ligne = ((VueListeDiagnostique) vue).getjTableId().getSelectedRow();
        int colonne = ((VueListeDiagnostique) vue).getjTableId().getSelectedColumn();

        if (ligne != -1 && colonne != -1) {
            String id = (String) ((VueListeDiagnostique) vue).getModeleTableId().getValueAt(ligne, colonne);
            System.out.println(id);
            evaluation = EvaluationDao.selectOneById(Integer.parseInt(id));
            remplirJTextFieldPersonne(evaluation);
            remplirJTextFieldEvaluation(evaluation);
            remplirJTextFieldEvaluationScore(evaluation);
        }
    }

    public void supprimerDiagnostique() throws ClassNotFoundException, SQLException, ParseException {
        int ligne = ((VueListeDiagnostique) vue).getjTableId().getSelectedRow();
        int colonne = ((VueListeDiagnostique) vue).getjTableId().getSelectedColumn();
        if (ligne != -1 && colonne != -1) {
            if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr de supprimer cette evaluation ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String id = (String) ((VueListeDiagnostique) vue).getModeleTableId().getValueAt(ligne, colonne);
                EvaluationDao.delete(Integer.parseInt(id));
                this.getControleurPrincipal().action(EnumAction.QUITTER_LISTEDIAGNOSTIQUE);
                this.getControleurPrincipal().action(EnumAction.LISTEDIAGNOSTIQUE);
            }
        }
    }

    public void remplirJTextFieldPersonne(Evaluation evaluation) {
        String nom = (String) evaluation.getEvaluationPersonne().getNom();
        String prenom = (String) evaluation.getEvaluationPersonne().getPrenom();
        String sexe = (String) evaluation.getEvaluationPersonne().getSexe();
        String dateNaissance = (String) evaluation.getEvaluationPersonne().getDateNaissance();
        String codeSecuriteSociale = (String) evaluation.getEvaluationPersonne().getSecuriteSociale();

        ((VueListeDiagnostique) vue).getjTextFieldNom().setText(nom);
        ((VueListeDiagnostique) vue).getjTextFieldPrenom().setText(prenom);
        ((VueListeDiagnostique) vue).getjTextFieldSexe().setText(sexe);
        ((VueListeDiagnostique) vue).getjTextFieldDateNaissance().setText(dateNaissance);
        ((VueListeDiagnostique) vue).getjTextFieldCodeSecuriteSociale().setText(codeSecuriteSociale);

    }

    public void remplirJTextFieldEvaluation(Evaluation evaluation) {
        String taille = Double.toString(evaluation.getEvaluationTourDeTaille());
        Boolean sportif = evaluation.getEvaluationActiviteSportive();
        Boolean traitement = evaluation.getEvaluationTraitement();
        Boolean familleDiabete = evaluation.getEvaluationTraitement();
        String masse = Double.toString(evaluation.getEvaluationMasse());
        Integer alimentation = evaluation.getEvaluationConsoLegume();
        Boolean atcd = evaluation.getEvaluationATCD();
        String age = Integer.toString(evaluation.getEvaluationPersonne().getAge());

        ((VueListeDiagnostique) vue).getjTextFieldTaille().setText(taille);
        String evaluationActiviteSportive = "";
        if (!sportif) {
            evaluationActiviteSportive = "Non";
        } else {
            evaluationActiviteSportive = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldActiviteSportive().setText(evaluationActiviteSportive);
        String evaluationTraitement = "";
        if (!traitement) {
            evaluationTraitement = "Non";
        } else {
            evaluationTraitement = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldTraitement().setText(evaluationTraitement);
        String evaluationFamilleDiabete = "";
        if (!familleDiabete) {
            evaluationFamilleDiabete = "Non";
        } else {
            evaluationFamilleDiabete = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldFamillePositive().setText(evaluationFamilleDiabete);
        ((VueListeDiagnostique) vue).getjTextFieldMasse().setText(masse);
        String alimentationEval = "";
        if (alimentation == 2) {
            alimentationEval = "Non";
        } else {
            if (alimentation == 1) {
                alimentationEval = "Pas tout les jours";
            } else {
                if (alimentation == 0) {
                    alimentationEval = "Oui";
                }
            }
        }
        ((VueListeDiagnostique) vue).getjTextFieldConsoLegume().setText(alimentationEval);
        String evaluationTauxGlycemie = "";
        if (!atcd) {
            evaluationTauxGlycemie = "Non";
        } else {
            evaluationTauxGlycemie = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldATCDGlycemie().setText(evaluationTauxGlycemie);
        ((VueListeDiagnostique) vue).getjTextFieldAge().setText(age);
    }

    public void remplirJTextFieldEvaluationScore(Evaluation evaluation) {
        EvaluationScore evaluationScore = new EvaluationScore(evaluation);
        Integer tailleScore = evaluationScore.getEvaluationTourDeTaille();
        Integer sportifScore = evaluationScore.getEvaluationActiviteSportive();
        Integer traitementScore = evaluationScore.getEvaluationTraitement();
        Integer familleDiabeteScore = evaluationScore.getEvaluationFamillePositive();
        Integer massScore = evaluationScore.getEvaluationMasse();
        Integer alimentationScore = evaluationScore.getEvaluationConsoLegume();
        Integer atcdScore = evaluationScore.getEvaluationATCDGlycemie();
        Integer ageScore = evaluationScore.getEvaluationAge();
        Integer scoreTotal = tailleScore + sportifScore + traitementScore + familleDiabeteScore + massScore + alimentationScore + atcdScore + ageScore;
        Integer risque = 1;
        if (scoreTotal < 7) {
            risque = 1;
        } else {
            if (scoreTotal > 7 && scoreTotal <= 11) {
                risque = 4;
            } else {
                if (scoreTotal > 11 && scoreTotal <= 14) {
                    risque = 17;
                } else {
                    if (scoreTotal > 14 && scoreTotal <= 20) {
                        risque = 33;
                    } else {
                        if (scoreTotal > 20) {
                            risque = 50;
                        }
                    }
                }
            }
        }

        ((VueListeDiagnostique) vue).getjTextFieldTailleScore().setText(Integer.toString(tailleScore));
        ((VueListeDiagnostique) vue).getjTextFieldActiviteSportiveScore().setText(Integer.toString(sportifScore));
        ((VueListeDiagnostique) vue).getjTextFieldTraitementScore().setText(Integer.toString(traitementScore));
        ((VueListeDiagnostique) vue).getjTextFieldFamillePositiveScore().setText(Integer.toString(familleDiabeteScore));
        ((VueListeDiagnostique) vue).getjTextFieldMassScore().setText(Integer.toString(massScore));
        ((VueListeDiagnostique) vue).getjTextFieldConsoLegumeScore().setText(Integer.toString(alimentationScore));
        ((VueListeDiagnostique) vue).getjTextFieldATCDGlycemieScore().setText(Integer.toString(atcdScore));
        ((VueListeDiagnostique) vue).getjTextFieldAgeScore().setText(Integer.toString(ageScore));
        ((VueListeDiagnostique) vue).getjTextFieldScoreTotal().setText(Integer.toString(scoreTotal));
        ((VueListeDiagnostique) vue).getjTextFieldRisque().setText(Integer.toString(risque) + "%");
    }

    public void quitterListeDiagnostique() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().action(EnumAction.QUITTER_LISTEDIAGNOSTIQUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(((VueListeDiagnostique) vue).getjButtonRetour())) {
            try {
                quitterListeDiagnostique();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource().equals(((VueListeDiagnostique) vue).getjButtonSupprimer())){
            try {
                supprimerDiagnostique();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            quitterListeDiagnostique();
        } catch (SQLException ex) {
            Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(((VueListeDiagnostique) vue).getjTableId())) {
            try {
                afficherInformationEvaluation();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
