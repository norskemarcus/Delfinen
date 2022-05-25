package Delfinen.Main;

import Delfinen.Main.PrintMenuInterface;

import java.util.Scanner;

public class UIMain implements PrintMenuInterface {
  final Scanner sc = new Scanner(System.in);


  public void printMenuOptions(){
    System.out.println();
    System.out.println("***DELFINENS MEDLEMSDATABASE***");
    System.out.println("Vælg log-in person");
    System.out.println("1. Formand");
    System.out.println("2. Kasserer");
    System.out.println("3. Træner");
    System.out.println("0. Luk programmet");


  }

  public int inputNumber() {
    System.out.print("Vælg et tal fra menuen:");
    String numberString = sc.nextLine();
    int number = 15;

    try {
      number = Integer.parseInt(numberString);
    } catch (NumberFormatException n) {
      System.err.println("Kun tal");
    }
    return number;
  }

  public void printHeader(){
    System.out.println("*** Velkommen til Svømmeklubben Delfinens administrative system ***");
  }

  public void printErrorMessage() {
    System.out.println("Ugyldig indtastning - indtast et tal fra menuen.");
  }

}
