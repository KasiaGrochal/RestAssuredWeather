import enums.Cities;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import weatherCurrent.WeatherReq;
import weatherCurrent.WeatherResp;

import static io.restassured.RestAssured.given;

public class CurrentWeatherTest extends TestBase {

    @Test
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionBig")
    void validateCityDetailsByCityId() {

        given().
                spec(WeatherReq.getWeatherInfoByCityId(Cities.GDANSK)).
        when().
                get().
        then().
                spec(WeatherResp.expectCityDetailsToBe(Cities.GDANSK));
    }

    @Test
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionSmall")
    void validateCityName() {

        given().
                spec(WeatherReq.getWeatherInfoByCityName(Cities.OXFORD)).
        when().
                get().
        then().
                spec(WeatherResp.expectCityNameToBe(Cities.OXFORD));
    }

    @Test
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionSmall")
    void validateCityCoordinates() {

        given().
                spec(WeatherReq.getWeatherByCoordinates(Cities.LONDON)).
        when().
                get().
        then().
                spec(WeatherResp.expectCityCoordinatesToBe(Cities.LONDON));
    }

    @Test
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionBig")
    void validateWindValue() {
        Float MAXWIND = 100F;

        given().
                spec(WeatherReq.getWeatherInfoByCityId(Cities.GDANSK)).
        when().
                get().
        then().
                spec(WeatherResp.expectWindToBeLessThan(MAXWIND));
    }

    @Test
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionBig")
    void validateInvalidResponse() {

        given().
                spec(WeatherReq.getWeatherInfoByCityId(Cities.INVALID)).
        when().
                get().
        then().
                spec(WeatherResp.expectBadRequestResponse());
    }




}
