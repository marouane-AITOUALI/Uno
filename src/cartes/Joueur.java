package cartes;

public abstract class Joueur{

    private int nb;
    private String nom;
    private Uno u;


    public Joueur(int nb, String nom, Uno u){
        this.nb = nb;
        this.nom = nom;
        this.u = u;
    }

    public int getNb(){
        return this.nb;
    }

    public getNom(){
        return this.nom;
    }

    public abstract void jouer(String coup);
}