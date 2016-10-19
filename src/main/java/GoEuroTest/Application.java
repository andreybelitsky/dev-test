package GoEuroTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import GoEuroTest.service.CSVLoadingService;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    @Autowired
    CSVLoadingService csvLoadingService;


    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    public CommandLineRunner run(){
        return args -> {
            csvLoadingService.loadData(args[0]);
            log.info(Arrays.toString(args));
        };
    }

}