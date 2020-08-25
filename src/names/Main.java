package names;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main {
    public static final String NAME_FILE = "yob1900.txt";
    /**
     * Start of the program.
     */
    public static void main (String[] args) {
        //System.out.println("Hello world");
        int count = 0;
        try{
            Path path = Paths.get(Main.class.getClassLoader().getResource(NAME_FILE).toURI());
            for(String line : Files.readAllLines(path)){
                count +=1;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count + " names");
    }
}
