package tests.apiPlublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

//Julian Chica

public class GetObjects {
    @Test
    @Parameters({"id","expectedStatusCode"})
    public void getObject(String id, int expectedStatusCode ){
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");

        Response response = request
                .when()
                .get(id);

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode);

        /*JSONObject jsonResponse = new JSONObject(response.asString());
        String name = jsonResponse.getString("name");
        System.out.println(name);


        JSONObject jsonData =  jsonResponse.getJSONObject("data");
        String cpuModel = jsonData.getString("CPU model");
        System.out.println(cpuModel);*/
    }
}
