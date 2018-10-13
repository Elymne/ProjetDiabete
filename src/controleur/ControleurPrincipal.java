package controleur;

import static controleur.EnumAction.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Djurdjevic Sacha
 */
public class ControleurPrincipal {
    
    private ControleurMenu controleurMenu = null;
    private ControleurEvaluation controleurEvaluation = null;
    private ControleurAjoutPatient controleurAjoutPatient = null;
    private ControleurListeDiagnostique controleurListeDiagnostique = null;
    private ControleurStatistique controleurStatistique = null;
    
    public void action(){
        if(controleurMenu==null){
            controleurMenu=new ControleurMenu(this);
        }
        controleurMenu.getVue().setVisible(true);
        controleurMenu.getVue().setEnabled(true);
    }
    
    public void action(EnumAction action) throws SQLException, ClassNotFoundException{
        switch(action){
            case QUITTER_APPLICATION:
                menuQuitter();
                break;
            case EVALUATION:
                accesVueEvaluation();
                break;
            case QUITTER_EVALUATION:
                quitterVueEvaluation();
                break;
            case AJOUTPATIENT:
                accesVueAjoutPatient();
                break;
            case QUITTER_AJOUTPATIENT:
                quitterVueAjoutPatient();
                break;
            case LISTEDIAGNOSTIQUE:
                accesVueListeDiagnostique();
                break;
            case QUITTER_LISTEDIAGNOSTIQUE:
                quitterVueListeDiagnostique();
                break;
            case STATISTIQUE:
                accesVueStatistique();
                break;
            case QUITTER_STATISTIQUE:
                quitterVueStatistique();
                break;
        }
    }
    
    private void accesVueEvaluation() throws SQLException, ClassNotFoundException {
        if (controleurEvaluation == null) {
            controleurEvaluation = new ControleurEvaluation(this);
        }
        controleurMenu.getVue().setEnabled(false);
        controleurEvaluation.getVue().setVisible(true);
    }
    
    private void quitterVueEvaluation(){
        if (controleurMenu == null) {
            controleurMenu = new ControleurMenu(this);
        }
        controleurMenu.getVue().setEnabled(true);
        controleurEvaluation.getVue().setVisible(false);
        controleurEvaluation = null;
    }
    
    private void accesVueAjoutPatient() {
        if (controleurAjoutPatient == null) {
            controleurAjoutPatient = new ControleurAjoutPatient(this);
        }
        controleurMenu.getVue().setEnabled(false);
        controleurAjoutPatient.getVue().setVisible(true);
    }
    
    private void quitterVueAjoutPatient(){
        if (controleurMenu == null) {
            controleurMenu = new ControleurMenu(this);
        }
        controleurMenu.getVue().setEnabled(true);
        controleurAjoutPatient.getVue().setVisible(false);
        controleurAjoutPatient = null;
    }
    
    private void accesVueListeDiagnostique() throws SQLException, ClassNotFoundException {
        if (controleurListeDiagnostique == null) {
            controleurListeDiagnostique = new ControleurListeDiagnostique(this);
        }
        controleurMenu.getVue().setEnabled(false);
        controleurListeDiagnostique.getVue().setVisible(true);
    }
    
    private void quitterVueListeDiagnostique(){
        if (controleurMenu == null) {
            controleurMenu = new ControleurMenu(this);
        }
        controleurMenu.getVue().setEnabled(true);
        controleurListeDiagnostique.getVue().setVisible(false);
        controleurListeDiagnostique = null;
    }
    
    private void accesVueStatistique() throws SQLException, ClassNotFoundException {
        if (controleurStatistique == null) {
            controleurStatistique = new ControleurStatistique(this);
        }
        controleurMenu.getVue().setEnabled(false);
        controleurStatistique.getVue().setVisible(true);
    }
    
    private void quitterVueStatistique(){
        if (controleurMenu == null) {
            controleurMenu = new ControleurMenu(this);
        }
        controleurMenu.getVue().setEnabled(true);
        controleurStatistique.getVue().setVisible(false);
        controleurStatistique = null;
    }
    
    private void menuQuitter() {
        try {
            System.out.println("Deconnexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Fermeture Application - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }
     
}
