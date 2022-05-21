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
    System.out.println("1: Top 5 præstationer kvinder - to be implemented");
    System.out.println("2: Top 5 præstationer mænd - to be implemented");
    System.out.println("3: Oprette et nyt stævne");
    System.out.println("4: Opret en ny træning");
    System.out.println("5: Vis alle træningstider"); //TODO: Sortering ind her?
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
    Integer minutNumber = inputInteger(0,59);
    System.out.print("Indput resultatets sekundtal: ");
    Integer secondNumber = inputInteger(0,59);
    System.out.print("Hvilken måned er resultatet opnået (1-12): ");
    Integer month = inputInteger(1,12);
    System.out.print("Hvilken år er resultatet opnået (fx.22): ");
    Integer year = inputInteger(0,99);
    competitor.getBestResultTraining().setPersonalBestTrainingTimeSeconds(secondNumber);
    competitor.getBestResultTraining().setPersonalBestTrainingTimeMinutes(minutNumber);
    competitor.getBestResultTraining().setPersonalBestTrainingMonth(month);
    competitor.getBestResultTraining().setPersonalBestTrainingYear(year);
    System.out.println("Nyt træningsresultat er registreret til " + competitor.getName());
  }
  public void createNewCompetitionResult(Competitor competitor) {
    System.out.print("Indput resultatets minuttal: ");
    Integer minutNumber = inputInteger(0,59);
    System.out.print("Indput resultatets sekundtal: ");
    Integer secondNumber = inputInteger(0,59);
    System.out.print("Hvilken måned er resultatet opnået (1-12): ");
    Integer month = inputInteger(1,12);
    System.out.print("Hvilken år er resultatet opnået (fx.22): ");
    Integer year = inputInteger(0,99);
    competitor.getBestResultCompetition().setPersonalBestCompetitionTimeSeconds(secondNumber);
    competitor.getBestResultCompetition().setPersonalBestCompetitionTimeMinutes(minutNumber);
    competitor.getBestResultCompetition().setPersonalBestCompetitionMonth(month);
    competitor.getBestResultCompetition().setPersonalBestCompetitionYear(year);
    System.out.println("Nyt konkurrenceresultat er registreret til " + competitor.getName());
  }

  private Integer inputInteger(int min, int max) {
    int number = -1;
    while (number < min || number > max) {
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
    if (number < min || number > max) {
      System.out.print("Ugyldig indtastning. Prøv igen: ");
    }
    }
    return number;
  }

  public void printAllCompetitors(ArrayList<Competitor> memberListCompetitor) {

    System.out.println("\nKlubben konkurrencemedlemmer:");
    for (Competitor competitor : memberListCompetitor) {

      int minutes = competitor.getBestResultTraining().getPersonalBestTrainingTimeMinutes();
      int seconds = competitor.getBestResultTraining().getPersonalBestTrainingTimeSeconds();
      int month = competitor.getBestResultTraining().getPersonalBestTrainingMonth();
      int year = competitor.getBestResultCompetition().getPersonalBestCompetitionYear(); //TODO: Er dette korrekt?

      if (year < 10) {

        System.out.printf("""
          Navn: %s MedlemsNummer: %s Bedste træningstid: %d:%d Dato: %d/200%d
          """, competitor.getName(), competitor.getMemberNumber(), minutes, seconds, month, year);
      } else {
        System.out.printf("""
            Navn: %s MedlemsNummer: %s Bedste træningstid: %d:%d Dato: %d/20%d
            """, competitor.getName(), competitor.getMemberNumber(), minutes, seconds, month, year);
      }
    }
  }

  public void printMenuJrSr() {
    System.out.println("");
    System.out.println("1: Junior");
    System.out.println("2: Senior");
  }

  public void printMenuDisciplines() {
    System.out.println("");
    System.out.println("1: Bryst");
    System.out.println("2: Crawl");
    System.out.println("3: Rygcrawl");
    System.out.println("4: Butterfly");
  }

  public void printTop5Chest(ArrayList<Competitor> allCompetitors) {
    System.out.println("");
    System.out.println("Her kommer en liste over de top 5 bedste brystsvømmere");

  }

  public void printTop5Crawl(ArrayList<Competitor> allCompetitors) {
    System.out.println("Her kommer en liste over de top 5 bedste crawl");
  }

  public void printTop5BackCrawl(ArrayList<Competitor> allCompetitors) {
    System.out.println("Her kommer en liste over de top 5 bedste rygcrawl");
  }

  public void printTop5Butterfly(ArrayList<Competitor> allCompetitors) {
    System.out.println("Her kommer en liste over de top 5 bedste butterfly");
  }
}
