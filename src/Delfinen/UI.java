package Delfinen;

import java.util.Scanner;

public class UI {
  Scanner sc = new Scanner(System.in);

  public int inputNumber() {
    System.out.println("Vælg et tal fra menuen:");
    return sc.nextInt();
  }

  public void showMenuOptionsChairman() {
    System.out.println("1: Tilføj medlem");
    System.out.println("2: Søg på medlem");
    System.out.println("3: Vis medlemmer");
    System.out.println("4: Rediger medlemsoplysninger");
    System.out.println("5: Gå tilbage til hovedmenu");
  }
}
