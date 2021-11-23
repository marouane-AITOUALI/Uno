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

    public PaquetDeCartes jeuUno(Uno u) {
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
            for (int i = 1; i < 9; i++) {
                Chiffre a = new Chiffre(u, J, i);
                Chiffre b = new Chiffre(u, R, i);
                Chiffre c = new Chiffre(u, V, i);
                Chiffre d = new Chiffre(u, B, i);
                p.ajouter(a, b, c, d);
            }
        }
        // Cartes spéciales
        for (int b = 0; b < 2; b++){
            // Passe ton tour - Inversement de sens -
            for (int a = 0; a < 4; ++a){
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
            }
        }

        return p;
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

