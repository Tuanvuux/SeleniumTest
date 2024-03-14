package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    //"D:\SeleniumTest\Executables\chromedriver.exe"
    //"D:\SeleniumTest\src\test\resources\chromedriver.exe"
    //"D:\SeleniumTest\src\test\resources\chromedriver.exe"
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
     //   System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "D:\\SeleniumTest\\src\\test\\resources\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01(){
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME +"@gmail.com", Constant.PASSWORD).getWelcomeMessage();


        if(!actualMsg.isEmpty()){
            String[] parts = actualMsg.split("@", 2);

            // Lấy phần username
            actualMsg = parts[0];

        }
        String expectedMsg = "Welcome " + Constant.USERNAME;



        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
