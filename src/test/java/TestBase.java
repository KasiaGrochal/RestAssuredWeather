import config.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

@Slf4j
public class TestBase {

    public static Map<String, String> config;

    @BeforeAll
    static void setUpProject() {
        config = Config.getEnvironmentConfig().getProperties();
        RestAssured.requestSpecification = getCommonReqSpec();
        RestAssured.responseSpecification = getCommonRespSpec();
    }


    public static RequestSpecification getCommonReqSpec() {
        return new RequestSpecBuilder().
                setBaseUri(config.get("baseUri")).
                addParam("appid", config.get("appid")).
                build().
                filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public static ResponseSpecification getCommonRespSpec() {
        Long expRespTime = Long.valueOf(config.get("expRespTime"));
        return new ResponseSpecBuilder().
                expectResponseTime(Matchers.lessThan(expRespTime)).
                build();
    }


}
