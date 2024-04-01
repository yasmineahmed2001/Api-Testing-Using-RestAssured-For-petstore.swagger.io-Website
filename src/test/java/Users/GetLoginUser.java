package Users;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class GetLoginUser {
    @BeforeTest
    public void precondition(){
        PostCreateUsersWithArrayInputs p=new PostCreateUsersWithArrayInputs();
        p.CreateUsersWithArrayInputswithStatus200();
    }
    @Test(priority = 1)
    public void UserByUsernamewithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/user/login?yasmine123&llll")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
    @Test(priority = 2)
    public void UserByUsernamewithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/user/login?yasmine123&llll")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
}
