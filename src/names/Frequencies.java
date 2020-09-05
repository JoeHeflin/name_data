package names;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Frequencies {
    static int frequency;
    static Stack<String> names;

    public static void maxNameFreq(int[] years, String gender){
        /*
        Use two hashmaps:
            1) looks up a name to find its frequency
            2) looks up a collection of names given a frequency
         */
        HashMap<String, Integer> name2freq = new HashMap<>();
        HashMap<Integer, Stack<String>> freq2name = new HashMap<>();
        int max = 0;

        for(int year = years[0]; year <= years[1]; year++){
            NameArray n = new NameArray(gender, year);
            List<Name> topNames = n.topRank();
            for(Name name: topNames){
                int freq = 1;
                if(name2freq.containsKey(name.name)){
                    freq = name2freq.get(name.name)+1;
                    name2freq.replace(name.name,freq);
                }
                else{
                    name2freq.put(name.name,freq);
                }
                if(freq2name.containsKey(freq)){
                    freq2name.get(freq).push(name.name);
                }
                else{
                    Stack<String> s = new Stack<>();
                    s.push(name.name);
                    freq2name.put(freq,s);
                }
                if(freq>=max){
                    max = freq;
                }
            }
        }
        names = freq2name.get(max);
        frequency = max;
    }
}