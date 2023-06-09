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
    public void testIsPalindrom() {
        assertFalse(palindrome.isPalindrome("hello"));
        assertFalse(palindrome.isPalindrome("good"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        OffByOne ofo = new OffByOne();
        assertTrue(palindrome.isPalindrome("", ofo));
        assertTrue(palindrome.isPalindrome("asdfeerb", ofo));
        assertFalse(palindrome.isPalindrome("aba", ofo));
    }
}
