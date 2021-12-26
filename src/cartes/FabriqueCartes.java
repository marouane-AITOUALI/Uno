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
    private FabriqueCartes(){
        this.instance = instance;
    }

    /**
    * Retourne un paquet de 32 cartes avec 4 couleurs différentes
    * @return Paquet de 32 cartes avec 4 couleurs différentes
    */

 /*
 * Ancienne version : constructeur avec valeur et couleur
  public PaquetDeCartes getPaquet32(){
        PaquetDeCartes paquet = new PaquetDeCartes();
        int p = 0;
        while (p < 4){
            Couleur couleur = Couleur.values()[p];
            for(int i = 1; i < 9; i++){
                Carte carte = new Carte(i, couleur);
                paquet.ajouter(carte);
            }
            p++;
        }
        return paquet;    
    }
  */

    public PaquetDeCartes getPaquet108(Uno u) {
        PaquetDeCartes p = new PaquetDeCartes();
        Couleur J = Couleur.JAUNE;
        Couleur R = Couleur.ROUGE;
        Couleur V = Couleur.VERT;
        Couleur B = Couleur.BLEU;
        Chiffre c1 = new Chiffre(u, J, 0);
        Chiffre c2 = new Chiffre(u, R, 0);
        Chiffre c3 = new Chiffre(u, V, 0);
        Chiffre c4 = new Chiffre(u, B, 0);
        p.ajouter(c1, c2, c3, c4);
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i <= 9; i++) {
                Chiffre a = new Chiffre(u, J, i);
                Chiffre b = new Chiffre(u, R, i);
                Chiffre c = new Chiffre(u, V, i);
                Chiffre d = new Chiffre(u, B, i);
                p.ajouter(a, b, c, d);
            }
        }

        // Cartes spéciales
        // Passe ton tour - Inversement de sens -
        for (int a = 0; a < 2; ++a){
            PasseTonTour ptt1 = new PasseTonTour(u, J);
            PasseTonTour ptt2 = new PasseTonTour(u, R);
            PasseTonTour ptt3 = new PasseTonTour(u, B);
            PasseTonTour ptt4 = new PasseTonTour(u, V);

            Plus2 p2_1 = new Plus2(u, J);
            Plus2 p2_2 = new Plus2(u, R);
            Plus2 p2_3 = new Plus2(u, B);
            Plus2 p2_4 = new Plus2(u, V);

            ChangementDeSens cds1 = new ChangementDeSens(u, J);
            ChangementDeSens cds2 = new ChangementDeSens(u, R);
            ChangementDeSens cds3 = new ChangementDeSens(u, B);
            ChangementDeSens cds4 = new ChangementDeSens(u, V);
            p.ajouter(ptt1, ptt2, ptt3, ptt4, p2_1, p2_2, p2_3, p2_4, cds1, cds2, cds3, cds4);
        }

        for (int cpt = 0; cpt < 4; cpt++){
            Joker j = new Joker(u);
            Plus4 p4 = new Plus4(u);
            p.ajouter(j, p4);
        }

        return p;
    }

    public PaquetDeCartes paquetEmpty(){
        PaquetDeCartes p = new PaquetDeCartes();
        return p;
    }

    /**
    * Retourne un paquet de 8 cartes vertes
    * @return Paquet de 8 cartes vertes
    */
/*
 * Ancienne version : constructeur avec valeur et couleur
    public PaquetDeCartes getPaquet1Vert(){
        PaquetDeCartes paquetVert = new PaquetDeCartes();
        
        //Paquet de 8 cartes vertes numérotées de 1 à 8
        for(int i = 0; i < 8; ++i){
            Carte carte = new Carte(i+1, Couleur.VERT); 
            paquetVert.ajouter(carte);
        }
        return paquetVert;

    }
 */

   
}

