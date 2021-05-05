import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteMethod {

    @Test
    public void UpdateUser() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        Response postResponse = given()
                .header("content-type", "application/json")
                .delete("/api/users/2");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 204, "Expected 204 " + postResponse.getStatusCode());
    }
}

