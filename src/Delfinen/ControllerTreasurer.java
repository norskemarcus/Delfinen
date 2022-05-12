package Delfinen;

public class ControllerTreasurer {
  private UITreasurer uiTreasurer = new UITreasurer();
  public void menuKasserer() {
    boolean running = true;

    while (running) {
      uiTreasurer.printHeader();
      uiTreasurer.printMenuOptions();

      switch (uiTreasurer.inputNumber()) {
        case 1 -> System.out.println("Viser kontingent"); //Skal være metoder til UI
        case 2 -> System.out.println("Viser restancemedlemmer");
        case 3 -> System.out.println("Tilbage til hovedmenu");
        case 4 -> System.out.println("Afslut program"); // set running til false
        default -> uiTreasurer.printErrorMessage();
      }
    }
  }

}
