package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import vue.VueEvaluation;
/**
 *
 * @author Elymne
 */
public class ControleurEvaluation extends ControleurGenerique implements ActionListener, WindowListener{
    
    public ControleurEvaluation(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueEvaluation();
        vue.addWindowListener(this);
        getVue().getjButtonAnnuler().addActionListener(this);
        getVue().getjButtonValider().addActionListener(this);
    }
    
    @Override
    public VueEvaluation getVue() {
        return (VueEvaluation) vue;
    }
    
    public void quitterVueEvaluation() {
        int a = JOptionPane.showConfirmDialog(getVue(), "Annulation de l'evaluation\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            this.getControleurPrincipal().ActiverControleur(EnumAction.QUITTER_EVALUATION);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjButtonAnnuler())) {
            quitterVueEvaluation();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        quitterVueEvaluation();
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
