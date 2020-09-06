package names;

public class Main {

    public static String LOCAL_TEST_DATA = "testdata/";
    public static String REMOTE_TEST_DATA = "https://www2.cs.duke.edu/courses/compsci307d/fall20/assign/01_data/data/ssa_complete/";
    /**
     * Start of the program.
     */

    public static void main (String[] args) {

    }

    public static int findAverageRank(int[] years, String gender, String name) throws Exception {
        int totalRank = 0;

        if(years[1]<years[0]){
            throw new Exception("Invalid Year Range");
        }

        for(int year = years[0]; year <= years[1]; year++){
            NameArray n = new NameArray(gender,year);
            int rank = n.findRank(name);
            totalRank += rank;
        }
        int avgRank = totalRank/(years[1]-years[0]+1);

        return avgRank;
    }
}