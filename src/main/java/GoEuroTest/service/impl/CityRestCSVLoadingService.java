package GoEuroTest.service.impl;

import GoEuroTest.service.CSVLoadingService;
import GoEuroTest.vo.CityVo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityRestCSVLoadingService implements CSVLoadingService {
    public static final String CITY_REST_API = "http://api.goeuro.com/api/v2/position/suggest/en/%s";
    public static final String PATH_TO_CSV_FILE = "result.csv";
    public static final char DELIMITER = ';';

    private static final Logger LOGGER = LoggerFactory.getLogger(CityRestCSVLoadingService.class);

    @Autowired
    RestTemplateBuilder builder;

    private void writeUtf8BomSpecialChars(OutputStream outputStream) throws IOException{
        outputStream.write(239);
        outputStream.write(187);
        outputStream.write(191);
    }

    private void produceCSVFile(List<CityVo> citiesList) throws IOException {
        CSVFormat csvFileFormat = CSVFormat.EXCEL.withHeader((String[])CityVo.FIELDS_LIST.toArray()).withDelimiter(DELIMITER);
        try(OutputStream outputStream = new FileOutputStream(PATH_TO_CSV_FILE)) {
            writeUtf8BomSpecialChars(outputStream);
            try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                 CSVPrinter csvFilePrinter = new CSVPrinter(printWriter, csvFileFormat)
            ) {
                csvFilePrinter.printRecords(citiesList.stream().map(CityVo::asList).collect(Collectors.toList()));
                printWriter.flush();
            }
        }
    }

    @Override
    public void loadData(String location){
        ResponseEntity<List<CityVo>> responseEntity = builder.build().exchange(
                String.format(CITY_REST_API, location),
                HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CityVo>>(){});
        List<CityVo> citiesList = responseEntity.getBody();
        LOGGER.info(String.format("The following data was received from the REST service %s", citiesList.toString()));
        try {
            produceCSVFile(citiesList);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
