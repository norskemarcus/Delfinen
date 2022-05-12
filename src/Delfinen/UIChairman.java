package Delfinen;

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
    System.out.println("1: Tilføj medlem");
    System.out.println("2: Søg på medlem");
    System.out.println("3: Vis medlemmer");
    System.out.println("4: Rediger medlemsoplysninger");
    System.out.println("5: Gå tilbage til hovedmenu");
  }


  public void printHeader(){
    System.out.println("*** Formandens forside ***");
  }

  public void errorMessage() {
    System.out.println("Ugyldig indtastning - indtast et tal fra menuen.");
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

}
