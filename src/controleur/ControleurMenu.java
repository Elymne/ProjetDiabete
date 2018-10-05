package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vue.VueMenu;

/**
 *
 * @author Elymne
 */
public class ControleurMenu extends ControleurGenerique implements ActionListener, WindowListener {

    public ControleurMenu(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueMenu();
        vue.addWindowListener(this);
        getVue().getjButtonEvaluation().addActionListener(this);
        getVue().getjButtonListeDiagnostique().addActionListener(this);
        getVue().getjButtonStatistique().addActionListener(this);
        getVue().getjButtonAjoutPatient().addActionListener(this);
    }

    @Override
    public VueMenu getVue() {
        return (VueMenu) vue;
    }

    public void quitterApplication() throws SQLException, ClassNotFoundException {
        int a = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            this.getControleurPrincipal().ActiverControleur(EnumAction.QUITTER_APPLICATION);
        }
    }

    public void accesEvaluation() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().ActiverControleur(EnumAction.EVALUATION);
    }

    public void accesListeDiagnostique() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().ActiverControleur(EnumAction.LISTEDIAGNOSTIQUE);
    }

    public void accesStatistique() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().ActiverControleur(EnumAction.STATISTIQUE);
    }

    public void accesAjoutPatient() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().ActiverControleur(EnumAction.AJOUTPATIENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjButtonEvaluation())) {
            try {
                accesEvaluation();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(getVue().getjButtonListeDiagnostique())) {
            try {
                accesListeDiagnostique();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(getVue().getjButtonStatistique())) {
            try {
                accesStatistique();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(getVue().getjButtonAjoutPatient())) {
            try {
                accesAjoutPatient();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            quitterApplication();
        } catch (SQLException ex) {
            Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurMenu.class.getName()).log(Level.SEVERE, null, ex);
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
