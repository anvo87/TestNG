package tests;
import mappings.MappingLogin;
import pages.BasePage;
import pages.LoginPage;
import org.testng.annotations.*;
import java.util.Iterator;
import java.util.List;
import mappings.MappingLogin;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private LoginPage loginWithBlankPage;


    @DataProvider(name= "userInfo")
    private Iterator<MappingLogin> createData(){
        List<MappingLogin> data = getDataAsObject("resources/Data.csv", MappingLogin.class);

        return data.iterator();
    }

    @Test(dataProvider = "userInfo")
    public void LoginSuccessfully(MappingLogin mappingLogin) {
        loginPage = basePage.goToLoginPage();
        loginPage.clickOnToggleMenu();
        loginPage.clickOnLoginLink();
        loginPage.inputUserName(mappingLogin.getUserName());
        loginPage.inputPassWord(mappingLogin.getPassWord());
        loginPage.clickOnLoginButton();

    }

    //@Test
    public void LoginWithBlank(){
        loginWithBlankPage = basePage.goToLoginPage();
        loginWithBlankPage.clickOnToggleMenu();
        loginWithBlankPage.clickOnLoginLink();
        loginWithBlankPage.clickOnLoginButton();
        loginWithBlankPage.checkMessageWhenLoginBlank();
   }

}
