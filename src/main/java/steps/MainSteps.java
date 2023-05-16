package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import org.openqa.selenium.WebElement;

public class MainSteps {
    protected WebDriver wd = Driver.getDriver();

    @Given("Go to Azercell")
    public void go_to_azercell() {
        wd.get("https://www.azercell.com/az/");
    }

    @When("Select akart")
    public void select_akart() throws InterruptedException {
        Thread.sleep(1000);
        WebElement akart_link = wd.findElement(By.xpath("//span[@data-menu='akart']"));
        akart_link.click();
    }

    @Then("Select elde et")
    public void select_elde_et() throws InterruptedException {
        WebElement elde_et_link = wd.findElement(By.linkText("\"akart\"ı əldə et"));
        elde_et_link.click();
    }

    @Then("Select yukle")
    public void select_yukle() throws InterruptedException {
        WebElement yukle = wd.findElement(By.className("btn-l"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", yukle);
        Thread.sleep(500);
        yukle.click();
    }

    @Then("Check the opened page")
    public void check_the_opened_page(){
        boolean is_exist;
        if (wd.findElement(By.linkText("Azercell Kabinetim")).isDisplayed()) is_exist = true;
        else is_exist = false;
        System.out.println(is_exist);
    }
}
