package security;

import org.openqa.selenium.By;

/**
 * @author Richard Lopez on 27/05/2023
 * https://www.linkedin.com/in/richard-lopez-/
 * https://github.com/lopezrichard
 */
public class LoginUI {
 public static final By USER=By.xpath("//input[@placeholder='Username']");
 public static final By PASSWORD=By.xpath("//input[@placeholder='Password']");
 public static final By BUTTON_LOGIN=By.xpath("//button[normalize-space()='Login']");

}
