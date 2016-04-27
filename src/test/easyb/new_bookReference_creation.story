import sfinksit.*
import sfinksit.controller.*
import sfinksit.domain.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'An user can add a new book'

scenario "Book creation succesfull with valid values", {
   given 'Move to page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi kirja"));       
        element.click();       
    }

    when 'Values entered and submit clicked', {
        element = driver.findElement(By.name("reference.bibtexKey"));
        element.sendKeys("W04");
        element = driver.findElement(By.name("reference.author"));
        element.sendKeys("Kirjoittaja");
        element = driver.findElement(By.name("reference.title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("reference.publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'book is created', {
        driver.getPageSource().contains("Reference created").shouldBe true
    }
}

scenario "Book creation unsuccesfull with missing values", {
   given 'Move to page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi kirja"));       
        element.click();       
    }

    when 'Values entered and submit clicked', {
        element = driver.findElement(By.name("reference.bibtexKey"));
        element.sendKeys("W05");
        
        element = driver.findElement(By.name("reference.title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("reference.publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.submit();
    }
 
    then 'user stays in creation page', {
        driver.getPageSource().contains("Add new book").shouldBe true
    }
}

