package security;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
public class ZAP {


private WebDriver driver;
private ClientApi api;
private WebDriverWait wait;

@Test
public void testSecurity() throws InterruptedException, ClientApiException {

 driver= ChromeDriver.create();
 api=new ClientApi(ConfigurationZAP.ZAP_PROXY_ADDRESS, ConfigurationZAP.ZAP_PROXY_PORT, ConfigurationZAP.ZAP_API_KEY);
 wait=  new WebDriverWait(driver, Duration.ofSeconds(2));
 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

 WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
 user.sendKeys("Admin");
 WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
 password.sendKeys("admin123");
 WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
 login.click();

 wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

 Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","No se logro ingresar al home");

 Report.generate(api);
 driver.quit();
}
}


