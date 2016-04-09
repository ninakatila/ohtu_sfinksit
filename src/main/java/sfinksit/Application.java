package sfinksit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Import;
import sfinksit.profiles.DevProfile;
import sfinksit.profiles.ProdProfile;

@SpringBootApplication
@Import({DevProfile.class, ProdProfile.class})
@EnableAutoConfiguration
public class Application {

    // private static final Logger log = LoggerFactory.getLogger(Application.class);
    

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
