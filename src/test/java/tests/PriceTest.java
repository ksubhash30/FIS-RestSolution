package tests;

import endpoints.PriceEndPoint;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PriceTest {

    @Test
    public void validateResponse()
    {
        Response response = PriceEndPoint.readPrice();
        response.then().log().all();
        String jsonResponse = response.asString();
        JsonPath jsonPath = new JsonPath(response.toString());
        boolean isUSDpresent = jsonResponse.contains("\"USD\":");
        boolean isGBPpresent = jsonResponse.contains("\"GBP\":");
        boolean isEURpresent = jsonResponse.contains("\"EUR\":");

        Assert.assertTrue(isUSDpresent,"USD is not present in the response" );
        Assert.assertTrue(isGBPpresent,"GBP is not present in the response");
        Assert.assertTrue(isEURpresent,"EUR is not present in the response");

        String desc = jsonPath.getString("x.bpi.GBP.description");
        Assert.assertEquals(desc,"British Pound Sterling" );

    }
}
