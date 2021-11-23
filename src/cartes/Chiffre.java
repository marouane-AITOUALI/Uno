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

    public boolean peutEtrePoseeSur(Plus2 c){
        return false;
    }

    public boolean peutEtrePoseeSur(Plus4 c){
        return false;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c){
        return false;
    }

    public boolean peutEtrePoseeSur(PasseTonTour c){
        return false;
    }

    public boolean peutEtrePoseeSur(Joker c){
        return false;
    }
}
