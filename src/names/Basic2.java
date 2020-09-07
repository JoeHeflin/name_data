package names;

import java.util.ArrayList;
import java.util.List;

public class Basic2 {
    public static List<List<String>> run(String givenName,String gender,int year) throws Exception {
        List<List<String>> ret = new ArrayList<List<String>>();
        int mostRecentYear = Main.findMaxYear();
        NameArray old = new NameArray(gender, year);
        NameArray recentMale = new NameArray("M",mostRecentYear);
        NameArray recentFemale = new NameArray("F",mostRecentYear);

        recentMale.rankGenerator();
        recentFemale.rankGenerator();

        int rank = old.findRank(givenName);
        if(rank < 1){
            System.out.println("Error: Name not found in year given");
            return null;
        }

        for(Name n: recentMale.nameArray){
            if(n.rank == rank) {
                if (ret.size() < 1) {
                    List<String> temp = new ArrayList<String>();
                    temp.add(n.name);
                    ret.add(temp);
                } else {
                    ret.get(0).add(n.name);
                }
            }
        }
        for(Name n: recentFemale.nameArray){
            if(n.rank == rank) {
                if (ret.size() < 2) {
                    List<String> temp = new ArrayList<String>();
                    temp.add(n.name);
                    ret.add(temp);
                } else {
                    ret.get(1).add(n.name);
                }
            }
        }

        return ret;
    }

    public static List<String> run(String givenName,String gender,int year,int mostRecentYear) throws Exception {
        List<String> ret = new ArrayList<String>();
        NameArray old = new NameArray(gender, year);
        NameArray recentMale = new NameArray("M",mostRecentYear);
        NameArray recentFemale = new NameArray("F",mostRecentYear);

        recentMale.rankGenerator();
        recentFemale.rankGenerator();

        int rank = old.findRank(givenName);
        if(rank < 1){
            System.out.println("Error: Name not found in year given");
            return null;
        }

        for(Name n: recentMale.nameArray){
            if(n.rank == rank) {
                ret.add(n.name + ", " + n.gender);
            }
        }

        for(Name n: recentFemale.nameArray){
            if(n.rank == rank) {
                ret.add(n.name + ", " + n.gender);
            }
        }
        return ret;
    }

    public static void main (String[] args) throws Exception {
        System.out.println("Basic: Question 2");
        List<List<String>> ret = run("David","M",2000);
        System.out.println("Solution for year 2000: "+ret);
    }
}
