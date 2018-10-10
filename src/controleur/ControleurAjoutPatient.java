package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.PersonneDao;
import vue.VueAjoutPatient;

public class ControleurAjoutPatient extends ControleurGenerique implements ActionListener, WindowListener {

    public ControleurAjoutPatient(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueAjoutPatient();
        vue.addWindowListener(this);
        getVue().getjButtonAnnuler().addActionListener(this);
        getVue().getjButtonValider().addActionListener(this);
    }

    @Override
    public VueAjoutPatient getVue() {
        return (VueAjoutPatient) vue;
    }

    public void ajoutPatient() throws ClassNotFoundException, SQLException {
        String nom = (((VueAjoutPatient) vue).getjTextFieldNom().getText());
        String prenom = (((VueAjoutPatient) vue).getjTextFieldPrenom().getText());
        String sexe = (((VueAjoutPatient) vue).getjComboBoxSexe().getSelectedItem().toString());
        String dateNaissance
                = (((VueAjoutPatient) vue).getjTextFieldDateAnnee().getText()) + "-"
                + (((VueAjoutPatient) vue).getjTextFieldDateMois().getText()) + "-"
                + (((VueAjoutPatient) vue).getjTextFieldDateJour().getText());
        String securiteSociale = (((VueAjoutPatient) vue).getjTextFieldSecuriteSociale().getText());
        
        
        
        String ddYear = (((VueAjoutPatient) vue).getjTextFieldDateAnnee().getText());
	LocalDateTime now = LocalDateTime.now();
        String ccYear = Integer.toString(now.getYear());
        
        int age;
        age = Integer.parseInt(ccYear)-Integer.parseInt(ddYear);
        

        PersonneDao.insert(nom, prenom, sexe, dateNaissance, securiteSociale, age);
        this.getControleurPrincipal().ActiverControleur(EnumAction.QUITTER_AJOUTPATIENT);
    }

    public void quitterVueAjoutPatient() throws SQLException, ClassNotFoundException {
        int a = JOptionPane.showConfirmDialog(getVue(), "Annulation de l'ajout d'un patient\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            this.getControleurPrincipal().ActiverControleur(EnumAction.QUITTER_AJOUTPATIENT);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getVue().getjButtonAnnuler())) {
            try {
                quitterVueAjoutPatient();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (e.getSource().equals(getVue().getjButtonValider())) {
                if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        ajoutPatient();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            quitterVueAjoutPatient();
        } catch (SQLException ex) {
            Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
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
