package Delfinen.Chairman;

import Delfinen.Member.*;
import Delfinen.Main.UIMain;

import java.util.ArrayList;
import java.util.Scanner;

public class UIChairman extends UIMain {

  private final Scanner sc = new Scanner(System.in);

  public String confirmMemberDeletion(String name) {
    System.out.println("Er du sikker på, at du vil slette " + name + "? j/n");
    Scanner sc = new Scanner(System.in);
    String areYouSure = sc.nextLine();
    return areYouSure;
  }



  public void noMemberHasBeenDeleted() {
    System.out.println("Intet medlem er blevet slettet.");
  }


  public void printHeader() {
    System.out.println(" ");
    System.out.println("*** Formandens forside ***");
  }

  public void printMenuOptions() {
    System.out.println("1: Tilføj medlem");
    System.out.println("2: Søg efter medlem");
    System.out.println("3: Vis medlemmer");
    System.out.println("4: Rediger medlemsoplysninger");
    System.out.println("5: Slet medlem");
    System.out.println("0: Gem ændringer og gå tilbage til hovedmenu");
  }

  public void searchMemberOptions() {
    System.out.println();
    System.out.println("1. Søg ud fra e-Mail");
    System.out.println("2. Søg ud fra navn");
    System.out.println("3. Søg ud fra medlemsnummer");
    System.out.println("4. Tilbage til forrige menu");

  }

  public String inputStringOfSearchCriteria(String descriptionOfWhat) {
    System.out.print("\nIndtast hel eller delvis " + descriptionOfWhat + " på medlem: ");
    String memberInfo = sc.nextLine();
    return memberInfo;
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

  public void printFoundMembersBySearch(ArrayList<Member> members) {

    if (members.isEmpty()) {
      System.out.println("Ingen medlemmer fundet ud fra søgekriterier.");
    } else {
      System.out.println("Fundne medlemmer ud fra søgekriterier:");

      for (Member member : members) {

        if (member instanceof Competitor competitor) {
          System.out.printf("""
              Navn: %s  Medlemsnummer: %d Køn: %s  Email: %s  Alder:  %d år  restance: %s
              """, competitor.getName(), competitor.getMemberNumber(), competitor.getGender(), competitor.getEmail(), competitor.getAge(), competitor.isMembershipPaid());
        } else {
          System.out.printf("""
              Navn: %s  Medlemsnummer: %d  Email: %s  Alder:  %d år  restance: %s
              """, member.getName(), member.getMemberNumber(), member.getEmail(), member.getAge(), member.isMembershipPaid());
        }
      }
    }
  }

  public void printAllMembers(ArrayList<NonCompetitor> memberListNonCompetitor, ArrayList<Competitor> memberListCompetitor) {
    System.out.println("\nKlubbens ikke-konkurrencemedlemmer:");
    for (Member member : memberListNonCompetitor) {
      printMember(member);
    }
    System.out.println("\nKlubben konkurrencemedlemmer:");
    for (Competitor competitor : memberListCompetitor) {
      printMember(competitor);
    }
  }

  public void printMember(Member member) {

    if (member instanceof Competitor competitor) {
      System.out.printf("""
          Navn: %s  Medlemsnummer: %d Køn: %s  Email: %s  Alder:  %d år  Restance: %s  Svømmedisciplin: %s
          """, member.getName(), member.getMemberNumber(), competitor.getGender(), member.getEmail(), member.getAge(), member.isMembershipPaid(), competitor.getSwimmingDisciplin());
    } else {
      System.out.printf("""
          Navn: %s  Medlemsnummer: %d  Email: %s  Alder:  %d år  restance: %s
          """, member.getName(), member.getMemberNumber(), member.getEmail(), member.getAge(), member.isMembershipPaid());
    }
  }

  public void printMemberMenu(){
    System.out.println("1: Tilføj ny motionssvømmer");
    System.out.println("2: Tilføj ny konkurrencesvømmer");
    System.out.println("0: Gå tilbage til formandens forside");
  }

  public NonCompetitor addNonCompetitorMember(Integer memberNumber) {
    System.out.println("\nOpret ny motionssvømmer. Tast ind stamoplysninger:");
    System.out.print("Navn: ");
    String name = sc.nextLine();
    System.out.print("Alder: ");
    String ageString = sc.nextLine();
    int age = Integer.parseInt(ageString);
    System.out.print("Email: ");
    String email = sc.nextLine();


    String isActiveAnswer = "";
    boolean isActive = true;
    while (!isActiveAnswer.equals("a") && !isActiveAnswer.equals("p")) {
      System.out.print("Er medlemskabet aktivt (a) eller passivt (p): ");
      isActiveAnswer = sc.nextLine();

      if (isActiveAnswer.equals("p")) {
        isActive = false;
      }
    }

    String membershipAnswer = "";
    boolean isMembershipPaid = true;
    while (!membershipAnswer.equals("j") && !membershipAnswer.equals("n")) {
      System.out.print("Er kontingent betalt (j/n): ");
      membershipAnswer = sc.nextLine();

      if (membershipAnswer.equals("n")) {
        isMembershipPaid = false;
      }
    }


      NonCompetitor nonCompetitor = new NonCompetitor(name, memberNumber, age, email, isMembershipPaid, isActive);

      System.out.println("\nNy motionssvømmer lagt ind i systemet:");
      printMember(nonCompetitor);

      return nonCompetitor;
  }


  public Competitor addCompetitorMember(Integer memberNumber) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nOpret ny konkurrencesvømmer. Tast ind stamoplysninger:");
    System.out.print("Navn: ");
    String name = sc.nextLine();
    System.out.print("Alder: ");
    String ageString = sc.nextLine();
    String gender = "";
    while (!gender.equals("M") && !gender.equals("K")) {
      System.out.print("Køn (M/K): ");
      gender = sc.nextLine().toUpperCase();
    }
    int age = Integer.parseInt(ageString);
    System.out.print("Email: ");
    String email = sc.nextLine();

    String membershipAnswer = "";
    boolean isMembershipPaid = true;
    while (!membershipAnswer.equals("j") && !membershipAnswer.equals("n")) {
      System.out.print("Er kontingent betalt (j/n): ");
      membershipAnswer = sc.nextLine();
      if (membershipAnswer.equals("n")) {
        isMembershipPaid = false;
      }
    }
    SwimmingDisciplin swimmingDisciplin = null;
    int inputDisciplin = 0;

    while (!(inputDisciplin > 0 && inputDisciplin < 5)) {

      System.out.println("Vælg svømmedisciplin: "); // egen printmetode
      System.out.println("1: Bryst");
      System.out.println("2: Crawl");
      System.out.println("3: Rygcrawl");
      System.out.println("4: Butterfly");

      inputDisciplin = sc.nextInt();

      switch (inputDisciplin){
        case 1 -> swimmingDisciplin = SwimmingDisciplin.BRYST;
        case 2 -> swimmingDisciplin = SwimmingDisciplin.CRAWL;
        case 3 -> swimmingDisciplin = SwimmingDisciplin.RYGCRAWL;
        case 4 -> swimmingDisciplin = SwimmingDisciplin.BUTTERFLY;
        default -> printErrorMessage();
      }
    }

    BestResultCompetition bestResultCompetition = new BestResultCompetition(0,0,0,0);
    BestResultTraining bestResultTraining = new BestResultTraining(0,0,0,0);

    Competitor competitor = new Competitor(name, memberNumber, age, email, isMembershipPaid, gender, swimmingDisciplin, bestResultTraining,bestResultCompetition);
    System.out.println("\nNy konkurrencesvømmer lagt ind i systemet:");
    printMember(competitor);
    return competitor;
  }



  public void printMemberFoundByMembernumber(Member member) {
    if (member == null) {
      System.out.println("Intet medlemmer fundet ud fra søgekriteriet.");
    } else {
      System.out.println("fundet medlem ud fra søgekriteriet:");

      if (member instanceof Competitor competitor) {
        System.out.printf("""
            Navn: %s  Medlemsnummer: %d Køn: %s  Email: %s  Alder:  %d år  Restance: %s  Svømmedisciplin: %s 
            """, competitor.getName(), competitor.getMemberNumber(), competitor.getGender(), competitor.getEmail(), competitor.getAge(), competitor.isMembershipPaid(), competitor.getSwimmingDisciplin());
      } else {
        System.out.printf("""
            Navn: %s  Medlemsnummer: %d  Email: %s  Alder:  %d år  Restance: %s
            """, member.getName(), member.getMemberNumber(), member.getEmail(), member.getAge(), member.isMembershipPaid());
      }
    }
  }

  public String confirmEditEmail(String name) {
    System.out.println("Er du sikker på, at du vil ændre mail på " + name + "? j/n");
    Scanner sc = new Scanner(System.in);
    String areYouSure = sc.nextLine();
    return areYouSure;
  }

  public void printInfoOfEditMail(String name, String email) {
    System.out.println("Medlem " + name + " har ændret mail til " + email);
  }
  public void noEmailHasBeenChanged() { //Denne metode til flere steder måske
    System.out.println("Ingen ændringer foretaget");
  }

  public String newMail(){
    System.out.println("Indtast den nye mail du ønsker: ");
    String newMail = sc.nextLine();
    return newMail;
  }


  public void printInfoOfDeletedMember(String name, Integer memberNumber) {
    System.out.println("Medlem " + name + " med medlemsnummer " + memberNumber + " er blevet slettet fra systemet");
  }

}









