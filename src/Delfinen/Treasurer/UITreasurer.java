package Delfinen.Treasurer;

import Delfinen.Member.Competitor;
import Delfinen.Member.Member;
import Delfinen.Member.NonCompetitor;
import Delfinen.PrintMenuInterface;
import Delfinen.UIMain;

import java.util.ArrayList;
import java.util.Scanner;

public class UITreasurer extends UIMain implements PrintMenuInterface {
  private Scanner sc = new Scanner(System.in);

  public void printMenuOptions() {
    System.out.println("1: Se forventeligt kontingentbudget");
    System.out.println("2: Medlemmer i restance");
    System.out.println("3: Ændre restance for medlem - to be implemented");
    System.out.println("0: Gem og gå tilbage til hovedmenu");
  }

  public void printHeader() {
    System.out.println("\n*** Kassererens forside ***");
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

  public void printExpectedAnnualSum(double expectedSum) {
    System.out.println("Forventet årligt indkomst: " + expectedSum + " kr.");
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

  public void changePaymentOptions(Member member) {
    System.out.println("Hvad skal restance forholdet sættes til, for medlem: " + member.getName() + " , medlemsnummer: " + member.getMemberNumber() + "?");
    System.out.println("1: Medlem er i restance");
    System.out.println("2: Medlem er ikke i restance");
    System.out.println("0: Tilbage til Menuen");
  }


  public int inputchoicenumber() {
    System.out.print("\nIndtast valg: ");
    String memberNumberString = sc.nextLine();
    int number = 0;

    try {
      number = Integer.parseInt(memberNumberString);
    } catch (NumberFormatException n) {
      System.err.println("Kun tal");
    }
    return number;
  }

  public void printMemberNotFound() {
    System.out.println("Medlem blev ikke fundet.");
  }

  public void printMembersInDebtHeader() {
    System.out.println("\nMedlemmer i restance:");
  }

  public void printMembersInDebt(String name, double debt) {
    System.out.println(name + ": " + debt);
  }
}
