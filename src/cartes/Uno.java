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

    public int getNbJoueur(){
        return joueurs.size();
    }

    public void creerJoueur(int nbJoueur){
        this.joueurs = new ArrayList<>(nbJoueur);
        this.joueurs.add(new JoueurHumain(0,"Marouane", this));

        for (int i = 1; i < nbJoueur; i++){
            PaquetDeCartes p = new PaquetDeCartes();
             this.joueurs.add(new Bot(i, "bot" + i, this));
        }

    }

    public void distribuerCartes(){
        this.pioche  = FabriqueCartes.getInstance().getPaquet108(this);
        for (int i = 0; i < 8;i++){
            for(int j = 0; j < this.joueurs.size();j++){

            }
        }
        this.talon.ajouter(this.pioche.getSommet());

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