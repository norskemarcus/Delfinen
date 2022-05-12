package Delfinen;

import java.util.ArrayList;

public class ControllerChairman {
  private UIChairman uiChairman = new UIChairman();

  private MemberList memberList = new MemberList();

  public void menuChairman() {
    boolean running = true;

    while (running) {

      uiChairman.printHeader();
      uiChairman.printMenuOptions();


      switch (uiChairman.inputNumber()) {
        case 1 -> addNonCompetitorMember();
        //case 2 -> addCompetitorMember();
        case 3 -> searchMember();
        case 4 -> showMembers();
        case 5 -> editMembers();
        case 6 -> returnToMainMenu();
        default -> errorMessage();
      }
    }
  }

  private void errorMessage() {
    uiChairman.errorMessage();
  }

  //Kald metode fra member/memberlist-klasse via nedenstående metoder:

  private void returnToMainMenu() {
  }

  private void editMembers() {
  }

  private void showMembers() {
    uiChairman.printAllMembers(memberList.getAllMembers());

  }

  private void searchMember() {
    uiChairman.searchMemberOptions();
    int number = uiChairman.inputNumber();

    Member foundMember = null;

    switch (number) {
      case 1 -> foundMember = searchMemberByEmail();
      case 2 -> System.out.println();
      case 3 -> System.out.println();
      case 4 -> System.out.println();
      default -> System.out.println();
    }

    if (number != 4) {
      uiChairman.displayMember(foundMember);
    }
  }

  private Member searchMemberByEmail() {
    String memberEmail = uiChairman.inputStringOfSearchCritiria("E-mail");
    Member foundMember = memberList.findSpecifikMember(memberEmail);
    return foundMember;
  }

// motionssvømmer
  public void addNonCompetitorMember(){
    NonCompetitor newNonCompetitorMember = uiChairman.addNonCompetitorMember();
    memberList.getAllMembers().add(newNonCompetitorMember);
  }
/*
//konkurrencesvømmer
  public void addCompetitorMember(){
    Competitor newCompetitorMember = uiChairman.addCompetitorMember();
    memberList.getAllCompetitors().add(newCompetitorMember);
    memberList.getAllMembers().add(newCompetitorMember); // Hele medlemslisten
  }

 */

  public MemberList getMemberList() {
    return memberList;
  }
}
