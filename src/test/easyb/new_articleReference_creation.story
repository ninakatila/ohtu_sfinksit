import sfinksit.*
import sfinksit.controller.*
import sfinksit.domain.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'An user can add a new article'

scenario "Article creation succesfull with valid values", {
   given 'created', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
    }

    when 'created', {
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("S04");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Kirjoittaja");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("article.journal"));
        element.sendKeys("Julkaisu");
        element = driver.findElement(By.name("article.volume"));
        element.sendKeys("10");
        element = driver.findElement(By.name("article.number"));
        element.sendKeys("20");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'article is created', {
        driver.getPageSource().contains("Reference created").shouldBe true
    }
}
scenario "Article creation succesfull with valid values and check list page", {
   given 'created', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
    }
when 'move to list page', {
 element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("S06");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Kirjoittaja");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("article.journal"));
        element.sendKeys("Julkaisu");
        element = driver.findElement(By.name("article.volume"));
        element.sendKeys("10");
        element = driver.findElement(By.name("article.number"));
        element.sendKeys("20");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.click();
       element = driver.findElement(By.linkText("Kaikki lähteet"));       
        element.click(); 
    }
 
    then 'check list page', {
        driver.getPageSource().contains("S06").shouldBe true
    }
}

scenario "Article creation unsuccesfull with missing values", {
   given 'created', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
    }

    when 'created', {
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("S05");
        
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'user stays in creation page', {
        driver.getPageSource().contains("Add reference").shouldBe true
    }
}


