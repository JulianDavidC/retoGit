package tests.apiPlublica;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

//Julian Chica

public class CreateObject {
    String path   = "./Reporte/Apis.html";
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(path);
    ExtentTest test;

    @Test
    public void createObject(){
        try {
            extent.attachReporter(spark);
            test = extent.createTest("Prueba");
            File postBody = new File("src/main/resources/createObject.json");
            test.log(Status.INFO,"Paso la ruta del body que es " +postBody);
            RequestSpecification request = given()
                    .baseUri("https://api.restful-api.dev")
                    .basePath("/objects")
                    .header("Content-Type","application/json")
                    .body(postBody);

            Response response = request
                    .when()
                    .post();

            test.log(Status.INFO,"Se realizo el consumo del api");
            response.prettyPrint();
            int statusCode = response.getStatusCode();
            test.log(Status.INFO,"El Status code es" +statusCode);
            Assert.assertEquals(statusCode, 200);
            test.log(Status.PASS,"Fue exito el test");
        }catch (Exception e){
            test.log(Status.FAIL,"El Fallido el test" + e);
        }
        extent.flush();
    }
}
