package main.ptitlu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Todo_liste {
    

    static Scanner sc;
    static String element = "";

    static List<String> list = new ArrayList<>();

    public void list() throws InterruptedException {
        sc = new Scanner(System.in);
        int increm = 0;
        String choice;
        do {

            showList(increm);
            System.out.print("\n A: <-- Retour \n \n");
            choice = sc.nextLine().toUpperCase();
        } while (!choice.equals("A"));
    }

    public void del() throws InterruptedException {
        int increm = 0;
        int id_element = 0;
        sc = new Scanner(System.in);

        System.out.print("Quel élément retirer? \n Liste: \n\n");
        showList(increm);

        try {
            id_element = sc.nextInt();

            while (id_element <= 0 || id_element > list.size()) {
                System.out.print("Veuillez entrer une valeur valide.\n\n");
                id_element = sc.nextInt();

            }
            list.remove(id_element - 1);

            System.out.print("\nElement retiré avec succès.\nListe: \n \n");
            showList(increm);
            Thread.sleep(1000);

        } catch (InputMismatchException e) {
            System.out.print("Veuillez entrer une valeur valide.\n\n ");

        }

    }

    public void add() throws InterruptedException {
        int increm = 0;
        sc = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String formattedDate = now.format(formatter);


        System.out.print("Quel élément ajouter? \n \n");
        element = sc.nextLine();
        list.add(element+"   |Date d'ajout: "+formattedDate+"|");

        System.out.print("Liste: \n\n");
        showList(increm);
        Thread.sleep(1000);

    }

    

    //// --------GETTER-SETTER--------////

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        Todo_liste.list = list;
    }

    //// --------REFACTOR--------////

    private void showList(int increm) {
        for (String elem : list) {

            increm++;
            System.out.println(increm + ": " + elem);
        }
    }
}
