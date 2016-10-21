package GoEuroTest.service;

import GoEuroTest.service.impl.CityRestCSVLoadingService;
import GoEuroTest.vo.CityVo;
import GoEuroTest.vo.GeoPositionVo;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

public class CityRestCSVLoadingServiceTest {
    private CityRestCSVLoadingService sut = new CityRestCSVLoadingService();

    @Test
    public void convertToListCity() {
        CityVo cityVo = new CityVo();
        GeoPositionVo geoPositionVo = new GeoPositionVo();
        cityVo.set_id(376217);
        cityVo.setKey(null);
        cityVo.setName("Berlin");
        cityVo.setFullName("Berlin, Germany");
        cityVo.setIata_airport_code(null);
        cityVo.setType("location");
        cityVo.setCountry("Germany");
        geoPositionVo.setLatitude("52.52437");
        geoPositionVo.setLongitude("13.41053");
        cityVo.setGeo_position(geoPositionVo);
        cityVo.setLocation_id(0);
        cityVo.setInEurope(true);
        cityVo.setCountryCode("DE");
        cityVo.setCoreCountry(true);
        cityVo.setDistance(null);
        assertThat(sut.convertToList(cityVo), is(Arrays.asList("376217", null, "Berlin", "Berlin, Germany", null, "location", "Germany", "52.52437", "13.41053", "0", "true", "DE", "true", null)));
    }

    @Test
    public void convertToListCityAirport() {
        CityVo cityVo = new CityVo();
        GeoPositionVo geoPositionVo = new GeoPositionVo();
        cityVo.set_id(314826);
        cityVo.setKey(null);
        cityVo.setName("Berlin Tegel");
        cityVo.setFullName("Berlin Tegel (TXL), Germany");
        cityVo.setIata_airport_code("TXL");
        cityVo.setType("airport");
        cityVo.setCountry("Germany");
        geoPositionVo.setLatitude("52.3887261");
        geoPositionVo.setLongitude("13.5180874");
        cityVo.setGeo_position(geoPositionVo);
        cityVo.setLocation_id(0);
        cityVo.setInEurope(true);
        cityVo.setCountryCode("DE");
        cityVo.setCoreCountry(true);
        cityVo.setDistance(null);
        assertThat(sut.convertToList(cityVo), is(Arrays.asList("314826", null, "Berlin Tegel", "Berlin Tegel (TXL), Germany", "TXL", "airport", "Germany", "52.3887261", "13.5180874", "0", "true", "DE", "true", null)));
    }

    @Test
    public void convertToListCityAirportWithUnicodeChar() {
        CityVo cityVo = new CityVo();
        GeoPositionVo geoPositionVo = new GeoPositionVo();
        cityVo.set_id(314827);
        cityVo.setKey(null);
        cityVo.setName("Berlin Schönefeld");
        cityVo.setFullName("Berlin Schönefeld (SXF), Germany");
        cityVo.setIata_airport_code("SXF");
        cityVo.setType("airport");
        cityVo.setCountry("Germany");
        geoPositionVo.setLatitude("52.3887261");
        geoPositionVo.setLongitude("13.5180874");
        cityVo.setGeo_position(geoPositionVo);
        cityVo.setLocation_id(0);
        cityVo.setInEurope(true);
        cityVo.setCountryCode("DE");
        cityVo.setCoreCountry(true);
        cityVo.setDistance(null);
        assertThat(sut.convertToList(cityVo), is(Arrays.asList("314827", null, "Berlin Schönefeld", "Berlin Schönefeld (SXF), Germany", "SXF", "airport", "Germany", "52.3887261", "13.5180874", "0", "true", "DE", "true", null)));
    }

    @Test
    public void convertToListTwoWordCity() {
        CityVo cityVo = new CityVo();
        GeoPositionVo geoPositionVo = new GeoPositionVo();
        cityVo.set_id(316321);
        cityVo.setKey(null);
        cityVo.setName("San Francisco");
        cityVo.setFullName("San Francisco (SFO), USA");
        cityVo.setIata_airport_code("SFO");
        cityVo.setType("location");
        cityVo.setCountry("USA");
        geoPositionVo.setLatitude("37.61522");
        geoPositionVo.setLongitude("-122.39");
        cityVo.setGeo_position(geoPositionVo);
        cityVo.setLocation_id(0);
        cityVo.setInEurope(false);
        cityVo.setCountryCode("US");
        cityVo.setCoreCountry(false);
        cityVo.setDistance(null);
        assertThat(sut.convertToList(cityVo), is(Arrays.asList("316321", null, "San Francisco", "San Francisco (SFO), USA", "SFO", "location", "USA", "37.61522", "-122.39", "0", "false", "US", "false", null)));
    }

    @Test
    public void convertToListCityWithHyphen() {
        CityVo cityVo = new CityVo();
        GeoPositionVo geoPositionVo = new GeoPositionVo();
        cityVo.set_id(455571);
        cityVo.setKey(null);
        cityVo.setName("Porto-Novo");
        cityVo.setFullName("Porto-Novo, Benin");
        cityVo.setIata_airport_code(null);
        cityVo.setType("location");
        cityVo.setCountry("Benin");
        geoPositionVo.setLatitude("6.49646");
        geoPositionVo.setLongitude("2.60359");
        cityVo.setGeo_position(geoPositionVo);
        cityVo.setLocation_id(0);
        cityVo.setInEurope(false);
        cityVo.setCountryCode("BJ");
        cityVo.setCoreCountry(false);
        cityVo.setDistance(null);
        assertThat(sut.convertToList(cityVo), is(Arrays.asList("455571", null, "Porto-Novo", "Porto-Novo, Benin", null, "location", "Benin", "6.49646", "2.60359", "0", "false", "BJ", "false", null)));
    }
}
