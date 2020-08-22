import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("Ata"));
    }

    @Test
    public void testNewIsPalindrome() {
        OffByOne cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertFalse(palindrome.isPalindrome("racecar", cc));
        assertTrue(palindrome.isPalindrome("aboab", cc));
        assertFalse(palindrome.isPalindrome("caac", cc));
        assertFalse(palindrome.isPalindrome("horse", cc));
        assertFalse(palindrome.isPalindrome("rancor", cc));
        assertFalse(palindrome.isPalindrome("Ata", cc));

        OffByN dd = new OffByN(5);
        assertTrue(palindrome.isPalindrome("", dd));
        assertTrue(palindrome.isPalindrome("a", dd));
        assertFalse(palindrome.isPalindrome("racecar", dd));
        assertTrue(palindrome.isPalindrome("bidding", dd));
        assertFalse(palindrome.isPalindrome("caac", dd));
        assertFalse(palindrome.isPalindrome("horse", dd));
        assertFalse(palindrome.isPalindrome("rancor", dd));
        assertFalse(palindrome.isPalindrome("Ata", dd));
    }
}
