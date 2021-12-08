package cartes;

import java.util.ArrayList;

public class Uno {

    private int joueurActuel;
    private int joueurQuiDistribue;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;
    private boolean sensPartie;
    private ArrayList<Joueur> joueurs;

    public Uno(){
        initialiser(joueurs.size());
    }

    public void creerJoueur(int nbJoueur){
        this.joueurs = new ArrayList<>(nbJoueur);

    }

    public void distribuerCartes(){

    }

    public void choisirQuiDistribue(){

    }

    public void choisirQuiJoue(){

    }



    public void initialiser(int nbJoueur){
        assert (nbJoueur > 1) : "Bug nombre de joueurs";
        this.creerJoueur(nbJoueur);
        this.distribuerCartes();
        this.choisirQuiDistribue();
        this.choisirQuiJoue();
    }


}