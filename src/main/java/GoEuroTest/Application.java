package GoEuroTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import GoEuroTest.service.CSVLoadingService;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    @Autowired
    CSVLoadingService csvLoadingService;


    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(){
        return args -> {
            LOGGER.info(String.format("Running the application with the following arguments %s", Arrays.toString(args)));
            if(args.length!=1) {
                throw new IllegalArgumentException(String.format("Incorrect number of attributes expected 1 got %s", args.length));
            }
            csvLoadingService.loadData(args[0]);
        };
    }
}