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
import modele.dao.EvaluationDao;
import modele.dao.PersonneDao;
import modele.metier.Personne;
import vue.VueEvaluation;

public class ControleurEvaluation extends ControleurGenerique implements ActionListener, WindowListener{
    
    Personne personne;
    
    public ControleurEvaluation(ControleurPrincipal controleurPrincipal) throws SQLException, ClassNotFoundException {
        super(controleurPrincipal);
        vue = new VueEvaluation();
        vue.addWindowListener(this);
        remplirJComboBoxNom();
        getVue().getjComboBoxNomPatient().addActionListener(this);
        getVue().getjComboBoxPrenomPatient().addActionListener(this);
        getVue().getjButtonAnnuler().addActionListener(this);
        getVue().getjButtonValider().addActionListener(this);
    }
    
    @Override
    public VueEvaluation getVue() {
        return (VueEvaluation) vue;
    }
    
    public final void remplirJComboBoxNom() throws SQLException, ClassNotFoundException {
        resetElements();
        ArrayList<Personne> listePersonnes = new ArrayList<>();
        listePersonnes = PersonneDao.selectAll();
        for (Personne personne : listePersonnes) {
            getVue().getjComboBoxNomPatient().addItem(personne.getNom());
        }
    }

    public void remplirJComboBoxPrenom() throws SQLException, ClassNotFoundException {
        ArrayList<Personne> listePersonnes = new ArrayList<>();
        String nom = (((VueEvaluation) vue).getjComboBoxNomPatient().getSelectedItem().toString());
        listePersonnes = PersonneDao.selectAllByNom(nom);
        for (Personne personne : listePersonnes) {
            getVue().getjComboBoxPrenomPatient().addItem(personne.getPrenom());
        }
    }
    
    public void resetElements() {
        getVue().getjComboBoxPrenomPatient().removeAllItems();
    }
    
    public void ajouterEvaluation() throws ClassNotFoundException, SQLException{
        double tourTaille =  Double.parseDouble(((VueEvaluation) vue).getjTextFieldTourTaille().getText());
        boolean ActiviteSportive = false;
        if((((VueEvaluation) vue).getjCheckBoxActiviteSportive().isSelected())){
            ActiviteSportive = true;
        }
        boolean hta = false;
        if((((VueEvaluation) vue).getjCheckBoxHTA().isSelected())){
            hta = true;
        }
        boolean familleDiabete = false;
        if((((VueEvaluation) vue).getjCheckBoxFamilleDiabete().isSelected())){
            familleDiabete = true;
        }
        double imc =  Double.parseDouble(((VueEvaluation) vue).getjTextFieldIMC().getText());
        int alimentationEval = -1;
        String alimentation = (((VueEvaluation) vue).getjComboBoxAlimentation().getSelectedItem().toString());
        if(alimentation == "Non"){ 
            alimentationEval = 2 ;
        }else{
            if(alimentation =="Pas tous les jours"){
                alimentationEval = 1;
            }else{
                if(alimentation == "Tous les jours"){
                    alimentationEval = 0;
                }
            }
        }
        boolean tauxGlycemie = false;
        if((((VueEvaluation) vue).getjCheckBoxTauxGlycémie().isSelected())){
            tauxGlycemie = true;
        }
        String nom = getVue().getjComboBoxNomPatient().getSelectedItem().toString();
        String prenom = getVue().getjComboBoxPrenomPatient().getSelectedItem().toString();
        personne = PersonneDao.selectOneByNomAndPrenom(nom, prenom);
        EvaluationDao.insert(tourTaille, ActiviteSportive, hta, familleDiabete, imc, alimentationEval, tauxGlycemie, personne);
        this.getControleurPrincipal().ActiverControleur(EnumAction.QUITTER_EVALUATION);
    }
    
    public void quitterVueEvaluation() throws SQLException, ClassNotFoundException{
        int a = JOptionPane.showConfirmDialog(getVue(), "Annulation de l'evaluation\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            this.getControleurPrincipal().ActiverControleur(EnumAction.QUITTER_EVALUATION);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjButtonAnnuler())) {
            try {
                quitterVueEvaluation();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(getVue().getjButtonValider())) {
            try {
                int a = JOptionPane.showConfirmDialog(getVue(), "Validation de l'evaluation\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (a == JOptionPane.YES_OPTION) {
                   ajouterEvaluation(); 
                } 
            } catch (SQLException ex) {
                Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(getVue().getjComboBoxNomPatient())) {
            
            try {
                resetElements();
                remplirJComboBoxPrenom();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            quitterVueEvaluation();
        } catch (SQLException ex) {
            Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurEvaluation.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
