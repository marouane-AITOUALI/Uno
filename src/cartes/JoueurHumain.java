package cartes;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class JoueurHumain extends Joueur{

    public JoueurHumain(int nb, String nom, Uno u){
        super(nb, nom, u);
    }

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
                        return this.getMain().getCarte(a - 1);
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
                    if(this.getMain().getNombreDeCartes() < a){
                        throw new CoupIncorrect("La carte n'existe pas");
                    }
                    else{
                        return this.getMain().getCarte(a - 1);
                    }
                }
                else if(liste.contains(firstLetter)&& couleur.contains(secondLetter)){
                    int num = parseInt(firstLetter);
                    if(this.getMain().getNombreDeCartes() < num || !this.getMain().getCarte(num).estSansCouleur()){
                        throw new CoupIncorrect("Carte inexistante ou le choix de couleur impossible pour la carte");
                    }
                    else{
                        Carte carte = this.getMain().getCarte(num);
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

            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void jouer(String coup){
        assert (coup != null): "Coup invalide";
        if (coup == "p"){
            this.recoitCarte(this.getUno().getPioche().getSommet());
        }
    }
}