package Delfinen.Member;

import java.util.Comparator;

public class SecondsComparator extends Top5ListTrainingComparator implements Comparator<Competitor> {


  @Override
  public int compare(Competitor o1, Competitor o2) {
    Integer secondsO1 = o1.getBestResultTraining().getPersonalBestTrainingTimeSeconds();
    Integer secondsO2 = o2.getBestResultTraining().getPersonalBestTrainingTimeSeconds();

    return secondsO1.compareTo(secondsO2);

  }


}
