package cartes;

public class Chiffre extends Carte {
    private int valeur;

    public Chiffre(Uno u, Couleur c, int valeur){
        super(u, c);
        this.valeur = valeur;
    }

    public String getNom(){
        return "Chiffre";
    }

    public int getValeur(){
        return valeur;
    }

    public boolean peutEtreRecouvertePar(Carte c){
        return valeur == c.getValeur();
    }

    public boolean peutEtrePoseeSur(Chiffre c){
        return this.valeur == c.getValeur();
    }
}
