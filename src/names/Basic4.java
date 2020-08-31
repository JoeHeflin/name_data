package names;

import java.util.List;
import java.util.Stack;

public class Basic4 {
    public static void run(int[] years){
        NameArray data = new NameArray("F",years);
        Stack<String> s = data.maxLetterFreq();
        s.sort(String::compareTo);

        while(!s.empty()){
            System.out.println(s.pop());
        }
        //return null;
    }

    public static void main (String[] args){
        System.out.println("Basic: Question 4");
        int[] years = {1880,2018};
        run(years);
    }
}
