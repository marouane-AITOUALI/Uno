package cartes;

import java.util.ArrayList;
import java.util.Random;

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

    public PaquetDeCartes getTalon(){
        return this.talon;
    }

    public void distribuerCartes(){
        this.pioche  = FabriqueCartes.getInstance().getPaquet108(this);
        for (int i = 0; i < 7;i++){
            for(int j = 0; j < this.joueurs.size();j++){
                Carte carte = pioche.getSommet();
                this.joueurs.get(j).recoitCarte(carte);
            }
        }
        this.talon = new PaquetDeCartes();
        this.talon.ajouter(this.pioche.getSommet());

    }

    public void choisirQuiDistribue(){
        Random r = new Random();
        this.joueurQuiDistribue = r.nextInt(this.getNbJoueur());
    }

    public void choisirQuiJoue(){
        if (this.joueurQuiDistribue == this.getNbJoueur() - 1 ){
            this.joueurActuel = 0;
        }
        else{
            this.joueurActuel = this.joueurQuiDistribue + 1;
        }
    }



    public void initialiser(int nbJoueur){
        assert (nbJoueur > 1) : "Bug nombre de joueurs";
        this.sensPartie = true;
        this.creerJoueur(nbJoueur);
        this.distribuerCartes();
        this.choisirQuiDistribue();
        this.choisirQuiJoue();
    }


}