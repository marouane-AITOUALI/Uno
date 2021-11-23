package cartes;

public class PasseTonTour extends Carte{

    public PasseTonTour(Uno u, Couleur c){
        super(u, c);
    }

    public int getValeur(){
        return 20;
    }

    public String getNom(){
        return "PasseTonTour";
    }

    public boolean peutEtreRecouvertePar(Carte c){
        return c.getValeur() == 50 || this.estDeCouleurCompatibleAvec(c) || this.getValeur() == c.getValeur();
    }

    public boolean peutEtrePoseeSur(Chiffre c){
        return this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(Plus2 c){
        return false;
    }

    public boolean peutEtrePoseeSur(Plus4 c){
        return false;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c){
        return this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(PasseTonTour c){
        return true;
    }

    public boolean peutEtrePoseeSur(Joker c){
        return this.estDeCouleurCompatibleAvec(c);
    }
}
