package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner idNr = new Scanner(System.in);
        System.out.println("Wilkommen, geben Sie bitte Ihre ID-Nummer:");

        String id = idNr.nextLine();

        if(id.length() != 7){
            System.out.println("falsche Eingabe");
        }else{
            System.out.println("richtige Eingabe");
        }

    }
}
