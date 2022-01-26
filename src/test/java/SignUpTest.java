import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void zipCodeInputShouldAcceptFiveDigitsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value = 'Register']")).isDisplayed(),
                "Register element is not displayed");
        driver.quit();
    }

    @Test
    public void zipCodeInputShouldNotAcceptFourDigitsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error element is not displayed");
        driver.quit();
    }

    @Test
    public void zipCodeInputShouldNotAcceptSixDigitsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
        boolean isElementDisplayed = false;
        try {
            isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found!");
        }
        driver.quit();
        Assert.fail();
    }

    @Test
    public void accountCreationTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("jdsvbj@kjh.jnb");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1111");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'confirmation_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Account is not created");
        driver.quit();
    }

    @Test
    public void noFirstNameTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("jdsvbj@kjh.jnb");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1111");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error message is not shown");
        driver.quit();
    }

    @Test
    public void noLastNameTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("jdsvbj@kjh.jnb");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1111");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'confirmation_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Account is not created");
        driver.quit();
    }

    @Test
    public void noEmailNameTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1111");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error message is not shown");
        driver.quit();
    }

    @Test
    public void incorrectEmailTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("incorrectemail@dd");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1111");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error message is not shown");
        driver.quit();
    }

    @Test
    public void emptyPasswordTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("correct@dd.cc");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1111");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error message is not shown");
        driver.quit();
    }

    @Test
    public void emptyConfirmPasswordTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("correct@dd.cc");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error message is not shown");
        driver.quit();
    }

    @Test
    public void tooShortPasswordTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("correct@dd.cc");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error message is not shown");
        driver.quit();
    }

    @Test
    public void differentPasswordAndConfirmTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Karina");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Mashkanova");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("correct@dd.cc");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("1112");

        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        boolean isElementDisplayed = driver.findElement(By.xpath("//span[@class = 'error_message']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "Error message is not shown");
        driver.quit();
    }
}
