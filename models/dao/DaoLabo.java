

package models.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.metier.Labo;


public class DaoLabo {
    public static Labo selectOne(String codeLabo) throws SQLException {
        Labo unLabo = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LABO WHERE LAB_CODE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeLabo);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String nomLabo = rs.getString("LAB_NOM");
            String chefVente = rs.getString("LAB_CHEFVENTE");
            unLabo = new Labo(codeLabo, nomLabo, chefVente);
        }
        return unLabo;
    }

    public static List<Labo> selectAll() throws DaoException {
        List<Labo> lesLabos = new ArrayList<Labo>();
        Labo unLabo;
        ResultSet rs;
        try {
            PreparedStatement pstmt;
            Jdbc jdbc = Jdbc.getInstance();
            // préparer la requête
            String requete = "SELECT * FROM LABO";
            pstmt = jdbc.getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String codeLabo = rs.getString("LAB_CODE");
                String nomLabo = rs.getString("LAB_NOM");
                String chefVente = rs.getString("LAB_CHEFVENTE");
                unLabo = new Labo(codeLabo, nomLabo, chefVente);
                lesLabos.add(unLabo);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            throw new DaoException("DaoLabo - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        return lesLabos;
    }
}
