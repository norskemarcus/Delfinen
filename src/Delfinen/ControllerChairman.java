package Delfinen;

import Delfinen.Persistence.FileHandler;

public class ControllerChairman {
  private UIChairman uiChairman = new UIChairman();
  private MemberList memberLists = new MemberList();
  boolean running = true;

  public void menuChairman() {

    while (running) {

      uiChairman.printHeader();
      uiChairman.printMenuOptions();

      switch (uiChairman.inputNumber()) {
        case 1 -> addNonCompetitorMember();
        case 2 -> addCompetitorMember();
        case 3 -> searchMember();
        case 4 -> showMembers();
        case 5 -> editMembers();
        case 6 -> saveAndReturnToMainMenu();
        default -> errorMessage();
      }
    }
  }

  private void errorMessage() {
    uiChairman.printErrorMessage();
  }

  //Kald metode fra member/memberlist-klasse via nedenstående metoder:

  private void saveAndReturnToMainMenu() {
    FileHandler fileHandler = new FileHandler();
    fileHandler.saveAllNonCompetitorsToFile(memberLists.getAllNonCompetitors());
    running = false;
  }

  private void editMembers() {
  }

  private void showMembers() {
    uiChairman.printAllMembers(memberLists.getAllNonCompetitors());

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
    Member foundMember = memberLists.findSpecifikMember(memberEmail);
    return foundMember;
  }

// motionssvømmer
  public void addNonCompetitorMember(){
    NonCompetitor newNonCompetitorMember = uiChairman.addNonCompetitorMember();
    memberLists.getAllNonCompetitors().add(newNonCompetitorMember);
  }

//konkurrencesvømmer
  public void addCompetitorMember(){
    Competitor newCompetitorMember = uiChairman.addCompetitorMember();
    memberLists.getAllCompetitors().add(newCompetitorMember);
    memberLists.getAllNonCompetitors().add(newCompetitorMember);
  }



  public MemberList getMemberLists() {
    return memberLists;
  }
}
