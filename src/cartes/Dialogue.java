package cartes;

public class Dialogue {
    protected Uno uno;

    public Dialogue(Uno uno){
        this.uno = uno;
    }

    public String afficherCarte(){
        return uno.getJoueur( uno.getJoueurActuel() ).getMain().toString();
    }

    public void afficher(){
        System.out.println("---------- BIENVENUE DANS UNO ----------");
        System.out.println("C'est le tour du joueur: " + uno.getJoueurActuel());
        System.out.println("Vos cartes sont : "+afficherCarte()+"\nChoisissez votre carte: ");
    }
}
