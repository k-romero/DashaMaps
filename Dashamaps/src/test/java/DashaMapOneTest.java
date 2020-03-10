import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;
public class DashaMapOneTest {

    Node nodeBuilder = new Node();


    @Test
    public void nodeArraySizeTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        assertEquals(26,actual.length);
    }

    @Test
    public void nodeArrayGetValTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        String z = actual[25].theKey;
        assertEquals("z",z);
    }

    @Test
    public void nodeArrayTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        String o = actual[14].theKey;
        assertEquals("o",o);
    }

    @Test
    public void nodeArray1Test(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        String a = actual[0].theKey;
        assertEquals("a",a);
    }

    @Test
    public void nodeAppendTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        map.appendTo("a",nodeBuilder.createNewNode("ace",1,null));
        assertTrue(actual[0].nextNode.theKey.equals("ace"));
    }

    @Test
    public void nodeAppend1Test(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        map.appendTo("z",nodeBuilder.createNewNode("zebra",1,null));
        assertTrue(actual[25].nextNode.theKey.equals("zebra"));
    }

    @Test
    public void nodeAppendUsinghashFunctionTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        String noob = "Noob";
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Noob",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!",1,null));
        assertTrue(actual[13].nextNode.nextNode.theKey.equals("Still here!"));
        assertTrue(actual[13].theValue == 2);
    }

    @Test
    public void nodeAppend5ItemsTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        String noob = "Noob";
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Here",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!1",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!2",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!3",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!4",1,null));
        assertTrue(actual[13].nextNode.nextNode.nextNode.nextNode.nextNode.theKey.equals("Still here!4"));
        assertTrue(actual[13].theValue == 5);
    }

    @Test
    public void isEmptyTest(){
        DashaMapOne map = new DashaMapOne();
        assertTrue(map.isEmpty());
    }

    @Test
    public void isEmptyFalseTest(){
        DashaMapOne map = new DashaMapOne();
        String noob = "Noob";
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Here",1,null));
        assertFalse(map.isEmpty());
    }

    @Test
    public void sizeTest(){
        DashaMapOne map = new DashaMapOne();
        String noob = "Noob";
        Long beforeAppendExpected = 0l;
        Long beforeAppend = map.size();
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Here",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!1",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!2",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!3",1,null));
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Still here!4",1,null));
        Long afterAppendExpected = 5l;
        Long afterAppend = map.size();
        assertEquals(beforeAppendExpected,beforeAppend);
        assertEquals(afterAppendExpected,afterAppend);
        assertFalse(map.isEmpty());
    }

    @Test
    public void getValueTest(){
        DashaMapOne map = new DashaMapOne();
        map.appendTo(map.hashFunctionOne("nerf"),nodeBuilder.createNewNode("nerf",1,null));
        map.appendTo(map.hashFunctionOne("nope"),nodeBuilder.createNewNode("nope",1,null));
        map.appendTo(map.hashFunctionOne("next"),nodeBuilder.createNewNode("next",1,null));
        map.appendTo(map.hashFunctionOne("nine"),nodeBuilder.createNewNode("nine",1,null));
        map.appendTo(map.hashFunctionOne("niagra"),nodeBuilder.createNewNode("niagra",6,null));
        assertTrue(map.get("niagra") == 6);
    }

    @Test
    public void setNewNodeTest(){
        DashaMapOne map = new DashaMapOne();
        map.set("Work",100);
        assertTrue(map.size() == 1);
        assertTrue(map.get("Work") == 100);
    }

    @Test
    public void setMultipleNodesTest(){
        DashaMapOne map = new DashaMapOne();
        map.set("Work",100);
        map.set("crazy", 75);
        assertTrue(map.size() == 2);
        assertTrue(map.get("crazy") == 75);
    }

    @Test
    public void readFileTest() throws IOException {
        DashaMapOne map = new DashaMapOne();
        BufferedReader br = new BufferedReader(new FileReader("/Users/kromero/Dev/Projects/Labs/Week5Labs/DashaMaps/word-list.txt"));
        //For debugging
        long size = 0;
        String line = br.readLine();
        while (line != null) {
            String[] keyValue = line.split(" ");
            String key = keyValue[0];
            Integer value = Integer.valueOf(keyValue[1]);
            map.set(key, value);
            line = br.readLine();
            size = map.size();
        }
        assertTrue(map.size() == 124l);
        assertTrue(map.get("just") == 12);
    }



    //a b c d e f g h i j k l m n o p q r s t u v w x y z
    //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
}
