import sfinksit.*
import sfinksit.controller.*
import sfinksit.domain.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'An user can add a new article'

scenario "Article creation succesfull with valid values", {
   given 'Move to page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
    }

    when 'Values entered and submit clicked', {
        element = driver.findElement(By.name("reference.bibtexKey"));
        element.sendKeys("S04");
        element = driver.findElement(By.name("reference.author"));
        element.sendKeys("Kirjoittaja");
        element = driver.findElement(By.name("reference.title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("article.journal"));
        element.sendKeys("Julkaisu");
        element = driver.findElement(By.name("article.volume"));
        element.sendKeys("10");
        element = driver.findElement(By.name("article.number"));
        element.sendKeys("20");
        element = driver.findElement(By.name("reference.publisher"));
        element.sendKeys("Julkaisija");
        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'article is created', {
        driver.getPageSource().contains("Reference").shouldBe true
    }
}

scenario "Article creation succesfull with valid values and check list page", {
    given 'Move to page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
     }

    when 'Values entered and submit clicked', {
        element = driver.findElement(By.name("reference.author"));
        element.sendKeys("Vihavainen");
        element = driver.findElement(By.name("reference.title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("article.journal"));
        element.sendKeys("Julkaisu");
        element = driver.findElement(By.name("article.volume"));
        element.sendKeys("10");
        element = driver.findElement(By.name("article.number"));
        element.sendKeys("20");
        element = driver.findElement(By.name("reference.publisher"));
        element.sendKeys("Julkaisija");
        element = driver.findElement(By.name("reference.year"));
        element.sendKeys("2016");

        element = driver.findElement(By.tagName("button"));
        element.click();
        element = driver.findElement(By.partialLinkText("Kaikki"));       
        element.click(); 

    }
 
    then 'check list page', {
        driver.getPageSource().contains("V2016").shouldBe true
    }
}

scenario "Article creation unsuccesfull with missing values", {
   given 'created', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
    }

    when 'Values entered and submit clicked', {
        element = driver.findElement(By.name("reference.bibtexKey"));
        element.sendKeys("S05");
        
        element = driver.findElement(By.name("reference.title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("reference.publisher"));
        element.sendKeys("Julkaisija");
        element = driver.findElement(By.name("reference.year"));
        element.sendKeys("2016");
        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'user stays in creation page', {
        driver.getPageSource().contains("Add reference").shouldBe true
    }
}


