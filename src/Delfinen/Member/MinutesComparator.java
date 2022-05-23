package Delfinen.Member;

import java.util.Comparator;

public class MinutesComparator extends Top5ListTrainingComparator implements Comparator<Competitor> {


  @Override
  public int compare(Competitor o1, Competitor o2) {
    Integer minutesO1 = o1.getBestResultTraining().getPersonalBestTrainingTimeMinutes();
    Integer minutesO2 = o2.getBestResultTraining().getPersonalBestTrainingTimeMinutes();

    return minutesO1.compareTo(minutesO2);

  }
}
