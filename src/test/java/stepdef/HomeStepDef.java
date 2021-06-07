package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


public class HomeStepDef extends PropertiesDef {

    @Given("user in home page")
    public void userInHomePage() throws InterruptedException {
        loginStep();
    }

    @When("user click thumbnail song from quick picks")
    public void userClickThumbnailSongFromQuickPicks() {
        driver.findElement(By.xpath(indexFirstSong));
        driver.findElement(By.xpath(playButtonOnIndexFirstSong)).click();
    }

    @Then("user redirect to music screen and song played")
    public void userRedirectToMusicScreenAndSongPlayed() throws InterruptedException {
        wait(upNextTab,5);
        Thread.sleep(7000); //wait until song played
        quit();
    }

    @Given("user in music screen")
    public void userInMusicScreen() throws InterruptedException {
        userInHomePage();
        userClickThumbnailSongFromQuickPicks();
        wait(upNextTab,5);
    }

    @When("user click back button")
    public void userClickBackButton() {
        driver.navigate().back();
    }

    @Then("user redirect to previous page and mini player will appear in bottom right of page")
    public void userRedirectToPreviousPageAndMiniPlayerWillAppearInBottomRightOfPage() throws InterruptedException {
        wait(miniPlayer,5);
        Thread.sleep(7000); //wait until song played
        quit();
    }

    @Given("user in home page with mini player appear")
    public void userInHomePageWithMiniPlayerAppear() throws InterruptedException {
        userInMusicScreen();
        userClickBackButton();
    }

    @When("user click pause or play button in mini player")
    public void userClickPauseOrPlayButtonInMiniPlayer() throws InterruptedException {
        wait(miniPlayer,3);
        Thread.sleep(2000);
        driver.findElement(By.xpath(miniPlayer)).click();
        System.out.println("Song Paused");
        Thread.sleep(2000);
        driver.findElement(By.xpath(miniPlayer)).click();
        Thread.sleep(3000);
    }

    @Then("user will see player is paused or played")
    public void userWillSeePlayerIsPausedOrPlayed() throws InterruptedException {
        driver.findElement(By.xpath(miniPlayer)).click();
        System.out.println("Song Played");
        Thread.sleep(5000);
        System.out.println("Song Paused");
        quit();
    }
}
