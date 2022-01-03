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


    public void setDialogue(Dialogue d){
        dialogue = d;
    }
    public void startGame() throws CoupIncorrect {
        dialogue.reagir();
    }
    public void setPioche(PaquetDeCartes p){
        pioche = p;
    }

    public void setTalon(PaquetDeCartes p){
        talon = p;
    }

    public void appliquerEffet(){
        Carte carte = this.getTalon().getSommet();
        if(carte.getNom().equals("ChangementDeSens")){
            sensPartie = !sensPartie;
        }
        else if(carte.getNom().equals("PasseTonTour")){
            this.choisirQuiJoue();
        }
        else if(carte.getNom().equals("Plus4")){
            this.choisirQuiJoue();
            for(int i = 0; i < 4; i++){
                Carte ajout = this.getPioche().piocher();
                this.getJoueur(joueurActuel ).recoitCarte(ajout);
            }
        }
        else if(carte.getNom().equals("Plus2")){
            this.choisirQuiJoue();
            for(int i = 0; i < 2; i++){
                Carte ajout = this.getPioche().piocher();
                this.getJoueur(joueurActuel).recoitCarte(ajout);
            }
        }
    }

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

    /**
     * retourne Le joueur actuel
     * @return joueurActuel
     */
    public int getJoueurActuel(){
        return joueurActuel;
    }

    /**
     * Retourne le joueur à l'indice
     * @param i Indice
     * @return Joueur à l'indice i
     */
    public Joueur getJoueur(int i){
        return joueurs.get(i);
    }

    /**
     * Retourne Le paquet de la pioche
     * @return Paquet Pioche
     */
    public PaquetDeCartes getPioche(){
        return this.pioche;
    }

    /**
     * Retourne Le paquet de la talon
     * @return Paquet Talon
     */
    public PaquetDeCartes getTalon(){
        return this.talon;
    }

    /**
     * On distribue 7 cartes à chaque joueur
     */
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

    /**
     * On choisir le joueur qui va distribuer et
     * le joueur qui va jouer en premier
     */
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

    /**
     * On choisit qui va jouer selon le joueurActuel et
     * selon le sens de la partie
     */
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

    /**
     * Initialiser le jeu avec les joueurs, le sens
     * et le joueur qui distribue et celui qui va jouer
     * @param nbJoueur Le nombre de joueur
     */
    public void initialiser(int nbJoueur){
        assert (nbJoueur > 1) : "Bug nombre de joueurs";
        this.sensPartie = true;
        this.creerJoueur(nbJoueur);
        this.distribuerCartes();
        this.choisirQuiDistribue();
        this.choisirQuiJoue();
    }


}