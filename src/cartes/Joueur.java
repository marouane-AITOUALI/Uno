package cartes;

public abstract class Joueur{

    private int nb;
    private String nom;
    private PaquetDeCartes main;
    private Uno u;


    public Joueur(int nb, String nom, PaquetDeCartes p, Uno u){
        this.nb = nb;
        this.nom = nom;
        this.main = p;
        this.u = u;
    }

    public int getNb(){
        return this.nb;
    }


    public PaquetDeCartes getMain() {
        return main;
    }

    public String getNom(){
        return this.nom;
    }

    public abstract void jouer(String coup);
}