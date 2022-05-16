package Delfinen.Coach;

public abstract class Activity {
  
  protected int resultMin;
  protected int resultSec;
  protected String disciplin;

  public Activity(int resultMin, int resultSec, String disciplin) {
    this.resultMin = resultMin;
    this.resultSec = resultSec;
    this.disciplin = disciplin;
  }
}
