package Users;

import io.restassured.RestAssured;
import net.bytebuddy.build.Plugin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class GetUserByUsername {
    @Test(priority = 0)
    public void precondition(){
        PostCreateUsersWithArrayInputs p=new PostCreateUsersWithArrayInputs();
        p.CreateUsersWithArrayInputswithStatus200();
    }@Test(priority = 1)
    public void GetUserByUsernamewithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/user/yasmine123")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test(priority = 2)
    public void GetUserByUsernamewithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/user/yasmine123")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }

}
