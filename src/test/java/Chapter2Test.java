import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Chapter2Test {
    final String BASE_URL = "http://api.zippopotam.us/us/33803";

    @Test
    public void testHttpResponseStatusCode() {

//        Validates StatusCode == 200
        given().
                when().
                get(BASE_URL).
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void testResponseContentType() {
//        String literal can also be passed as an argument

        given().
                when().
                get(BASE_URL).
                then().
                assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void testLogRequestAndResponse() {
//        Log - prints to the console any information related to response or request

        given().
                log().
                cookies().
                when().
                get(BASE_URL).
                then().
                log().
                body();
    }

    @Test
    public void testGetRequestPostCode() {

        given().
                when().
                get(BASE_URL).
                then().
                assertThat().
                body("'post code'", equalTo("33803"));
    }

    @Test
    public void testResponsePlaceArrayHasSizeOne() {
        given().
                when().
                get(BASE_URL).
                then().
                assertThat().
                body("'places'", hasSize(1));
    }

    @Test
    public void testResponseHasKeyCountry() {
        given().
                when().
                get(BASE_URL).
                then().
                assertThat().
                body("$", hasKey("country abbreviation"));
    }


}
