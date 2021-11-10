package cartes;
import cartes.Couleur;

public abstract class Carte {

    private int valeur;
    private Couleur couleur ;
    private Uno uno;

    /**
     * Construction par valeur et couleur de carte
     * @param valeur Valeur de la carte
     * @param couleur Couleur de la carte
     */
    public Carte(int valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    /**
     * Construction d'une carte à partir d'Uno
     * @param u Uno
     */
    public Carte(Uno u){
        this.uno = u;
    }

    /**
     * Construction d'une carte à partir d'Uno et couleur de carte
     * @param u Uno
     * @param c Couleur de la carte
     */
    public Carte(Uno u, Couleur c){
        this.uno = u;
        this.couleur = c;
    }

    /**
     *
     */
    public abstract boolean peutEtreRecouvertePar(Carte c);

    /**
     * retourne vrai si la carte est sans couleur
     * @return Vrai si la carte est sans couleur, Faux sinon
     */
    public boolean estSansCouleur(){
        return couleur.equals(null);
    }

    /**
     * retourne Vrai si la carte a la même couleur que la carte c
     * @return Vrai si la carte a la même couleur que la carte c
     */
    public boolean estDeCouleurCompatibleAvec(Carte c){
        return couleur == c.getCouleur();
    }

    /**
     *
     * @param c Carte au Sommet
     * @return vrai si la carte peut être posée sur la carte c, Faux sinon
     */
    public abstract boolean peutEtrePoseeSur(Chiffre c);

    public abstract boolean peutEtrePoseeSur(Plus2 c);

    public abstract boolean peutEtrePoseeSur(Plus4 c);

    public abstract boolean peutEtrePoseeSur(Joker c);

    public abstract boolean peutEtrePoseeSur(PasseTonTour c);

    public abstract boolean peutEtrePoseeSur(ChangementDeSens c);

    /**
     * Retourne la valeur de la carte
     * @return Valeur de la carte
     */
    public abstract int getValeur();

    /**
     * Retourne la couleur de la carte
     * @return Couleur de la carte
     */
    public Couleur getCouleur(){
        return couleur;
    }

    /**
    * Modifie la valeur de la carte
    * @param valeur Nouvelle valeur de la carte
    */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    /**
    * Modifie la couleur de la carte
    * @param couleur Nouvelle couleur de la carte
    */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
    * Retourne la chaîne "Carte{valeur= val, couleur= coul}" où val valeur de la carte et coul la couleur
    * @return "Carte{valeur=valeur de la carte, couleur=couleur de la carte}" */
    public String toString() {
        return "Carte{" +
                "valeur=" + valeur +
                ", couleur=" + couleur +
                '}';
    }

    

}

