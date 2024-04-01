package Users;

import Store.PostCreatePlaceOrder;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class DeleteUser {
    @BeforeTest
    public void precondition(){
        PostCreateUsersWithArrayInputs p=new PostCreateUsersWithArrayInputs();
        p.CreateUsersWithArrayInputswithStatus200();
    }
    @Test(priority = 1)
    public void DeletUserwithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .delete("/user/yasmine123")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test(priority = 2)
    public void DeleteUserwithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        long startTime = System.currentTimeMillis();
        given()
                .when()
                .delete("/user/yasmine123")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}
