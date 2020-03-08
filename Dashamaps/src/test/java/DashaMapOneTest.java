import org.junit.Test;
import static org.junit.Assert.*;
public class DashaMapOneTest {


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
}
