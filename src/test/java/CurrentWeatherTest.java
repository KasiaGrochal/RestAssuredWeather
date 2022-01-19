import enums.Cities;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import weatherCurrent.WeatherReq;
import weatherCurrent.WeatherResp;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class CurrentWeatherTest extends TestBase {

    @ParameterizedTest
    @EnumSource(value = Cities.class,mode = EXCLUDE, names = {"INVALID"})
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionBig")
    void validateCityDetailsByCityId(Cities cities) {

        given().
                spec(WeatherReq.getWeatherInfoByCityId(cities)).
        when().
                get().
        then().
                spec(WeatherResp.expectCityDetailsToBe(cities));
    }

    @ParameterizedTest
    @EnumSource(value = Cities.class,mode = EXCLUDE, names = {"INVALID"})
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionSmall")
    void validateCityName(Cities cities) {

        given().
                spec(WeatherReq.getWeatherInfoByCityName(cities)).
        when().
                get().
        then().
                spec(WeatherResp.expectCityNameToBe(cities));
    }

    @ParameterizedTest()
    @EnumSource(value = Cities.class,mode = EXCLUDE, names = {"INVALID"})
    @Tag("weather")
    @Tag("responseBodyValidation")
    @Tag("regressionSmall")
    void validateCityCoordinates(Cities cities) {

        given().
                spec(WeatherReq.getWeatherByCoordinates(cities)).
        when().
                get().
        then().
                spec(WeatherResp.expectCityCoordinatesToBe(cities));
    }

    @ParameterizedTest()
    @EnumSource(value = Cities.class,mode = EXCLUDE, names = {"INVALID"})
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
