package Delfinen;

public class ControllerChairman {
  private UIChairman uiChairman = new UIChairman();

  private MemberList memberList = new MemberList();

  public void menuChairman() {
    boolean running = true;

    while (running) {

      uiChairman.headerText();
      uiChairman.showMenuOptionsChairman();


      switch (uiChairman.inputNumber()) {
        case 1 -> addMember();
        case 2 -> searchMember();
        case 3 -> showMembers();
        case 4 -> editMembers();
        case 5 -> returnToMainMenu();
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

  private void addMember() {
  }

}
