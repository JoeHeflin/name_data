package names;

import java.util.List;
import java.util.Stack;

public class Basic3 {
    public static Frequencies run(int[] years, String gender) throws Exception {
        Frequencies f = new Frequencies();
        f.maxNameFreq(years, gender);
        return f;
    }

    public static void main (String[] args) throws Exception {
        System.out.println("Basic: Question 3");
        NameArray.setDataPath("testdata/");
        int[] years = {3000,3004};
        //Frequencies f = new Frequencies();
        Frequencies f = run(years,"M");
        Stack<String> stack = f.names;
        int frequency = f.frequency;
        System.out.println(frequency);
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
