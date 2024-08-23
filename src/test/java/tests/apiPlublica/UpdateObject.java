package tests.apiPlublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

//Julian Chica

public class UpdateObject{
@Test
    public void updateObject(){
        File putBody = new File("src/main/resources/putObject.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(putBody);

        Response response = request
                .when()
                .put("/ff80818190966d7f01909ad66df20ca8");

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
