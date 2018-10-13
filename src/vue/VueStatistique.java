package vue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Djurdjevic Sacha
 */
public class VueStatistique extends VueGenerique {

    /**
     * Creates new form VueStatistique
     */
    public VueStatistique() {
        super();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton5 = new javax.swing.JRadioButton();
        jPanelMain = new javax.swing.JPanel();
        jLabelTitreMain = new javax.swing.JLabel();
        jPanelChoixSexe = new javax.swing.JPanel();
        jRadioButtonSexeTous = new javax.swing.JRadioButton();
        jRadioButtonSexeFemme = new javax.swing.JRadioButton();
        jRadioButtonSexeHomme = new javax.swing.JRadioButton();
        jLabelTitreSexe = new javax.swing.JLabel();
        jPanelChoixAge = new javax.swing.JPanel();
        jLabeltitreAge = new javax.swing.JLabel();
        jRadioButtonAgeTous = new javax.swing.JRadioButton();
        jRadioButtonAgeUn = new javax.swing.JRadioButton();
        jRadioButtonDeux = new javax.swing.JRadioButton();
        jRadioButtonTrois = new javax.swing.JRadioButton();
        jRadioButtonQuatre = new javax.swing.JRadioButton();
        jPanelChoixDescription = new javax.swing.JPanel();
        jLabelTitreDescription = new javax.swing.JLabel();
        jCheckBoxTourTaille = new javax.swing.JCheckBox();
        jCheckBoxActiviteSportive = new javax.swing.JCheckBox();
        jCheckBoxTraitement = new javax.swing.JCheckBox();
        jCheckBoxFamilleDiabete = new javax.swing.JCheckBox();
        jCheckBoxIMC = new javax.swing.JCheckBox();
        jCheckBoxLegume = new javax.swing.JCheckBox();
        jCheckBoxGlycemie = new javax.swing.JCheckBox();
        jButtonValider = new javax.swing.JButton();
        jButtonRetour = new javax.swing.JButton();
        jPanelStatistique = new javax.swing.JPanel();
        jPanelStatistiquePrincipale = new javax.swing.JPanel();
        jPanelStatistiqueTourTaille = new javax.swing.JPanel();
        jPanelStatistiqueActiviteSportive = new javax.swing.JPanel();
        jPanelStatistiqueTraitement = new javax.swing.JPanel();
        jPanelFamilleDiabete = new javax.swing.JPanel();
        jPanelStatistiqueIMC = new javax.swing.JPanel();
        jPanelStatistiqueLegume = new javax.swing.JPanel();
        jPanelStatistiqueGlycemie = new javax.swing.JPanel();

        jRadioButton5.setText("jRadioButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabelTitreMain.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTitreMain.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitreMain.setText("Statistique - Choix Descriptifs");

        jPanelChoixSexe.setBackground(new java.awt.Color(255, 255, 255));

        jRadioButtonSexeTous.setText("Tous");

        jRadioButtonSexeFemme.setText("Femme");

        jRadioButtonSexeHomme.setText("Homme");

        jLabelTitreSexe.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTitreSexe.setText("Choix des sexes");

        javax.swing.GroupLayout jPanelChoixSexeLayout = new javax.swing.GroupLayout(jPanelChoixSexe);
        jPanelChoixSexe.setLayout(jPanelChoixSexeLayout);
        jPanelChoixSexeLayout.setHorizontalGroup(
            jPanelChoixSexeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChoixSexeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChoixSexeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonSexeTous)
                    .addComponent(jLabelTitreSexe)
                    .addComponent(jRadioButtonSexeFemme)
                    .addComponent(jRadioButtonSexeHomme))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanelChoixSexeLayout.setVerticalGroup(
            jPanelChoixSexeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChoixSexeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitreSexe)
                .addGap(10, 10, 10)
                .addComponent(jRadioButtonSexeTous)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonSexeFemme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonSexeHomme)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelChoixAge.setBackground(new java.awt.Color(255, 255, 255));

        jLabeltitreAge.setForeground(new java.awt.Color(0, 0, 0));
        jLabeltitreAge.setText("Choix tranche d'age");

        jRadioButtonAgeTous.setText("Tous");
        jRadioButtonAgeTous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAgeTousActionPerformed(evt);
            }
        });

        jRadioButtonAgeUn.setText("Moins de 45 ans");

        jRadioButtonDeux.setText("45 - 54 ans");

        jRadioButtonTrois.setText("55 - 64 ans");

        jRadioButtonQuatre.setText("Plus de 64 ans");

        javax.swing.GroupLayout jPanelChoixAgeLayout = new javax.swing.GroupLayout(jPanelChoixAge);
        jPanelChoixAge.setLayout(jPanelChoixAgeLayout);
        jPanelChoixAgeLayout.setHorizontalGroup(
            jPanelChoixAgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChoixAgeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChoixAgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeltitreAge)
                    .addComponent(jRadioButtonAgeTous)
                    .addComponent(jRadioButtonAgeUn)
                    .addComponent(jRadioButtonDeux)
                    .addComponent(jRadioButtonTrois)
                    .addComponent(jRadioButtonQuatre))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanelChoixAgeLayout.setVerticalGroup(
            jPanelChoixAgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChoixAgeLayout.createSequentialGroup()
                .addComponent(jLabeltitreAge, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAgeTous)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAgeUn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonDeux)
                .addGap(5, 5, 5)
                .addComponent(jRadioButtonTrois)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonQuatre)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanelChoixDescription.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitreDescription.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitreDescription.setText("Choix des descriptions");

        jCheckBoxTourTaille.setText("Tour de taille");

        jCheckBoxActiviteSportive.setText("Activité Sportive");

        jCheckBoxTraitement.setText("Antécédent de traitement anti-HTA");

        jCheckBoxFamilleDiabete.setText("Antécédent familale de diabète");

        jCheckBoxIMC.setText("IMC");

        jCheckBoxLegume.setText("Consomation Legumes Verts");

        jCheckBoxGlycemie.setText("Antécédent glycémie supérieur à la moyenne");

        javax.swing.GroupLayout jPanelChoixDescriptionLayout = new javax.swing.GroupLayout(jPanelChoixDescription);
        jPanelChoixDescription.setLayout(jPanelChoixDescriptionLayout);
        jPanelChoixDescriptionLayout.setHorizontalGroup(
            jPanelChoixDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChoixDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChoixDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxFamilleDiabete)
                    .addComponent(jLabelTitreDescription)
                    .addComponent(jCheckBoxTraitement)
                    .addComponent(jCheckBoxActiviteSportive)
                    .addComponent(jCheckBoxGlycemie)
                    .addComponent(jCheckBoxLegume))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelChoixDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxTourTaille)
                    .addComponent(jCheckBoxIMC))
                .addGap(19, 19, 19))
        );
        jPanelChoixDescriptionLayout.setVerticalGroup(
            jPanelChoixDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChoixDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitreDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelChoixDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxFamilleDiabete)
                    .addComponent(jCheckBoxTourTaille))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelChoixDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxActiviteSportive)
                    .addComponent(jCheckBoxIMC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxTraitement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxGlycemie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxLegume)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButtonValider.setText("Regarder Statistique");

        jButtonRetour.setText("Retour");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelChoixSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelChoixAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelChoixDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabelTitreMain))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonValider)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRetour)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitreMain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelChoixDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelChoixSexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelChoixAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValider)
                    .addComponent(jButtonRetour))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelStatistiquePrincipale.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelStatistiquePrincipaleLayout = new javax.swing.GroupLayout(jPanelStatistiquePrincipale);
        jPanelStatistiquePrincipale.setLayout(jPanelStatistiquePrincipaleLayout);
        jPanelStatistiquePrincipaleLayout.setHorizontalGroup(
            jPanelStatistiquePrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelStatistiquePrincipaleLayout.setVerticalGroup(
            jPanelStatistiquePrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelStatistiqueTourTaille.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelStatistiqueTourTailleLayout = new javax.swing.GroupLayout(jPanelStatistiqueTourTaille);
        jPanelStatistiqueTourTaille.setLayout(jPanelStatistiqueTourTailleLayout);
        jPanelStatistiqueTourTailleLayout.setHorizontalGroup(
            jPanelStatistiqueTourTailleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelStatistiqueTourTailleLayout.setVerticalGroup(
            jPanelStatistiqueTourTailleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanelStatistiqueActiviteSportive.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelStatistiqueActiviteSportiveLayout = new javax.swing.GroupLayout(jPanelStatistiqueActiviteSportive);
        jPanelStatistiqueActiviteSportive.setLayout(jPanelStatistiqueActiviteSportiveLayout);
        jPanelStatistiqueActiviteSportiveLayout.setHorizontalGroup(
            jPanelStatistiqueActiviteSportiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelStatistiqueActiviteSportiveLayout.setVerticalGroup(
            jPanelStatistiqueActiviteSportiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelStatistiqueTraitement.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelStatistiqueTraitementLayout = new javax.swing.GroupLayout(jPanelStatistiqueTraitement);
        jPanelStatistiqueTraitement.setLayout(jPanelStatistiqueTraitementLayout);
        jPanelStatistiqueTraitementLayout.setHorizontalGroup(
            jPanelStatistiqueTraitementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanelStatistiqueTraitementLayout.setVerticalGroup(
            jPanelStatistiqueTraitementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanelFamilleDiabete.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelFamilleDiabeteLayout = new javax.swing.GroupLayout(jPanelFamilleDiabete);
        jPanelFamilleDiabete.setLayout(jPanelFamilleDiabeteLayout);
        jPanelFamilleDiabeteLayout.setHorizontalGroup(
            jPanelFamilleDiabeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelFamilleDiabeteLayout.setVerticalGroup(
            jPanelFamilleDiabeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelStatistiqueIMC.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelStatistiqueIMCLayout = new javax.swing.GroupLayout(jPanelStatistiqueIMC);
        jPanelStatistiqueIMC.setLayout(jPanelStatistiqueIMCLayout);
        jPanelStatistiqueIMCLayout.setHorizontalGroup(
            jPanelStatistiqueIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelStatistiqueIMCLayout.setVerticalGroup(
            jPanelStatistiqueIMCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanelStatistiqueLegume.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStatistiqueLegume.setPreferredSize(new java.awt.Dimension(590, 250));

        javax.swing.GroupLayout jPanelStatistiqueLegumeLayout = new javax.swing.GroupLayout(jPanelStatistiqueLegume);
        jPanelStatistiqueLegume.setLayout(jPanelStatistiqueLegumeLayout);
        jPanelStatistiqueLegumeLayout.setHorizontalGroup(
            jPanelStatistiqueLegumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanelStatistiqueLegumeLayout.setVerticalGroup(
            jPanelStatistiqueLegumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanelStatistiqueGlycemie.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelStatistiqueGlycemieLayout = new javax.swing.GroupLayout(jPanelStatistiqueGlycemie);
        jPanelStatistiqueGlycemie.setLayout(jPanelStatistiqueGlycemieLayout);
        jPanelStatistiqueGlycemieLayout.setHorizontalGroup(
            jPanelStatistiqueGlycemieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanelStatistiqueGlycemieLayout.setVerticalGroup(
            jPanelStatistiqueGlycemieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelStatistiqueLayout = new javax.swing.GroupLayout(jPanelStatistique);
        jPanelStatistique.setLayout(jPanelStatistiqueLayout);
        jPanelStatistiqueLayout.setHorizontalGroup(
            jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatistiqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelStatistiqueTraitement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelStatistiquePrincipale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelStatistiqueTourTaille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelStatistiqueGlycemie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelStatistiqueLegume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelStatistiqueActiviteSportive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFamilleDiabete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelStatistiqueIMC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelStatistiqueLayout.setVerticalGroup(
            jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatistiqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelStatistiqueLegume, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jPanelStatistiquePrincipale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelStatistiqueTourTaille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelStatistiqueActiviteSportive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelStatistiqueTraitement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFamilleDiabete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelStatistiqueIMC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelStatistiqueGlycemie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelStatistique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelStatistique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonAgeTousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAgeTousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAgeTousActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueStatistique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JCheckBox jCheckBoxActiviteSportive;
    private javax.swing.JCheckBox jCheckBoxFamilleDiabete;
    private javax.swing.JCheckBox jCheckBoxGlycemie;
    private javax.swing.JCheckBox jCheckBoxIMC;
    private javax.swing.JCheckBox jCheckBoxLegume;
    private javax.swing.JCheckBox jCheckBoxTourTaille;
    private javax.swing.JCheckBox jCheckBoxTraitement;
    private javax.swing.JLabel jLabelTitreDescription;
    private javax.swing.JLabel jLabelTitreMain;
    private javax.swing.JLabel jLabelTitreSexe;
    private javax.swing.JLabel jLabeltitreAge;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelChoixAge;
    private javax.swing.JPanel jPanelChoixDescription;
    private javax.swing.JPanel jPanelChoixSexe;
    private javax.swing.JPanel jPanelFamilleDiabete;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelStatistique;
    private javax.swing.JPanel jPanelStatistiqueActiviteSportive;
    private javax.swing.JPanel jPanelStatistiqueGlycemie;
    private javax.swing.JPanel jPanelStatistiqueIMC;
    private javax.swing.JPanel jPanelStatistiqueLegume;
    private javax.swing.JPanel jPanelStatistiquePrincipale;
    private javax.swing.JPanel jPanelStatistiqueTourTaille;
    private javax.swing.JPanel jPanelStatistiqueTraitement;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButtonAgeTous;
    private javax.swing.JRadioButton jRadioButtonAgeUn;
    private javax.swing.JRadioButton jRadioButtonDeux;
    private javax.swing.JRadioButton jRadioButtonQuatre;
    private javax.swing.JRadioButton jRadioButtonSexeFemme;
    private javax.swing.JRadioButton jRadioButtonSexeHomme;
    private javax.swing.JRadioButton jRadioButtonSexeTous;
    private javax.swing.JRadioButton jRadioButtonTrois;
    // End of variables declaration//GEN-END:variables

    public JButton getjButtonRetour() {
        return jButtonRetour;
    }

    public JButton getjButtonValider() {
        return jButtonValider;
    }

    public JCheckBox getjCheckBoxActiviteSportive() {
        return jCheckBoxActiviteSportive;
    }

    public JCheckBox getjCheckBoxFamilleDiabete() {
        return jCheckBoxFamilleDiabete;
    }

    public JCheckBox getjCheckBoxGlycemie() {
        return jCheckBoxGlycemie;
    }

    public JCheckBox getjCheckBoxIMC() {
        return jCheckBoxIMC;
    }

    public JCheckBox getjCheckBoxLegume() {
        return jCheckBoxLegume;
    }

    public JCheckBox getjCheckBoxTourTaille() {
        return jCheckBoxTourTaille;
    }

    public JCheckBox getjCheckBoxTraitement() {
        return jCheckBoxTraitement;
    }

    public JPanel getjPanelFamilleDiabete() {
        return jPanelFamilleDiabete;
    }

    public JPanel getjPanelStatistique() {
        return jPanelStatistique;
    }

    public JPanel getjPanelStatistiqueActiviteSportive() {
        return jPanelStatistiqueActiviteSportive;
    }

    public JPanel getjPanelStatistiqueGlycemie() {
        return jPanelStatistiqueGlycemie;
    }

    public JPanel getjPanelStatistiqueIMC() {
        return jPanelStatistiqueIMC;
    }

    public JPanel getjPanelStatistiqueLegume() {
        return jPanelStatistiqueLegume;
    }

    public JPanel getjPanelStatistiquePrincipale() {
        return jPanelStatistiquePrincipale;
    }

    public JPanel getjPanelStatistiqueTourTaille() {
        return jPanelStatistiqueTourTaille;
    }

    public JPanel getjPanelStatistiqueTraitement() {
        return jPanelStatistiqueTraitement;
    }

    public JRadioButton getjRadioButtonAgeTous() {
        return jRadioButtonAgeTous;
    }

    public JRadioButton getjRadioButtonAgeUn() {
        return jRadioButtonAgeUn;
    }

    public JRadioButton getjRadioButtonDeux() {
        return jRadioButtonDeux;
    }

    public JRadioButton getjRadioButtonQuatre() {
        return jRadioButtonQuatre;
    }

    public JRadioButton getjRadioButtonSexeFemme() {
        return jRadioButtonSexeFemme;
    }

    public JRadioButton getjRadioButtonSexeHomme() {
        return jRadioButtonSexeHomme;
    }

    public JRadioButton getjRadioButtonSexeTous() {
        return jRadioButtonSexeTous;
    }

    public JRadioButton getjRadioButtonTrois() {
        return jRadioButtonTrois;
    }


}
