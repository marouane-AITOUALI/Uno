package cartes;

public class ChangementDeSens extends Carte{

    /**
     * Constructeur d'une carte changement de sens
     * @param u Uno auquel appartient la carte
     * @param c Couleur de la carte
     */
    public ChangementDeSens(Uno u, Couleur c){
        super(u, c);
    }

    /**
     * Nom de la carte
     * @return ChangementDeSens
     */
    public String getNom(){
        return "ChangementDeSens";
    }

    /**
     * Valeur de la carte
     * @return 20
     */
    public int getValeur(){
        return 20;
    }

    public boolean peutEtreRecouvertePar(Carte c){
        return c.getValeur() == 50 || this.getValeur() == c.getValeur() || this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(Chiffre c){
        return this.estDeCouleurCompatibleAvec(c);
    }

    public boolean peutEtrePoseeSur(Plus2 c){
        assert (c != null) : "Erreur carte nulle";
        return false;
    }

    public boolean peutEtrePoseeSur(Plus4 c){
        assert (c != null) : "Erreur carte nulle";
        return false;
    }

    public boolean peutEtrePoseeSur(ChangementDeSens c){
        assert (c != null) : "Erreur carte nulle";
        return true;
    }

    public boolean peutEtrePoseeSur(Joker c){
        assert (c != null) : "Erreur carte nulle";
        return false;
    }

    public boolean peutEtrePoseeSur(PasseTonTour c){
        assert (c != null) : "Erreur carte nulle";
        return false;
    }
}
