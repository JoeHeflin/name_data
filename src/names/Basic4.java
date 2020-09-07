package names;

import java.util.List;
import java.util.Stack;

public class Basic4 {
    public static Stack<String> run(int[] years,String gender) throws Exception {
        NameArray data = new NameArray(gender,years);
        Frequencies f = new Frequencies();
        f.maxLetterFreq(data.nameArray);
        Stack<String> s = f.names;
        s.sort(String::compareTo);

        return s;

//        while(!s.empty()){
//            System.out.println(s.pop());
//        }
    }

    public static void main (String[] args) throws Exception {
//        System.out.println("Basic: Question 4");
//        int[] years = {1900,1900};
//        run(years);
    }
}
