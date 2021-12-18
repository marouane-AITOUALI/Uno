package cartes;

import java.util.Random;

public class Bot extends Joueur {

    public Bot(int nb, String nom, Uno u) {
        super(nb, nom, u);
    }

    public boolean estHumain(){
        return false;
    }

    public void jouer(String coup) {
        if(!this.estHumain()){
            Carte carte = this.getUno().getTalon().getSommet();
            boolean trouve = false;
            for (int i = 0; i < this.getMain().getNombreDeCartes() && !trouve; i++) {
                Carte carteBot = this.getMain().getCarte(i);
                if (carte.peutEtreRecouvertePar(carteBot)) {
                    if (carteBot.estSansCouleur()){
                        Random r = new Random();
                        int a = r.nextInt(4);
                        carteBot.setCouleur(Couleur.values()[a]);
                    }
                    this.getUno().getTalon().ajouter(carteBot);
                    this.getMain().enlever(carteBot);
                    trouve = true;
                }
            }
            if(!trouve){
                Carte pioche = this.getUno().getPioche().piocher();
                if(carte.peutEtreRecouvertePar(pioche)){
                    if (pioche.estSansCouleur()){
                        Random r = new Random();
                        int a = r.nextInt(4);
                        pioche.setCouleur(Couleur.values()[a]);
                    }
                    this.getUno().getTalon().ajouter(pioche);
                }
                else{
                    this.recoitCarte(pioche);
                }
            }
        }

    }
}