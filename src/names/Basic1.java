package names;

import java.util.ArrayList;
import java.util.List;

public class Basic1 {
    public static List<Integer> run(String givenName, String gender){
        List<Integer> ranks = new ArrayList<Integer>();

        for(int year = NameArray.findMinYear(); year < NameArray.findMaxYear()+1;year++){
            NameArray n = new NameArray(gender, year);
            ranks.add(n.findRank(givenName));
        }

        return ranks;
    }

    public static void main (String[] args){
        System.out.println("Basic: Question 1");
        List<Integer> ret = run("David","M");
        System.out.println("Solution: "+ret);
    }
}
