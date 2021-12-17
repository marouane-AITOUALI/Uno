package cartes;

public class Bot extends Joueur {

    public Bot(int nb, String nom, Uno u) {
        super(nb, nom, u);
    }


    public void jouer(String coup) {
        Carte carte = this.getUno().getTalon().getSommet();
        boolean trouve = false;
        for (int i = 0; i < this.getMain().getNombreDeCartes() && !trouve; i++) {
            if (carte.peutEtreRecouvertePar(this.getMain().getCarte(i))) {
                this.getUno().getTalon().ajouter(this.getMain().getCarte(i));
                this.getMain().enlever(this.getMain().getCarte(i));
                trouve = true;
            }
        }
        if(!trouve){
            Carte pioche = this.getUno().getPioche().piocher();
            if(carte.peutEtreRecouvertePar(pioche)){
                this.getUno().getTalon().ajouter(pioche);
            }
            else{
                this.getMain().ajouter(pioche);
            }
        }
    }
}