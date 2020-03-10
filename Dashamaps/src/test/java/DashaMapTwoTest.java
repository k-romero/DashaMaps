import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashaMapTwoTest {

    DashaMapTwo map;
    @Before
    public void setUp(){
        map = new DashaMapTwo();
    }

    @Test
    public void nodeArraySizeTest(){
        Node[] actual = map.getAlphaNodes();
        assertEquals(26,actual.length);
    }

    @Test
    public void nodeArrayGetValTest(){
        Node[] actual = map.getAlphaNodes();
        String z = actual[25].theKey;
        assertEquals("z",z);
    }

    @Test
    public void hashFunctionThreeTest(){
        String actual = map.hashFunctionTwo("Assert");
        String expected = "s";
        assertEquals(expected,actual);
    }

    @Test
    public void nodeAppendTest(){
        long sizeBefore = map.size();
        map.appendTo(map.hashFunctionTwo("Assert"),Node.createNewNode("Assert",25,null));
        long sizeAfter = map.size();
        assertEquals(0,sizeBefore);
        assertEquals(1,sizeAfter);
        assertEquals("Assert",map.alphaNodes[18].nextNode.theKey);
    }

    @Test
    public void readFileTest() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/kromero/Dev/Projects/Labs/Week5Labs/DashaMaps/word-list.txt"));
        //For debugging
        String line = br.readLine();
        while (line != null) {
            String[] keyValue = line.split(" ");
            String key = keyValue[0];
            Integer value = Integer.valueOf(keyValue[1]);
            map.set(key, value);
            line = br.readLine();
        }
        assertTrue(map.size() == 124l);
        assertTrue(map.get("just") == 12);
    }

    //a b c d e f g h i j k l m n o p q r s t u v w x y z
    //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5

}
