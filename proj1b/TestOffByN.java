import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(1);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'b'));
        assertTrue(offByN.equalChars('r', 'q'));
        assertFalse(offByN.equalChars('a', 'e'));
        assertFalse(offByN.equalChars('z', 'a'));
        assertFalse(offByN.equalChars('a', 'a'));
        assertTrue(offByN.equalChars('A', 'B'));
        assertTrue(offByN.equalChars('B', 'A'));
    }
}
