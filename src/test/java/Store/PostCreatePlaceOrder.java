package Store;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class PostCreatePlaceOrder {
    @Test
    public void AddOrderwithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\": 550,\"petId\": 220,\"quantity\": 2,\"shipDate\": \"2024-03-11T05:27:59.163Z\",\"status\": \"sold\",\"complete\": true}")
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test
    public void AddOrderwithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\": 550,\"petId\": 220,\"quantity\": 2,\"shipDate\": \"2024-03-11T05:27:59.163Z\",\"status\": \"sold\",\"complete\": true}")
                .when()
                .post("/store/order")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}


