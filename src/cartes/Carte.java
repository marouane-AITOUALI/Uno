package cartes;
import cartes.Couleur;

import java.util.Random;


public abstract class Carte {

    protected Couleur couleur ;
    protected Uno uno;


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
     * Retourne vrai si la carte c peut etre posée sur la carte 'this'
     * @param c Carte à posée
     * @return true si carte peut etre recouverte par la Carte c, false sinon
     */
    public abstract boolean peutEtreRecouvertePar(Carte c);

    /**
     * retourne vrai si la carte est sans couleur
     * @return Vrai si la carte est sans couleur, Faux sinon
     */
    public boolean estSansCouleur(){
        return couleur == null;
    }

    /**
     * retourne Vrai si la carte a la même couleur que la carte c
     * @return Vrai si la carte a la même couleur que la carte c
     */
    public boolean estDeCouleurCompatibleAvec(Carte c){
        return couleur == c.getCouleur();
    }

    /**
     * @param c Carte au Sommet
     * @return vrai si la carte peut être posée sur la carte c, Faux sinon
     */
    public abstract boolean peutEtrePoseeSur(Chiffre c);

    /**
     * @param c Carte au Sommet
     * @return vrai si la carte peut être posée sur la carte c, Faux sinon
     */
    public abstract boolean peutEtrePoseeSur(Plus2 c);

    /**
     * @param c Carte au Sommet
     * @return vrai si la carte peut être posée sur la carte c, Faux sinon
     */
    public abstract boolean peutEtrePoseeSur(Plus4 c);

    /**
     * @param c Carte au Sommet
     * @return vrai si la carte peut être posée sur la carte c, Faux sinon
     */
    public abstract boolean peutEtrePoseeSur(Joker c);

    /**
     * @param c Carte au Sommet
     * @return vrai si la carte peut être posée sur la carte c, Faux sinon
     */
    public abstract boolean peutEtrePoseeSur(PasseTonTour c);

    /**
     * @param c Carte au Sommet
     * @return vrai si la carte peut être posée sur la carte c, Faux sinon
     */
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
     * Retourne le nom de la carte
     * @return Nom de la carte
     */
    public abstract String getNom();

    /**
    * Modifie la couleur de la carte
    * @param couleur Nouvelle couleur de la carte
    */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
    * Retourne la chaîne "{Carte val couleur}" où Carte nom val valeur et couleur la couleur de la carte
    * @return "{Carte=nom  val=valeur couleur= couleur de la Carte}" */
    public String toString() {
        return "{"+ this.getNom() +
                " " + this.getValeur() +
                " " + this.getCouleur() + "}"
                ;
    }

    

}

