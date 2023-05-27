package security;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import utils.ConfigurationZAP;
import java.time.Duration;

/**
 * @author Richard Lopez on 27/05/2023
 * https://www.linkedin.com/in/richard-lopez-/
 * https://github.com/lopezrichard
 */
public class ZAPTest {
private WebDriver driver;
private ClientApi api;
private WebDriverWait wait;

@BeforeTest
public void setUp(){
 driver= ChromeDriver.create();
 api=new ClientApi(ConfigurationZAP.ZAP_PROXY_ADDRESS, ConfigurationZAP.ZAP_PROXY_PORT, ConfigurationZAP.ZAP_API_KEY);
 wait=  new WebDriverWait(driver, Duration.ofSeconds(2));
 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@Test
public void testSecurity() {
 String urlDashboard="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

 WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginUI.USER));
 user.sendKeys("Admin");

 WebElement password = driver.findElement(LoginUI.PASSWORD);
 password.sendKeys("admin123");

 WebElement login = driver.findElement(LoginUI.BUTTON_LOGIN);
 login.click();

 wait.until(ExpectedConditions.urlToBe(urlDashboard));
 Assert.assertEquals(driver.getCurrentUrl(),urlDashboard,"No se logro ingresar al Dashboard");


}
@AfterTest
public void tearDown() throws ClientApiException {
 Report.generate(api);
 driver.quit();
}
}


