package names;

import java.util.ArrayList;
import java.util.List;

public class Basic2 {
    public static List<List<String>> run(String givenName,String gender,int year){
        List<List<String>> ret = new ArrayList<List<String>>();
        int mostRecentYear = NameArray.findMaxYear();
        NameArray old = new NameArray(gender, year);
        NameArray recentMale = new NameArray("M",mostRecentYear);
        NameArray recentFemale = new NameArray("F",mostRecentYear);

        int rank = old.findRank(givenName);
        if(rank < 1){
            System.out.println("Error: Name not found in year given");
            return null;
        }
        List<List<Name>> recentMaleRanks = recentMale.rankGenerator();
        List<List<Name>> recentFemaleRanks = recentFemale.rankGenerator();

        for(Name n:recentMaleRanks.get(rank-1)){
            if(ret.size()<1){
                List<String> temp = new ArrayList<String>();
                temp.add(n.name);
                ret.add(temp);
            }
            else {
                ret.get(0).add(n.name);
            }
        }
        for(Name n:recentFemaleRanks.get(rank-1)){
            if(ret.size()<2){
                List<String> temp = new ArrayList<String>();
                temp.add(n.name);
                ret.add(temp);
            }
            else {
                ret.get(1).add(n.name);
            }
        }

        return ret;
    }

    public static void main (String[] args){
        System.out.println("Basic: Question 2");
        List<List<String>> ret = run("David","M",2000);
        System.out.println("Solution for year 2000: "+ret);
    }
}
