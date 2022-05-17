package Delfinen.Treasurer;

import Delfinen.Member.Member;
import Delfinen.Member.NonCompetitor;

public class ControllerTreasurer {
  private UITreasurer uiTreasurer = new UITreasurer();
  public void menuTreasurer() {
    boolean running = true;

    while (running) {
      uiTreasurer.printHeader();
      uiTreasurer.printMenuOptions();

      switch (uiTreasurer.inputNumber()) {
        case 1 -> System.out.println("Viser kontingent - to be implemented"); //Skal være metoder til UI
        case 2 -> System.out.println("Viser restancemedlemmer - to be implemented");
        case 0 -> running = false;
        //case 0 -> System.out.println("Afslut program"); // set running til false
        default -> uiTreasurer.printErrorMessage();
      }
    }
  }


  public double calculateMembershipCost(Member member) {
    double adultMembershipCost = 1600;
    double seniorDiscount = 0.75;
    int age = member.getAge();

    if (member instanceof NonCompetitor) {
      if (!((NonCompetitor) member).isActive()) {
        return 500;
      }
    }

    if (age < 18) {
      return 1000;
    } else if (age < 65) {
      return adultMembershipCost;
    } else {
      return adultMembershipCost * seniorDiscount;
    }
  }
}
