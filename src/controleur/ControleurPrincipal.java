package controleur;

import static controleur.EnumAction.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Elymne
 */
public class ControleurPrincipal {
    
    private ControleurMenu controleurMenu = null;
    private ControleurEvaluation controleurEvaluation = null;
    
    public void ActiverControleur(){
        if(controleurMenu==null){
            controleurMenu=new ControleurMenu(this);
        }
        controleurMenu.getVue().setVisible(true);
        controleurMenu.getVue().setEnabled(true);
    }
    
    public void ActiverControleur(EnumAction action){
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
            case LISTEDIAGNOSTIQUE:
                System.out.println("Non");
                break;
            case QUITTER_LISTEDIAGNOSTIQUE:
                System.out.println("Non");
                break;
            case STATISTIQUE:
                System.out.println("Non");
                break;
            case QUITTER_STATISTIQUE:
                System.out.println("Non");
                break;
        }
    }
    
    private void accesVueEvaluation() {
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
