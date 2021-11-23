package cartes;

public class Plus2 extends Carte {

    public Plus2(Uno u, Couleur c){
        super(u, c);
    }

    public int getValeur(){
        return 20;
    }

    public String getNom(){
        return "Plus2";
    }

    public boolean peutEtreRecouvertePar(Carte c){
        return c.getValeur() == 50 || this.getValeur() == c.getValeur() || this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(Chiffre c){
        assert (c != null) : "Carte nulle";
        return this.getValeur() == c.getValeur();
    }

    public boolean peutEtrePoseeSur(Plus2 c){
        return true;
    }

    public boolean peutEtrePoseeSur(Plus4 c){
        return false;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c){
        return this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(PasseTonTour c){
        return this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(Joker c){
        return this.estDeCouleurCompatibleAvec(c);
    }


    
}
