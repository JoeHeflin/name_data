package names;

class Name{
    public static String name;
    public static String gender;
    public int count;

    public Name(String nameLine){
        String[] nameInfo = nameLine.split(",");
        name = nameInfo[0];
        gender = nameInfo[1];
        count = Integer.parseInt(nameInfo[2]);
    }
}
