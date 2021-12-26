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
    private Dialogue dialogue;

    public Uno(int nbJoueur){
        initialiser(nbJoueur);
    }

    public boolean getSensPartie(){
        return this.sensPartie;
    }

    public int getNbJoueur(){
        return joueurs.size();
    }

    public void setJoueurActuel(){
        joueurActuel += 1;
    }

    public void creerJoueur(int nbJoueur){
        this.joueurs = new ArrayList<>(nbJoueur);
        this.joueurs.add(new JoueurHumain(0,"Marouane", this));

        for (int i = 1; i < nbJoueur; i++){
            this.joueurs.add(new Bot(i, "bot" + i, this));
        }
    }

    public int getJoueurActuel(){
        return joueurActuel;
    }

    public Joueur getJoueur(int i){
        return joueurs.get(i);
    }

    public PaquetDeCartes getPioche(){
        return this.pioche;
    }

    public PaquetDeCartes getTalon(){
        return this.talon;
    }

    public void distribuerCartes(){
        this.pioche  = FabriqueCartes.getInstance().getPaquet108(this);
        pioche.melanger();
        for (int i = 0; i < 7;i++){
            for(int j = 0; j < this.joueurs.size();j++){
                Carte carte = pioche.piocher();
                this.joueurs.get(j).recoitCarte(carte);
            }
        }
        this.talon = new PaquetDeCartes();
        this.talon.ajouter(this.pioche.getSommet());

    }

    public void choisirQuiDistribue(){
        Random r = new Random();
        this.joueurQuiDistribue = r.nextInt(this.getNbJoueur());
        if (this.joueurQuiDistribue == this.getNbJoueur() - 1 && sensPartie){
            this.joueurActuel = 0;
        }
        else if(this.joueurQuiDistribue != 0 && !sensPartie){
            this.joueurActuel -= 1;
        }
        else if(this.joueurQuiDistribue != this.getNbJoueur() - 1 && sensPartie){
            this.joueurActuel += 1;
        }
        else{
            this.joueurActuel = this.getNbJoueur() - 1;
        }
    }

    public void choisirQuiJoue(){
        if(joueurActuel != this.getNbJoueur() - 1 && sensPartie){
            joueurActuel += 1;
        }else if(joueurActuel == this.getNbJoueur() - 1 && sensPartie){
            joueurActuel = 0;
        }else if(joueurActuel != 0 && !sensPartie){
            joueurActuel -= 1;
        }else{
            joueurActuel = this.getNbJoueur() - 1;
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