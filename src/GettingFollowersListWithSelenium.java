import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GettingFollowersListWithSelenium {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.instagram.com/");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement usernameInput =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[1]/div/label/input"));
        WebElement passwordInput =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[2]/div/label/input"));
        WebElement submitBtn =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[3]/button"));

        usernameInput.sendKeys("4gayev1");
        passwordInput.sendKeys("menim19yasimvar");
        submitBtn.click();

        Thread.sleep(3000);


        WebElement notNow = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/section/main/div/div/div/div/div"));
        notNow.click();

        Thread.sleep(3000);

        WebElement notNow2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[3]/button[2]"));
        notNow2.click();

        Thread.sleep(1000);

        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[2]/div[8]/div/span/div/a/div/div[2]/div/div/span/span"));
        profile.click();

        Thread.sleep(3000);

        WebElement followersBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/section/main/div/header/section/ul/li[2]/a"));
        followersBtn.click();

        WebElement scrollbar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]"));


        for (int i = 0; i <10 ; i++) {
            jsExecutor.executeScript("arguments[0].scrollTop += arguments[0].scrollHeight;", scrollbar);
        }


        Thread.sleep(3000);


        List<WebElement> ListofFollowers = driver.findElements(By.cssSelector(".x9f619.xjbqb8w.x1rg5ohu.x168nmei.x13lgxp2.x5pf9jr.xo71vjh.x1n2onr6.x1plvlek.xryxfnj.x1c4vz4f.x2lah0s.x1q0g3np.xqjyukv.x6s0dn4.x1oa3qoh.x1nhvcw1"));
        List<String> names = new ArrayList<>();

        for(WebElement item : ListofFollowers) {
            names.add(item.getText());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Agayev/Desktop/1/followers1.txt"))) {
            writer.write(String.valueOf(names));
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
