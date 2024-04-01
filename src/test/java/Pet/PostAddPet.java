package Pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.number.OrderingComparison;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.lessThan;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;


public class PostAddPet {
        @Test
        public void AddPetWithStatus200(){
            RestAssured.baseURI = "https://petstore.swagger.io/v2";
            given()
                    .contentType(ContentType.JSON)
                    .body("{\"id\":320,\"category\": {\"id\":1,\"name\": \"orange\"},\"name\": \"doggie\",\"photoUrls\": [\"C:\\\\Users\\\\CompuCloud\\\\Pictures\\\\4.png\"],\"tags\": [{\"id\": 0,\"name\": \"elephant\"}],\"status\": \"available\"}")
                    .when()
                    .post("/pet")
                    .then()
                    .statusCode(200)
                    .log().all(); // Logging response
         }
        @Test
        public void AddPetWithResponseTime(){
            RestAssured.baseURI = "https://petstore.swagger.io/v2";
            given()
                    .contentType(ContentType.JSON)
                    .body("{\"id\":320,\"category\": {\"id\":1,\"name\": \"orange\"},\"name\": \"doggie\",\"photoUrls\": [\"C:\\\\Users\\\\CompuCloud\\\\Pictures\\\\4.png\"],\"tags\": [{\"id\": 0,\"name\": \"elephant\"}],\"status\": \"available\"}")
                    .when()
                    .post("/pet")
                    .then()
                    .time(OrderingComparison.lessThan(5000L))
                    .log().all();
             }
        }
