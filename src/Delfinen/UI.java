package Delfinen;

import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  public int inputNumber() {

    String numberString = sc.nextLine();
    int number = 15;
    try {
      System.out.println("Vælg et tal fra menuen:");
      number = Integer.parseInt(numberString);
    } catch (NumberFormatException n) {
      System.err.println("Kun tal");
    }
    return number;
  }

  public void showMenuOptionsChairman() {
    System.out.println("1: Tilføj medlem");
    System.out.println("2: Søg på medlem");
    System.out.println("3: Vis medlemmer");
    System.out.println("4: Rediger medlemsoplysninger");
    System.out.println("5: Gå tilbage til hovedmenu");
  }

  public void errorMessage() {
    System.out.println("Ugyldig indtastning - indtast et tal fra menuen.");
  }
}
