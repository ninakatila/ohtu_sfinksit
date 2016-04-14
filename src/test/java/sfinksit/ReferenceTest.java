package sfinksit;

import java.util.Set;
import javax.validation.ConstraintViolation;
import org.hibernate.validator.HibernateValidator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ReferenceTest {
    
    @Autowired
    private ReferenceRepository references;
    private LocalValidatorFactoryBean localValidatorFactory;
    
    //author, title, journal, publisher ei saa olla null
    
    @Before
    public void setUp(){
        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
    }

    @Test
    public void testSaveReferences() {
        references.deleteAll();
        Reference ref1 = createReference();
        
        references.save(ref1);
        
        Reference ref2 = createReference();
        references.save(ref2);
        
        assertEquals(2, references.findAll().size());
    }
    
    @Test
    public void YearNotNegative() {
        references.deleteAll();
        final Reference ref = createReference();
        ref.setYear(-500);
        
        Set<ConstraintViolation<Reference>> constraintViolations = localValidatorFactory.validate(ref);
        assertTrue("Expected validation error not found", constraintViolations.size() == 1);
    }
    
    public Reference createReference(){
        Reference ref = new Reference();
        ref.setAuthor("Author");
        ref.setTitle("testi");
        ref.setJournal("Herra");
        ref.setPublisher("Hakkarainen");
        return ref;
    }
}
