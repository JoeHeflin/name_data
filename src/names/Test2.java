package names;

import java.util.List;

public class Test2 {
    public static int[] run(int year, String gender, String letter){
        int [] ans = {0,0};
        NameArray nameList = new NameArray(gender,year);

        for(Name name:nameList.nameArray){
            if(Character.compare(name.name.charAt(0),letter.charAt(0))==0){
                ans[0]++;
                ans[1] += name.count;
            }
        }
        return ans;    }

    public static void main (String[] args){
        System.out.println("Test: Question 2");
        int[] ret = run(2000,"F","M");
        System.out.println("Solution for year 2000: "+ret);
    }
}
