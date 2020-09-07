package names;

public class Complete2 {
    public static int run(String gender, String name, int[] years) throws Exception{
        NameArray oldYearData = new NameArray(gender, years[0]);
        NameArray newYearData = new NameArray(gender, years[1]);

        int oldRank = oldYearData.findRank(name);
        int newRank = newYearData.findRank(name);
        return oldRank-newRank;
    }
}
