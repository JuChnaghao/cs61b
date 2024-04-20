import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();
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
    public void testisPalindrome(){
        assertTrue(palindrome.isPalindrome("abcddcba"));
        assertFalse(palindrome.isPalindrome("Abcddcba"));
        assertFalse(palindrome.isPalindrome("abcdedcca"));
        assertTrue(palindrome.isPalindrome("abcba"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
    }
    @Test
    public void testisPalindrome2()
    {
        assertTrue(palindrome.isPalindrome("abcdedcb", cc));
        assertFalse(palindrome.isPalindrome("abcddcba", cc));
        assertTrue(palindrome.isPalindrome("abccb", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));
    }
    /*Uncomment this class once you've created your Palindrome class. */
}
