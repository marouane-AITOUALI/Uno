package cartes;

public class Bot extends Joueur{

    public Bot(int nb, String nom, Uno u){
        super(nb, nom, u);
    }


    public void jouer(String coup){
        Carte carte = this.getUno().getTalon().getSommet();
        for (int i = 0; i < this.getMain().getNombreDeCartes(); i++){
            if (carte.peutEtreRecouvertePar(this.getMain().getCarte(i))) {
                this.getUno().getTalon().ajouter(this.getMain().getCarte(i));
                this.getMain().enlever(this.getMain().getCarte(i));
            }
        }
    }
}