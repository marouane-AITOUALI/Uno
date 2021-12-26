package cartes;

public class Joker extends Carte{

    public Joker(Uno u){
        super(u);
    }

    public int getValeur(){
        return 50;
    }

    public String getNom(){
        return "Joker";
    }


    public boolean peutEtreRecouvertePar(Carte c){
        return c.getValeur() == 50 || c.estDeCouleurCompatibleAvec(this);
    }

    public boolean peutEtrePoseeSur(Chiffre c){
        return true;
    }

    public boolean peutEtrePoseeSur(Plus2 c){
        return true;
    }

    public boolean peutEtrePoseeSur(Plus4 c){
        return true;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c){
        return true;
    }

    public boolean peutEtrePoseeSur(PasseTonTour c){
        return true;
    }

    public boolean peutEtrePoseeSur(Joker c){
        return true;
    }
}
