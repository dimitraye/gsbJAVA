package vue;

import controleur.CtrlAbstrait;
import javax.swing.JFrame;



public abstract class VueAbstraite extends JFrame{
    // associations
    protected CtrlAbstrait controleur=null;
    
    public VueAbstraite(CtrlAbstrait CtrlA) {
        this.controleur = CtrlA;
    }     

    public CtrlAbstrait getControleur() {
        return controleur;
    }

    public void setControleur(CtrlAbstrait controleur) {
        this.controleur = controleur;
    }
    
    
    
    
}
