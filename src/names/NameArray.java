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
public class NameArray { //extends ArrayList { // why extend???
    public static final String FILE_PREFIX = "yob";
    public static final String FILE_TYPE = ".txt";
    private List<Name> nameArray;

    public List<Name> getNameArray() {
        return nameArray;
    }

    public NameArray(int year) throws Exception {
        this("N", year);
    }

    public NameArray(String gender, int year) throws Exception {
        this(gender, new int[]{year, year});
    }

    public NameArray(String gender, int[] yearRange) throws Exception {
        List<Name> newNameArray = new ArrayList<>();

        for (int year = yearRange[0]; year <= yearRange[1]; year++) {
            String yearString = Integer.toString(yearRange[0]);
            String fileName = Main.getDataPath() + FILE_PREFIX + yearString + FILE_TYPE;
            // try to connect to url using given datapath
            try {
                URL url = new URL(fileName);
                InputStreamReader stream = new InputStreamReader(url.openStream());
                BufferedReader br = new BufferedReader(stream);
                String line;
                // create a new Name object for every name in the file
                while ((line = br.readLine()) != null) {
                    Name n = new Name(line);
                    // only add to new array if correct gender
                    if (n.getGender().compareTo(gender) == 0 || gender.compareTo("N") == 0) {
                        newNameArray.add(n);
                    }
                }
            } catch (Exception e) {
                // if url connection fails assume its a local file path
                try {
                    File localStream = new File(fileName);
                    BufferedReader br = new BufferedReader(new FileReader(localStream));
                    String line;
                    // create a new Name object for every name in the file
                    while ((line = br.readLine()) != null) {
                        Name n = new Name(line);
                        // only add to new array if correct gender
                        if (n.getGender().compareTo(gender) == 0 || gender.compareTo("N") == 0) {
                            newNameArray.add(n);
                        }
                    }
                } catch (Exception e1) {
                    throw new Exception("Invalid dataPath: " + fileName + ", see README.md");
                }
            }
        }
        nameArray = newNameArray;
    }

   // @Override
    public Name get(int index) {
        return nameArray.get(index);
    }

    /**
     * @param givenName to find rank of
     * @return the rank of the name given
     */
    public int findRank(String givenName) {
        // add valid rank values to names in nameArray
        this.rankGenerator();
        for (Name name : nameArray) {
            // find rank of the name in nameArray
            if (name.getName().compareTo(givenName) == 0) {
                return name.getRank();
            }
        }
        return nameArray.size() + 1;
        //throw new Exception("Name not found");
    }

    /**
     * Assigns a rank to every name in collection according to count descending
     */
    public void rankGenerator(){
        int prevCount = -1;
        int rank = -1;
        Collections.sort(nameArray, new SortByCount());
        int i = 1; // DON'T USE i
        for (Name name : nameArray) {
            if (name.getCount() != prevCount) {
                prevCount = name.getCount();
                rank = i;
            }
            name.setRank(rank);
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
            if (name.getRank() == 1) {
                ret.add(name);
            }
            else if (name.getRank() > 1) {
                return ret;
            }
            else {
                throw new Exception("Names not ranked");
            }
        }
        return ret;
    }
}