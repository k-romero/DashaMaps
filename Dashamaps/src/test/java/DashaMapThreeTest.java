import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DashaMapThreeTest {

    DashaMapThree map;
    @Before
    public void setUp(){
        map = new DashaMapThree();
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
    public void nodeAppendTest(){
        map.appendTo(map.HashFunctionThree("Assert"),Node.createNewNode("Assert",25,null));
    }
}
