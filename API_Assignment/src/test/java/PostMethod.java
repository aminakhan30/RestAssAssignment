import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostMethod {

    @Test
    public void UpdateUser() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        String reqBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response postResponse = given()
                .header("content-type", "application/json")
                .body(reqBody).post("/api/users/2");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 201, "Expected 201 " + postResponse.getStatusCode());
    }


    @Test
    public void UpdateUser1() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        Response postResponse = given()
                .header("content-type", "application/json")
                .body(reqBody).post("/api/register");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 200, "Expected 200 " + postResponse.getStatusCode());
    }


    @Test
    public void UpdateUser2() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";
        Response postResponse = given()
                .header("content-type", "application/json")
                .body(reqBody).post("/api/register");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),400, "Expected 400" + postResponse.getStatusCode());
    }
    @Test
    public void UpdateUser3() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        Response postResponse = given()
                .header("content-type", "application/json")
                .body(reqBody).post("/api/login");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),200, "Expected 200" + postResponse.getStatusCode());
    }

    @Test
    public void UpdateUser4() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";
        Response postResponse = given()
                .header("content-type", "application/json")
                .body(reqBody).post("api/login");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),400, "Expected 400" + postResponse.getStatusCode());
    }
}

