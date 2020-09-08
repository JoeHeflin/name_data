package names;

public class Test2 {
    public static int[] run(int year, String gender, String letter) throws Exception {
        int [] ans = {0,0};
        NameArray nameList = new NameArray(gender,year);

        for (Name name : nameList.getNameArray()) {
            if(Character.compare(name.getName().charAt(0),letter.charAt(0)) == 0) {
                ans[0]++;
                ans[1] += name.getCount();
            }
        }
        return ans;
    }
}
