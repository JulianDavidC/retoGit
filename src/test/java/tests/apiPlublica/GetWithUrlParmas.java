package tests.apiPlublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetWithUrlParmas {
    //@Test
    public void getObject(){
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id","1")
                .formParam("id","2");

        Response response = request
                .when()
                .get();

        response.prettyPrint();

    }
    @Test
    public void getObject2(){
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id",4,5);

        Response response = request
                .when()
                .get();

        response.prettyPrint();

    }
}

