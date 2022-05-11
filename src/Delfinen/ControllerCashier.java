package Delfinen;

public class ControllerCashier {
  private UI ui = new UI();

  public void menuKasserer() {//222
    boolean running = true;

    while (running) {
      ui.forsideTekst("Kasserer");
      ui.showMenuOptionsKasserer();


      switch (ui.inputNumber()) {
        case 1 -> System.out.println("Viser kontingent"); //Skal være metoder til UI
        case 2 -> System.out.println("Viser restancemedlemmer");
        case 3 -> System.out.println("Tilbage til hovedmenu");
        case 4 -> System.out.println("Tilbage til hovedmenu");
        default -> ui.errorMessage();
      }
    }
  }

}
