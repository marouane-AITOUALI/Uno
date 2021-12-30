package cartes;

import java.util.Scanner;

public class Dialogue {
    protected Uno uno;

    public Dialogue(Uno uno){
        this.uno = uno;
    }

    /**
     * Retourne les cartes du joueur humain
     * @return liste des cartes du joueurHumain
     */
    public String afficherCarteHumain(){
        return uno.getJoueur(0).getMain().toString();
    }

    /**
     * Affiche le jeu uno, le tour et le sens du jeu
     * @throws CoupIncorrect En cas de coup invalide du joueurHumain
     */
    public void reagir() throws CoupIncorrect {
        System.out.println("---------- BIENVENUE DANS UNO ----------\n");
        boolean fin = false;
        while(!fin){
            if(uno.getPioche().getNombreDeCartes() == 6){
                Carte sommet = uno.getTalon().getSommet();
                uno.getTalon().enlever(sommet);
                uno.getPioche().ajouter(uno.getTalon());
                uno.setTalon(FabriqueCartes.getInstance().paquetEmpty());
                uno.getTalon().ajouter(sommet);
            }
            if(uno.getJoueur(uno.getJoueurActuel()).estHumain()){
                System.out.println("C'est le tour du joueur: " + uno.getJoueur(uno.getJoueurActuel()).getNom() +
                        "\nLa carte sur le sommet du talon est:" + uno.getTalon().getSommet()+"\n" +
                        "Le sens de la partie est:" +uno.getSensPartie());
                System.out.println("La main du joueur humain est :"+ afficherCarteHumain());
                Scanner s = new Scanner(System.in);
                System.out.println("Entrer la carte choisie: ");
                String coup = s.nextLine();
                uno.getJoueur(uno.getJoueurActuel()).jouer(coup);
            }else{
                System.out.println("C est le tour du bot "+uno.getJoueurActuel());
                uno.getJoueur(uno.getJoueurActuel()).jouer("");
            }
            if(uno.getJoueur(uno.getJoueurActuel()).getMain().getNombreDeCartes() == 0){
                fin = true;
                System.out.println("---------- Fin partie ----------\n");
                afficherStats(uno.getJoueurActuel());
            }
            uno.appliquerEffet();
            uno.choisirQuiJoue();
        }
    }

    public void afficherStats(int gagnant){
        System.out.println("Le joueur gagnant est: "+uno.getJoueur(gagnant).getNom()
                +"\nLes stats des autres joueurs");
        for (int i = 0; i < uno.getNbJoueur(); i++){
            if (i != gagnant){
                System.out.println("\nLe score du joueur "
                        + uno.getJoueur(i).getNom() + " est : "
                        +uno.getJoueur(i).getMain().getValeur());
            }
        }
    }


}
