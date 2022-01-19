package weatherCurrent;


import commons.CommonRequests;
import enums.Cities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class WeatherReq extends CommonRequests {


    public static RequestSpecification getWeatherInfoByCityName(Cities city) {
        return new RequestSpecBuilder().
                addParam(CITY, city.getCityName() + city.getCountry()).
                build().spec(setBase());
    }

    public static RequestSpecification getWeatherInfoByCityId(Cities city) {
        return new RequestSpecBuilder().
                addParam(ID, city.getCityId()).
                build().spec(setBase());
    }

    public static RequestSpecification getWeatherByCoordinates(Cities city) {
        return new RequestSpecBuilder().
                addParam(LON, city.getLon()).
                addParam(LAT, city.getLat()).
                build().spec(setBase());
    }

    public static RequestSpecification setBase() {
        return setBasePath(WEATHER);
    }

}
