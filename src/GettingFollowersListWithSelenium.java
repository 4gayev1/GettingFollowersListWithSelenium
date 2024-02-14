import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GettingFollowersListWithSelenium {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "out/production/GettingFollowersListWithSelenium2/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.instagram.com/");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement usernameInput =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[1]/div/label/input"));
        WebElement passwordInput =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[2]/div/label/input"));
        WebElement submitBtn =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[3]/button"));

        usernameInput.sendKeys("XXXX");
        passwordInput.sendKeys("XXXX");
        submitBtn.click();

        Thread.sleep(3000);

System.out.println("alma");


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

        Thread.sleep(3000);
        WebElement scrollbar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]"));


        for (int i = 0; i <10 ; i++) {
            jsExecutor.executeScript("arguments[0].scrollTop += arguments[0].scrollHeight;", scrollbar);
            Thread.sleep(2000);
        }


        Thread.sleep(5000);


        List<WebElement> ListofFollowers = driver.findElements(By.cssSelector("._aacl._aaco._aacw._aacx._aad7._aade"));
        List<String> names = new ArrayList<>();


        for(WebElement item : ListofFollowers) {
            System.out.println(item.getText());
            names.add(item.getText());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Agayev/Desktop/1/followers2.txt"))) {
            for(String item :names) {
                writer.write(String.valueOf(item));
                writer.newLine();
            }
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
