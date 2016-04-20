import sfinksit.*
import sfinksit.controller.*
import sfinksit.domain.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'An user can add a new conference'

scenario "Conference creation succesfull with valid values", {
   given 'Add new Conference', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi konferenssi"));       
        element.click();       
    }

    when 'Adding new Conference', {
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("B06");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Kirjoittaja2");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko2");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija2");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'Conference is created', {
        driver.getPageSource().contains("Reference").shouldBe true
    }
}

scenario "Conference creation unsuccesfull with missing values", {
   given 'Add new Conference', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi konferenssi"));       
        element.click();       
    }

    when 'Adding new Conference', {
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("B07");
        
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");

        element = driver.findElement(By.tagName("button"));
        element.submit();
    }
 
    then 'user stays in creation page', {
        driver.getPageSource().contains("Add new conference").shouldBe true
    }
}

