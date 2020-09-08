package names;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    public static final String LOCAL_TEST_DATA = "testdata/";
    public static final String REMOTE_TEST_DATA =
            "https://www2.cs.duke.edu/courses/compsci307d/fall20/assign/01_data/data/ssa_complete/";

    private static String dataPath = "testdata/";

    public static void setDataPath(String path){
        dataPath = path;
    }

    public static String getDataPath() {
        return dataPath;
    }

    /**
     * @return most recent year in data set
     */
    public static int findMaxYear() throws Exception {
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
                throw new Exception("Invalid data path: "+dataPath);
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

            while ((line = br.readLine()) != null) {
                if (line.contains("yob")) {
                    line = line.replaceAll("(.*?)yob", "");
                    line = line.replaceAll("\\.txt(.*)", "");

                    int year = Integer.parseInt(line);

                    if (year < min || year < 0){
                        min = year;
                    }
                }
            }
        } catch(Exception e){
            try {
                File dir = new File(dataPath);
                File[] files = dir.listFiles();
                for (File file : files) {
                    String name = file.getName();
                    name = name.replaceAll("[^\\d]","");
                    int year = Integer.parseInt(name);
                    if (year < min || min < 0) {
                        min = year;
                    }
                }

            } catch (Exception e1) {
                throw new Exception("Invalid data path: " + dataPath);
            }
        }
        return min;
    }

    public static float findAverageRank(int[] years, String gender, String name) throws Exception {
        float totalRank = 0;

        if (years[1] < years[0]) {
            throw new Exception("Invalid Year Range");
        }

        for (int year = years[0]; year <= years[1]; year++) {
            NameArray n = new NameArray(gender,year);
            int rank;
            try {
                rank = n.findRank(name);
            } catch (Exception e) {
                rank = n.getNameArray().size() + 1;
            }
            totalRank += rank;
        }
        float avgRank = totalRank / (years[1] - years[0] + 1);

        return avgRank;
    }

    /**
     * Start of the program.
     */
    public static void main (String[] args) throws Exception {
        setDataPath("data/ssa_complete/");
        System.out.println("Test Implementation:");
        System.out.println("1. In the year 1999, what is the top ranked name for each gender (M and F)? Answer: "
                + Test1.run(1999));
        System.out.println("2. In the year 1899, how many male names start with J and how many total babies were" +
                " given those names? Answer: " + Test2.run(1999,"M","J"));
        System.out.println("Basic Implementation:");
        System.out.println("1. What are all rankings of males named Joseph in the data set? Answer: " +
                Basic1.ranksInDataset("Joseph","M"));
        System.out.println("2. What name/gender pair has the same rank as Joseph/M in 1999 in the most recent " +
                "year in the data set? Answer: " + Basic2.findNamesOfEqualRank("Joseph","M", 1999));
        int[] yearsLarge = {1900, 2000};
        System.out.println("3. From 1900 to 2000, what female name(s) were ranked as the years' most popular female " +
                "name the most often and how many years did they have the top rank? Answer: " +
                Basic3.findMostTopRanks(yearsLarge, "F"));
        System.out.println("4. What was the most popular letter that girls? names started with from 1900 to 2000?" +
                " Answer: " + Basic4.findNamesWithMostCommonLetter(yearsLarge, "F"));
        System.out.println("Complete Implementation:");
        System.out.println("1. What are the rankings of the female name Darby from 1900 to 2000? Answer: " +
                Complete1.ranksInRange("Darby","F",yearsLarge));
        System.out.println("2. What is the difference in the ranking of males named Joseph from 1900 to 2000? Answer: " +
                Complete2.rankDiff("M","Joseph",yearsLarge));
        System.out.println("3. What male name's rank changed the most from 1900 to 2000? Answer: " +
                Complete3.maxRankDiff(yearsLarge,"M"));
        System.out.println("4. What is the average rank of the male name Joseph from 1900 to 2000? Answer: "
                + Complete4.avgRank("Joseph","M",yearsLarge));
        int[] yearsSmall = {1995,2005};
        System.out.println("5. What female name has the highest average rank from 1995 to 2005? Answer: " +
                Complete5.maxAvgRank(yearsSmall,"F"));
        System.out.println("6. What is the average rank of the male name Joseph over the last 10 years? Answer: " +
                Complete6.mostRecentAvgRank("Joseph","M",10));
        System.out.println("7. What female name(s) held 100th place each year from 1995 to 2005? Answer: " +
                Complete7.namesAtRank(yearsSmall,"F",100));
        Complete8.mostCommonAtRank(yearsLarge,"M",2);
        System.out.println("8. What male name(s) held 2nd place most often from 1900 to 2000 and how often were they" +
                "in 2nd place? Answer: " + Complete8.getNames() + ", " + Complete8.getCount());

    }
}