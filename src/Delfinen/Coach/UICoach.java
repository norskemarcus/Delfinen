package Delfinen.Coach;

import Delfinen.Member.Competitor;
import Delfinen.PrintMenuInterface;
import Delfinen.UIMain;

import java.util.ArrayList;
import java.util.Scanner;

public class UICoach extends UIMain implements PrintMenuInterface {

  private Scanner sc = new Scanner(System.in);


  public void printHeader() {
    System.out.println("\n*** Trænerens forside ***");
  }

  @Override
  public void printMenuOptions() {
    System.out.println("1: Top 5 præstationer junior - to be implemented");
    System.out.println("2: Top 5 præstationer senior - to be implemented");
    System.out.println("3: Opret en ny træning");
    System.out.println("4: Oprette et nyt stævne - to be implemented");
    System.out.println("5: Vis ALLE tider");
    System.out.println("0: Gå tilbage til hovedmenu");
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
    Integer minutNumber = inputInteger();
    System.out.print("Indput resultatets sekundtal: ");
    Integer secondNumber = inputInteger();
    System.out.print("Hvilken måned er resultatet opnået (1-12): ");
    Integer month = inputInteger();
    System.out.print("Hvilken år er resultatet opnået (fx.22): ");
    Integer year = inputInteger();
    competitor.setPersonalBestTrainingTimeSeconds(secondNumber);
    competitor.setPersonalBestTrainingTimeMinutes(minutNumber);
    competitor.setPersonalBestMonth(month);
    competitor.setPersonalBestYear(year);
    System.out.println("Nyt træningsresultat er registreret til " + competitor.getName());
  }

  private Integer inputInteger() {
    int number = -1;
    while (number == -1) {
      String memberNumberString = sc.nextLine();
      while (memberNumberString.length() > 2 || memberNumberString.isEmpty()) {
      System.out.print("Ugyldig indtastning. Indtast igen: ");
      memberNumberString = sc.nextLine();
    }

    try {
      number = Integer.parseInt(memberNumberString);
    } catch (NumberFormatException n) {
      System.out.print("Indtastning må kun være tal: ");
    }
    }
    return number;
  }

  public void printAllCompetitors(ArrayList<Competitor> memberListCompetitor) {

    System.out.println("\nKlubben konkurrencemedlemmer:");
    for (Competitor competitor : memberListCompetitor) {
      System.out.printf("""
          Navn: %s MedlemsNummer: %s Bedste træningstid: %d:%d Dato: %d/20%d
          """, competitor.getName(), competitor.getMemberNumber(), competitor.getPersonalBestTrainingTimeMinutes(), competitor.getPersonalBestTrainingTimeSeconds(), competitor.getPersonalBestMonth(), competitor.getPersonalBestYear());
    }
  }

}
