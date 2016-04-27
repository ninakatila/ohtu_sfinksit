import sfinksit.*
import sfinksit.controller.*
import sfinksit.domain.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'An user can search the database with a given word'

before "create article, book and conference", {
    drivers = new HtmlUnitDriver();
    drivers.get("http://localhost:8080");
    element = drivers.findElement(By.linkText("Lisää uusi artikkeli"));       
    element.click();

    element = drivers.findElement(By.name("reference.author"));
    element.sendKeys("Lumiukko Maailma");
    element = drivers.findElement(By.name("reference.title"));
    element.sendKeys("Lumiukon seikkailut");
    element = drivers.findElement(By.name("article.journal"));
    element.sendKeys("Kahvi");
    element = drivers.findElement(By.name("reference.publisher"));
    element.sendKeys("Kahvia");
    element = drivers.findElement(By.name("article.address"));
    element.sendKeys("Pohjoinen");

    element = drivers.findElement(By.tagName("button"));
    element.click();
    
    driverA = new HtmlUnitDriver();
    driverA.get("http://localhost:8080");

    element = driverA.findElement(By.linkText("Lisää uusi kirja"));       
    element.click(); 
            
    element = driverA.findElement(By.name("reference.author"));
    element.sendKeys("Mahtava Joutsen");
    element = driverA.findElement(By.name("reference.title"));
    element.sendKeys("Joutsenen kotimatka");
    element = driverA.findElement(By.name("reference.publisher"));
    element.sendKeys("Kahvia");

    element = driverA.findElement(By.tagName("button"));
    element.click();
}

scenario "An existing article can be found with a saved value", {
   given 'click for search', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Haku"));       
        element.click();       
    }

    when 'search with a given word', {
        element = driver.findElement(By.name("search"));
        element.sendKeys("Pohjoinen");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }

    then 'article is found', {
        driver.getPageSource().contains("Lumiukon seikkailut").shouldBe true
    }
}

scenario "An existing book can be found with a saved value", {
   given 'click for search', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Haku"));       
        element.click();       
    }

    when 'search with a given word', {
        element = driver.findElement(By.name("search"));
        element.sendKeys("Mahtava Joutsen");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }

    then 'book is found', {
        driver.getPageSource().contains("Joutsenen kotimatka").shouldBe true
    }
}

scenario "If no reference has a saved value that equals search, nothing is returned", {
   given 'click for search', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Haku"));       
        element.click();       
    }

    when 'search with a given word', {
        element = driver.findElement(By.name("search"));
        element.sendKeys("MaailmanLaidalla");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }

    then 'nothing is found', {
        driver.getPageSource().contains("MaailmanLaidalla").shouldBe false
    }
}

scenario "Search returns several items", {
   given 'click for search', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("Haku"));       
        element.click();       
    }

    when 'search with a given word', {
        element = driver.findElement(By.name("search"));
        element.sendKeys("Kahvia");

        element = driver.findElement(By.tagName("button"));
        element.click();
    }

    then 'article is found', {
        driver.getPageSource().contains("Lumiukko Maailma").shouldBe true
    }
    and 
    then 'book is found', {
        driver.getPageSource().contains("Mahtava Joutsen").shouldBe true
    }
}