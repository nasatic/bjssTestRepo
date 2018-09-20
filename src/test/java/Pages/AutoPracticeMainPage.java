package Pages;

import Utility.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AutoPracticeMainPage extends BaseClass {


    @FindBy(css = "a.login")
    WebElement signInButton;

    @FindBy(how = How.CSS, using = "#email")
    WebElement userName;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement WomenTab;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/h5/a")
    WebElement BlouseItem;

    @FindBy(xpath = "//*[@id='center_column']//li[6]//h5/a")
    WebElement PrintedDressItem;

    @FindBy(css = ".pb-center-column.col-xs-12.col-sm-4>h1")
    WebElement PrintedDressText;

    @FindBy(css = "#center_column h1")
    WebElement BlouseRetText;

    @FindBy(css = "#our_price_display")
    WebElement BlousePriceText;

    @FindBy(xpath = ".//*[@id='our_price_display']")
    WebElement DressPriceText;

    @FindBy(css = "#group_1")
    WebElement sizeDropdown;

    @FindBy(css = "#group_1>option:nth-child(2)")
    WebElement mediumSize;

    @FindBy(css = "#group_1>option:nth-child(3)")
    WebElement largeSize;

    @FindBy(xpath = ".//*[@id='add_to_cart']/button")
    WebElement addToCartButton;

    @FindBy(xpath = ".//*[@id='layer_cart']//div[4]/span")
    WebElement ContinueBtn;

    @FindBy(xpath = ".//*[@title='View my shopping cart']")
    WebElement shoppingCart;

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    WebElement checkoutBtn;

    @FindBy(css = ".first_item:nth-child(1)>div>span")
    WebElement chktPriceForDress;

    @FindBy(css = ".products>dt:nth-child(3)>div>span")
    WebElement chktPriceForBlouse;

    @FindBy(css = ".button.btn.btn-default.standard-checkout.button-medium>span")
    WebElement proceedToCheckoutBtn;

    @FindBy(xpath = ".//*[@id='center_column']/form/p/button")
    WebElement innerChkoutBtn;

    @FindBy(xpath = ".//*[@id='cgv']")
    WebElement tandcBox;

    @FindBy(xpath = ".//*[@id='form']/p/button")
    WebElement inner2ChkoutBtn;

    @FindBy(xpath = ".//*[@class='bankwire' and  @title='Pay by bank wire']")
    WebElement payByBankWireBtn;

    @FindBy(xpath = ".//*[@id='cart_navigation']/button")
    WebElement confirmOrderBtn;

    @FindBy(xpath = ".//*[@id='center_column']/div/p/strong")
    WebElement orderCompleteText;

    @FindBy(xpath = ".//*[@class='logout' and @title='Log me out']")
    WebElement signOutBtn;

    @FindBy(xpath = ".//*[contains(text(),'Order history and details')]")
    WebElement orderDetailsBtn;

    @FindBy(how = How.ID, using = "SubmitLogin")
    WebElement loginButton;

    @FindBy(how = How.CSS, using = "#passwd")
    WebElement passWord;

    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Sign out')]")
    WebElement signOutButton;


    public AutoPracticeMainPage(WebDriver driver) {
        super(driver);

    }

    public void closeAndQuitBrowser() {
        driver.close();
        driver.quit();
    }

    public void clickOnSignIn() {
        signInButton.click();

    }

    public void enterUsername(String Username) {
        userName.sendKeys(Username);

    }
    public void enterPassword(String Password) {
        passWord.sendKeys(Password);


    }

    public void clickOnLogin() {
        loginButton.click();

    }

    public void selectBlouseItem() throws InterruptedException {
        WomenTab.click();
        Thread.sleep(2000);
        BlouseItem.click();
    }

    public void selectPrintedItem() throws InterruptedException {
        WomenTab.click();
        Thread.sleep(2000);
        PrintedDressItem.click();
    }

    public String getBlousePrice() {
        String Blouseprice = null;
        try {
            String priceText = BlousePriceText.getText();
            Blouseprice = priceText.replace("$", "");
            System.out.println("xxxxx Blouse price is:" + Blouseprice + "xxxxxx");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Blouseprice;
    }


    public String getDressPrice() {
        String DressPrice = null;
        try {
            String priceText = DressPriceText.getText();
            DressPrice = priceText.replace("$", "");
            System.out.println("xxxxx Dress price is:" + DressPrice + "xxxxxx");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DressPrice;
    }

    public void verifyBlouseItem() {
        String blouseText = BlouseRetText.getText();
        System.out.println("**** blouse dress text is :" + blouseText + "****");
        Assert.assertEquals(blouseText, "Blouse");
    }

    public void verifyPrintedItem() {
        String printText = PrintedDressText.getText();
        System.out.println("**** printed Dress text is :" + printText + "****");
        Assert.assertEquals(printText, "Printed Summer Dress");
    }

    public void selectSize(String size) {
        Select select = new Select(sizeDropdown);
        select.selectByVisibleText(size);

    }

    public void verifySelectedDropText(String size) {
        Select select = new Select(sizeDropdown);
        String selectedSize = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedSize, size);

    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void verifyDefaultDropdownText(String size) {
        Select select = new Select(sizeDropdown);
        String selectedSize = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedSize, size);

    }

    public void continueToNewItem(String newItem) throws InterruptedException {
        Thread.sleep(3000);
        ContinueBtn.click();
        Thread.sleep(2000);
        WomenTab.click();
        Thread.sleep(2000);
        switch (newItem) {
            case "PrintedDress":
                PrintedDressItem.click();
                break;
            case "Blouse":
                BlouseItem.click();
                break;
        }
        System.out.println("*****No match returned*******");
    }

    public void gotoShoopingCart() {
        checkoutBtn.click();

    }

    public void matchChkOutDressPrice() {
        String priceText = chktPriceForDress.getText();
        String price = priceText.replace("$", "");
        Assert.assertTrue(getDressPrice().equals(price));

    }

    public void matchChkOutBlousePrice() {
        String priceText = chktPriceForBlouse.getText();
        String price = priceText.replace("$", "");
        String tests = getBlousePrice();
        Assert.assertTrue(tests.equals(price));
    }

    public void checkoutAndPayByWire() throws InterruptedException {
        proceedToCheckoutBtn.click();
        Thread.sleep(2000);
        innerChkoutBtn.click();
        Thread.sleep(2000);
        tandcBox.click();
        inner2ChkoutBtn.click();
        Thread.sleep(2000);
        payByBankWireBtn.click();
        Thread.sleep(2000);
        confirmOrderBtn.click();
        Thread.sleep(2000);

    }

    public void verifyCompleteOder(){
        String text = orderCompleteText.getText();
        Assert.assertEquals(text,"Your order on My Store is complete.");

    }

    public void logout(){
        signOutBtn.click();
    }

    public void goToOrderDetailsPage(){
        orderDetailsBtn.click();
    }

}