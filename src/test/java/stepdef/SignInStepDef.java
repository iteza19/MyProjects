package stepdef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


public class SignInStepDef extends PropertiesDef {

    @Given("user already on home page youtube music")
    public void user_already_on_home_page_youtube_music(){
        System.out.println("Given state");
        setDriver(baseUrl);
    }

    @When("user click button sign in")
    public void userClickButtonSignIn() {
        System.out.println("When state");
        driver.findElement(By.xpath(SignButton)).click();
    }

    @And("user login with correct account")
    public void userLoginWithCorrectAccount() throws InterruptedException {
        System.out.println("And state");
        driver.findElement(By.xpath(accountField)).sendKeys(username);
        driver.findElement(By.xpath(nextButton)).click();
        wait(textUsername,3);
        driver.findElement(By.xpath(passField)).sendKeys(password);
        driver.findElement(By.xpath(nextButton)).click();
    }

    @Then("user will redirected to home")
    public void userWillRedirectedToHome() throws InterruptedException {
        System.out.println("Then state");
        wait(iconAcc,3);
        quit();
    }

    @And("user login with incorrect account")
    public void userLoginWithIncorrectAccount() throws InterruptedException {
        System.out.println("And state");
        driver.findElement(By.xpath(accountField)).sendKeys(username);
        driver.findElement(By.xpath(nextButton)).click();
        wait(textUsername,3);
        driver.findElement(By.xpath(passField)).sendKeys(wrongPass);
        driver.findElement(By.xpath(nextButton)).click();
    }

    @Then("user will see error text wrong password")
    public void userWillSeeErrorTextWrongPassword() throws InterruptedException {
    wait(errorText,3);
    quit();
    }
}
