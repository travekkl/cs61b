import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b);
    }

    @Test
    public void testIsSameNumber() {
        for (int i = 0; i < 100; i++) {
            boolean t = isSameNumber(new Integer(i), new Integer(i));
            assertEquals(true, t);
        }

    }
}
