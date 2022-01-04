package org.fedi;

public class Personne {
    private int id ;
    private String nom ;
    private String genre ;
    public Personne(int id, String nom, String genre) {
        super();
        this.id = id;
        this.nom = nom;
        this.genre = genre;
    }

    public Personne( String nom, String genre) {
        this.nom = nom;
        this.genre = genre;
    }

   // getters
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getGenre() {
        return genre;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}