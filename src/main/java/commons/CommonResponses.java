package commons;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import providers.ParamProvider;


public class CommonResponses extends ParamProvider {

    protected static ResponseSpecification isStatus200() {
        return new ResponseSpecBuilder().
                expectStatusCode(200).
                build();
    }

    public static ResponseSpecification isStatus400() {
        return new ResponseSpecBuilder().
                expectStatusCode(400).
                build();
    }
}
