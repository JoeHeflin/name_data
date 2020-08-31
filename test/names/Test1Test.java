package names;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test1Test {

    /*
    Make sure all files are unsorted
     */

    @Test
    void singleMostPopular(){
        NameArray f = new NameArray("F", 3001);
        NameArray m = new NameArray("M", 3001);

        List<Name> fRank = f.topRank();
        List<Name> mRank = m.topRank();

        for (Name name:mRank){
            //System.out.println(name);
            assertEquals(name.name.compareTo("George"),0);
        }
        for (Name name:fRank){
            assertEquals(name.name.compareTo("Margaret"),0);
        }
    }

    @Test
    void multipleMostPopular(){
        NameArray f = new NameArray("F", 3002);
        NameArray m = new NameArray("M", 3002);

        List<Name> fRank = f.topRank();
        List<Name> mRank = m.topRank();

        String[] solF = {"MaryLou","Helen","Anna"};
        String[] solM = {"Jonny","William"};

        for (Name name:mRank){
            assertEquals(name.name.compareTo(solM[mRank.indexOf(name)]),0);
        }
        for (Name name:fRank){
            assertEquals(name.name.compareTo(solF[fRank.indexOf(name)]),0);
        }
    }

    @Test
    void multipleMostPopularShuffled(){
        NameArray f = new NameArray("F", 3000);
        NameArray m = new NameArray("M", 3000);

        List<Name> fRank = f.topRank();
        List<Name> mRank = m.topRank();

        String[] solF = {"Helen","Margaret"};
        String[] solM = {"Jonny","James","Charles"};

        for (Name name:mRank){
            assertEquals(0, name.name.compareTo(solM[mRank.indexOf(name)]));
        }
        for (Name name:fRank){
            assertEquals(0, name.name.compareTo(solF[fRank.indexOf(name)]));
        }
    }

}