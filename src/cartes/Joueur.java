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
        this.main = new PaquetDeCartes();
    }

    public Uno getUno(){
        return this.u;
    }
    public PaquetDeCartes getMain() {
        return main;
    }

    public void recoitCarte(Carte c){
        this.main.ajouter(c);
    }

    public abstract boolean estHumain();


    public int getNb(){
        return this.nb;
    }

    public String getNom(){
        return this.nom;
    }

    public abstract void jouer(String coup) throws CoupIncorrect;
}