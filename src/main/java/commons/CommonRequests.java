package commons;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import providers.ParamProvider;


public class CommonRequests extends ParamProvider {

    public static RequestSpecification setBasePath(String path) {
        return new RequestSpecBuilder().
                setBasePath(path).
                build();
    }


}
