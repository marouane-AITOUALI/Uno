package cartes;

public abstract class Joueur{

    private int nb;
    private String nom;
    private bot bot;
    private JoueurHumain joueurHumain;


    public Joueur(int nb, String nom, ){
        this.nb = nb;
        this.nom = nom;
        this.bot = new Bot(int nb, String nom);
        this.joueurHumain = new JoueurHumain(int nb, String nom);

    }

    public int getNb(){
        return this.nb;
    }

    public getNom(){
        return this.nom;
    }
}