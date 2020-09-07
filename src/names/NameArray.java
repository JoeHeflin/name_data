package names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * Functions to perform on a collection of Name objects
 */
public class NameArray extends ArrayList {
    public static String dataPath = "testdata/";
    public static final String FILE_PREFIX = "yob";
    public static final String FILE_TYPE = ".txt";
    public List<Name> nameArray;

    public NameArray(int year) throws Exception {
        int[] yearRange = {year,year};
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator("N", yearRange, array);
    }

    public NameArray(String gender, int year) throws Exception {
        int[] yearRange = {year,year};
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator(gender, yearRange, array);
    }

    public NameArray(String gender, int[] yearRange) throws Exception {
        List<Name> array = new ArrayList<Name>();
        nameArray = arrayGenerator(gender, yearRange, array);
    }

    public static void setDataPath(String path){
        dataPath = path;
    }
    /**
     * @param gender of names to add to collection
     * @param yearRange start and end of the range of years to store names from, inclusive
     * @param newNameArray an array to pass that collects names after going through multiple files recursively
     * @return collection of Name objects
     */
    public List<Name> arrayGenerator(String gender, int[] yearRange, List<Name> newNameArray) throws Exception { //,int[] years)

        for(int year = yearRange[0];year<=yearRange[1];year++) {
            String yearString = Integer.toString(yearRange[0]);

            String fileName = dataPath + FILE_PREFIX + yearString + FILE_TYPE;
            try {
                URL url = new URL(fileName);

                InputStreamReader stream = new InputStreamReader(url.openStream());

                BufferedReader br = new BufferedReader(stream);
                String line;
                while ((line = br.readLine()) != null) {
                    Name n = new Name(line);
                    if (n.gender.compareTo(gender) == 0 || gender.compareTo("N") == 0) {
                        newNameArray.add(n);
                    }
                }
            } catch (Exception e) {
                try {
                    File localStream = new File(fileName);
                    BufferedReader br = new BufferedReader(new FileReader(localStream));
                    String line;
                    while ((line = br.readLine()) != null) {
                        Name n = new Name(line);
                        if (n.gender.compareTo(gender) == 0 || gender.compareTo("N") == 0) {
                            newNameArray.add(n);
                        }
                    }
                } catch (Exception e1) {
                    throw new Exception("Invalid dataPath: " + fileName + ", see README.md");
                }
            }
        }
        return newNameArray;
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

    public static int findMaxYear() {
        int max = 0;
        try {
            URL url = new URL(dataPath);

            InputStreamReader stream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(stream);
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains("yob")) {
                    line = line.replaceAll("(.*?)yob", "");
                    line = line.replaceAll("\\.txt(.*)", "");

                    int year = Integer.parseInt(line);

                    if (year > max) {
                        max = year;
                    }
                }
            }
        } catch (Exception e) {
            try {
                File dir = new File(dataPath);
                File[] files = dir.listFiles();
                for (File file : files) {
                    String name = file.getName();
                    name = name.replaceAll("[^\\d]", "");
                    int year = Integer.parseInt(name);
                    if (year > max) {
                        max = year;
                    }
                }

            } catch (Exception e1) {
                e.printStackTrace();
            }
        }
        return max;
    }

    /**
     * @return earliest year in data set
     */
    public static int findMinYear() throws Exception {
        int min = -1;

        try{
            URL url = new URL(dataPath);

            InputStreamReader stream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(stream);
            String line;

            while((line = br.readLine()) != null){
                if(line.contains("yob")) {
                    line = line.replaceAll("(.*?)yob", "");
                    line = line.replaceAll("\\.txt(.*)", "");

                    int year = Integer.parseInt(line);

                    if(year < min || year < 0){
                        min = year;
                    }
                }
            }
        } catch(Exception e){
            try {
                File dir = new File(dataPath);
                File[] files = dir.listFiles();
                for(File file:files) {
                    String name = file.getName();
                    name = name.replaceAll("[^\\d]","");
                    int year = Integer.parseInt(name);
                    if(year < min || min < 0){
                        min = year;
                    }
                }

            } catch (Exception e1) { e.printStackTrace();}
        }
        return min;
    }

    /**
     * @return a collection of names beginning with the most common letter in collection
     */
//    public Stack<String> maxLetterFreq(){
//        int max = 0;
//        Character maxC = 'z';
//
//        HashMap<Character, Stack<String>> letter2names = new HashMap<>();
//        HashMap<Character, Integer> letter2count = new HashMap<>();
//
//        for(Name name:nameArray){
//
//            letter2names.putIfAbsent(name.name.charAt(0),new Stack<>());
//            letter2count.putIfAbsent(name.name.charAt(0),0);
//
//            int currentCount = letter2count.get(name.name.charAt(0))+name.count;
//            letter2count.put(name.name.charAt(0), currentCount);
//
//            Stack<String> stack = letter2names.get(name.name.charAt(0));
//            if(!stack.contains(name.name)){
//                stack.push(name.name);
//            }
//        }
//        for(Character c:letter2count.keySet()){
//            int total = letter2count.get(c);
//
//            if(total >= max){
//                if(total > max || c < maxC){
//                    maxC = c;
//                }
//                max = total;
//            }
//        }
//        return letter2names.get(maxC);
//    }
}