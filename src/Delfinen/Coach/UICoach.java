package Delfinen.Coach;

import Delfinen.Member.Competitor;
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

  public int inputMembernumber() {
    System.out.print("\nIndtast medlemsnummer på medlem: ");
    String memberNumberString = sc.nextLine();
    int number = 0;

    try {
      number = Integer.parseInt(memberNumberString);
    } catch (NumberFormatException n) {
      System.err.println("Kun tal");
    }
    return number;
  }

  public void memberNotFound() {
    System.out.println("kan ikke fortsætte, medlem kan ikke findes.");
  }

  public void createNewTrainingResult(Competitor competitor) {
    System.out.print("Indput resultatets minuttal: ");
    Integer minutNumber = sc.nextInt();
    System.out.print("Indput resultatets sekundtal: ");
    Integer secondNumber = sc.nextInt();
    System.out.print("Hvilken måned er resultatet opnået (1-12): ");
    Integer month = sc.nextInt();
    System.out.print("Hvilken år er resultatet opnået (fx.2022): ");
    Integer year = sc.nextInt();
    competitor.setPersonalBestTrainingTimeSeconds(secondNumber);
    competitor.setPersonalBestTrainingTimeMinutes(minutNumber);
    competitor.setPersonalBestMonth(month);
    competitor.setPersonalBestYear(year);
    System.out.println("Nyt træningsresultat er registreret til " + competitor.getName());
  }
}
