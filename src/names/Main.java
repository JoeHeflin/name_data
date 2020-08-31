package names;

import java.util.ArrayList;
import java.util.List;


public class Main {

//    public static String[] p1q1(int year){
//        String topMale;
//        String topFemale;
//
//        NameArray maleNameList = new NameArray("M",year);
//        NameArray femaleNameList = new NameArray("F",year);
//
//        topMale = maleNameList.nameArray.get(0).name; //NEEDS TO ACCOUNT FOR EMPTY LIST
//        topFemale = femaleNameList.nameArray.get(0).name;
//        return new String[]{topMale, topFemale};
//    }

//    public static int[] p1q2(int year, String gender, String letter){
//        int [] ans = {0,0};
//        List<Name> nameList = new NameArray(gender,year);
//
//        for(Name name:nameList){
//            if(Character.compare(name.name.charAt(0),letter.charAt(0))==0){
//                ans[0]++;
//                ans[1] += name.count;
//            }
//        }
//        return ans;
//    }

//    public static List<Integer> p2q1(String givenName, String gender){
//        List<Integer> ranks = new ArrayList<Integer>();
//
//        for(int year = NameArray.findMinYear(); year < NameArray.findMaxYear()+1;year++){
//            NameArray n = new NameArray(gender, year);
//            ranks.add(n.findRank(givenName));
//        }
//
//        return ranks;
//    }

//    public static List<List<String>> p2q2(String givenName,String gender,int year){
//        List<List<String>> ret = new ArrayList<List<String>>();
//        int mostRecentYear = NameArray.findMaxYear();
//        NameArray old = new NameArray(gender, year);
//        NameArray recentMale = new NameArray("M",mostRecentYear);
//        NameArray recentFemale = new NameArray("F",mostRecentYear);
//
//        int rank = old.findRank(givenName);
//        if(rank < 1){
//            System.out.println("Error: Name not found in year given");
//            return null;
//        }
//        List<List<Name>> recentMaleRanks = recentMale.rankGenerator();
//        List<List<Name>> recentFemaleRanks = recentFemale.rankGenerator();
//        //f.add();
////        ret.add(); ret.add(null);
//        for(Name n:recentMaleRanks.get(rank-1)){
//            if(ret.size()<1){
//                List<String> temp = new ArrayList<String>();
//                temp.add(n.name);
//                ret.add(temp);
//            }
//            else {
//                ret.get(0).add(n.name);
//            }
//        }
//        for(Name n:recentFemaleRanks.get(rank-1)){
//            if(ret.size()<2){
//                List<String> temp = new ArrayList<String>();
//                temp.add(n.name);
//                ret.add(temp);
//            }
//            else {
//                ret.get(1).add(n.name);
//            }
//        }
//
//        return ret;
//    }

    public static List<String> p2q3(int[] years,String gender){
        return null;
    }

    public static List<String> p2q4(int[] years){
        return null;
    }

    /**
     * Start of the program.
     */

    public static void main (String[] args) {
        List<Name>[] p1q1 = Test1.run(1900);
        int[] p2q2 = Test2.run(1900,"M","J");
        //p2q1 = p2q1; //TODO
        //p2q2 = p2q2; //TODO
        //p2q3 = p2q3; //TODO
        //p2q4 = p2q5; //TODO
    }
}