import sfinksit.*
import sfinksit.controller.*
import sfinksit.domain.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'An user can add a new book'

scenario "Book creation succesfull with valid values", {
   given 'created', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi kirja"));       
        element.click();       
    }

    when 'created', {
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("W04");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Kirjoittaja");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'book is created', {
        driver.getPageSource().contains("Reference").shouldBe true
    }
}

scenario "Book creation unsuccesfull with missing values", {
   given 'created', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi kirja"));       
        element.click();       
    }

    when 'created', {
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("W05");
        
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.submit();
    }
 
    then 'user stays in creation page', {
        driver.getPageSource().contains("Add new book").shouldBe true
    }
}

