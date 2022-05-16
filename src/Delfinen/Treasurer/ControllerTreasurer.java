package Delfinen.Treasurer;

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
        case 3 -> running = false;
        case 0 -> System.out.println("Afslut program"); // set running til false
        default -> uiTreasurer.printErrorMessage();
      }
    }
  }

}
