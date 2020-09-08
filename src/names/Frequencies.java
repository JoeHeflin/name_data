package names;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Frequencies {
    private static int frequency;
    private static Stack<String> names;

    public int getFrequency() {
        return frequency;
    }

    public Stack<String> getNames() {
        return names;
    }

    public static void maxNameAtRank(List<String> namesAtACertainRank){
        HashMap<String, Integer> name2freq = new HashMap<>();
        HashMap<Integer, Stack<String>> freq2name = new HashMap<>();
        int max = 0;

        for(String year:namesAtACertainRank) {
            String[] namesThisYear = year.split(", ");
            for(String name:namesThisYear) {
                int freq = 1;
                if(name2freq.containsKey(name)) {
                    freq = name2freq.get(name)+1;
                    name2freq.replace(name,freq);
                } else {
                    name2freq.put(name,freq);
                }
                if(freq2name.containsKey(freq)) {
                    freq2name.get(freq).push(name);
                } else {
                    Stack<String> s = new Stack<>();
                    s.push(name);
                    freq2name.put(freq,s);
                }
                if(freq>=max) {
                    max = freq;
                }
            }

        }
        names = freq2name.get(max);
        frequency = max;
    }

    public static void maxNameFreq(int[] years, String gender) throws Exception {
        /*
        Use two hashmaps:
            1) looks up a name to find its frequency
            2) looks up a collection of names given a frequency
         */
        HashMap<String, Integer> name2freq = new HashMap<>();
        HashMap<Integer, Stack<String>> freq2name = new HashMap<>();
        int max = 0;

        for (int year = years[0]; year <= years[1]; year++) {
            NameArray n = new NameArray(gender, year);
            List<Name> topNames = n.topRank();
            for (Name name : topNames) {
                int freq = 1;
                if (name2freq.containsKey(name.getName())) {
                    freq = name2freq.get(name.getName())+1;
                    name2freq.replace(name.getName(),freq);
                } else {
                    name2freq.put(name.getName(),freq);
                }
                if (freq2name.containsKey(freq)) {
                    freq2name.get(freq).push(name.getName());
                } else {
                    Stack<String> s = new Stack<>();
                    s.push(name.getName());
                    freq2name.put(freq,s);
                }
                if (freq >= max) {
                    max = freq;
                }
            }
        }
        names = freq2name.get(max);
        frequency = max;
    }

    /**
     * @return a collection of names beginning with the most common letter in collection
     */
    public void maxLetterFreq(List<Name> nameArray){
        int max = 0;
        Character maxC = 'z';

        HashMap<Character, Stack<String>> letter2names = new HashMap<>();
        HashMap<Character, Integer> letter2count = new HashMap<>();

        for(Name name:nameArray){

            letter2names.putIfAbsent(name.getName().charAt(0),new Stack<>());
            letter2count.putIfAbsent(name.getName().charAt(0),0);

            int currentCount = letter2count.get(name.getName().charAt(0))+name.getCount();
            letter2count.put(name.getName().charAt(0), currentCount);

            Stack<String> stack = letter2names.get(name.getName().charAt(0));
            if(!stack.contains(name.getName())){
                stack.push(name.getName());
            }
        }
        for(Character c:letter2count.keySet()){
            int total = letter2count.get(c);

            if(total >= max){
                if(total > max || c < maxC){
                    maxC = c;
                }
                max = total;
            }
        }
        names = letter2names.get(maxC);
        frequency = max;
    }
}