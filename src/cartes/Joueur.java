package cartes;

public abstract class Joueur{

    private int nb;
    private String nom;
    private PaquetDeCartes main;
    private Uno u;


    public Joueur(int nb, String nom, Uno u){
        this.nb = nb;
        this.nom = nom;
        this.u = u;
    }

    public void setMain(PaquetDeCartes p){
        this.main = p;
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