package dcp; 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static dcp.Problem3.*;

public class Problem3Test {

    @Test
    public void serialize_and_deserialize() {
        Node root = new Node("20");
        root.left = new Node("8");
        root.left.left = new Node("3");
        root.left.left.left = new Node("4");
        root.left.left.left.left = new Node("5");
        root.right = new Node("22");

        String actual = Node.serialize(root);
        Node object = Node.deserialize(actual);
        String expected = Node.serialize(object);
        
        assertEquals(actual, expected);
    }
}