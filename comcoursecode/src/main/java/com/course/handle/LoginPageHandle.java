package com.course.handle;

import com.course.base.DriverBase;
import com.course.pageObject.LoginPage;
import org.openqa.selenium.JavascriptExecutor;


import java.io.IOException;

public class LoginPageHandle  {
    public DriverBase driver;
    public LoginPage lp;
    /*
    * 引入驱动
    * */
   public LoginPageHandle(DriverBase driver)  {
       this.driver=driver;
       lp=new LoginPage(driver);
   }
    /*
    * 点击登录入口的登录链接
    * */
    public void clickLoginLink() throws IOException {
        driver.click(lp.getLoginLinkElement());
    }
    /*
    * 输入账号
    * */
    public void sendUserName(String userName) throws IOException {
        driver.sendKeys(lp.getUserElement(),userName);
    }
    /*
     * 输入密码
     * */
    public void sendPassword(String password) throws IOException {
        driver.sendKeys(lp.getUserPasswordElement(),password);
    }
    /*
     * 点击登录按钮
     * */
    public void clickLoginButton() throws IOException {
        driver.click(lp.getLoginButtonElement());
    }
    /*
    * 移动到Hover处
    * */
    public void moveToHover() throws IOException {
        driver.moveToHover(lp.getHoverElement());
    }
    /*
    * js控制直接显示悬浮窗口
    * */
    public void JsGetHoverInfo(){
       String jscript="document.getElementsByClassName('g-user-card')[0].style.visibility='visible'";
        JavascriptExecutor js= (JavascriptExecutor) driver.webDriver;
        js.executeScript(jscript);
    }

}
