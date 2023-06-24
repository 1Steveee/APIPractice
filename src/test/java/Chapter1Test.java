import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter1Test {

    @Test
    public void testRequestGetPlaceName() {
        final String SITE = "http://api.zippopotam.us/us/33803";


        given().
                when().
                get(SITE).
                then().log().body().
                assertThat().
                body("places[0].'place name'", equalTo("Lakeland"));
    }
}
