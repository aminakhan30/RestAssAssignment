import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetMethod {

    @Test
    public void getUsers() {
        Response response = given().header("content-type", "application/json").get("https://reqres.in/api/users");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected response code was 200 but found" + response.statusCode());
    }

    @Test
    public void getUsers1() {
        Response response = given().header("content-type", "application/json").get("https://reqres.in/api/users/2");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected response code was 200 but found" + response.statusCode());
    }

    @Test
    public void getUsers2() {
        Response response = given().header("content-type", "application/json").get("https://reqres.in/api/users/23");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 404, "Expected response code was 404 but found" + response.statusCode());
    }
    @Test
    public void getUsers3() {
        Response response = given().header("content-type", "application/json").get("https://reqres.in/api/users?delay=3");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected response code was 200 but found" + response.statusCode());
    }

    @Test
    public void getUsers4() {
        Response response = given().header("content-type", "application/json").get("https://reqres.in/api/unknown/23");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 404, "Expected response code was 404 but found" + response.statusCode());
    }
    @Test
    public void getUsers5() {
        Response response = given().header("content-type", "application/json").get("https://reqres.in/api/users?page=2");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected response code was 200 but found" + response.statusCode());
    }
    @Test
    public void getUsers6() {
        Response response = given().header("content-type", "application/json").get("https://reqres.in/api/unknown");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected response code was 200 but found" + response.statusCode());
    }

}

