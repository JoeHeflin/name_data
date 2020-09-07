package names;

import java.util.ArrayList;
import java.util.List;


/**
 * This method sucks
 */
public class Complete7 {
    public static List<String> run(int[] years, String gender, int rank) throws Exception {
        List<String> ret = new ArrayList<>();
        for(int year = years[0]; year<=years[1];year++){
            List<String> namesPerYearList = new ArrayList<>();
            NameArray n = new NameArray(gender,year);
            n.rankGenerator();
            for(Name name:n.nameArray){
                if(name.rank == rank){
                    namesPerYearList.add(name.name);
                }
            }
            namesPerYearList.sort(String::compareTo);
            String namesPerYearString = namesPerYearList.get(0);
            if(namesPerYearList.size()>1) {
                for (String name : namesPerYearList.subList(1, namesPerYearList.size())) {
                    namesPerYearString = namesPerYearString + ", " + name;

                }
            }
            ret.add(namesPerYearString);
        }
        return ret;
    }
}
