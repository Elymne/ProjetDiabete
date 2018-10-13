/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Evaluation;
import vue.VueStatistique;

/**
 *
 * @author Elymne
 */
public class ControleurStatistique extends ControleurGenerique implements ActionListener, WindowListener{
    
    private ArrayList<Evaluation> lesEvaluations;
    private Evaluation evaluation;
    
    public ControleurStatistique(ControleurPrincipal controleurPrincipal) {
        super(controleurPrincipal);
        vue = new VueStatistique();
        vue.addWindowListener(this);
        ((VueStatistique) vue).getjButtonRetour().addActionListener(this);
    }
    
    @Override
    public VueStatistique getVue() {
        return (VueStatistique) vue;
    }
    
    public void quitterStatistique() throws SQLException, ClassNotFoundException{
        this.getControleurPrincipal().action(EnumAction.QUITTER_STATISTIQUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(((VueStatistique) vue).getjButtonRetour())){
            try {
                quitterStatistique();
            } catch (SQLException ex) {
                Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            quitterStatistique();
        } catch (SQLException ex) {
            Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleurStatistique.class.getName()).log(Level.SEVERE, null, ex);
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
