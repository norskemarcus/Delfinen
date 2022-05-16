package Delfinen.Persistence;

import Delfinen.Member.Competitor; //TODO: Peter?
import Delfinen.Member.Member;
import Delfinen.Member.NonCompetitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {

  public ArrayList<NonCompetitor> loadNonCompetitors() {

    ArrayList<NonCompetitor> nonCompetitorList = new ArrayList<NonCompetitor>();

    try {
      Scanner fileScanner = new Scanner(new File("medlemsliste_motionist.csv"));

      while (fileScanner.hasNextLine()) {
        String lineInput = fileScanner.nextLine();
        Scanner line = new Scanner(lineInput).useDelimiter(";").useLocale(Locale.ENGLISH);
    String name = line.next();
    int memberNumber = Integer.parseInt(line.next());
    int age = Integer.parseInt(line.next());
    String email = line.next();
    boolean isMembershipPaid = Boolean.parseBoolean(line.next());
    boolean isActive = Boolean.parseBoolean(line.next());
    NonCompetitor nonCompetitor = new NonCompetitor(name, memberNumber, age, email, isMembershipPaid, isActive);
    nonCompetitorList.add(nonCompetitor);
      }
    } catch (FileNotFoundException fnfe) {
      System.err.println("File not found");
    }

    return nonCompetitorList;
  }

  public ArrayList<Competitor> loadCompetitors() {

    ArrayList<Competitor> competitorList = new ArrayList<>();

    try {
      Scanner fileScanner = new Scanner(new File("medlemsliste_konkurrencesvømmer.csv"));

      while (fileScanner.hasNextLine()) {
        String lineInput = fileScanner.nextLine();
        Scanner line = new Scanner(lineInput).useDelimiter(";").useLocale(Locale.ENGLISH);
        String name = line.next();
        int memberNumber = Integer.parseInt(line.next());
        String gender = line.next();
        int age = Integer.parseInt(line.next());
        String email = line.next();
        boolean isMembershipPaid = Boolean.parseBoolean(line.next());
//        boolean isActive = Boolean.parseBoolean(line.next());
        Competitor competitor = new Competitor(name,memberNumber,age,email,isMembershipPaid,gender);
        competitorList.add(competitor);

      }
    } catch (FileNotFoundException fnfe) {
      System.err.println("File not found");
    }

    return competitorList;
  }


  public void saveAllNonCompetitorsToFile(ArrayList<NonCompetitor> listOfNonCompetitors) {

    try {
      PrintStream out = new PrintStream(new File("medlemsliste_motionist.csv"));

      for (NonCompetitor member : listOfNonCompetitors) {
        out.print(member.getName());
        out.print(";");
        out.print(member.getMemberNumber());
        out.print(";");
        out.print(member.getAge());
        out.print(";");
        out.print(member.getEmail());
        out.print(";");
        out.print(member.isMembershipPaid());
        out.print(";");
        out.print(member.isActive());
        out.print("\n");
      }

    } catch (FileNotFoundException fnfe) {
      System.err.println("Fil ikke fundet");
    }
  }


  public void saveAllCompetitorsToFile(ArrayList<Competitor> listOfCompetitors) {

    try {
      PrintStream out = new PrintStream("medlemsliste_konkurrencesvømmer.csv");

      for (Competitor competitor : listOfCompetitors) {
        out.print(competitor.getName());
        out.print(";");
        out.print(competitor.getMemberNumber());
        out.print(";");
        out.print(competitor.getGender());
        out.print(";");
        out.print(competitor.getAge());
        out.print(";");
        out.print(competitor.getEmail());
        out.print(";");
        out.print(competitor.isMembershipPaid());
        out.print("\n");
      }

    } catch (FileNotFoundException fnfe) {
      System.err.println("Fil ikke fundet");
    }
  }

  public int loadMemberNumber() {
    Integer memberNumber = 0;

    try {
      Scanner fileScanner = new Scanner(new File("medlemsnummer.txt"));
      String line = fileScanner.nextLine();
      memberNumber = Integer.parseInt(line);

    } catch (FileNotFoundException fnfe) {
      System.err.println("Fil ikke fundet");
    }
    return memberNumber;
  }

  public void saveMemberNumberToFile(Integer memberNumber) {

    try {
      PrintStream out = new PrintStream("medlemsnummer.txt");
      out.print(memberNumber);

    } catch (FileNotFoundException fnfe) {
      System.err.println("Fil ikke fundet");
    }
  }


}
