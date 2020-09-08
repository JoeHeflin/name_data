package names;

import java.util.Comparator;

public class SortByCount implements Comparator<Name> {
    public int compare(Name a, Name b){
        return b.getCount() - a.getCount();
    }
}
