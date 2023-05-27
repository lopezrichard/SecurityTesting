package security;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigurationZAP;

/**
 * @author Richard Lopez on 27/05/2023
 * https://www.linkedin.com/in/richard-lopez-/
 * https://github.com/lopezrichard
 */
public class ChromeDriverCreator {
    public static WebDriver createWebDriver(){
        String proxyServerURL= ConfigurationZAP.ZAP_PROXY_ADDRESS+":"+ ConfigurationZAP.ZAP_PROXY_PORT;
        Proxy proxy=new Proxy();
        proxy.setHttpProxy(proxyServerURL);
        proxy.setSslProxy(proxyServerURL);
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setProxy(proxy);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-dev-shm-usage", "--ignore-ssl-errors=yes", "--ignore-certificate-errors");
    return new ChromeDriver(chromeOptions);
    }
}
