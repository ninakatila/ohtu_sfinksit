package sfinksit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Import;


@SpringBootApplication
// @Import({ProdProfile.class})
public class Application {

    // private static final Logger log = LoggerFactory.getLogger(Application.class);
    

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
