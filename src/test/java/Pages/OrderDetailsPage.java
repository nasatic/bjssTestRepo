package Pages;

import Utility.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderDetailsPage extends BaseClass {

    @FindBy(xpath = ".//*[@id='order-list']/thead/tr/th[2]")
    WebElement dateFilter;

    @FindBy(xpath = ".//*[@name='id_product']")
    WebElement orderProdDropdowm;

    @FindBy(xpath = ".//*[@name='msgText']")
    WebElement commentMsgArea;

    @FindBy(xpath = ".//*[@id='sendOrderMessage']/div/button")
    WebElement submitBtn;

    @FindBy(how = How.CSS, using = "#block-order-detail div:nth-child(9) tr.first_item.item td:nth-child(2)")
    WebElement commentSuceessMsg;

    @FindBy(xpath = ".//*[@id='order-list']/tbody/tr[1]/td[1]/a")
    WebElement firstOrderItem;

    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Sign out')]")
    WebElement signOutButton;

    @FindBy(xpath = ".//*[@id='order-detail-content']//tr[1]/td[2]/label")
    WebElement selectedItemDetails;

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void sortRecentDate() throws InterruptedException {
        dateFilter.click();
        Thread.sleep(2000);
    }


    public void selectFirstOrderItem() throws InterruptedException {
       firstOrderItem.click();
        Thread.sleep(2000);
        Select select = new Select(orderProdDropdowm);
        select.selectByVisibleText("Printed Dress - Color : Orange, Size : M");
        Thread.sleep(2000);

    }

    public void enterAndPostComment() throws InterruptedException {
        commentMsgArea.sendKeys("This is a comment from Ibe Okoro for BJSS tech test");
        Thread.sleep(2000);
        submitBtn.click();
        Thread.sleep(3000);
    }

    public void verifyCommentSuccessMsg() {
        String txt = commentSuceessMsg.getText();
        Assert.assertEquals(txt, "This is a comment from Ibe Okoro for BJSS tech test");
    }

    public void signOutAndQuitBrowser() {
        signOutButton.click();
        driver.close();
        driver.quit();
    }

    public void verifyItemColor(){
        String itemText = selectedItemDetails.getText();
        Assert.assertTrue(itemText.contains("Orange"));
    }

}
