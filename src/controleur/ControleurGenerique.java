package controleur;

import vue.VueGenerique;

/**
 *
 * @author Djurdjevic Sacha
 * @author Allain Mathys
 */
public abstract class ControleurGenerique {

    protected VueGenerique vue = null;

    protected ControleurPrincipal controleurPrincipal = null;

    protected ControleurGenerique(ControleurPrincipal controleurPrincipal) {
        this.controleurPrincipal = controleurPrincipal;
    }

    public VueGenerique getVue() {
        return vue;
    }

    public void setVue(VueGenerique vue) {
        this.vue = vue;
    }

    public ControleurPrincipal getControleurPrincipal() {
        return (ControleurPrincipal) controleurPrincipal;
    }

    public void setControleurPrincipal(ControleurPrincipal controleurPrincipal) {
        this.controleurPrincipal = controleurPrincipal;
    }

}
