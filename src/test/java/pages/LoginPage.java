package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
//import lombok.Data;


public class LoginPage extends BasePage {

    By toggleMenu = By.id("menu-toggle");
    By loginLink = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a");
    By userNameInput = By.id("txt-username");
    By passWordInput = By.id("txt-password");
    By loginButton = By.id("btn-login");
    By messageBlank = By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]");


    public void clickOnToggleMenu(){
        driver.findElement(toggleMenu).click();
    }
    public void clickOnLoginLink(){
        driver.findElement(loginLink).click();
    }
    public void inputUserName(String userName){
        driver.findElement(userNameInput).sendKeys(userName);
    }
    public void inputPassWord(String passWord){
        driver.findElement(passWordInput).sendKeys(passWord);
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void checkMessageWhenLoginBlank(){
        String actualResult = driver.findElement(messageBlank).getText();
        String expectedResult = "Login failed! Please ensure the username and password are valid.";
        Assert.assertEquals(actualResult,expectedResult);
    }


}
