package Delfinen;

import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  public String inputEmail() {
    System.out.print("\nIndtast e-mail på medlem: ");
    String memberEmail = sc.nextLine();
    return memberEmail;
  }

  public int inputNumber() {

    String numberString = sc.nextLine();
    int number = 15;
    try {
      System.out.println("Vælg et tal fra menuen:");
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
      System.out.println("\nMedlem blev ikke fundet ud indtastede oplysninger.\n");
    } else {
      System.out.printf("""
          
          Fundet medlem:
          Navn:   %s  Medlemsnummer: %d Email: %s
          Alder:  %d år  restance: %s 
          
          """, member.getName(),member.getMemberNumber(),member.getEmail(),member.getAge(),member.isMembershipPaid());
    }
  }
}
