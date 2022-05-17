package Delfinen.Treasurer;

import Delfinen.Member.Member;
import Delfinen.Member.MemberList;
import Delfinen.Member.NonCompetitor;
import Delfinen.Persistence.FileHandler;

public class ControllerTreasurer {
  private UITreasurer uiTreasurer = new UITreasurer();
  private MemberList memberList = new MemberList();
  private FileHandler fileHandler = new FileHandler();
  private boolean running = true;


  public void loadAndThenRunMain() {
    memberList.setAllNonCompetitors(fileHandler.loadNonCompetitors());
    memberList.setAllCompetitors(fileHandler.loadCompetitors());
    menuTreasurer();
  }

  private void saveAndReturnToMainMenu() {
    fileHandler.saveAllNonCompetitorsToFile(memberList.getAllNonCompetitors());
    fileHandler.saveAllCompetitorsToFile(memberList.getAllCompetitors());
    running = false;
  }

  public void menuTreasurer() {
    running = true;

    while (running) {
      uiTreasurer.printHeader();
      uiTreasurer.printMenuOptions();

      switch (uiTreasurer.inputNumber()) {
        case 1 -> calculateExpectedAnnualIncome();
        case 2 -> System.out.println("Viser restancemedlemmer - to be implemented");
        case 0 -> saveAndReturnToMainMenu();
        //case 0 -> System.out.println("Afslut program"); // set running til false
        default -> uiTreasurer.printErrorMessage();
      }
    }
  }

  public void calculateExpectedAnnualIncome() {
    double expectedSum = 0;
    for (Member member : memberList.getAllNonCompetitors()) {
      expectedSum += calculateMembershipCost(member);
    }

    for (Member member : memberList.getAllCompetitors()) {
      expectedSum += calculateMembershipCost(member);
    }

    uiTreasurer.printExpectedAnnualSum(expectedSum);

  }

  protected double calculateMembershipCost(Member member) {
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
