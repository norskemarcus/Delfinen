package Delfinen;

public class ControllerCoach {
  private UI ui = new UI();

  public void menuCoach() {
    boolean running = true;

    while (running) {

      ui.forsideTekst("Træner");
      ui.showMenuOptionsCoach();


      switch (ui.inputNumber()) {
        case 1 -> System.out.println("Metode til top 5 junior"); //Skal være metoder til UI
        case 2 -> System.out.println("Metod til top 5 senior");
        case 3 -> System.out.println("Metode til hovedmenu"); //Evt log ud
        default -> ui.errorMessage();
      }
    }
  }
  }

