package names;

public class Complete4 {
    public static int run(String name, String gender, int[] years) throws Exception {
        int ret = Main.findAverageRank(years,gender,name);
        return ret;
    }
}
