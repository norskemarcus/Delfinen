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
        case 2 -> showMembersInDebt();
        case 3 -> changeMembershipPaymentStatus();
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

  public void showMembersInDebt() {
    uiTreasurer.printMembersInDebtHeader();

    for (Member member : memberList.getAllNonCompetitors()) {
      if (!member.isMembershipPaid()) {
        uiTreasurer.printMembersInDebt(member.getName(), calculateMembershipCost(member));
      }
    }

    for (Member member : memberList.getAllCompetitors()) {
      if (!member.isMembershipPaid()) {
        uiTreasurer.printMembersInDebt(member.getName(), calculateMembershipCost(member));
      }
    }
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

  private void changeMembershipPaymentStatus() {
    int membernumber = uiTreasurer.inputMembernumber();
    Member memberToChange = memberList.findSpecifikMemberByMemberNumber(membernumber);

    if (memberToChange == null) {
      uiTreasurer.printMemberNotFound();
    }

    if (memberToChange != null) {
      uiTreasurer.changePaymentOptions(memberToChange);
      int choice = -1;
      while (choice != 1 && choice != 2 && choice != 0) {
        choice = uiTreasurer.inputchoicenumber();
        if (choice == 1) {
          memberToChange.setMembershipPaid(true);
        } else if (choice == 2) {
          memberToChange.setMembershipPaid(false);
        }
      }
    }
  }

}
