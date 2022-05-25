package Delfinen.Coach;

import Delfinen.Member.Competitor;
import Delfinen.Member.SwimmingDisciplin;
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
    System.out.println("1: Top 5 præstationer kvinder");
    System.out.println("2: Top 5 præstationer mænd");
    System.out.println("3: Opret en ny stævnetid");
    System.out.println("4: Opret en ny træningstid");
    System.out.println("5: Vis alle træningstider");
    System.out.println("6: Konverter en motionssvømmer til konkurrencesvømmer");
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

  protected Integer inputInteger(int min, int max) {
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
    System.out.println("3: Forrige menu");

  }

  public void printMenuDisciplines() {
    System.out.println("");
    System.out.println("1: Bryst");
    System.out.println("2: Crawl");
    System.out.println("3: Rygcrawl");
    System.out.println("4: Butterfly");
    System.out.println("5: Forrige menu");
    System.out.println("0: Trænerens forside");

  }

  public void printTop5List(ArrayList<Competitor> allTrainingTimes, ArrayList<Competitor> allCompetitionTimes) {
    System.out.println("Top 5 træningstider:");
    for (int i = 0; i < allTrainingTimes.size(); i++) {
      Competitor competitor = allTrainingTimes.get(i);
      Integer minutes =  competitor.getBestResultTraining().getPersonalBestTrainingTimeMinutes();
      Integer seconds = competitor.getBestResultTraining().getPersonalBestTrainingTimeSeconds();
      Integer month = competitor.getBestResultTraining().getPersonalBestTrainingMonth();
      Integer year = competitor.getBestResultTraining().getPersonalBestTrainingYear();

      System.out.printf("""
          %d. Medlemsnummer: %d, %s, Tid: %d:%d, Dato:%d/%d
          """, i+1, competitor.getMemberNumber(), competitor.getName(),minutes, seconds, month, year);
          }

    System.out.println("Top 5 konkurrencetider:");
    for (int i = 0; i < allCompetitionTimes.size(); i++) {
      Competitor competitor = allCompetitionTimes.get(i);
      Integer minutes =  competitor.getBestResultCompetition().getPersonalBestCompetitionTimeMinutes();
      Integer seconds = competitor.getBestResultCompetition().getPersonalBestCompetitionTimeSeconds();
      Integer month = competitor.getBestResultCompetition().getPersonalBestCompetitionMonth();
      Integer year = competitor.getBestResultCompetition().getPersonalBestCompetitionYear();

      System.out.printf("""
          %d. Medlemsnummer: %d, %s, Tid: %d:%d, Dato:%d/%d
          """, i+1, competitor.getMemberNumber(), competitor.getName(),minutes, seconds, month, year);
    }

  }

  public String addGenderToNewCompetitor() {
    System.out.println("I hvilken kønskategori skal vedkommende konkurrere i? (M/K)");
    String gender = sc.nextLine();
    return gender;
  }

  public void showDisciplinesOptions() {
    System.out.println("Hvilken svømmedisciplin skal medlemmet tilføjes til?");
    System.out.println("1) Bryst\n2) Ryg\n3) Crawl\n4) Butterfly");
  }

  public void printNotCorrectMemberType(String name) {
    System.out.println(name + " er allerede en konkurrencesvømmer");
  }
}
