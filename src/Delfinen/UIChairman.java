package Delfinen;

import java.util.ArrayList;
import java.util.Scanner;

public class UIChairman extends UIMain implements PrintMenuInterface {

  private Scanner sc = new Scanner(System.in);

  public void searchMemberOptions(){
    System.out.println();
    System.out.println("1. Søg ud fra e-Mail");
    System.out.println("2. Søg ud fra navn");
    System.out.println("3. Søg ud fra medlemsnummer");
    System.out.println("4. Tilbage til forrige menu");

  }

  public String inputStringOfSearchCritiria(String descriptionOfWhat) {
    System.out.print("\nIndtast " + descriptionOfWhat + " på medlem: ");
    String memberEmail = sc.nextLine();
    return memberEmail;
  }

  public void printMenuOptions() {
    System.out.println("1: Tilføj motionssvømmer");
    System.out.println("2: Tilføj konkurrencemedlem");
    System.out.println("3: Søg på medlem");
    System.out.println("4: Vis medlemmer");
    System.out.println("5: Rediger medlemsoplysninger");
    System.out.println("6: Gå tilbage til hovedmenu");
  }


  public void printHeader(){
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
          
          """, member.getName(),member.getMemberNumber(),member.getEmail(),member.getAge(),member.isMembershipPaid());
    }
  }

  public NonCompetitor addNonCompetitorMember() {
    System.out.println("Opret ny motionssvømmer. Tast ind stamoplysninger:");
    System.out.println("Navn:");
    String name = sc.nextLine();
    System.out.println("Alder");
    String ageString = sc.nextLine();
    int age = Integer.parseInt(ageString);
    System.out.println("Email:");
    String email = sc.nextLine();
    System.out.println("Er kontingent betalt? (j/n)");

    String answer = "";
    boolean isMembershipPaid = true;
    while(!answer.equals("j") && !answer.equals("n") ){
    answer = sc.nextLine();
      if (answer.equals("j")){
         isMembershipPaid = true;
      } else if (answer.equals("n")){
         isMembershipPaid = false;
      } else System.out.println("Indtast j for ja eller n for nej");
    }

    Integer memberNumber = 0; //TODO hardcoded

    // (String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid){
    return new NonCompetitor(name,memberNumber, age, email, isMembershipPaid);
  }

  public void printAllMembers(ArrayList<Member> memberList) {

    for (Member member: memberList) {
      System.out.printf("""
          
          Fundet medlem:
          Navn:   %s  Medlemsnummer: %d Email: %s
          Alder:  %d år  restance: %s 
          
          """, member.getName(),member.getMemberNumber(),member.getEmail(),member.getAge(),member.isMembershipPaid());

    }
  }


  public Competitor addCompetitorMember() {
      System.out.println("Opret ny konkurrencesvømmer. Tast ind stamoplysninger:");
      System.out.println("Navn:");
      String name = sc.nextLine();
      System.out.println("Alder");
      String ageString = sc.nextLine();
      System.out.println("Køn (M/K)");
      //TODO: if sætninger hvis ikke M eller K og mærkelig alder etc
      String gender = sc.nextLine();
      int age = Integer.parseInt(ageString);
      System.out.println("Email:");
      String email = sc.nextLine();
      System.out.println("Er kontingent betalt? (j/n)");

      String answer = "";
      boolean isMembershipPaid = true;
      while(!answer.equals("j") && !answer.equals("n") ){
        answer = sc.nextLine();
        if (answer.equals("j")){
          isMembershipPaid = true;
        } else if (answer.equals("n")){
          isMembershipPaid = false;
        } else System.out.println("Indtast j for ja eller n for nej");
      }

      Integer memberNumber = 0; //TODO hardcoded

      // String name, Integer memberNumber, Integer age, String email, boolean isMembershipPaid, String gender)
      return new Competitor(name, memberNumber, age, email, isMembershipPaid, gender);
    }
  }






