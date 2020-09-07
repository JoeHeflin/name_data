package names;

public class Complete4 {
    public static float run(String name, String gender, int[] years) throws Exception {
        float ret = Main.findAverageRank(years,gender,name);
        return ret;
    }
}
