package weatherCurrent;

import commons.CommonResponses;
import enums.Cities;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

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
                expectBody(COORD + LON, equalTo(city.getLon())).
                expectBody(COORD + LAT, equalTo(city.getLat())).
                build().spec(isStatus200());
    }


}
