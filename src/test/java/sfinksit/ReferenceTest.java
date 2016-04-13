package sfinksit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ReferenceTest {
    
    @Autowired
    private ReferenceRepository references;

    @Test
    public void testSaveReferences() {
        Reference ref1 = new Reference();
        ref1.setAuthor("Author");
        
        references.save(ref1);
        
        Reference ref2 = new Reference();
        ref2.setAuthor("Aleksanteri Suuri");
        references.save(ref2);
        
        assertEquals(2, references.findAll().size());
    }
}
