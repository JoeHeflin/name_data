package names;

import java.util.List;
import java.util.Stack;

public class Basic3 {
    public static Frequencies run(int[] years, String gender) {
        Frequencies f = new Frequencies();
        f.maxNameFreq(years, gender);
        return f;
    }

    public static void main (String[] args){
        System.out.println("Basic: Question 3");
        int[] years = {1880,2018};
        Stack<String> stack = run(years,"M").names;
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
