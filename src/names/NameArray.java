package names;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameArray extends ArrayList{
    public List<Name> nameArray;// = new ArrayList<Name>();

    /*
    [firstYear,lastYear]
     */

    public NameArray(){
        //int[] ret = {year};
        String gender = "N";
        int[] yearRange = {1900,1900};
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator(gender, yearRange, array);
    }

    public NameArray(String gender){
        int[] yearRange = {1900,1900};
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator(gender, yearRange, array);
    }

    public NameArray(int year){
        int[] yearRange = {year,year};
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator("N", yearRange, array);
    }

    public NameArray(String gender, int year){
        int[] yearRange = {year,year};
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator(gender, yearRange, array);
    }

    public NameArray(String gender, int[] yearRange){
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator(gender, yearRange, array);
    }

    public List<Name> arrayGenerator(String gender, int[] yearRange, List<Name> newNameArray){ //,int[] years)

        if(yearRange[0] == yearRange[1]+1){
            return newNameArray;
        }

        String fileName = Integer.toString(yearRange[0]);

        try{
            Path path = Paths.get(Main.class.getClassLoader().getResource("yob"+fileName+".txt").toURI());
            List<String> lines = Files.readAllLines(path);
            for(String line: lines){
                Name n = new Name(line);
                if(n.gender.compareTo(gender)==0 || n.gender.compareTo("N")==0){
                    newNameArray.add(n);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        yearRange[0]+=1;
        return arrayGenerator(gender, yearRange, newNameArray);
    }

    @Override
    public Name get(int index) {
        return nameArray.get(index);
    }

    public int findRank(String givenName){
        this.rankGenerator();
        boolean breaker = false;
        for(Name name: nameArray){
            if(name.name.compareTo(givenName)==0){
                return name.rank;
            }
        }
        return -1;
    }

    public void rankGenerator(){
        int prevCount = -1;
        int rank = -1;

        //List<List<Name>> ranks = new ArrayList<List<Name>>();

        Collections.sort(nameArray, new SortByCount());

        int i = 1;
        for (Name name: nameArray){
            if(name.count != prevCount) {
                prevCount = name.count;
                rank = i;
            }
            name.rank = rank;
            i++;
        }
        //return ranks;
    }

    public List<Name> topRank(){
        this.rankGenerator();
        List<Name> ret = new ArrayList<Name>();
        for(Name name: nameArray){
            if(name.rank == 1){
                ret.add(name);
            }
            else if(name.rank > 1){
                return ret;
            }
            else{
                System.out.println("SOMETHING UNEXPECTED HAPPENED");
            }
        }
        return ret;
    }

    public static int findMaxYear(){
        int max = 0;
        for(int fileName = 0;fileName<2026;fileName++) {
            try {
                Path path = Paths.get(Main.class.getClassLoader().getResource("yob" + fileName + ".txt").toURI());
                max = fileName;
            } catch (Exception e) {

            }
        }
        return max;
    }

    public static int findMinYear() {
        int min = 0;
        for (int fileName = 0; fileName < 2026; fileName++) {
            try {
                Path path = Paths.get(Main.class.getClassLoader().getResource("yob" + fileName + ".txt").toURI());
                min = fileName;
                return min;
            } catch (Exception e) {

            }
        }
        return -1;
    }
}
