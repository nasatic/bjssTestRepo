package StepDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiStepDef {
    String sUserUrl = "https://reqres.in/api/users/2";
    String mUserUrl = "https://reqres.in/api/users?page=2";
    String noUserUrl = "https://reqres.in/api/users/23";
    String loginUrl = "https://reqres.in/api/login";
    String regUrl = "https://reqres.in/api/register";
    String addUserUrl = "https://reqres.in/api/users";

    @BeforeTest
    public Response setValResponse() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(sUserUrl);
        return res;
    }

    public Response setValResForNoUser() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(noUserUrl);
        return res;
    }

    public Response setValResForLoginUrl() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(loginUrl);
        return res;
    }

    public Response setValResForRegUrl() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(regUrl);
        return res;
    }

    public Response setValResForAddUsrUrl() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(addUserUrl);
        return res;
    }

    public Response setValResponseM() {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get(mUserUrl);
        return res;


    }


    @When("^User makes a GET request to endpoint \"([^\"]*)\"$")
    public void userMakesAGETRequestToEndpoint(String url) throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then().log().all();
    }

    @Then("^Response code should be \"([^\"]*)\"$")
    public void responseCodeShouldBe(int statusCode) throws Throwable {
        Assert.assertEquals(setValResponseM().statusCode(), statusCode);

    }

    @And("^Response body for case \"([^\"]*)\" should contain response data \"([^\"]*)\"$")
    public void responseBodyForCaseShouldContainResponseData(String swcase, String data) {

        switch (swcase) {
            case "many":
                Assert.assertEquals(setValResponseM().then().extract().path("data[1].last_name"), (data));
                break;
            case "single":
                Assert.assertEquals(setValResponse().then().extract().path("data.first_name"), (data));
                break;
            case "none":
                System.out.println("xxxxx No response body xxxxxx");
                break;
        }
        System.out.println("***** Invalid selection *****");


    }



    @And("^Response body should contain multiple response data$")
    public void responseBodyShouldContainMultipleResponseData() throws Throwable {
        String index1data = setValResponseM().then().extract().path("data[0].first_name");
        int index3data = setValResponseM().then().extract().path("data[2].id");
        Assert.assertEquals(index1data, "Eve");
        Assert.assertEquals(index3data, 6);


    }

    @When("^User makes a GET request$")
    public void userMakesAGETRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User makes a POST request to endpoint \"([^\"]*)\"$")
    public void userMakesAPOSTRequestToEndpoint(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Response body should contain posted data \"([^\"]*)\"$")
    public void responseBodyShouldContainPostedData(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User makes a PUT request to endpoint \"([^\"]*)\"$")
    public void userMakesAPUTRequestToEndpoint(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Response body should contain updated data \"([^\"]*)\"$")
    public void responseBodyShouldContainUpdatedData(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User makes a PATCH request to endpoint \"([^\"]*)\"$")
    public void userMakesAPATCHRequestToEndpoint(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Response body should contain patched data \"([^\"]*)\"$")
    public void responseBodyShouldContainPatchedData(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User makes a DELETE request to endpoint \"([^\"]*)\"$")
    public void userMakesADELETERequestToEndpoint(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Response body should not contain deleted data \"([^\"]*)\"$")
    public void responseBodyShouldNotContainDeletedData(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User makes a request to endpoint \"([^\"]*)\" using payload for \"([^\"]*)\"$")
    public void userMakesARequestToEndpointUsingPayloadFor(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Response body should contain data \"([^\"]*)\"$")
    public void responseBodyShouldContainData(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^User makes a POST request to endpoint \"([^\"]*)\" using payload for \"([^\"]*)\"$")
    public void userMakesAPOSTRequestToEndpointUsingPayloadFor(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Response code should be \"([^\"]*)\" for \"([^\"]*)\"$")
    public void responseCodeShouldBeFor(int code, String selectCase) throws Throwable {
        switch (selectCase) {
            case "many":
                Assert.assertEquals(setValResponseM().statusCode(), code);
                break;
            case "single":
                Assert.assertEquals(setValResponse().statusCode(), code);
                break;
            case "none":
                Assert.assertEquals(setValResForNoUser().statusCode(), code);
                break;
        }
    }

}
