package Delfinen;

import java.util.Scanner;

public class UICoach {

  private Scanner sc = new Scanner(System.in);

  public void showMenuOptionsCoach() {
    System.out.println("1: Top 5 præstationer junior");
    System.out.println("2: Top 5 præstationer senior");
    System.out.println("3: Gå tilbage til hovedmenu");
    System.out.println("4: Afslut program"); // tilføj til switch i controller
  }

  public int inputNumber() {
    System.out.println("Vælg et tal fra menuen:");
    String numberString = sc.nextLine();
    int number = 15;

    try {
      number = Integer.parseInt(numberString);
    } catch (NumberFormatException n) {
      System.err.println("Kun tal");
    }
    return number;
  }

  public void headerText(){
    System.out.println("*** Trænerens forside ***");
  }

  public void errorMessage() {
    System.out.println("Ugyldig indtastning - indtast et tal fra menuen.");
  }

}
