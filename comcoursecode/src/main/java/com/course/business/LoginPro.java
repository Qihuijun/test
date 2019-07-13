package com.course.business;

import com.course.base.DriverBase;
import com.course.handle.LoginPageHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/*
* 登录的业务层
* */
public class LoginPro {
    DriverBase driver;
    public LoginPageHandle lph;
    /*
    * 构造函数，引入驱动
    * */
    public LoginPro(DriverBase driver){
        this.driver=driver;
        lph=new LoginPageHandle(driver);
    }
    /*
    *登录业务
    * */
    public void Login(String username,String password) throws IOException, InterruptedException {
        Thread.sleep(2000);
        lph.clickLoginLink();
        Thread.sleep(2000);
        lph.sendUserName(username);
        lph.sendPassword(password);
        lph.clickLoginButton();
        Thread.sleep(2000);
        lph.moveToHover();
        lph.JsGetHoverInfo();
        Thread.sleep(3000);
        System.out.println(lph.lp.getUserNameInfo());
        if (lph.lp.getUserNameInfo().equals("慕粉1934322775")){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }
}
