package Delfinen;

public class ControllerChairman {
  private  UI ui = new UI();
  private MemberList memberList = new MemberList();

  public void menuChairman() {
    boolean running = true;

    while (running) {

      ui.showMenuOptionsChairman();



      switch (ui.inputNumber()) {
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
    ui.errorMessage();
  }

  //Kald metode fra member/memberlist-klasse via nedenstående metoder:

  private void returnToMainMenu() {
  }

  private void editMembers() {
  }

  private void showMembers() {
  }

  private void searchMember() {
    String memberEmail = ui.inputEmail();
    Member foundMember = memberList.findSpecifikMember(memberEmail);
    ui.displayMember(foundMember);
  }

  private void addMember() {
  }

}
