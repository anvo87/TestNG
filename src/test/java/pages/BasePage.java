package pages;

import ultilities.PropertiesFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class BasePage {
    public static WebDriver driver;

//    public WebDriver getDriver() {
//        return driver;
//    }

   public static String propertiesFilePathRoot = "resources/Configs/configs.properties";


    public void setDriverForPage(){

        PropertiesFileReader.setProperties(propertiesFilePathRoot);
        driver = setDriver(PropertiesFileReader.getPropValue("browserType"), PropertiesFileReader.getPropValue("URL"));

    }

    public WebDriver setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
   // @Parameters({"browserType", "appURL"})
//    @BeforeClass
//    public void initializeTestBaseSetup(String browserType, String appURL) {
//
//            setDriver(browserType, appURL);
//
//    }


    public void tearDown() {
        driver.quit();
    }

    public LoginPage goToLoginPage(){
        return new LoginPage();
    }


}
