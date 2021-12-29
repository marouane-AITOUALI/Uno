package cartes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class JoueurHumain extends Joueur{

    /**
     * Constructeur d'un joueurHumain
     * @param nb Numéro du joueur
     * @param nom Nom du joueur
     * @param u Uno
     */
    public JoueurHumain(int nb, String nom, Uno u){
        super(nb, nom, u);
    }

    /**
     * Retourne true si le joueur est humain, false sinon
     * @return True if human, otherwise false
     */
    public boolean estHumain(){
        return true;
    }

    /**
     * Retourne la carte choisie par le joueurHumain
     * @param coup La carte choisie
     * @return La carte choisie dans la main du joueurHumain
     * @throws CoupIncorrect En cas de coup incorrecte
     */
    public Carte carteChoisie(String coup) throws CoupIncorrect{
        try{
            List liste = new ArrayList();
            List couleur = new ArrayList();
            couleur.add("j");couleur.add("r");couleur.add("v");couleur.add("b");
            for (int a =0; a < 30; a++){
                liste.add("" + a);
            }
            if (coup.length() == 1){
                if(liste.contains(coup)){
                    int a = parseInt(coup);
                    if(this.getMain().getNombreDeCartes() < a ){
                        throw new CoupIncorrect("La carte n'existe pas");
                    }
                    else{
                        Carte carte = this.getMain().getCarte(a-1);
                        if (carte.estSansCouleur()){
                            Random r = new Random();
                            int index = r.nextInt(4);
                            carte.setCouleur(Couleur.values()[index]);
                        }
                        return carte;
                    }
                }
                else {
                    for (int i = 0; i < this.getMain().getNombreDeCartes(); i++) {
                        Carte c = this.getMain().getCarte(i);
                        if (c.getNom().equals("PasseTonTour")) {
                            return c;
                        }
                    }
                    throw new CoupIncorrect("La carte n'existe pas");
                }
            }
            else if(coup.length() == 2){
                String firstLetter = Character.toString(coup.charAt(0));
                String secondLetter = Character.toString(coup.charAt(1));
                if (liste.contains(firstLetter) && liste.contains(secondLetter)){
                    int a = parseInt(coup);
                    if(this.getMain().getNombreDeCartes() < a ){
                        throw new CoupIncorrect("La carte n'existe pas");
                    }
                    else{
                        Carte carte = this.getMain().getCarte(a-1);
                        if (carte.estSansCouleur()){
                            Random r = new Random();
                            int index = r.nextInt(4);
                            carte.setCouleur(Couleur.values()[index]);
                        }
                        return carte;
                    }
                }
                else if(liste.contains(firstLetter)&& couleur.contains(secondLetter)){
                    int num = parseInt(firstLetter);
                    if(this.getMain().getNombreDeCartes() < num || !this.getMain().getCarte(num - 1).estSansCouleur()){
                        throw new CoupIncorrect("Carte inexistante ou le choix de couleur impossible pour la carte");
                    }
                    else{
                        Carte carte = this.getMain().getCarte(num - 1);
                        switch(secondLetter){
                            case "v":
                                carte.setCouleur(Couleur.VERT);
                            case"r":
                                carte.setCouleur(Couleur.ROUGE);
                            case"j":
                                carte.setCouleur(Couleur.JAUNE);
                            case"b":
                                carte.setCouleur(Couleur.BLEU);
                        }
                        return carte;
                    }
                }
                else{
                    throw new CoupIncorrect("Coup invalide !");
                }
            }
            else if(coup.length() == 3){
                String firstLetter = Character.toString(coup.charAt(0));
                String secondLetter = Character.toString(coup.charAt(1));
                String thirdLetter = Character.toString(coup.charAt(2));

                if(liste.contains(firstLetter+secondLetter) && couleur.contains(thirdLetter)){
                    int index = parseInt(firstLetter+secondLetter);
                    if(this.getMain().getNombreDeCartes() < index || !this.getMain().getCarte(index - 1).estSansCouleur()){
                        throw new CoupIncorrect("Carte inexistante ou le choix de couleur impossible pour la carte");
                    }
                    else{
                        Carte carte = this.getMain().getCarte(index - 1);
                        switch(thirdLetter){
                            case "v":
                                carte.setCouleur(Couleur.VERT);
                            case"r":
                                carte.setCouleur(Couleur.ROUGE);
                            case"j":
                                carte.setCouleur(Couleur.JAUNE);
                            case"b":
                                carte.setCouleur(Couleur.BLEU);
                        }
                        return carte;
                    }
                }
                else{
                    throw new CoupIncorrect("Coup invalide");
                }

            }
            else{
                throw new CoupIncorrect("Coup invalide");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Permet au joueurHumain de jouer son coup
     * @param coup Le coup choisi
     * @throws CoupIncorrect En cas de coup invalide
     */
    public void jouer(String coup) throws CoupIncorrect {
        assert (coup != null): "Coup invalide";
        try {
            Carte carteTalon = this.getUno().getTalon().getSommet();
            if (coup.equals("p")) {
                Carte cartePioche = this.getUno().getPioche().piocher();
                if (carteTalon.peutEtreRecouvertePar(cartePioche)) {
                    this.getUno().getTalon().ajouter(cartePioche);
                } else {
                    this.recoitCarte(cartePioche);
                }
            }
            else {
                Carte carte = this.carteChoisie(coup);
                if (carteTalon.peutEtreRecouvertePar(carte)) {
                    this.getUno().getTalon().ajouter(carte);
                    this.getMain().enlever(carte);
                }else{
                    throw new CoupIncorrect("Coup incorrecte");
                }
            }
        }
        catch(Exception e){
            Scanner s = new Scanner(System.in);
            System.out.println("Donner un autre coup : ");
            String nouveauCoup = s.nextLine();
            this.jouer(nouveauCoup);
        }


    }
}