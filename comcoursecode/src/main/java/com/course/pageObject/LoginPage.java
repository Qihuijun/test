package com.course.pageObject;

import com.course.base.DriverBase;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class LoginPage extends BasePage{

    public LoginPage(DriverBase driver){
        super(driver);
    }
    /*
    * 获取登录入口元素
    * */
    public WebElement getLoginLinkElement() throws IOException {
        return   driver.element(driver.by("login_element"));
    }
    /*
    * 获取用户名输入框元素
    * */
    public WebElement getUserElement() throws IOException {
      return   driver.element(driver.by("username_element"));
    }
    /*
    * 获取密码输入框元素
    * */
    public WebElement getUserPasswordElement() throws IOException {
       return driver.element(driver.by("password_element"));
    }
    /*
     * 获取登录按钮元素
     * */
    public WebElement getLoginButtonElement() throws IOException {
        return driver.element(driver.by("loginButton_element"));
    }
    /*
    * 登录成功后获取登录头像处的悬浮窗口元素
    * */
    public WebElement getHoverElement() throws IOException {
        return driver.element(driver.by("hover_element"));
    }
    /*
    * 获取用户名称元素
    * */
    public WebElement getUserNameElement() throws IOException {
        return driver.element(driver.by("getusername_elemtent"));
    }
    /*
    * 获取元素的内容
    * */
    public String getUserNameInfo() throws IOException {
        WebElement getUserNameElement=this.getUserNameElement();
      return   driver.getTextInfo(getUserNameElement);
    }
}
