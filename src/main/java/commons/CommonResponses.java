package commons;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import providers.ParamProvider;

import static org.hamcrest.Matchers.equalTo;


public class CommonResponses extends ParamProvider {

    protected static ResponseSpecification isStatus200() {
        return new ResponseSpecBuilder().
                expectStatusCode(Integer.parseInt(SUCCESS)).
                build();
    }


    public static ResponseSpecification expectBadRequestResponse() {
        return new ResponseSpecBuilder().
                expectStatusCode(Integer.parseInt(BADREQUEST)).
                expectBody(COD, equalTo(BADREQUEST)).
                build();
    }
}
