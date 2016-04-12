
package sfinksit.repository;

import java.lang.ref.Reference;
import junit.framework.TestCase;
import sfinksit.controller.ReferenceController;

public class ReferenceRepositoryTest extends TestCase {
    
    public ReferenceRepositoryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        ReferenceController ref=new ReferenceController();
        ref.create(new Reference("author", "title", "journal", 19, 5, 2004, 249, 259, "publisher", "address"), null);
        fail("The test case is a prototype.");
    }
    
}
