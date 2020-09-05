package names;

import java.util.ArrayList;
import java.util.List;

public class Basic1 {
    public static List<Integer> run(String givenName, String gender) throws Exception {
        List<Integer> ranks = new ArrayList<Integer>();

        for(int year = NameArray.findMinYear(); year < NameArray.findMaxYear()+1;year++){
            NameArray n = new NameArray(gender, year);
            try {
                ranks.add(n.findRank(givenName));
            } catch (Exception e){
                ranks.add(-1);
            }
        }

        return ranks;
    }

    public static void main (String[] args) throws Exception {
        System.out.println("Basic: Question 1");
        List<Integer> ret = run("David","M");
        System.out.println("Solution: "+ret);
    }
}
