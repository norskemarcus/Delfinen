package Delfinen;

import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  public void searchMemberOptions(){
    System.out.println();
    System.out.println("1. Søg ud fra e-Mail");
    System.out.println("2. Søg ud fra navn");
    System.out.println("3. Søg ud fra medlemsnummer");
    System.out.println("4. Tilbage til forrige menu");

  }

  public void mainMenuPrint(){
    System.out.println("***DELFINS MEDLEMSDATABASE***");
    System.out.println();
    System.out.println("Vælg log-in person");
    System.out.println("1. Formand");
    System.out.println("2. Kasserer");
    System.out.println("3. Træner");
    System.out.println("4. Luk programmet");


  }

  public String inputStringOfSearchCritiria(String descriptionOfWhat) {
    System.out.print("\nIndtast " + descriptionOfWhat + " på medlem: ");
    String memberEmail = sc.nextLine();
    return memberEmail;
  }

  public int inputNumber() {
    System.out.println("Vælg et tal fra menuen:");
    String numberString = sc.nextLine();
    int number = 15;

    try {
      number = Integer.parseInt(numberString);
    } catch (NumberFormatException n) {
      System.err.println("Kun tal");
    }
    return number;
  }

  public void showMenuOptionsChairman() {
    System.out.println("1: Tilføj medlem");
    System.out.println("2: Søg på medlem");
    System.out.println("3: Vis medlemmer");
    System.out.println("4: Rediger medlemsoplysninger");
    System.out.println("5: Gå tilbage til hovedmenu");
  }

  public void errorMessage() {
    System.out.println("Ugyldig indtastning - indtast et tal fra menuen.");
  }

  public void displayMember(Member member) {

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
}
