package cartes;

public class Main {
    public static final int nbJoueur = 5;
    public static void main(String [] args) throws CoupIncorrect {

        Uno uno = new Uno(nbJoueur);
        Dialogue dialogue = new Dialogue(uno);
        uno.setDialogue(dialogue);
        dialogue.reagir();

    }
}
