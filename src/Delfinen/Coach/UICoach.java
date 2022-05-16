package Delfinen.Coach;

import Delfinen.PrintMenuInterface;
import Delfinen.UIMain;

import java.util.Scanner;

public class UICoach extends UIMain implements PrintMenuInterface {

  private Scanner sc = new Scanner(System.in);


  public void printHeader(){
    System.out.println("\n*** Trænerens forside ***");
  }

  @Override
  public void printMenuOptions() {
    System.out.println("1: Top 5 præstationer junior - to be implemented");
    System.out.println("2: Top 5 præstationer senior - to be implemented");
    System.out.println("3. Oprette et nyt stævne - to be implemented");
    System.out.println("4: Opret en ny træning - to be implemented");
    System.out.println("5: Gå tilbage til hovedmenu");
    System.out.println("0: Afslut program"); // tilføj til switch i controller
  }
}
