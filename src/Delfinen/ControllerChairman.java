package Delfinen;

public class ControllerChairman {
  private  UI ui = new UI();

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
      }
    }
  }

  //Kald metode fra member/memberlist-klasse via nedenstående metoder:

  private void returnToMainMenu() {
  }

  private void editMembers() {
  }

  private void showMembers() {
  }

  private void searchMember() {
  }

  private void addMember() {
  }

}
