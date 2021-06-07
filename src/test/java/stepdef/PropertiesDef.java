package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertiesDef {
    public static WebDriver driver;

    public void setDriver(String baseUrl){
        System.setProperty("webdriver.chrome.driver", "/Users/harrygumbilar/IdeaProjects/MyProjects/dependency/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    public void callDb(Properties p) throws IOException {
        FileReader reader=new FileReader("resources/data.properties");
        p.load(reader);
    }

    public void wait(String path,int time) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }

    public void quit(){
        driver.quit();
    }

    public void loginStep() throws InterruptedException {
        setDriver(baseUrl);
        driver.findElement(By.xpath(SignButton)).click();
        driver.findElement(By.xpath(accountField)).sendKeys(username);
        driver.findElement(By.xpath(nextButton)).click();
        Thread.sleep(2000);
        wait(textUsername,5);
        driver.findElement(By.xpath(passField)).sendKeys(password);
        driver.findElement(By.xpath(nextButton)).click();
        wait(iconAcc,3);
    }


    //path page login
    String baseUrl="https://music.youtube.com/";
    String SignButton = "//*[@class='sign-in-link style-scope ytmusic-nav-bar']";
    String accountField = "//*[@class='whsOnd zHQkBf']";
    String passField = "//*[@class='whsOnd zHQkBf']";
    String nextButton= "//*[text()='Next']";
    String iconAcc = "//*[@class='style-scope tp-yt-iron-icon']";
    String textUsername = "//*[text()='dikevracing@gmail.com']";
    String errorText = "//*[text()='Wrong password. Try again or click Forgot password to reset it.']";

    //path home
    String indexFirstSong = "(//*[@class='style-scope ytmusic-item-thumbnail-overlay-renderer'])[1]";
    String playButtonOnIndexFirstSong = "(//*[@class='icon style-scope ytmusic-play-button-renderer'])[1]";
    String upNextTab = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[1]";
    String miniPlayer = "//*[@class='song-media-controls style-scope ytmusic-player']";

    //account information
    String username = "dikevracing@gmail.com";
    String password = "dadanracing";
    String wrongPass = "dadanbalap";


}
