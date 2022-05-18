package Delfinen;

//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

import Delfinen.Member.Competitor;
import Delfinen.Member.MemberList;
import Delfinen.Member.NonCompetitor;
import Delfinen.Member.SwimmingDisciplins;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CompetitorTest {

  @Test
  void createNewMember(){
    //arrange
    Competitor sebastian = new Competitor("Sebastian", 20220001, 19, "seb@gmail.com", true, "M", SwimmingDisciplins.CRAWL);
    MemberList memberList = new MemberList();
    //act
    //memberList.getAllNonCompetitors().add(sebastian);
    memberList.getAllCompetitors().add(sebastian);
    //assert
    assertTrue(memberList.getAllNonCompetitors().size() == 1);
    assertTrue(memberList.getAllCompetitors().size() == 1);
  }

}