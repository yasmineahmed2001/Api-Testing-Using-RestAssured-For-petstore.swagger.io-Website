package Pet;

import de.sciss.file.File;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class PostUploadImage {
    @BeforeTest
    public void precondition(){
        PostAddPet p=new PostAddPet();
        p.AddPetWithStatus200();
    }
    @Test(priority = 1)
    public void UploadImageWithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        given()
                .multiPart("file",("C://Users//CompuCloud//Pictures//dog.jpg"))
                .when()
                .post("/pet/320/uploadImage")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }
    @Test(priority = 2)
    public void UploadImageWithResponseTime(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .multiPart("file",("C:/Users/CompuCloud/Pictures/dog.jpg"))
                .when()
                .post("/pet/320/uploadImage")
                .then()
                .time(lessThan(5000L))
                .log().all()
                .extract().response();
    }
}
