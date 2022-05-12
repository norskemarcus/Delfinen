package Delfinen;

import java.util.Scanner;

public class UITreasurer {
  private Scanner sc = new Scanner(System.in);

  public void showMenuOptionsTreasurer() {
    System.out.println("1: Se forventeligt kontingentbudget");
    System.out.println("2: Medlemmer i restance");
    System.out.println("3: Gå tilbage til hovedmenu");
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

  public void headerText(){
    System.out.println("*** Kassererens forside ***");
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
