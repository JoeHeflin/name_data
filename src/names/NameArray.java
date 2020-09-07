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

    /**
     * @param gender of names to add to collection
     * @param yearRange start and end of the range of years to store names from, inclusive
     * @param newNameArray an array to pass that collects names after going through multiple files recursively
     * @return collection of Name objects
     */
    public List<Name> arrayGenerator(String gender, int[] yearRange, List<Name> newNameArray) throws Exception { //,int[] years)

        for (int year = yearRange[0]; year <= yearRange[1]; year++) {
            String yearString = Integer.toString(yearRange[0]);
            String fileName = Main.dataPath + FILE_PREFIX + yearString + FILE_TYPE;
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
                    e1.printStackTrace();
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
        for (Name name : nameArray) {
            if (name.name.compareTo(givenName) == 0) {
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
        for (Name name : nameArray) {
            if (name.count != prevCount) {
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
    public List<Name> topRank() throws Exception {
        this.rankGenerator();
        List<Name> ret = new ArrayList<Name>();
        for (Name name : nameArray) {
            if (name.rank == 1) {
                ret.add(name);
            }
            else if (name.rank > 1) {
                return ret;
            }
            else {
                throw new Exception("Names not ranked");
            }
        }
        return ret;
    }
}