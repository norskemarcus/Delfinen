package Delfinen.Member;

import java.util.ArrayList;

public class MemberList {

  private ArrayList<Member> allNonCompetitors;
  private ArrayList<Competitor> allCompetitors;

  public MemberList(){
    allNonCompetitors = new ArrayList<>();
    allCompetitors = new ArrayList<>();
  }

  public ArrayList<Member> findSpecifikMembersByMail(String memberEmail) {

    ArrayList<Member> foundMembers = new ArrayList<>();

    for (Member member : allNonCompetitors) {
      if (member.getEmail().contains(memberEmail)) {
        foundMembers.add(member);
      }
    }

    for (Member member : allCompetitors) {
      if (member.getEmail().contains(memberEmail)) {
        foundMembers.add(member);
      }
    }
    return foundMembers;
  }

  public ArrayList<Member> getAllNonCompetitors() {
    return allNonCompetitors;
  }

  public ArrayList<Competitor> getAllCompetitors() {
    return allCompetitors;
  }
}
