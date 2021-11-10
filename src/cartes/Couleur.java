package cartes;
import cartes.Carte;


public enum Couleur{
    JAUNE("Jaune"),
    VERT("Vert"),
    BLEU("Bleu"),
    ROUGE("Rouge");

    private String couleur;

    /**
    * Construction par nom de couleur
    * @param nom Nom de la couleur */
    private Couleur(String  nom){
        this.couleur = nom;
    }

    /**
    * Retourne le nom de la couleur
    * @return Nom de la couleur
    */
    public String getNom(){
        return this.couleur;
    }

    /**
    * Retourne Le champ couleur
    * @return Le nom de la couleur
    */
    public String toString(){
        return "" + this.getNom();
    }
    


   
} 

