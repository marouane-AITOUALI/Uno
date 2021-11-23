package cartes;

public class Plus4 extends Carte{

    public Plus4(Uno u){
        super(u);
    }

    public int getValeur(){
        return 50;
    }

    public String getNom(){
        return "Plus4";
    }

    public boolean peutEtreRecouvertePar(Carte c){
        return this.getValeur() == c.getValeur() || this.estDeCouleurCompatibleAvec(c);
    }


    public boolean peutEtrePoseeSur(Plus4 c){
        return true;
    }

    public boolean peutEtrePoseeSur(Joker c){
        return true;
    }

    public boolean peutEtrePoseeSur(Plus2 c){
        return true;
    }

    public boolean peutEtrePoseeSur(Chiffre c){
        return true;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c){
        return true;
    }

    public boolean peutEtrePoseeSur(PasseTonTour c){
        return true;
    }
}
