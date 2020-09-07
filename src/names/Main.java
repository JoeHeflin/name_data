package names;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    public static String LOCAL_TEST_DATA = "testdata/";
    public static String REMOTE_TEST_DATA = "https://www2.cs.duke.edu/courses/compsci307d/fall20/assign/01_data/data/ssa_complete/";

    public static String dataPath = "testdata/";

    /**
     * Start of the program.
     */

    public static void main (String[] args) {

    }

    public static void setDataPath(String path){
        dataPath = path;
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


    public static float findAverageRank(int[] years, String gender, String name) throws Exception {
        float totalRank = 0;

        if(years[1]<years[0]){
            throw new Exception("Invalid Year Range");
        }

        for(int year = years[0]; year <= years[1]; year++){
            NameArray n = new NameArray(gender,year);
            int rank = n.findRank(name);
            totalRank += rank;
        }
        float avgRank = totalRank/(years[1]-years[0]+1);

        return avgRank;
    }
}