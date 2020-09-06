package names;

public class Complete4 {
    public static int run(String name, String gender, int[] years) throws Exception {
        int totalRank = 0;

        if(years[1]<years[0]){
            throw new Exception("Invalid Year Range");
        }

        for(int year = years[0]; year <= years[1]; year++){
            NameArray n = new NameArray(gender,year);
            int rank = n.findRank(name);
            totalRank += rank;
        }
        int avgRank = totalRank/(years[1]-years[0]+1);

        return avgRank;
    }
}
