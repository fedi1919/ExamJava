package org.fedi;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class MyDataBase {

    //Les variables BD
    Connection conn = null; //Variable de connexion
    Statement stm = null; //Requete
    ResultSet res;     //Resultat de la requete Select


    public MyDataBase() {
        connexion();
    }


    //Methode de connexion
    void connexion() {
        String pilote = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/BaseJava";
        String nom_utilisateur = "root";
        String motdepasse = "";

        //1)Etape 1:	Charger un pilote driver ==>
        try {
            Class.forName(pilote);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver loading error: " + e);
        }

        //2)Etape 2:	Etablir une connexion ==>
        try {
            conn = DriverManager.getConnection(url, nom_utilisateur, motdepasse);
        } catch (SQLException e) {
            System.err.println("Error opening SQL connection: " + e);
        }


        //3)Etape 3:	Creer un objet Statement ==>
        try {
            stm = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Error creating SQL statement: " + e);
        }
    }

    //Requete Insert

    int ajouter(Personne p) {
        try {
            var i = stm.executeUpdate("INSERT INTO personnes (id, nom, genre) VALUES ('" + p.getId() + "','" + p.getNom() + "','" + p.getGenre() + "')");
            System.out.println("Ajout effectué");
            return i;
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }

    // Remplir Tab
    void remplirTab(DefaultTableModel model) {
        try {
            res = stm.executeQuery("SELECT * FROM personnes");
            while (res.next()) {
                // get if the id is already in the table
                var found = false;
                var data = model.getDataVector();
                for (Vector row : data) {
                    if (row.get(0).equals(res.getInt("id"))) {
                        found = true;
                        break;
                    }
                }

                // if not found, add it
                if (!found) {
                    model.addRow(new Object[]{res.getInt("id"), res.getString("nom"), res.getString("genre")});
                }

            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e);
        }
    }

}
