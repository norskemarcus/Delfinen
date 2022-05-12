package Delfinen;

public class ControllerCoach {
  private UICoach uiCoach = new UICoach();
  public void menuCoach() {
    boolean running = true;

    while (running) {

      uiCoach.headerText();
      uiCoach.showMenuOptionsCoach();


      switch (uiCoach.inputNumber()) {
        case 1 -> System.out.println("Metode til top 5 junior"); //Skal være metoder til UI
        case 2 -> System.out.println("Metod til top 5 senior");
        case 3 -> System.out.println("Metode til hovedmenu"); //Evt log ud
        default -> uiCoach.errorMessage();
      }
    }
  }
  }

