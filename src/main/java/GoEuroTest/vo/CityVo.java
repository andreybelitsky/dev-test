package GoEuroTest.vo;

import java.util.Arrays;
import java.util.List;

public class CityVo {
    public static final List<String> FIELDS_LIST = Arrays.asList("_id", "key", "name", "fullName", "iata_airport_code",
            "type", "country", "latitude", "longitude", "location_id", "inEurope", "countryCode", "coreCountry", "distance");

    private int _id;
    private String key;
    private String name;
    private String fullName;
    private String iata_airport_code;
    private String type;
    private String country;
    private GeoPositionVo geo_position;
    private int location_id;
    private boolean inEurope;
    private String countryCode;
    private boolean coreCountry;
    private String distance;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIata_airport_code() {
        return iata_airport_code;
    }

    public void setIata_airport_code(String iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoPositionVo getGeo_position() {
        return geo_position;
    }

    public void setGeo_position(GeoPositionVo geo_position) {
        this.geo_position = geo_position;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityVo cityVo = (CityVo) o;

        if (_id != cityVo._id) return false;
        if (coreCountry != cityVo.coreCountry) return false;
        if (inEurope != cityVo.inEurope) return false;
        if (location_id != cityVo.location_id) return false;
        if (country != null ? !country.equals(cityVo.country) : cityVo.country != null) return false;
        if (countryCode != null ? !countryCode.equals(cityVo.countryCode) : cityVo.countryCode != null) return false;
        if (distance != null ? !distance.equals(cityVo.distance) : cityVo.distance != null) return false;
        if (fullName != null ? !fullName.equals(cityVo.fullName) : cityVo.fullName != null) return false;
        if (geo_position != null ? !geo_position.equals(cityVo.geo_position) : cityVo.geo_position != null)
            return false;
        if (iata_airport_code != null ? !iata_airport_code.equals(cityVo.iata_airport_code) : cityVo.iata_airport_code != null)
            return false;
        if (key != null ? !key.equals(cityVo.key) : cityVo.key != null) return false;
        if (name != null ? !name.equals(cityVo.name) : cityVo.name != null) return false;
        if (type != null ? !type.equals(cityVo.type) : cityVo.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _id;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (iata_airport_code != null ? iata_airport_code.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (geo_position != null ? geo_position.hashCode() : 0);
        result = 31 * result + location_id;
        result = 31 * result + (inEurope ? 1 : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (coreCountry ? 1 : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CityVo{" +
                "_id=" + _id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iata_airport_code='" + iata_airport_code + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", geo_position=" + geo_position +
                ", location_id=" + location_id +
                ", inEurope=" + inEurope +
                ", countryCode='" + countryCode + '\'' +
                ", coreCountry=" + coreCountry +
                ", distance='" + distance + '\'' +
                '}';
    }
}
