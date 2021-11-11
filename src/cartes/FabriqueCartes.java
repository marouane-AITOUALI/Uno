package cartes;
import cartes.Carte;
import cartes.PaquetDeCartes;
import cartes.Couleur;
import java.util.Random;

/**
* Fabriquer des Cartes
* @author  Marouane AIT OUALI, Université de Lorraine
*/
public class FabriqueCartes{

    private static FabriqueCartes instance = new FabriqueCartes();


    public static FabriqueCartes getInstance(){
        return instance;
    }

    /**
    * Constructeur */
    public FabriqueCartes(){
        this.instance = instance;
    }

    /**
    * Retourne un paquet de 32 cartes avec 4 couleurs différentes
    * @return Paquet de 32 cartes avec 4 couleurs différentes
    */
    public PaquetDeCartes getPaquet32(){
        PaquetDeCartes paquet = new PaquetDeCartes();
        int p = 0;
        while (p < 4){
            Couleur couleur = Couleur.values()[p];
            for(int i = 0; i < 9; i++){
                Carte carte = new Carte(i+1, couleur);
                paquet.ajouter(carte);
            }
            p++;
        }
        return paquet;    
    }

    public PaquetDeCartes jeuUno(){
        PaquetDeCartes p = new PaquetDeCartes();
        Uno u = new Uno();
        Couleur J = Couleur.JAUNE;
        Couleur R = Couleur.ROUGE;
        Couleur V = Couleur.VERT;
        Couleur B = Couleur.BLEU;
        for (int i = 0; i )
        Chiffre c = new Chiffre
    }

    /**
    * Retourne un paquet de 8 cartes vertes
    * @return Paquet de 8 cartes vertes
    */

    public PaquetDeCartes getPaquet1Vert(){
        PaquetDeCartes paquetVert = new PaquetDeCartes();
        
        //Paquet de 8 cartes vertes numérotées de 1 à 8
        for(int i = 0; i < 8; ++i){
            Carte carte = new Carte(i+1, Couleur.VERT); 
            paquetVert.ajouter(carte);
        }
        return paquetVert;
    }
    

   
}

