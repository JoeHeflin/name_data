package names;

public class Complete6 {
    public static float run(String name, String gender, int i) throws Exception {
        NameArray.setDataPath("testdata/");
        int lastYearInData = NameArray.findMaxYear();
        int[] yearRange = {lastYearInData-i+1,lastYearInData};
        float ret = Main.findAverageRank(yearRange,gender,name);
        return ret;
    }
}
