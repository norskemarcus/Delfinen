package Delfinen.Treasurer;

import Delfinen.Member.Member;
import Delfinen.PrintMenuInterface;
import Delfinen.UIMain;

import java.util.Scanner;

public class UITreasurer extends UIMain implements PrintMenuInterface {
  private Scanner sc = new Scanner(System.in);

  public void printMenuOptions() {
    System.out.println("1: Se forventeligt kontingentbudget - to be implemented");
    System.out.println("2: Medlemmer i restance - to be implemented");
    System.out.println("0: Gå tilbage til hovedmenu");
  }

  public void printHeader(){
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
          
          """, member.getName(),member.getMemberNumber(),member.getEmail(),member.getAge(),member.isMembershipPaid());
    }
  }

}
