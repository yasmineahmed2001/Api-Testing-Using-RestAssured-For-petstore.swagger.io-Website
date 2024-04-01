package Users;

import Pet.PostAddPet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class PutUpdateUser {
    @BeforeTest
    public void precondition(){
        PostCreateUsersWithArrayInputs p=new PostCreateUsersWithArrayInputs();
        p.CreateUsersWithArrayInputswithStatus200();
    }
    @Test(priority = 1)
    public void UpdatePetWithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\": 0,\"username\": \"youmna123\",\"firstName\": \"youmna\",\"lastName\": \"ahmed\",\"email\": \"youmna@gmail.com\",\"password\": \"llll\",\"phone\": \"01023654789\",\"userStatus\": 2}")
                .when()
                .put("/user/yasmine123")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test(priority = 2)
    public void UpdatePetWithResponseTime(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\": 0,\"username\": \"youmna123\",\"firstName\": \"youmna\",\"lastName\": \"ahmed\",\"email\": \"youmna@gmail.com\",\"password\": \"llll\",\"phone\": \"01023654789\",\"userStatus\": 2}")
                .when()
                .post("/user/yasmine123")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }

}
