package Delfinen.Chairman;

import Delfinen.Member.*;
import Delfinen.PrintMenuInterface;
import Delfinen.UIMain;

import java.util.ArrayList;
import java.util.Scanner;

public class UIChairman extends UIMain implements PrintMenuInterface {

  private final Scanner sc = new Scanner(System.in);

  public static String confirmMemberDeletion() { // IntelliJ VIL have, metoden skal være static
    System.out.println("Er du sikker på, at du vil slette medlemmet? j/n");
    Scanner sc = new Scanner(System.in);
    String areYouSure = sc.nextLine();
    return areYouSure;
  }

  public static void noMemberHasBeenDeleted() { // TODO: HVORFOR STATIC??
    System.out.println("Intet medlem er blevet slettet.");
  }
  // TODO: Hvor skal "private MembershipTypes membershipTypes" ligge?

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

  public void displayMember(Member member) { //TODO: Skal denne fremvisning differentieres afhængig af, om man er kasserer og formand?

    if (member == null) {
      System.out.println("\nIntet medlem blev ikke fundet ud indtastede oplysninger.\n");
    } else {
      System.out.printf("""
                    
          Fundet medlem:
          Navn:   %s  Medlemsnummer: %d Email: %s
          Alder:  %d år  restance: %s
                    
          """, member.getName(), member.getMemberNumber(), member.getEmail(), member.getAge(), member.isMembershipPaid());
    }
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
    System.out.println("\nAlle klubbens medlemmer er:");
    for (Member member : memberListNonCompetitor) {
      printMember(member);
    }
    for (Competitor competitor : memberListCompetitor) {
      printMember(competitor);
    }
  }

  public void printMember(Member member) {

    if (member instanceof Competitor competitor) {
      System.out.printf("""
          Navn: %s  Medlemsnummer: %d Køn: %s  Email: %s  Alder:  %d år  restance: %s
          """, member.getName(), member.getMemberNumber(), competitor.getGender(), member.getEmail(), member.getAge(), member.isMembershipPaid());
    } else {
      System.out.printf("""
          Navn: %s  Medlemsnummer: %d  Email: %s  Alder:  %d år  restance: %s
          """, member.getName(), member.getMemberNumber(), member.getEmail(), member.getAge(), member.isMembershipPaid());
    }

  }

  public void addMemberMenu(){
    System.out.println("1: Tilføj ny motionssvømmer");
    System.out.println("2: Tilføj ny konkurrencesvømmer");
    System.out.println("3: Gå tilbage til formandens forside");
    System.out.println("0: Gå tilbage til hovedmenu");
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
        //TODO: koble til enum i stedet for boolean?

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
    System.out.println("\nOpret ny konkurrencesvømmer. Tast ind stamoplysninger:");
    System.out.print("Navn: ");
    String name = sc.nextLine();
    System.out.print("Alder: ");
    String ageString = sc.nextLine();
    String gender = "";
    while (!gender.equals("M") && !gender.equals("K")) {
      System.out.print("Køn (M/K): ");
      gender = sc.nextLine();
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


    Competitor competitor = new Competitor(name, memberNumber, age, email, isMembershipPaid, gender);
    System.out.println("\nNy konkurrencesvømmer lagt ind i systemet:");
    printMember(competitor);
    // String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender)
    return competitor;
  }

  public String addGenderToNewCompetitor() {
    System.out.println("I hvilken kønskategori skal vedkommende konkurrere i? (M/K)");
    String gender = sc.nextLine();
    return gender;
  }

  public void printMemberFoundByMembernumber(Member member) {
    if (member == null) {
      System.out.println("Intet medlemmer fundet ud fra søgekriteriet.");
    } else {
      System.out.println("fundet medlem ud fra søgekriteriet:");

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


  public void printInfoOfDeletedMember(String name, Integer memberNumber) {
    System.out.println("Medlem " + name + " med medlemsnummer " + memberNumber + " er blevet slettet fra systemet");
  }
}









