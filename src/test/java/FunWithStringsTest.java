import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunWithStringsTest {

    @Test
    void countWords() {
        assertEquals(7, FunWithStrings.countWords("EiP macht Spaß! Und Strings sind toll!"));
        assertEquals(0, FunWithStrings.countWords(""));
        assertEquals(1, FunWithStrings.countWords("Wort"));
        assertEquals(3, FunWithStrings.countWords("EiP macht Spaß!"));
    }

    @Test
    void getQuotedText() {
        assertNull(FunWithStrings.getQuotedText("keine Anführungezeichen"));
        assertNull(FunWithStrings.getQuotedText("nur ein \"Anführungezeichen"));
        assertEquals("Text", FunWithStrings.getQuotedText("vorher \"Text\" nachher"));
        assertEquals("", FunWithStrings.getQuotedText("vorher \"\" nachher"));
    }

    @Test
    void commonPrefix() {
        assertEquals("", FunWithStrings.commonPrefix("First", "Second"));
        assertEquals("xyz", FunWithStrings.commonPrefix("xyzTest", "xyzHello"));
        assertEquals("Hello", FunWithStrings.commonPrefix("Hello", "Hello"));
    }
}