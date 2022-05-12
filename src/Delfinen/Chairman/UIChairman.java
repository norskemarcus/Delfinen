package Delfinen.Chairman;

import Delfinen.Member.Competitor;
import Delfinen.Member.Member;
import Delfinen.Member.NonCompetitor;
import Delfinen.PrintMenuInterface;
import Delfinen.UIMain;

import java.util.ArrayList;
import java.util.Scanner;

public class UIChairman extends UIMain implements PrintMenuInterface {

  private final Scanner sc = new Scanner(System.in);

  public void searchMemberOptions() {
    System.out.println();
    System.out.println("1. Søg ud fra e-Mail");
    System.out.println("2. Søg ud fra navn");
    System.out.println("3. Søg ud fra medlemsnummer");
    System.out.println("4. Tilbage til forrige menu");

  }

  public String inputStringOfSearchCritiria(String descriptionOfWhat) {
    System.out.print("\nIndtast hel eller delvis " + descriptionOfWhat + " på medlem: ");
    String memberInfo = sc.nextLine();
    return memberInfo;
  }

  public void printMenuOptions() {
    System.out.println("1: Tilføj motionssvømmer");
    System.out.println("2: Tilføj konkurrencemedlem");
    System.out.println("3: Søg på medlem");
    System.out.println("4: Vis medlemmer");
    System.out.println("5: Rediger medlemsoplysninger");
    System.out.println("6: Gem ændringer og gå tilbage til hovedmenu");
  }


  public void printHeader() {
    System.out.println(" ");
    System.out.println("*** Formandens forside ***");
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

    boolean anyOneFound = false;
    System.out.println("fundne medlemmer ud fra søgekriterier:");
    for (Member member : members) {

      if (member instanceof Competitor competitor) {
        System.out.printf("""
            Navn: %s  Medlemsnummer: %d Køn: %s  Email: %s  Alder:  %d år  restance: %s
            """, competitor.getName(), competitor.getMemberNumber(), competitor.getGender(), competitor.getEmail(), competitor.getAge(), competitor.isMembershipPaid());
        anyOneFound = true;
      } else {
        System.out.printf("""
            Navn: %s  Medlemsnummer: %d  Email: %s  Alder:  %d år  restance: %s
            """, member.getName(), member.getMemberNumber(), member.getEmail(), member.getAge(), member.isMembershipPaid());
        anyOneFound = true;
      }
    }
    if (!anyOneFound) {
      System.out.println("- Ingen medlemmer fundet.");
    }
  }



  public void printAllMembers(ArrayList<Member> memberList) {
//TODO: ændre til at det nu er 2 lister
    for (Member member : memberList) {
      System.out.printf("""
                    
          Fundet medlem:
          Navn:   %s  Medlemsnummer: %d Email: %s
          Alder:  %d år  restance: %s
                    
          """, member.getName(), member.getMemberNumber(), member.getEmail(), member.getAge(), member.isMembershipPaid());

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


  public NonCompetitor addNonCompetitorMember() {
    System.out.println("\nOpret ny motionssvømmer. Tast ind stamoplysninger:");
    System.out.print("Navn: ");
    String name = sc.nextLine();
    System.out.print("Alder: ");
    String ageString = sc.nextLine();
    int age = Integer.parseInt(ageString);
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Er kontingent betalt (j/n): ");

    String answer = "";
    boolean isMembershipPaid = true;
    while (!answer.equals("j") && !answer.equals("n")) {
      answer = sc.nextLine();
      if (answer.equals("j")) {
        isMembershipPaid = true;
      } else if (answer.equals("n")) {
        isMembershipPaid = false;
      } else System.out.println("Indtast j for ja eller n for nej");
    }

    Integer memberNumber = 0; //TODO hardcoded

    NonCompetitor nonCompetitor = new NonCompetitor(name, memberNumber, age, email, isMembershipPaid);

    System.out.println("\nNy motionssvømmer lagt ind i systemet:");
    printMember(nonCompetitor);

    return nonCompetitor;
  }


  public Competitor addCompetitorMember() {
    System.out.println("\nOpret ny konkurrencesvømmer. Tast ind stamoplysninger:");
    System.out.print("Navn: ");
    String name = sc.nextLine();
    System.out.print("Alder: ");
    String ageString = sc.nextLine();
    System.out.print("Køn (M/K): ");
    //TODO: if sætninger hvis ikke M eller K og mærkelig alder etc
    String gender = sc.nextLine();
    int age = Integer.parseInt(ageString);
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Er kontingent betalt (j/n): ");

    String answer = "";
    boolean isMembershipPaid = true;
    while (!answer.equals("j") && !answer.equals("n")) {
      answer = sc.nextLine();
      if (answer.equals("j")) {
        isMembershipPaid = true;
      } else if (answer.equals("n")) {
        isMembershipPaid = false;
      } else System.out.println("Indtast j for ja eller n for nej");
    }

    Integer memberNumber = 0; //TODO hardcoded

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
}






