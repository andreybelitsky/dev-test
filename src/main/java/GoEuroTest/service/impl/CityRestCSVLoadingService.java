package GoEuroTest.service.impl;

import GoEuroTest.service.CSVLoadingService;
import GoEuroTest.vo.CityVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityRestCSVLoadingService implements CSVLoadingService {
    public static final String CITY_REST_API = "http://api.goeuro.com/api/v2/position/suggest/en/%s";
    private static final Logger log = LoggerFactory.getLogger(CityRestCSVLoadingService.class);

    @Autowired
    RestTemplateBuilder builder;

    @Override
    public void loadData(String location){
        ResponseEntity<List<CityVO>> citiesList = builder.build().exchange(
                String.format(CITY_REST_API, location),
                HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CityVO>>(){});
    }
}
