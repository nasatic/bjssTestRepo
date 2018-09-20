package StepDef;

import Utility.PayLoad;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class ApiStepDef {
    Logger logger = Logger.getLogger("ApiStepDef");
    PayLoad payLoad = new PayLoad();
    String sUserUrl = "https://reqres.in/api/users/2";
    String mUserUrl = "https://reqres.in/api/users?page=2";
    String noUserUrl = "https://reqres.in/api/users/23";
    String loginUrl = "https://reqres.in/api/login";
    String regUrl = "https://reqres.in/api/register";
    String addUserUrl = "https://reqres.in/api/users";

    @BeforeTest
    public Response setValResponse() {
        Response res = given().contentType(ContentType.JSON).when().get(sUserUrl);
        return res;
    }

    public Response setValResForNoUser() {
        Response res = given().contentType(ContentType.JSON).when().get(noUserUrl);
        return res;
    }

    public Response getPostForLoginPass() {
        Response res = given().contentType(ContentType.JSON).with().body(payLoad.postLoginSuccess()).when().post(loginUrl);
        return res;
    }

    public Response getPostLoginFail() {
        Response res = given().contentType(ContentType.JSON).with().body(payLoad.postLoginFailure()).when().post(loginUrl);
        return res;
    }

    public Response getPostRegPass() {
        Response res = given().contentType(ContentType.JSON).with().body(payLoad.postRegSuccess()).when().post(regUrl);
        return res;
    }

    public Response getPostRegFail() {
        Response res = given().contentType(ContentType.JSON).with().body(payLoad.postRegFailure()).when().post(regUrl);
        return res;
    }

    public Response getPostAddUser() {
        Response res = given().contentType(ContentType.JSON).with().body(payLoad.postCreateUser()).when().post(addUserUrl);
        return res;
    }

    public Response getResponseFromPut() {
        Response res = given().contentType(ContentType.JSON).with().body(payLoad.putPayLoad()).put(sUserUrl);
        return res;
    }

    public Response getResponseFromPatch() {
        Response res = given().contentType(ContentType.JSON).with().body(payLoad.patchPayLoad()).patch(sUserUrl);
        return res;
    }

    public Response getResponseFromDelete() {
        Response res = given().contentType(ContentType.JSON).when().delete(sUserUrl);
        return res;
    }

    public Response setValResponseM() {
        Response res = given().contentType(ContentType.JSON).when().get(mUserUrl);
        return res;

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
                logger.info("xxxxx No response body xxxxxx");
                break;

            case "PUT":
                Assert.assertEquals(getResponseFromPut().then().extract().path("job"), ((data)));
                break;

            case "PATCH":
                Assert.assertEquals(getResponseFromPatch().then().extract().path("name"), ((data)));
                break;

            case "DELETE":
                Assert.assertTrue(getResponseFromDelete().asString().isEmpty());
                break;

            case "loginMissingPswd":
                Assert.assertEquals(getPostLoginFail().then().extract().path("error"), ((data)));
                break;

            case "LoginCorrectPswd":
                Assert.assertEquals(getPostForLoginPass().then().extract().path("token"), ((data)));
                break;

            case "RegMissingPswd":
                Assert.assertEquals(getPostRegFail().then().extract().path("error"), ((data)));
                break;
            case "RegCorrectPswd":
                Assert.assertEquals(getPostRegPass().then().extract().path("token"), ((data)));
                break;
            case "PostToAddUser":
                Assert.assertEquals(getPostAddUser().then().extract().path("name"), ((data)));
                break;
        }

    }

    @When("^User makes a request to endpoint \"([^\"]*)\" using payload for \"([^\"]*)\"$")
    public void userMakesARequestToEndpointUsingPayloadFor(String url, String reqType) throws Throwable {
        switch (reqType) {
            case "PUT":
                given().contentType(ContentType.JSON).with().body(payLoad.putPayLoad()).when().put(url);
                break;

            case "many":
                given().contentType(ContentType.JSON).when().log().all().get(mUserUrl);
                break;
            case "single":
                given().contentType(ContentType.JSON).when().log().all().get(sUserUrl);
                break;
            case "none":
                given().contentType(ContentType.JSON).when().log().all().get(noUserUrl);
                break;

            case "PATCH":
                given().contentType(ContentType.JSON).with().body(payLoad.patchPayLoad()).when().post(url);
                break;
            case "DELETE":
                given().contentType(ContentType.JSON).when().delete(url);
                break;

            case "loginMissingPswd":
                getPostLoginFail();
                break;

            case "LoginCorrectPsw":
                getPostForLoginPass();
                break;

            case "RegMissingPswd":
                getPostRegFail();
                break;

            case "RegCorrectPswd":
                getPostRegPass();
                break;

            case "PostToAddUser":
                getPostAddUser();
                break;
        }

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

    @Then("^Response code for \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void responseCodeForShouldBe(String reqtype, int code) throws Throwable {
        switch (reqtype) {
            case "PUT":
                Assert.assertEquals(getResponseFromPut().statusCode(), code);
                break;
            case "PATCH":
                Assert.assertEquals(getResponseFromPatch().statusCode(), code);
                break;
            case "DELETE":
                Assert.assertEquals(getResponseFromDelete().statusCode(), code);
                break;
        }

    }
}
