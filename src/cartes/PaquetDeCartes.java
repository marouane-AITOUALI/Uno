package cartes;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import cartes.FabriqueCartes;

/**
* Un Paquet de Carte(valeur, couleur)
* @author Marouane AIT OUALI, Universit√© de Lorraine
*/
public class PaquetDeCartes{

    private ArrayList<Carte> cartes;

    /**
    * Construction d'un paquet de cartes 
    * */
    public PaquetDeCartes(){
        this.cartes = new ArrayList<Carte>();
    }

    /**
    * Retourne vrai si le paquet est vide, faux sinon
    * @return Vrai si le paquet est vide, faux sinon
    */

    public boolean estVide(){
        return this.cartes.isEmpty();
    }
    /**
    * Retourne les cartes du paquet this.cartes
    * @return Cartes dans le paquet
    */


    public ArrayList<Carte> getCarte(){
        return this.cartes;
    }

    public Carte getCarte(int i){
        return this.cartes.get(i);
    }

    /**
    * Retourne la somme des valeurs des cartes dans le paquet
    * @return Somme des valeurs des cartes dans le paquet
    */

    public int getValeur(){
        int valeur = 0;
        for(int j = 0; j < this.getNombreDeCartes(); j++){
            valeur += this.cartes.get(j).getValeur();
        }
        return valeur;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < this.getNombreDeCartes(); i++){
            s.append(" ").append(this.cartes.get(i).toString());
        }
        return s.toString();

    }

    /**
    * Ajoute les cartes au paquet de cartes 
    * @param cartes Tableau de cartes
    */
    public void ajouter(Carte... cartes){
        for(int i = 0; i < cartes.length; ++i){
            this.cartes.add(0, cartes[i]);
        }
        
    }

    /**
    * Retourne le nombre de cartes
    * @return Nombre de cartes dans le paquet */
    public int getNombreDeCartes(){
        return this.cartes.size();
    }

    /**
    * Ajoute les cartes du paquet pdc 
    * @param pdc Paquet de cartes
    */
    public void ajouter(PaquetDeCartes pdc){  
        for (int i = 0; i < pdc.getNombreDeCartes(); ++i){
            this.cartes.add(pdc.cartes.get(i));
        }
    }

    /**
    * Enl√®ve une carte dans le paquet
    * @param carte Carte √† enlever
    */
    public void enlever(Carte carte){
        this.cartes.remove(carte);
    }

    /**
    * Melange les cartes du paquet
    */
    public void melanger(){
        Random r = new Random();
        for (int i = 0; i < this.getNombreDeCartes(); ++i){
            int c = r.nextInt(this.getNombreDeCartes());
            Carte carte = this.cartes.get(0);
            enlever(carte);
            this.cartes.add(c, carte);
        }
    }

    /**
    * Inverse l'ordre des cartes
    */
    public void retourner(){
        for(int i = 0; i < this.getNombreDeCartes(); ++i){
            Carte carte = this.cartes.get(this.getNombreDeCartes() - 1);
            this.enlever(carte);
            this.cartes.add(i, carte);
        }
    }

    /**
    * Retourne la carte au sommet (indice 0)
    * @return la premiere carte au sommet (indice 0)
     */

    public Carte getSommet(){
        return this.cartes.get(0);
    }

    /**
    * Retourne la carte pioch√©e
    * @return La carte pioch√©e
    */

    public Carte piocher(){
        Carte carte = getSommet();
        enlever(carte);
        return carte;
    }

    /**
     * Description de chaque carte du paquet
     * @param nomDeFichier nom du fichier
     */

    void ecrire(String nomDeFichier) throws ErreurFichier{
        try{
            File f = new File(nomDeFichier);
            if (f.exists()) {
                throw new ErreurFichier("Le fichier existe d√©j√† !");
            }
            FileWriter flot = new FileWriter(nomDeFichier);
            BufferedWriter flotFiltre = new BufferedWriter(flot);
            for(int i = 0; i < this.getNombreDeCartes(); ++i){
                flotFiltre.write(this.cartes.get(i).toString());
                flotFiltre.newLine();
            }
            flotFiltre.close();
        }
        catch(ErreurFichier | IOException ef){
            System.out.println(ef.getMessage());
        }
    }

    void lire(String nomDeFichier) throws ErreurFichier{
        try{
            File f = new File(nomDeFichier);
            if (!f.exists()){
                throw new ErreurFichier("Le fichier n'existe pas");
            }
            FileReader flot = new FileReader(nomDeFichier);
            BufferedReader flotFiltre = new BufferedReader(flot);
            Scanner s = new Scanner(flotFiltre);
            while(s.hasNext()){

            }

        }
        catch  (ErreurFichier | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }




    // Cette partie permet d'√©crire les cartes du paquet p dans le fichier test.txt

    /*
    public static void main(String [] args) throws ErreurFichier {
        FabriqueCartes f = new FabriqueCartes();
        PaquetDeCartes p = f.getPaquet108();
        p.ecrire("test.txt");
    }
    */


}

