package Delfinen.Persistence;

import Delfinen.Member.Competitor; //TODO: Peter?
import Delfinen.Member.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

  public void saveAllNonCompetitorsToFile(ArrayList<Member> listOfNonCompetitors)  {

    try{
      PrintStream out = new PrintStream(new File("medlemsliste_motionist.csv"));

      for (Member member: listOfNonCompetitors) {
        out.print(member.getName());
        out.print(";");
        out.print(member.getMemberNumber());
        out.print(";");
        out.print(member.getAge());
        out.print(";");
        out.print(member.getEmail());
        out.print(";");
        out.print(member.isMembershipPaid());
        out.print("\n");
      }

    } catch (FileNotFoundException fnfe){
      System.err.println("Fil ikke fundet");
    }
  }


  public void saveAllCompetitorsToFile(ArrayList<Competitor> listOfCompetitors)  {

    try{
      PrintStream out = new PrintStream("medlemsliste_konkurrencesvømmer.csv");

      for (Competitor competitor: listOfCompetitors) {
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

    } catch (FileNotFoundException fnfe){
      System.err.println("Fil ikke fundet");
    }
  }

  public int loadMemberNumber(){
    Integer memberNumber = 0;

    try{
      Scanner fileScanner = new Scanner(new File ("medlemsnummer.txt"));
      String line = fileScanner.nextLine();
      memberNumber = Integer.parseInt(line);

    } catch (FileNotFoundException fnfe){
      System.err.println("Fil ikke fundet");
    }
    return memberNumber;
  }

  public void saveMemberNumberToFile(Integer memberNumber)  {

    try{
      PrintStream out = new PrintStream("medlemsnummer.txt");
      out.print(memberNumber);

    } catch (FileNotFoundException fnfe){
      System.err.println("Fil ikke fundet");
    }
  }


}
