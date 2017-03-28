package testAutomation;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by daljeetsidhu on 12/03/2017.
 */
public class Navigation {

    WebDriver driver = BrowserDriver.getCurrentDriver();


    @Given("^the user is on the hotel booking website$")
    public void open_booking_website() throws Throwable {
        BrowserDriver.loadPage(
                "http://hotel-test.equalexperts.io/");
        Thread.sleep(10000);
    }


    @When("^the user enters their firstname \"([^\"]*)\"$")
    public String the_user_enters_firstname(String fnName) throws Throwable {
        driver.findElement(By.id("firstname")).sendKeys(fnName);
        return fnName;

    }


    @And("^the user enters their lastname \"([^\"]*)\"$")
    public void the_user_enters_lastname(String lnName) throws Throwable {
        driver.findElement(By.id("lastname")).sendKeys(lnName);
    }

    @And("^the user enters \"([^\"]*)\"$")
    public void the_user_enters(String argument) throws Throwable {
        driver.findElement(By.id("totalprice")).sendKeys(argument);
    }

    @And("^the value of the deposit is \"([^\"]*)\"$")
    public void the_user_selects(String value) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("depositpaid")));
        dropdown.selectByVisibleText(value);
    }

    @And("^the checkin date is selected \"([^\"]*)\"$")
    public void the_user_selects_checkindate(String date) throws Throwable {
        WebElement dates = driver.findElement(By.id("checkin"));
        dates.click();
        Thread.sleep(5000);
        saveDate(date);
    }

    @And("^the checkout date is selected \"([^\"]*)\"$")
    public void the_user_selects_checkoutdate(String date) throws Throwable {
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(5000);
        saveDate(date);
    }

    @Then("^the user selects Save to book their room$")
    public void the_user_selects_save() throws Throwable {
        WebElement save = driver.findElement(By.xpath(".//*[@id='form']/div/div[7]/input"));
        save.click();
    }

    @Then("^the user selects Delete$")
    public void the_user_selects_delete() throws Throwable {
        List<WebElement> Save = driver.findElements(By.xpath("//input[@onclick and @value=\"Delete\"]"));
        int elementFound = Save.size();
        Thread.sleep(5000);
        WebElement lastDelete = Save.get(Save.size()-1);
        lastDelete.click();
        Thread.sleep(5000);
        }

    @And("^the user can see all booking details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_user_view_details(String fName, String lName, String price) throws Throwable {

        List<WebElement> bookingValues = driver.findElements(By.xpath("//div[@id='bookings']/div[@id]/div/p"));
        int elementFound = bookingValues.size();

        if (elementFound == 0) {
            System.out.print("No bookings have been found");
        }

        for (int i = 0; i < bookingValues.size(); i++) {
            //System.out.println(bookingValues.get(i).getText());
            Thread.sleep(1000);

            String value = bookingValues.get(i).getText();
            if (value.equals(fName)) {
                System.out.println(fName + "value has been found");
            } else if (value.equals(lName)) {
                System.out.println(lName + "value has been found");
            } else if (value.equals(price)) {
                System.out.println(price + "value has been found");
            }
        }
    }


    @And("^the user can no longer see the booking \"([^\"]*)\"$")
    public void user_cannot_view_details(String fnName) throws Throwable {

        try {
            driver.findElement(By.name("Sue"));
        } catch (NoSuchElementException ex){
            System.out.print("test passed fName does not appear");
        }
    }






/*        boolean textFound = false;
        try {
            driver.findElement(By.xpath("/*//*[contains(text(),'dal')]"));
            System.out.println("true");
        } catch (Exception e){
            textFound = false;
            System.out.println("fails");
        }*/

    //}

    public boolean isElementPresent(String elementXpath){

    int count = driver.findElements(By.xpath(elementXpath)).size();

        if(count ==0)
            return false;
        else return true;
    }

    public void saveDate(String date){

        List<WebElement> dates = driver.findElements(By.xpath(".//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']"));

        for (int i = 0; i < dates.size(); i++) {
           // System.out.println(dates.get(i).getText());
            if (dates.get(i).getText().equals(date)) {
                dates.get(i).click();
            }
        }

    }

}
