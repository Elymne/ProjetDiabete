package controleur;

import static controleur.EnumAction.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleurPrincipal {
    
    private ControleurMenu controleurMenu = null;
    private ControleurEvaluation controleurEvaluation = null;
    private ControleurAjoutPatient controleurAjoutPatient = null;
    private ControleurListeDiagnostique controleurListeDiagnostique = null;
    
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
                System.out.println("Non");
                break;
            case QUITTER_STATISTIQUE:
                System.out.println("Non");
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
