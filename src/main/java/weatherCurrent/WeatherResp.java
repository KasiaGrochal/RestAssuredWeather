package weatherCurrent;

import commons.CommonResponses;
import enums.Cities;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class WeatherResp extends CommonResponses {

    public static ResponseSpecification expectWindToBeLessThan(Float windValue) {
        return new ResponseSpecBuilder().
                expectBody(WIND + SPEED, lessThan(windValue)).
                build().spec(isStatus200());
    }

    public static ResponseSpecification expectCityNameToBe(Cities city) {
        return new ResponseSpecBuilder().
                expectBody(CITYNAME, equalTo(city.getCityName())).
                build().spec(isStatus200());
    }

    public static ResponseSpecification expectCityCoordinatesToBe(Cities city) {
        return new ResponseSpecBuilder().
                expectBody(COORD + LON, is(city.getLon())).
                expectBody(COORD + LAT, is(city.getLat())).
                build().spec(isStatus200());
    }

    public static ResponseSpecification expectCityIdToBe(Cities city) {
        return new ResponseSpecBuilder().
                expectBody(ID, is(Integer.parseInt(city.getCityId()))).
                build().spec(isStatus200());
    }

    public static ResponseSpecification expectCityDetailsToBe(Cities city) {
        return new ResponseSpecBuilder().build().
                spec(expectCityIdToBe(city).
                spec(expectCityNameToBe(city).
                spec(expectCityCoordinatesToBe(city))));
    }


}
