package Delfinen.Member;

import java.util.Comparator;

public class MemberNumberComparator implements Comparator<Competitor> {

  @Override
  public int compare(Competitor o1, Competitor o2) {
   return o1.getMemberNumber() - o2.getMemberNumber();
  }
}
