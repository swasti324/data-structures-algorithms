import com.example.palindrome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest{

    @Test
    fun testPalindrome1(){
        assertTrue(palindrome("level"))
    }

    @Test
    fun testPalindrome2(){
        assertTrue(palindrome("poop"))
    }
    @Test
    fun testNotPalindrome1(){
        assertFalse(palindrome("hello"))
    }
    @Test
    fun testNotPalindrome2(){
        assertFalse(palindrome(""))
    }

}