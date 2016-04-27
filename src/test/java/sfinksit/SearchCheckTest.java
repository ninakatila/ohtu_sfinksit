package sfinksit;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import sfinksit.tools.SearchCheck;

public class SearchCheckTest {
    SearchCheck check;
    
    @Before
    public void setUp() {
        check = new SearchCheck(".drop");
    }
    
    @Test
    public void stringWithDotsReturnsFalse() {
        check.setSearchWord(".drop");
        
        assertTrue(!check.validateNoDots());
    }
    
    @Test
    public void emptyStringReturnsFalse() {
        check.setSearchWord("");
        
        assertTrue(!check.notEmptySearchWord());
    }
    
    @Test
    public void tooLongStringReturnsFalse() {
        check.setSearchWord("hauki1kalahauki1kalahauki1kalahauki1kalahauki1kalahauki1kalahauki1kalahauki1kalahauki1kala");
        
        assertTrue(!check.validateStringLength());
    }
    
    @Test
    public void validStringReturnsTrue() {
        check.setSearchWord("hauki1kala");
        
        assertTrue(check.notEmptySearchWord());
    }
    
    @Test
    public void onlyIntegerNumberReturnsTrue() {
        check.setSearchWord("2000");
        
        assertTrue(check.wordContainsOnlyInteger());
    }
    
    @Test
    public void stringWithIntegersAndCharsReturnsFalseForOnlyIntegers() {
        check.setSearchWord("hauki123kala");
        
        assertTrue(!check.wordContainsOnlyInteger());
    }
}
