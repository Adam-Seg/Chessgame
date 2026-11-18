package boardgames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LocationTest {

    private Location b3;
    private Location a1;

    @BeforeEach
    public void setUp(){
        b3 = new Location('b', 3);
        a1 = new Location(0, 0);
    }

    @AfterEach
    public void tearDown(){
        b3 = null;
        a1 = null;
    }

    @Test
    void testConstructor(){
        assertEquals(0, a1.fileIndex);
        assertEquals('a', a1.getFile());
        assertEquals(0, a1.rankIndex);
        assertEquals(1, a1.getRank());
        assertEquals(1, b3.fileIndex);
        assertEquals('b', b3.getFile());
        assertEquals(2, b3.rankIndex);
        assertEquals(3, b3.getRank());
    }
    
    @Test
    void testEquals() {
        Location otherB3 = new Location(1, 2);
        assertEquals(b3, otherB3);
        assertFalse(a1.equals(b3));
    }
}
