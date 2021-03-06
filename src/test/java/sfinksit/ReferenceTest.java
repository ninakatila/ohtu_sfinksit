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
import sfinksit.domain.Article;
import sfinksit.domain.Book;
import sfinksit.domain.Conference;
import sfinksit.repository.ReferenceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ReferenceTest {

    @Autowired
    private ReferenceRepository references;
    private LocalValidatorFactoryBean localValidatorFactory;

    //author, title, journal, publisher ei saa olla null
    @Before
    public void setUp() {
        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
    }

    @Test
    public void testSaveReferences() {
        references.deleteAll();
        Reference ref1 = createArticleReference();

        references.save(ref1);

        Reference ref2 = createBookReference();
        references.save(ref2);

        Reference ref3 = createConfReference();
        references.save(ref3);

        assertEquals(3, references.findAll().size());
    }

    @Test
    public void YearNotNegative() {
        references.deleteAll();
        final Reference ref = createArticleReference();
        ref.setYear(-500);

        Set<ConstraintViolation<Reference>> constraintViolations = localValidatorFactory.validate(ref);
        assertTrue("Expected validation error not found", constraintViolations.size() == 1);
    }

    public Reference createArticleReference() {
        Reference ref = new Reference();
        Article article = new Article();

        ref.setAuthor("Author");
        ref.setTitle("testi");
        article.setJournal("Herra");
        ref.setArticle(article);
        ref.setPublisher("Hakkarainen");
        return ref;
    }

    @Test
    public void YearOk() {
        references.deleteAll();
        final Reference ref = createBookReference();
        ref.setYear(1975);

        Set<ConstraintViolation<Reference>> constraintViolations = localValidatorFactory.validate(ref);
        assertTrue("Expected validation error not found", constraintViolations.size() == 0);
    }

    public Reference createBookReference() {
        Reference ref = new Reference();
        Book book = new Book();
        ref.setAuthor("Author");
        ref.setPublisher("Publisher");
        ref.setTitle("Title");
        ref.setBook(book);
        return ref;
    }

    @Test
    public void YearOk2() {
        references.deleteAll();
        final Reference ref = createConfReference();
        ref.setYear(1989);

        Set<ConstraintViolation<Reference>> constraintViolations = localValidatorFactory.validate(ref);
        assertTrue("Expected validation error not found", constraintViolations.size() == 0);
    }

    public Reference createConfReference() {
        Reference ref = new Reference();
        Conference conf = new Conference();
        ref.setAuthor("Author");
        ref.setPublisher("Publisher");
        ref.setTitle("Title");
        ref.setConference(conf);
        return ref;
    }
}
