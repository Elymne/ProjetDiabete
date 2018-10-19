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
 * @author Djurdjevic Sacha
 * @author Allain Mathys
 */
public class ControleurMenu extends ControleurGenerique implements ActionListener, WindowListener {

    /**
     *
     * @param controleurPrincipal
     */
    public ControleurMenu(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueMenu();
        vue.addWindowListener(this);
        getVue().getjButtonEvaluation().addActionListener(this);
        getVue().getjButtonListeDiagnostique().addActionListener(this);
        getVue().getjButtonStatistique().addActionListener(this);
        getVue().getjButtonAjoutPatient().addActionListener(this);
    }

    /**
     *
     * @return
     */
    @Override
    public VueMenu getVue() {
        return (VueMenu) vue;
    }

    /**
     *
     * Permet de quitter l'application.
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void quitterApplication() throws SQLException, ClassNotFoundException {
        int a = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            this.getControleurPrincipal().action(EnumAction.QUITTER_APPLICATION);
        }
    }

    /**
     *
     * Permet d'accéder à la vue des évaluations
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void accesEvaluation() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().action(EnumAction.EVALUATION);
    }

    /**
     *
     * Permet d'accéder à la vue des diagnostiques
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void accesListeDiagnostique() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().action(EnumAction.LISTEDIAGNOSTIQUE);
    }

    /**
     *
     * Permet d'accéder à la vue des Statistiques
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void accesStatistique() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().action(EnumAction.STATISTIQUE);
    }

    /**
     *
     * Permet d'accéder à la vue des Patients
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void accesAjoutPatient() throws SQLException, ClassNotFoundException {
        this.getControleurPrincipal().action(EnumAction.AJOUTPATIENT);
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
        if (e.getSource().equals(getVue().getjButtonAjoutPatient())) {
            try {
                accesAjoutPatient();

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
