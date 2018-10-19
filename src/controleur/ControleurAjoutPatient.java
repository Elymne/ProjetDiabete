package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.PersonneDao;
import vue.VueAjoutPatient;

/**
 *
 * @author Djurdjevic Sacha
 * @author Allain Mathys
 */
public class ControleurAjoutPatient extends ControleurGenerique implements ActionListener, WindowListener, KeyListener {

    /**
     *
     * @param controleurPrincipal
     */
    public ControleurAjoutPatient(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueAjoutPatient();
        ((VueAjoutPatient) vue).getjTextFieldNom().addKeyListener(this);
        ((VueAjoutPatient) vue).getjTextFieldPrenom().addKeyListener(this);
        ((VueAjoutPatient) vue).getjTextFieldDateAnnee().addKeyListener(this);
        ((VueAjoutPatient) vue).getjTextFieldDateMois().addKeyListener(this);
        ((VueAjoutPatient) vue).getjTextFieldDateJour().addKeyListener(this);
        ((VueAjoutPatient) vue).getjTextFieldSecuriteSociale().addKeyListener(this);
        ((VueAjoutPatient) vue).getjComboBoxSexe().addKeyListener(this);
        getVue().getjButtonAnnuler().addActionListener(this);
        getVue().getjButtonValider().addActionListener(this);
        vue.setFocusable(true);
        vue.addWindowListener(this);
        vue.addKeyListener(this);
    }

    /**
     *
     * @return
     */
    @Override
    public VueAjoutPatient getVue() {
        return (VueAjoutPatient) vue;
    }

    /**
     *
     * Permet d'ajouter à la base de données une nouvelle personne suivant les données écrite dans les champs de texte.
     * Pour que cette méthode s'effectue correctement, il faut que la méthode verifier() retourne true sinon la méthode en fait rien.
     * Cette méthode fait quitter la vue actuelle pour revenir au menu
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void ajoutPatient() throws ClassNotFoundException, SQLException {
        if (verifier()) {
            if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String nom = ((VueAjoutPatient) vue).getjTextFieldNom().getText();
                String prenom = ((VueAjoutPatient) vue).getjTextFieldPrenom().getText();
                String sexe = ((VueAjoutPatient) vue).getjComboBoxSexe().getSelectedItem().toString();
                String dateNaissance
                        = ((VueAjoutPatient) vue).getjTextFieldDateAnnee().getText() + "-"
                        + ((VueAjoutPatient) vue).getjTextFieldDateMois().getText() + "-"
                        + ((VueAjoutPatient) vue).getjTextFieldDateJour().getText();
                String securiteSociale = ((VueAjoutPatient) vue).getjTextFieldSecuriteSociale().getText();

                String ddYear = ((VueAjoutPatient) vue).getjTextFieldDateAnnee().getText();
                LocalDateTime now = LocalDateTime.now();
                String ccYear = Integer.toString(now.getYear());

                int age;
                age = Integer.parseInt(ccYear) - Integer.parseInt(ddYear);

                PersonneDao.insert(nom, prenom, sexe, dateNaissance, securiteSociale, age);
                vue.setFocusable(false);
                this.getControleurPrincipal().action(EnumAction.QUITTER_AJOUTPATIENT);
            }
        }
    }

    /**
     *
     * Méthode permettant de valider le texte inscrit dans les champs de texte.
     * Si l'un de ces champs est incorrect, la méthode renvoie false, sinon true.
     * 
     * @return Boolean
     */
    public boolean verifier() {

        String nom = ((VueAjoutPatient) vue).getjTextFieldNom().getText();
        String prenom = ((VueAjoutPatient) vue).getjTextFieldPrenom().getText();
        String day = ((VueAjoutPatient) vue).getjTextFieldDateJour().getText();
        String month = ((VueAjoutPatient) vue).getjTextFieldDateMois().getText();
        String year = ((VueAjoutPatient) vue).getjTextFieldDateAnnee().getText();
        String codeSecu = ((VueAjoutPatient) vue).getjTextFieldSecuriteSociale().getText();

        boolean verif = true;
        boolean verifField[] = new boolean[6];

        if (!controleur.StringMatcher.isWord(nom)) {
            verifField[0] = false;
            ((VueAjoutPatient) vue).getjLabelErrorNom().setText("Nom incorrecte");
        } else {
            ((VueAjoutPatient) vue).getjLabelErrorNom().setText("");
            verifField[0] = true;
        }
        if (!controleur.StringMatcher.isWord(prenom)) {
            verifField[1] = false;
            ((VueAjoutPatient) vue).getjLabelErrorPrenom().setText("Prenom incorrecte");
        } else {
            ((VueAjoutPatient) vue).getjLabelErrorPrenom().setText("");
            verifField[1] = true;
        }
        if (!controleur.StringMatcher.isDay(day)) {
            verifField[2] = false;
            ((VueAjoutPatient) vue).getjLabelErrorDateNaissance().setText("Date de naissance incorrecte,vérifier format : 00-00-0000 ou véracité de la date");
        } else {
            ((VueAjoutPatient) vue).getjLabelErrorDateNaissance().setText("");
            verifField[2] = true;
        }
        if (!controleur.StringMatcher.isMonth(month)) {
            verifField[3] = false;
            ((VueAjoutPatient) vue).getjLabelErrorDateNaissance().setText("Date de naissance incorrecte,vérifier format : 00-00-0000 ou véracité de la date");
        } else {
            ((VueAjoutPatient) vue).getjLabelErrorDateNaissance().setText("");
            verifField[3] = true;
        }
        if (!controleur.StringMatcher.isYear(year)) {
            verifField[4] = false;
            ((VueAjoutPatient) vue).getjLabelErrorDateNaissance().setText("Date de naissance incorrecte,vérifier format : 00-00-0000 ou véracité de la date");
        } else {
            ((VueAjoutPatient) vue).getjLabelErrorDateNaissance().setText("");
            verifField[4] = true;
        }
        if (!controleur.StringMatcher.isCodeSecu(codeSecu)) {
            verifField[5] = false;
            ((VueAjoutPatient) vue).getjLabelErrorCodeSecuriteSociale().setText("Code de sécurité sociale invalide");
        } else {
            ((VueAjoutPatient) vue).getjLabelErrorCodeSecuriteSociale().setText("");
            verifField[5] = true;
        }

        for (int i = 0; i < verifField.length; i++) {
            System.err.println("Contenu de la donnée : " + i + " : " + verifField[i]);
            if (verifField[i] == false) {
                verif = false;
            }
        }
        return verif;

    }

    /**
     *
     * Permet de quitter la vue actuelle pour revenir au menu
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void quitterVueAjoutPatient() throws SQLException, ClassNotFoundException {
        int a = JOptionPane.showConfirmDialog(getVue(), "Annulation de l'ajout d'un patient\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            vue.setFocusable(false);
            this.getControleurPrincipal().action(EnumAction.QUITTER_AJOUTPATIENT);
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

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                ajoutPatient();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControleurAjoutPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    public void windowOpened(WindowEvent e) {

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
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
}
