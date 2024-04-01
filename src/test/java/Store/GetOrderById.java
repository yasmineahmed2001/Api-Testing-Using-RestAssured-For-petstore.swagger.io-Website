package Store;

import Pet.PostAddPet;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class GetOrderById {
    @Test(priority=0)
    public void precondition(){
        PostCreatePlaceOrder p=new PostCreatePlaceOrder();
        p.AddOrderwithStatus200();
    }
    @Test(priority = 1)
    public void GetOrderByIdwithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/store/order/550")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test(priority = 2)
    public void GetOrderByIdwithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/store/order/550")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }

}
