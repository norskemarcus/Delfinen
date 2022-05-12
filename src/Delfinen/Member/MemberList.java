package Delfinen.Member;

import java.util.ArrayList;

public class MemberList {

  private final ArrayList<Member> allNonCompetitors;
  private final ArrayList<Competitor> allCompetitors;

  public MemberList(){
    allNonCompetitors = new ArrayList<>();
    allCompetitors = new ArrayList<>();
  }

  public ArrayList<Member> findSpecifikMembersByEmail(String memberEmail) {

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

  public ArrayList<Member> findSpecifikMembersByName(String memberName) {
    ArrayList<Member> foundMembers = new ArrayList<>();

    for (Member member : allNonCompetitors) {
      if (member.getName().contains(memberName)) {
        foundMembers.add(member);
      }
    }
    for (Member member : allCompetitors) {
      if (member.getName().contains(memberName)) {
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
