package names;

import java.util.List;
import java.util.Stack;

public class Basic4 {
    public static void run(int[] years) throws Exception {
        NameArray data = new NameArray("F",years);
        Stack<String> s = data.maxLetterFreq();
        s.sort(String::compareTo);

        while(!s.empty()){
            System.out.println(s.pop());
        }
        //return null;
    }

    public static void main (String[] args) throws Exception {
        System.out.println("Basic: Question 4");
        int[] years = {1900,1900};
        run(years);
    }
}
