package names;

import java.util.List;

public class Test1 {
    public static List<Name>[] run(int year) throws Exception {
        NameArray f = new NameArray("F", 3001);
        NameArray m = new NameArray("M", 3001);

        List<Name> fRank = f.topRank();
        List<Name> mRank = m.topRank();

        List<Name>[] ret = new List[]{mRank, fRank};;
        return ret;
    }

    public static void main (String[] args) throws Exception {
        System.out.println("Test: Question 1");
        List<Name>[] ret = run(2000);
        System.out.println("Solution for year 2000: "+ret);
    }
}
