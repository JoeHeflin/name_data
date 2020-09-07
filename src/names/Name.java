package names;

class Name{
    public String name;
    public String gender;
    public int count;
    public int rank;

    public Name(String nameLine){
        String[] nameInfo = nameLine.split(",");
        name = nameInfo[0];
        gender = nameInfo[1];
        count = Integer.parseInt(nameInfo[2]);
        rank = -3;
    }
}
