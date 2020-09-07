package names;

import java.util.Stack;

public class Basic3 {
    public static Frequencies run(int[] years, String gender) throws Exception {
        Frequencies f = new Frequencies();
        f.maxNameFreq(years, gender);
        return f;
    }
}
