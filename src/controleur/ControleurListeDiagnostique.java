package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import modele.dao.EvaluationDao;
import modele.metier.Evaluation;
import vue.VueListeDiagnostique;

public class ControleurListeDiagnostique extends ControleurGenerique implements ActionListener, WindowListener, TableModelListener{
    
    private ArrayList<Evaluation> lesEvaluations;
    private Evaluation evaluation;
    
    public ControleurListeDiagnostique(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueListeDiagnostique();
        afficherListeEvaluation();
        ((VueListeDiagnostique) vue).getjButtonRetour().addActionListener(this);
    }
    
    public void afficherListeEvaluation(){
        ((VueListeDiagnostique) vue).getModeleTableListeDiagnostiques().setRowCount(0);
        String[] titresColonnes = {"ID évaluation", "Nom", "Prenom"};
        ((VueListeDiagnostique) vue).getModeleTableListeDiagnostiques().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[3];
            lesEvaluations = EvaluationDao.selectAll();
            for (Evaluation evaluation : lesEvaluations) {
                ligneDonnees[0] = Integer.toString(evaluation.getId());
                ligneDonnees[1] = evaluation.getEvaluationPersonne().getNom();
                ligneDonnees[2] = evaluation.getEvaluationPersonne().getPrenom();
                ((VueListeDiagnostique) vue).getModeleTableListeDiagnostiques().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            String msg = "Erreur dans la methode afficherListeEvaluation" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, "", msg, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void afficherInformationEvaluation() throws ClassNotFoundException, SQLException {
        int ligne = ((VueListeDiagnostique) vue).getTableListeDiagnostiques().getSelectedRow();
        int colonne = ((VueListeDiagnostique) vue).getTableListeDiagnostiques().getSelectedColumn();
        if (ligne != -1 && colonne != -1) {
            int id = (int) ((VueListeDiagnostique) vue).getModeleTableListeDiagnostiques().getValueAt(ligne, colonne);
            evaluation = EvaluationDao.selectOneById(id);
            remplirJTextField(evaluation);
        }
    }
    
    public void remplirJTextField(Evaluation evaluation){
        ((VueListeDiagnostique) vue).getjTextFieldNom().setText((String) evaluation.getEvaluationPersonne().getNom());
        ((VueListeDiagnostique) vue).getjTextFieldPrenom().setText((String) evaluation.getEvaluationPersonne().getPrenom());
        ((VueListeDiagnostique) vue).getjTextFieldSexe().setText((String) evaluation.getEvaluationPersonne().getSexe());
        ((VueListeDiagnostique) vue).getjTextFieldDateNaissance().setText((String) evaluation.getEvaluationPersonne().getDateNaissance());
        ((VueListeDiagnostique) vue).getjTextFieldCodeSecuriteSociale().setText((String) evaluation.getEvaluationPersonne().getSecuriteSociale());
        ((VueListeDiagnostique) vue).getjTextFieldTaille().setText(Double.toString(evaluation.getEvaluationTourDeTaille()));
        String evaluationActiviteSportive = "";
        if(evaluation.getEvaluationActiviteSportive() == false){
            evaluationActiviteSportive = "Non";
        }else{
            evaluationActiviteSportive = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldTaille().setText(evaluationActiviteSportive);
        String evaluationTraitement = "";
        if(evaluation.getEvaluationTraitement() == false){
            evaluationActiviteSportive = "Non";
        }else{
            evaluationActiviteSportive = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldTraitement().setText(evaluationTraitement);
        String evaluationFamilleDiabete = "";
        if(evaluation.getEvaluationTraitement() == false){
            evaluationFamilleDiabete = "Non";
        }else{
            evaluationFamilleDiabete = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldFamillePositive().setText(evaluationFamilleDiabete);
        ((VueListeDiagnostique) vue).getjTextFieldMasse().setText(Double.toString(evaluation.getEvaluationMasse()));
        int alimentation = evaluation.getEvaluationConsoLegume();
        String alimentationEval = "";
        if(alimentation == 2){ 
            alimentationEval = "Non";
        }else{
            if(alimentation == 1){
                alimentationEval = "Pas tout les jours";
            }else{
                if(alimentation == 0){
                    alimentationEval = "Oui";
                }
            }
        }
        ((VueListeDiagnostique) vue).getjTextFieldConsoLegume().setText(alimentationEval);
        String evaluationTauxGlycemie = "";
        if(evaluation.getEvaluationATCD()== false){
            evaluationTauxGlycemie = "Non";
        }else{
            evaluationTauxGlycemie = "Oui";
        }
        ((VueListeDiagnostique) vue).getjTextFieldATCDGlycemie().setText(evaluationTauxGlycemie);
    }
    
    public void quitterListeEvaluation() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().ActiverControleur(EnumAction.QUITTER_LISTEDIAGNOSTIQUE);
    }
    
    @Override
    public VueListeDiagnostique getVue() {
        return (VueListeDiagnostique) vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(((VueListeDiagnostique) vue).getjButtonRetour())){
            try {
                quitterListeEvaluation();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurListeDiagnostique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
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
            quitterListeEvaluation();
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
    public void tableChanged(TableModelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
