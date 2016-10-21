package GoEuroTest;

import GoEuroTest.service.impl.CityRestCSVLoadingService;
import GoEuroTest.vo.CityVo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ITEndToEndTest {


    public static final String COMPARED_ATTRIBUTE = "name";
    public static final String ARTIFACT_VERSION = "1.0-SNAPSHOT";

    private void runApplication(String parameter){
        List<String> wordTokens = Arrays.asList(parameter.split("\\-\\s"));
        File csv = new File(CityRestCSVLoadingService.PATH_TO_CSV_FILE);
        cleanup(csv);
        try {
            Runtime runtime = Runtime.getRuntime();
            String cmd = String.format("java -jar target/GoEuroTest-%s.jar \"%s\"", ARTIFACT_VERSION, parameter);
            runtime.exec(cmd);
            while(!csv.exists()) {
                Thread.sleep(100);
            }
            CSVFormat csvFileFormat = CSVFormat.EXCEL.withHeader((String[]) CityVo.FIELDS_LIST.toArray()).withDelimiter(CityRestCSVLoadingService.DELIMITER);
            try(FileReader fileReader = new FileReader(csv)) {
                Iterable<CSVRecord> records = csvFileFormat.parse(fileReader);
                assertTrue(String.format("No records were retrieved for %s", parameter), records.iterator().hasNext());
                records.forEach(r -> wordTokens.forEach(w->assertTrue(String.format("Result with name '%s' does not contain '%s'", r.get(COMPARED_ATTRIBUTE), w), r.get(COMPARED_ATTRIBUTE).contains(w))));
            }
        } catch (IOException | InterruptedException e){
            fail(e.getMessage());
        }
        finally {
            cleanup(csv);
        }
    }

    private void cleanup(File csv) {
        if(csv.exists()) {
            if (csv.delete()) {
                while(csv.exists()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        fail(e.getMessage());
                    }
                }
            }
        }
    }

    @Test
    public void runCity(){
        runApplication("Berlin");
    }

    @Test
    public void runCityAirport(){
        runApplication("Berlin Tegel");
    }
    @Test
    public void runCityAirportWithUnicodeChar() {
        runApplication("Berlin Schönefeld");
    }

    @Test
    public void runTwoWordCity() {
        runApplication("San Francisco");
    }

    @Test
    public void runCityWithHyphen() {
        runApplication("Porto-Novo");
    }
}
