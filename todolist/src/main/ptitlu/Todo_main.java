package main.ptitlu;

import java.util.Scanner;

public class Todo_main {

    public static void main(String[] args) throws Exception {
        Todo_main app = new Todo_main();
        app.mainLoop();

    }

    private Scanner sc;
    private Todo_liste todoListe;

    private void mainLoop() throws InterruptedException {

        this.todoListe = new Todo_liste();
        this.sc = new Scanner(System.in);

        String choice = null;
        do {

            System.out.print("\n\nTODOLIST:\n\n"
                    + "A: Consulter la todo\n"
                    + "B: Ajouter un élément \n"
                    + "C: Supprimer un élément \n"
                    + "D: Quitter \n \n");
            choice = sc.nextLine().toUpperCase();

            switchChoice(choice);

        } while (!choice.equals("D"));

    }

    private void choiceConsult() throws InterruptedException {
        todoListe.list();
    }

    private void choiceAdd() throws InterruptedException {
        todoListe.add();
    }

    private void choiceDel() throws InterruptedException {
        todoListe.del();
    }

    //// --------REFACTOR--------////

    private void switchChoice(String choice) throws InterruptedException {
        switch (choice) {

            case "A":
                this.choiceConsult();
                break;

            case "B":
                this.choiceAdd();
                break;

            case "C":
                this.choiceDel();
                break;
        }
    }
}
