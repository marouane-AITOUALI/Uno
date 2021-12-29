package cartes;

public class Chiffre extends Carte {
    private int valeur;

    /**
     * Constructeur d'une carte Chiffre
     * @param u Uno
     * @param c Couleur de la carte
     * @param valeur Valeur de la carte
     */
    public Chiffre(Uno u, Couleur c, int valeur){
        super(u, c);
        this.valeur = valeur;
    }

    /**
     * Nom de la carte
     * @return Chiffre
     */
    public String getNom(){
        return "Chiffre";
    }

    /**
     * Valeur de la carte
     * @return Valeur de la carte
     */
    public int getValeur(){
        return valeur;
    }

    public boolean peutEtreRecouvertePar(Carte c){
        return (c.getValeur()==50)||(valeur == c.getValeur())
                || this.estDeCouleurCompatibleAvec(c);
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
