package RestA;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import static io.restassured.RestAssured.*;

public class RestPractice {

    @Test
    public void propertyLossFlow()  {
        // Base URI
        RestAssured.baseURI = "http://82.29.165.20:30801";

        // Step 1: Get OTP
        Response otpResponse = given()
                .queryParam("MobileNumber", "8207798022")
                .when()
                .post("/apdims/mobile/auth/guest/login")
                .then()
                .statusCode(200)
                .extract().response();

        int otp = otpResponse.jsonPath().getInt("data");
        System.out.println("OTP received: " + otp);
        System.out.println("Get OTP Response Time: " + otpResponse.getTime() + " ms");

        // Step 2: Verify OTP and get token
        Response verifyResponse = given()
                .queryParam("MobileNumber", "8207798022")
                .queryParam("otp", otp)
                .when()
                .post("/apdims/mobile/auth/guest/verify/otp")
                .then()
                .statusCode(200)
                .extract().response();

        String token = verifyResponse.jsonPath().getString("data.token");
        System.out.println("Token: " + token);

        // Step 3: Prepare request body
        String requestBody = "{\r\n"
        		+ "\"reportedBy\": \"Chiranjeevi\",\r\n"
        		+ "\"reportedByPhone\": \"9669839441\",\r\n"
        		+ "\"description\": \"In guntur center\",\r\n"
        		+ "\"incidentType\": \"Chemical Incident\",\r\n"
        		+ "\"userPriority\": \"URGENT\",\r\n"
        		+ "\"status\": \"OPEN\",\r\n"
        		+ "\"location\": \"GNT\",\r\n"
        		+ "\"dateReported\": \"2025-07-16T13:00:14.1\",\r\n"
        		+ "\"address\": \"jkc Main Street\",\r\n"
        		+ "\"village\": \"Guntur\",\r\n"
        		+ "\"city\": \"kakinada\",\r\n"
        		+ "\"country\": \"India\",\r\n"
        		+ "\"state\": \"Andhra Pradesh\",\r\n"
        		+ "\"pincode\": \"520002\",\r\n"
        		+ "\"district\":\"Vijayawada\",\r\n"
        		+ "\"curr_lat\":\"\",\r\n"
        		+ "\"curr_lon\":\"\"\r\n"
        		+ "}";

        // File to upload
        File file1 = new File("C:\\Users\\mjirs\\OneDrive\\Desktop\\boat.png");

        // Step 4: Send Property Loss API request
        Response propertyLoss = given()
                .header("Authorization", token)
                .multiPart("mediaFiles", file1, "image/png")                 
                .multiPart("incident", requestBody,"application/json")
                .log().all()
                .when()
                .post("/apdims/api/v1.0/incidents")
                .then().body("success",equalTo(true))
                .extract().response();
        
        System.out.println("Final Response: " + propertyLoss.asString());
        System.out.println("Property Loss API Response Time: " + propertyLoss.getTime() + " ms");
        System.out.println("otp response time      "+otpResponse.getTime());
    }
}
