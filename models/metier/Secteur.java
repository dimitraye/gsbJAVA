

package models.metier;


public class Secteur {
    private String codeSec;
    private String libelleSec;

    public Secteur(String codeSec, String libelleSec) {
        this.codeSec = codeSec;
        this.libelleSec = libelleSec;
    }

    public String getCodeSec() {
        return codeSec;
    }

    public void setCodeSec(String codeSec) {
        this.codeSec = codeSec;
    }

    public String getLibelleSec() {
        return libelleSec;
    }

    public void setLibelleSec(String libelleSec) {
        this.libelleSec = libelleSec;
    }


    public String toString2() {
        return "Secteur{" + "codeSec=" + codeSec + ", libelleSec=" + libelleSec + '}';
    }
    
    public String toString(){
        return(libelleSec);
    }
}
