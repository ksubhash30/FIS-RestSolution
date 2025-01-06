package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PriceEndPoint {
    public static Response readPrice() {
        Response response = given()
                .when()
                .get(Routes.url)
                .then()
                .extract().response();
        return response;
    }
}
