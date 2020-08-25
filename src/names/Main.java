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
    /**
     * Start of the program.
     */
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
                //gender = name_data[1];
                //System.out.println(gender+" "+gender.compareTo("M"));
                if(gender.compareTo("M") == 0){
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
    public static int q2 (String gender, String letter){
        if(letter.compareTo("M")==0){
            
        }
        return -49;
    }
    public static void main (String[] args) {
        //System.out.println("Hello world");
        int count = 0;

        System.out.println("1)"+Main.q1()+"\n"+"2)"+Main.q2("M","J"));
    }
}
