
public class Listxx implements Comparable{
    String t1;
    String t2;
    double score;

    public Listxx(String t1, String t2, double score) {
        this.t1 = t1;
        this.t2 = t2;
        this.score = score;
    }

    @Override
    public int compareTo(Object zz) {
        Listxx aa=(Listxx) zz;
        if(score< aa.score)
        {
            return -1;
        }
        else
            return 1;
    }




}
