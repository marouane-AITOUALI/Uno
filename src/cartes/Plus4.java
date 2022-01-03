package cartes;

public class Plus4 extends Carte{

    /**
     * Constructeur carte Plus4
     * @param u Uno
     */
    public Plus4(Uno u){
        super(u);
    }

    /**
     * Retourne la valeur de la carte
     * @return 50
     */
    public int getValeur(){
        return 50;
    }

    /**
     * Retourne le nom de la carte
     * @return Plus4
     */
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
