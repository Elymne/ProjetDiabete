package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class ControleurEvaluation extends ControleurGenerique implements ActionListener, WindowListener, KeyListener {

    Personne personne;

    public ControleurEvaluation(ControleurPrincipal controleurPrincipal) throws SQLException, ClassNotFoundException {
        super(controleurPrincipal);
        vue = new VueEvaluation();
        vue.addWindowListener(this);
        vue.addKeyListener(this);
        vue.setFocusable(true);
        remplirJComboBoxNom();
        getVue().getjComboBoxNomPatient().addActionListener(this);
        getVue().getjComboBoxPrenomPatient().addActionListener(this);
        getVue().getjButtonAnnuler().addActionListener(this);
        getVue().getjButtonValider().addActionListener(this);
        ((VueEvaluation) vue).getjCheckBoxActiviteSportive().addKeyListener(this);
        ((VueEvaluation) vue).getjCheckBoxFamilleDiabete().addKeyListener(this);
        ((VueEvaluation) vue).getjCheckBoxHTA().addKeyListener(this);
        ((VueEvaluation) vue).getjCheckBoxTauxGlycémie().addKeyListener(this);
        ((VueEvaluation) vue).getjComboBoxAlimentation().addKeyListener(this);
        ((VueEvaluation) vue).getjTextFieldIMC().addKeyListener(this);
        ((VueEvaluation) vue).getjTextFieldTourTaille().addKeyListener(this);
    }

    @Override
    public VueEvaluation getVue() {
        return (VueEvaluation) vue;
    }

    public void remplirJComboBoxNom() throws SQLException, ClassNotFoundException {
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

    public void ajouterEvaluation() throws ClassNotFoundException, SQLException {
        if (verifier()) {
            if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                double tourTaille = Double.parseDouble(((VueEvaluation) vue).getjTextFieldTourTaille().getText());
                boolean ActiviteSportive = false;
                if ((((VueEvaluation) vue).getjCheckBoxActiviteSportive().isSelected())) {
                    ActiviteSportive = true;
                }
                boolean hta = false;
                if ((((VueEvaluation) vue).getjCheckBoxHTA().isSelected())) {
                    hta = true;
                }
                boolean familleDiabete = false;
                if ((((VueEvaluation) vue).getjCheckBoxFamilleDiabete().isSelected())) {
                    familleDiabete = true;
                }
                double imc = Double.parseDouble(((VueEvaluation) vue).getjTextFieldIMC().getText());
                int alimentationEval = -1;
                String alimentation = (((VueEvaluation) vue).getjComboBoxAlimentation().getSelectedItem().toString());
                if (alimentation == "Non") {
                    alimentationEval = 2;
                } else {
                    if (alimentation == "Pas tous les jours") {
                        alimentationEval = 1;
                    } else {
                        if (alimentation == "Tous les jours") {
                            alimentationEval = 0;
                        }
                    }
                }
                boolean tauxGlycemie = false;
                if ((((VueEvaluation) vue).getjCheckBoxTauxGlycémie().isSelected())) {
                    tauxGlycemie = true;
                }
                String nom = getVue().getjComboBoxNomPatient().getSelectedItem().toString();
                String prenom = getVue().getjComboBoxPrenomPatient().getSelectedItem().toString();
                personne = PersonneDao.selectOneByNomAndPrenom(nom, prenom);
                EvaluationDao.insert(tourTaille, ActiviteSportive, hta, familleDiabete, imc, alimentationEval, tauxGlycemie, personne);
                vue.setFocusable(false);
                this.getControleurPrincipal().action(EnumAction.QUITTER_EVALUATION);
            }
        }
    }

    public boolean verifier() {

        String tdt = ((VueEvaluation) vue).getjTextFieldTourTaille().getText();
        String imc = ((VueEvaluation) vue).getjTextFieldIMC().getText();

        boolean verif = true;
        boolean verifField[] = new boolean[3];

        if (!controleur.StringMatcher.isTourdeTailleValid(tdt)) {
            verifField[0] = false;
            ((VueEvaluation) vue).getjLabelErrorTDC().setText("Tour de taille incorrecte");
        } else {
            ((VueEvaluation) vue).getjLabelErrorTDC().setText("");
            verifField[0] = true;
        }
        if (!controleur.StringMatcher.isIMCValid(imc)) {
            verifField[1] = false;
            ((VueEvaluation) vue).getjLabelErrorIMC().setText("IMC incorrecte");
        } else {
            ((VueEvaluation) vue).getjLabelErrorIMC().setText("");
            verifField[1] = true;
        }
        if (((VueEvaluation) vue).getjComboBoxPrenomPatient().getSelectedItem() == null) {
            verifField[2] = false;
            ((VueEvaluation) vue).getjLabelErrorPrenom().setText("Le prénom n'a pas été selectionné");
        } else {
            ((VueEvaluation) vue).getjLabelErrorTDC().setText("");
            verifField[2] = true;
        }

        for (int i = 0; i < verifField.length; i++) {
            if (verifField[i] == false) {
                verif = false;
            }
        }
        return verif;
    }

    public void quitterVueEvaluation() throws SQLException, ClassNotFoundException {
        int a = JOptionPane.showConfirmDialog(getVue(), "Annulation de l'evaluation\nEtes-vous sûr(e) ?", "DIABETUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            vue.setFocusable(false);
            this.getControleurPrincipal().action(EnumAction.QUITTER_EVALUATION);
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

                ajouterEvaluation();

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
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                ajouterEvaluation();
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

}
