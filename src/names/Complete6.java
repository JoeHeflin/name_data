package names;

public class Complete6 {
    public static float run(String name, String gender, int i) throws Exception {
        Main.setDataPath("testdata/");
        int lastYearInData = Main.findMaxYear();
        int[] yearRange = {lastYearInData-i+1,lastYearInData};
        float ret = Main.findAverageRank(yearRange,gender,name);
        return ret;
    }
}
