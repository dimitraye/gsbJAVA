package controleur;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import models.dao.* ;



public class main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        String ficPropertiesJdbc ="gsbProperties.properties" ; //nom du fichier de properties SERVEUR DISTANT PERSONNEL**/
        Properties propertiesJdbc; // objet de propriétés (paramètres de l'appplication) pour Jdbc
        FileInputStream input; // flux de lecture des properties
        CtrlPrincipal ctrlPrincipal; // référence vers le contrôleur principal
// si au moins un paramètre a été passé sur la ligne de commandes
// le premier est le nom du fichier contenant les propriétés de connexion JDBC
        if (args.length > 0) {
            ficPropertiesJdbc = args[0];
        }
        CreateJdbc.creer(ficPropertiesJdbc);
        Jdbc.getInstance().connecter();
// Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();
    }
}
