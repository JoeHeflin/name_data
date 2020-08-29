package names;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static List<Name> arrayGenerator(){
        //int[] ret = {year};
        return arrayGenerator("N");
    }

    public static List<Name> arrayGenerator(String gender){
        List<Integer> ret = new ArrayList<Integer>(1900);
        return arrayGenerator(gender, ret);
    }

    public static List<Name> arrayGenerator(String gender, int year){
        List<Integer> ret = new ArrayList<Integer>(year);
        return arrayGenerator(gender, ret);
    }

    public static List<Name> arrayGenerator(String gender, List<Integer> years){
        List<Name> ret = new ArrayList<Name>();
        return arrayGenerator(gender, years, ret);
    }

    public static List<Name> arrayGenerator(String gender, List<Integer> years, List<Name> nameArray){ //,int[] years)

        if(years.size() == 0){
            return nameArray;
        }

        String fileName = Integer.toString(years.get(0));

        try{
            Path path = Paths.get(Main.class.getClassLoader().getResource("yob"+fileName+".txt").toURI());
            List<String> lines = Files.readAllLines(path);
            for(String line: lines){
                Name n = new Name(line);
                if(n.gender.compareTo(gender)==0){
                    nameArray.add(n);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        years.remove(0);
        return arrayGenerator(gender, years, nameArray);
    }

    public static List<List<Name>> rankGenerator(List<Name> names){
        int prevCount = -1;

        List <Name> sameRank = new ArrayList<Name>();
        List<List<Name>> ranks = new ArrayList<List<Name>>();

        for (Name name: names){
            if(name.count != prevCount) {
                ranks.add(sameRank);
                sameRank.clear();
                prevCount = name.count;
            }
            sameRank.add(name);
        }
        return ranks;
    }

    public static String[] p1q1(){
        String topMale;
        String topFemale;

        List<Name> maleNameList = arrayGenerator("M");
        List<Name> femaleNameList = arrayGenerator("F");

        topMale = maleNameList.get(0).name;
        topFemale = femaleNameList.get(0).name;
        return new String[]{topMale, topFemale};
    }

    public static int[] p1q2(String gender, String letter){
        int [] ans = {0,0};
        List<Name> nameList = arrayGenerator(gender);

        for(Name name:nameList){
            if(Character.compare(name.name.charAt(0),letter.charAt(0))==0){
                ans[0]++;
                ans[1] += name.count;
            }
        }

        return ans;
    }

    /**
     * Start of the program.
     */

    public static void main (String[] args) {
        String[] p1q1 = p1q1();
        int[] p2q2 = p1q2("M","J");
        //p2q3 = p2q3; //TODO
        //p2q4 = p2q4; //TODO
        //p2q5 = p2q5; //TODO
        //p2q6 = p2q6; //TODO
    }
}