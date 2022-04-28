package models.dao;

import java.sql.*;

/**
 * Singleton fournit un objet de connexion JDBC
 */
public class Jdbc {

    // Instance du singleton Jdbc
    private static Jdbc singleton = null;
    // Paramètre de la connexion
    private String piloteJdbc = "";
    private String protocoleJdbc = "";
    private String serveurBd = "";
    private String nomBd = "";
    private String loginSgbd = "";
    private String mdpSgbd = "";
    // Connexion
    private Connection connexion = null; // java.sql.Connection



    private Jdbc(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        this.piloteJdbc = pilote;
        this.protocoleJdbc = protocole;
        this.serveurBd = serveur;
        this.nomBd = base;
        this.loginSgbd = login;
        this.mdpSgbd = mdp;
    }

    public static void creer(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        if (singleton == null) {
            System.out.println(pilote+protocole+serveur+base+login+mdp);
            singleton = new Jdbc(pilote, protocole, serveur, base, login, mdp);
        }
    }

    public static Jdbc getInstance() {
        return singleton;
    }

    public void connecter() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        setConnexion(DriverManager.getConnection("jdbc:mysql://localhost:3306/SWISS", "root", "shinryuken"));
        getConnexion().setAutoCommit(true);
    }

    public void deconnecter() throws SQLException {
        getConnexion().close();
    }

    public static java.sql.Date utilDateToSqlDate(java.util.Date uneDate) {
        return (new java.sql.Date(uneDate.getTime()));
    }

    /**
     * ************************************* *
     * ACCESSEURS * **************************************
     */
    public String getPiloteJdbc() {
        return piloteJdbc;
    }

    public void setPiloteJdbc(String piloteJdbc) {
        this.piloteJdbc = piloteJdbc;
    }

    /**
     * @return the protocoleJdbc
     */
    public String getProtocoleJdbc() {
        return protocoleJdbc;
    }

    /**
     * @param protocoleJdbc the protocoleJdbc to set
     */
    public void setProtocoleJdbc(String protocoleJdbc) {
        this.protocoleJdbc = protocoleJdbc;
    }

    public String getServeurBd() {
        return serveurBd;
    }

    public void setServeurBd(String serveurBd) {
        this.serveurBd = serveurBd;
    }

    public String getNomBd() {
        return nomBd;
    }

    public void setNomBd(String nomBd) {
        this.nomBd = nomBd;
    }

    public String getLoginSgbd() {
        return loginSgbd;
    }

    public void setLoginSgbd(String loginSgbd) {
        this.loginSgbd = loginSgbd;
    }

    public String getMdpSgbd() {
        return mdpSgbd;
    }

    public void setMdpSgbd(String mdpSgbd) {
        this.mdpSgbd = mdpSgbd;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
}