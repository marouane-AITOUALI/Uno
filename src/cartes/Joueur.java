package cartes;

public abstract class Joueur{

    private int nb;
    private String nom;
    private bot bot;
    private JoueurHumain joueurHumain;
    private Uno u;


    public Joueur(int nb, String nom, Uno u){
        this.nb = nb;
        this.nom = nom;
        this.u = u;
        this.bot = new Bot(int nb, String nom, u);
        this.joueurHumain = new JoueurHumain(int nb, String nom, u);

    }

    public int getNb(){
        return this.nb;
    }

    public getNom(){
        return this.nom;
    }
}