package cartes;

/**
 * //////////////////////
 * /////  Jeu UNO  /////
 * ////////////////////
 * @author Marouane AIT OUALI, Université de Lorraine
 */

public class Main {

    // Le nombre de joueurs dans la partie
    public static final int nbJoueur = 5;

    public static void main(String [] args) throws CoupIncorrect {
        Uno uno = new Uno(nbJoueur);
        Dialogue dialogue = new Dialogue(uno);
        uno.setDialogue(dialogue);
        uno.startGame();

    }
}
