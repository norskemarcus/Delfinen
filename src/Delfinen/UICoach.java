package Delfinen;

import java.util.Scanner;

public class UICoach extends UIMain implements PrintMenuInterface {

  private Scanner sc = new Scanner(System.in);


  public void printHeader(){
    System.out.println("*** Trænerens forside ***");
  }

  public void errorMessage() {
    System.out.println("Ugyldig indtastning - indtast et tal fra menuen.");
  }

  @Override
  public void printMenuOptions() {
    System.out.println("1: Top 5 præstationer junior");
    System.out.println("2: Top 5 præstationer senior");
    System.out.println("3: Gå tilbage til hovedmenu");
    System.out.println("4: Afslut program"); // tilføj til switch i controller
  }
}
