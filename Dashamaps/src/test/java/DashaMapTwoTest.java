import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

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
    public void nodeDeleteTest(){
        long sizeBefore = map.size();
        map.appendTo(map.hashFunctionTwo("Assert"),Node.createNewNode("Assert",25,null));
        map.appendTo(map.hashFunctionTwo("Ssert"),Node.createNewNode("Ssert",25,null));
        map.set("Assign",100);
        assertEquals("Assert", map.alphaNodes[18].nextNode.theKey);
        assertEquals("Ssert", map.alphaNodes[18].nextNode.nextNode.theKey);
        assertEquals("Assign", map.alphaNodes[18].nextNode.nextNode.nextNode.theKey);
        map.delete("Ssert");
        long sizeAfter = map.size();
        assertEquals(2,sizeAfter);
        assertEquals("Assign", map.alphaNodes[18].nextNode.nextNode.theKey);
        assertNull(map.alphaNodes[18].nextNode.nextNode.nextNode);
    }

    @Test
    public void readFileTest() throws IOException {
        FileWriter fw = new FileWriter("/Users/kromero/Dev/Projects/Labs/Week5Labs/DashaMaps/word-list-test.txt");
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

        for (Node n : map.getAlphaNodes()) {
            Node currentNode = n;
            if(currentNode.nextNode != null){
                currentNode = currentNode.nextNode;
                for (int i = 0; i < n.theValue; i++) {
                    fw.write(currentNode.theKey + " " + currentNode.theValue + "\n");
                    if(currentNode.nextNode != null){
                        currentNode = currentNode.nextNode;
                    } else {
                        continue;
                    }
                }
            }

        }

        fw.close();
        assertTrue(map.size() == 124l);
        assertTrue(map.get("just") == 12);
    }

    //a b c d e f g h i j k l m n o p q r s t u v w x y z
    //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5

}
