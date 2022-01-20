package enums;

public enum Cities {
    LONDON("London", ",uk", "2643743", 51.5085f, -0.1257f),
    OXFORD("Oxford", ",uk", "2640729", 51.7522f, -1.256f),
    GDANSK("Gdańsk", ",pl", "3099434", 54.3521f, 18.6464f),
    INVALID("XXX", "xx", "0", 99.99f, 99.99f);

    private final String cityName;
    private final String country;
    private final String cityId;
    private final Float lat;
    private final Float lon;

    Cities(String cityName, String country, String cityId, Float lat, Float lon) {
        this.cityName = cityName;
        this.country = country;
        this.cityId = cityId;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCountry() {
        return country;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLon() {
        return lon;
    }
}
