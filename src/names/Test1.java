package names;

import java.util.List;

public class Test1 {
    public static List<Name>[] run(int year) throws Exception {
        NameArray f = new NameArray("F", 3001);
        NameArray m = new NameArray("M", 3001);

        List<Name> fRank = f.topRank();
        List<Name> mRank = m.topRank();

        List<Name>[] ret = new List[]{mRank, fRank};
        return ret;
    }
}
