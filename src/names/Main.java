package names;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main {
    public static final String NAME_FILE = "yob1900.txt";
    private static int male_index = -1;

    public static String q1 (){
        String[] name_data;
        String gender;
        String female_name;
        String male_name;

        try{
            Path path = Paths.get(Main.class.getClassLoader().getResource(NAME_FILE).toURI());
            List<String> lines = Files.readAllLines(path);
            female_name = lines.get(0).split(",")[0];
            for(String line : lines){
                gender = line.split(",")[1];
                if(gender.compareTo("M") == 0){
                    male_index = lines.indexOf(line);
                    male_name = line.split(",")[0];
                    return female_name + ", " + male_name;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static int[] q2 (String gender, String letter){
        String name;
        int [] ans = {0,0};

        try{
            Path path = Paths.get(Main.class.getClassLoader().getResource(NAME_FILE).toURI());
            List<String> lines = Files.readAllLines(path);

        if(gender.compareTo("M")==0){
            for(String line : lines.subList(male_index,lines.size())){
                name = line.split(",")[0];
                if(Character.compare(name.charAt(0),letter.charAt(0))==0){
                    ans[0]++;
                    ans[1] += Integer.parseInt(line.split(",")[2]);
                }
            }

            return ans;
        }
        else{
            for(String line : lines.subList(0,male_index)){
                name = line.split(",")[0];
                if(Character.compare(name.charAt(0),letter.charAt(0))==0){
                    ans[0]++;
                    ans[1] += Integer.parseInt(line.split(",")[2]);
                }
            }

            return ans;
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    /**
     * Start of the program.
     */
    public static void main (String[] args) {
        //System.out.println("Hello world");
        String first_letter = "J";
        int count = 0;
        String q1 = Main.q1();
        int[] q2 = Main.q2("M",first_letter);
        System.out.println("1)"+q1+"\n"+"2)"+"There are "+q2[1]+" different people of this gender that have one of "+q2[0]+" names beginning with "+first_letter);
    }
}