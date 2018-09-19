package StepDef;

import Pages.AutoPracticeMainPage;
import Pages.OrderDetailsPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.net.MalformedURLException;

import static Utility.BaseClass.driver;

public class PurchaseStepDef {
    Logger logger = Logger.getLogger("PurchaseStepDef");
    AutoPracticeMainPage auto = new AutoPracticeMainPage(driver);
    OrderDetailsPage order = new OrderDetailsPage(driver);

    @Given("^User is logged into site$")
    public void UserIsLoggedIntoSite() throws MalformedURLException, InterruptedException {
        auto.startBrowser();
        Thread.sleep(3000);
        auto.clickOnSignIn();
        Thread.sleep(2000);
        auto.enterUsername("bjsstest@bjss.com");
        Thread.sleep(2000);
        auto.enterPassword("BJSSTest");
        Thread.sleep(2000);
        auto.clickOnLogin();
        Thread.sleep(3000);


    }

    @When("^User selects an item to view$")
    public void UserSelectsAnItemToView() throws InterruptedException {
        auto.selectBlouseItem();
        logger.info("Logged into account");
    }

    @Then("^Selection is displayed on page$")
    public void SelectionIsDisplayedOnPage() throws InterruptedException {
        auto.verifyBlouseItem();
        Thread.sleep(2000);

    }
    @When("^User changes the size of selected item to \"([^\"]*)\"$")
    public void userChangesTheSizeOfSelectedItemTo(String size) throws Throwable {
        auto.selectSize(size);
        Thread.sleep(2000);
    }

    @And("^User adds item to basket$")
    public void UserAddsItemToBasket() {
        auto.addProductToCart();
        logger.info("***added to cart****");
    }


    @And("^The total is sum of the item cost plus shipping$")
    public void theTotalIsSumOfTheItemCostPlusShipping() {
        logger.info("***** Yet to be implemented *****");
    }


    @When("^User checks out$")
    public void userChecksOut() throws InterruptedException {
        Thread.sleep(2000);
        auto.gotoShoopingCart();
    }

    @Then("^User completes payment by wire$")
    public void userCompletesPaymentByWire() throws InterruptedException {
        auto.checkoutAndPayByWire();
        auto.verifyCompleteOder();

    }

    @And("^User logs out of application$")
    public void userLogsOutOfApplication() throws InterruptedException {
        auto.logout();
        Thread.sleep(2000);
        auto.closeAndQuitBrowser();
    }


    @When("^User selects an \"([^\"]*)\" to view$")
    public void userSelectsAnToView(String itemType) throws Throwable {

        switch (itemType) {
            case "Blouse":
                auto.selectBlouseItem();
                break;
            case "PrintedDress":
                auto.selectPrintedItem();
                break;
        }
        logger.info("*****No match returned*******");
    }

    @Then("^Previously selected size \"([^\"]*)\" is displayed on basket page$")
    public void previouslySelectedSizeIsDisplayedOnBasketPage(String size) throws Throwable {
        auto.selectSize(size);
        Thread.sleep(2000);
    }

    @And("^Selection for \"([^\"]*)\" is displayed on page$")
    public void selectionForIsDisplayedOnPage(String item) throws Throwable {

        switch (item) {
            case "Blouse":
                auto.verifyBlouseItem();
                break;
            case "PrintedDress":
                auto.verifyPrintedItem();
                break;
        }
        logger.info("*****No match returned*******");


    }

    @And("^Initial size for \"([^\"]*)\" is displayed on page$")
    public void initialSizeForIsDisplayedOnPage(String size) throws Throwable {
        switch (size) {
            case "M":
                auto.verifySelectedDropText(size);
                logger.info("****M****");
                break;
            case "L":
                auto.verifySelectedDropText(size);
                logger.info("****L****");
                break;
        }
        logger.info("*****No match returned*******");
    }

    @When("^User selects \"([^\"]*)\" to view$")
    public void userSelectsToView(String itemType) throws Throwable {

        switch (itemType) {
            case "Blouse":
                auto.selectBlouseItem();
                break;
            case "PrintedDress":
                auto.selectPrintedItem();
                break;
        }
        logger.info("*****No match returned*******");

    }

    @And("^User continues to view \"([^\"]*)\"$")
    public void userContinuesToView(String newItem) throws Throwable {
        auto.continueToNewItem(newItem);
    }

    @And("^User leaves the size as default$")
    public void userLeavesTheSizeAsDefault() throws Throwable {
        logger.info("rrrrrrrrrrrrrrrrrrrrrrrrr");
    }


    @And("^User gets the price for \"([^\"]*)\"$")
    public void userGetsThePriceFor(String test) throws Throwable {
        Thread.sleep(2000);
        if (test.equals("Blouse")) {
            auto.getBlousePrice();
        } else if (test.equals("PrintedDress")) {
            auto.getDressPrice();
        } else {
            logger.info(">>>>>>>>> No match price returned >>>>>>>>>");
        }


        auto.getDressPrice();
    }


    @Then("^The price for \"([^\"]*)\" should be as before$")
    public void thePriceForAndShouldBeAsBefore(String item) throws Throwable {
        if (item.equals("Blouse")) {
            auto.matchChkOutBlousePrice();
            logger.info("*****Blouse price matched *******");
        } else if (item.equals("PrintedDress")) {
            auto.matchChkOutDressPrice();
            logger.info("*****Print dress price matched *******");
        } else {
            logger.info("*****No match returned*******");
        }


    }

    @And("^User navigate to orders page$")
    public void userNavigateToOrdersPage() throws Throwable {
        Thread.sleep(2000);
        auto.goToOrderDetailsPage();
        Thread.sleep(2000);
    }

    @And("^User selects an item$")
    public void userSelectsAnItem() throws Throwable {
        order.selectFirstOrderItem();
        Thread.sleep(2000);
    }

    @And("^User sorts most recent order$")
    public void userSortsMostRecentOrder() throws Throwable {
        order = new OrderDetailsPage(driver);
        order.sortRecentDate();
        Thread.sleep(2000);
    }

    @When("^User posts an order comment$")
    public void userPostsAnOrderComment() throws Throwable {
        order.enterAndPostComment();
        Thread.sleep(2000);

    }

    @Then("^Message is displayed under messages section$")
    public void messageIsDisplayedUnderMessagesSection() throws Throwable {
        order.verifyCommentSuccessMsg();
    }

    @And("^User signs out of application$")
    public void userSignsOutOfApplication() throws Throwable {
        order.signOutAndQuitBrowser();
    }

    @Then("^User verifies the color of item selected$")
    public void userVerifiesTheColorOfItemSelected() throws Throwable {
        order.verifyItemColor();
    }


    @After
    public void takeShotOnFail (Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                // Take a screenshot......
                TakesScreenshot ts = (TakesScreenshot) driver;
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("./ScreenPrints/" + scenario.getName() + ".png"));
                scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
            }
        } catch (Exception e) {
            logger.info("Screen print exception:" + e.getMessage());
        }

    }
}