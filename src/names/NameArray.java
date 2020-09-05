package names;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Functions to perform on a collection of Name objects
 */
public class NameArray extends ArrayList{
    public List<Name> nameArray;

    public NameArray(){
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


    /**
     * @param gender of names to add to collection
     * @param yearRange start and end of the range of years to store names from, inclusive
     * @param newNameArray an array to pass that collects names after going through multiple files recursively
     * @return collection of Name objects
     */
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

    /**
     * @param givenName to find rank of
     * @return the rank of the name given
     */
    public int findRank(String givenName) throws Exception {
        this.rankGenerator();
        boolean breaker = false;
        for(Name name: nameArray){
            if(name.name.compareTo(givenName)==0){
                return name.rank;
            }
        }
        throw new Exception("Name not found");
    }

    /**
     * Assigns a rank to every name in collection according to count descending
     */
    public void rankGenerator(){
        int prevCount = -1;
        int rank = -1;

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
    }

    /**
     * @return The most common name(s) from the collection
     */
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

    /**
     * @return most recent year in data set
     */
    public static int findMaxYear(){
        int max = 0;
        for(int fileName = 0;fileName<2026;fileName++) {
            try {
                Path path = Paths.get(Main.class.getClassLoader().getResource("yob" + fileName + ".txt").toURI());
                max = fileName;
            } catch (Exception e) {}
        }
        return max;
    }

    /**
     * @return earliest year in data set
     */
    public static int findMinYear() throws Exception {
        int min = 0;
        for (int fileName = 0; fileName < 2026; fileName++) {
            try {
                Path path = Paths.get(Main.class.getClassLoader().getResource("yob" + fileName + ".txt").toURI());
                min = fileName;
                return min;
            } catch (Exception e) {}
        }
        throw new Exception("No valid year found");
    }

    /**
     * @return a collection of names beginning with the most common letter in collection
     */
    public  Stack<String> maxLetterFreq(){
        int max = 0;
        Character maxC = 'z';

        HashMap<Character, Stack<String>> letter2names = new HashMap<>();
        HashMap<Character, Integer> letter2count = new HashMap<>();

        for(Name name:nameArray){

            letter2names.putIfAbsent(name.name.charAt(0),new Stack<>());
            letter2count.putIfAbsent(name.name.charAt(0),0);

            int currentCount = letter2count.get(name.name.charAt(0))+name.count;
            letter2count.put(name.name.charAt(0), currentCount);

            Stack<String> stack = letter2names.get(name.name.charAt(0));
            if(!stack.contains(name.name)){
                stack.push(name.name);
            }
        }
        for(Character c:letter2count.keySet()){
            int total = letter2count.get(c);

            if(total >= max){
                if(total > max || c < maxC){
                    maxC = c;
                }
                max = total;
            }
        }
        return letter2names.get(maxC);
    }
}