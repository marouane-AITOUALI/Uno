package cartes;

import java.util.Random;

public class Bot extends Joueur {

    /**
     * Constructeur d'un Bot
     * @param nb Numéro du bot
     * @param nom Nom du bot
     * @param u Uno
     */
    public Bot(int nb, String nom, Uno u) {
        super(nb, nom, u);
    }

    /**
     * Retourne true si le joueur est humain, false sinon
     * @return True if human, otherwise false
     */
    public boolean estHumain(){
        return false;
    }

    /**
     * Permet au bot de choisir automatiquement une carte jouable
     * @param coup Carte choisie, mais ignorée dans le cas d'un Bot
     */
    public void jouer(String coup) {
        Carte carte = this.getUno().getTalon().getSommet();
        boolean trouve = false;
        for (int i = 0; i < this.getMain().getNombreDeCartes() && !trouve; i++) {
            Carte carteBot = this.getMain().getCarte(i);
            if (carteBot.estSansCouleur()){
                Random r = new Random();
                int a = r.nextInt(4);
                carteBot.setCouleur(Couleur.values()[a]);
            }
            if (carte.peutEtreRecouvertePar(carteBot)) {
                this.getUno().getTalon().ajouter(carteBot);
                this.getMain().enlever(carteBot);
                trouve = true;
            }}
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