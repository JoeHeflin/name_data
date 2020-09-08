package names;

class Name{
    private String name;
    private String gender;
    private int count;
    private int rank;

    public Name(String nameLine){
        String[] nameInfo = nameLine.split(",");
        name = nameInfo[0];
        gender = nameInfo[1];
        count = Integer.parseInt(nameInfo[2]);
        rank = -3;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getCount() {
        return count;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int newRank) {
        rank = newRank;
    }
}
