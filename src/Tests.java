
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    void testIsEmpty()
    {
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    void testString(){
        assertThrows(NumberFormatException.class, () -> Integer.decode("str"));
    }

    @Test
    void testInteger(){
        assertThrows(NumberFormatException.class, () -> Integer.decode(String.valueOf((long)Integer.MAX_VALUE+1)));
        assertThrows(NumberFormatException.class, () -> Integer.decode(String.valueOf((long)Integer.MIN_VALUE-1)));
    }

    @Test
    void testPlus(){
        assertEquals(+1, Integer.decode("+1"));
    }

    @Test
    void testMinus(){
        assertEquals(-1, Integer.decode("-1"));
    }

    @Test
    void testHex() {
        assertEquals(16, Integer.decode("0x10"));
        assertEquals(16, Integer.decode("0X10"));
        assertEquals(16, Integer.decode("#10"));
    }

    @Test
    void testOct() {
        assertEquals(8, Integer.decode("010"));
    }

    @Test
    void testSignPosition() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("OX1-6"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("0x-16"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("0+x16"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("0x16+"));
    }

    @Test
    void testMinMaxValue(){
        assertEquals(Integer.MIN_VALUE, Integer.decode(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MAX_VALUE, Integer.decode(String.valueOf(Integer.MAX_VALUE)));
    }
}
