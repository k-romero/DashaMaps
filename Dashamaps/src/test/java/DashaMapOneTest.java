import org.junit.Test;
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
        assertTrue(actual[0].nextNode.theKey.equals("Here"));
    }

    @Test
    public void nodeAppend1Test(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        map.appendTo("z",nodeBuilder.createNewNode("zebra",1,null));
        assertTrue(actual[25].nextNode.theKey.equals("Here"));
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
        Node[] actual = map.getAlphaNodes();
        assertTrue(map.isEmpty());
    }

    @Test
    public void isEmptyFalseTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
        String noob = "Noob";
        map.appendTo(map.hashFunctionOne(noob),nodeBuilder.createNewNode("Here",1,null));
        assertFalse(map.isEmpty());
    }

    @Test
    public void sizeTest(){
        DashaMapOne map = new DashaMapOne();
        Node[] actual = map.getAlphaNodes();
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
        Node[] actual = map.getAlphaNodes();
        map.appendTo(map.hashFunctionOne("nerf"),nodeBuilder.createNewNode("nerf",1,null));
        map.appendTo(map.hashFunctionOne("nope"),nodeBuilder.createNewNode("nope",1,null));
        map.appendTo(map.hashFunctionOne("next"),nodeBuilder.createNewNode("next",1,null));
        map.appendTo(map.hashFunctionOne("nine"),nodeBuilder.createNewNode("nine",1,null));
        map.appendTo(map.hashFunctionOne("Niagra"),nodeBuilder.createNewNode("niagra",6,null));
        assertTrue(map.get("niagra") == 6);
    }



    //a b c d e f g h i j k l m n o p q r s t u v w x y z
    //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
}
