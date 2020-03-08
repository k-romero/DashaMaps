import static org.junit.Assert.*;
import org.junit.Test;

public class NodeTest {
    Node nodeBuilder = new Node();

    @Test
    public void nodeBuilderTest(){
        Node newNode = nodeBuilder.createNewNode("Ayo I'm a builder.",0,null);
        assertEquals(newNode.theKey, "Ayo I'm a builder.");
    }

}
