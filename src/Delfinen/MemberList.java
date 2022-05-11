package Delfinen;

import java.util.ArrayList;

public class MemberList {

  private ArrayList<Member> allMembers;
  private ArrayList<Competitor> allCompetitors;

  public MemberList(){
    allMembers = new ArrayList<>();
    allCompetitors = new ArrayList<>();
  }

  public Member findSpecifikMember(String memberEmail) {

    for (Member member: allMembers) {
      if(member.getEmail().equals(memberEmail)){
        return member;
      }
    }
    return null;
  }

  public ArrayList<Member> getAllMembers() {
    return allMembers;
  }

  public ArrayList<Competitor> getAllCompetitors() {
    return allCompetitors;
  }
}
