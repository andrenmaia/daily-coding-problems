
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    public void hello() {
        System.out.println("This test method should be run");
        assertEquals(1,1);
    }

}