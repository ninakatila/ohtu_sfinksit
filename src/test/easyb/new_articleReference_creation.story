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
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("S04");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Kirjoittaja");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Julkaisu");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("10");
        element = driver.findElement(By.name("number"));
        element.sendKeys("20");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");
        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'article is created', {
        driver.getPageSource().contains("Reference").shouldBe true
    }
}

scenario "Article creation succesfull without given bibtexKey and with valid other values and check list page", {
    given 'Move to page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
     }

    when 'Values entered and submit clicked', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Vihavainen");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Julkaisu");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("10");
        element = driver.findElement(By.name("number"));
        element.sendKeys("20");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");
        element = driver.findElement(By.name("year"));
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

scenario "Article creation succesfull without given bibtexKey, when given multiple authors and other valid values and check list page", {
    given 'Move to page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Lisää uusi artikkeli"));       
        element.click();       
     }

    when 'Values entered and submit clicked', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Vihavainen Arto;Karvinen Tuomo;Tietäväinen Tero");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Julkaisu");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("6");
        element = driver.findElement(By.name("number"));
        element.sendKeys("16");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2016");

        element = driver.findElement(By.tagName("button"));
        element.click();
        element = driver.findElement(By.partialLinkText("Kaikki"));       
        element.click(); 

    }
 
    then 'check list page', {
        driver.getPageSource().contains("VKT2016").shouldBe true
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
        element = driver.findElement(By.name("bibtexKey"));
        element.sendKeys("S05");
        
        element = driver.findElement(By.name("title"));
        element.sendKeys("Otsikko");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Julkaisija");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2016");
        element = driver.findElement(By.tagName("button"));
        element.click();
    }
 
    then 'user stays in creation page', {
        driver.getPageSource().contains("Add reference").shouldBe true
    }
}


