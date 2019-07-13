package com.course.cases;

import com.course.base.DriverBase;
import com.course.business.LoginPro;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginCase extends CaseBase{
    DriverBase driver;
    LoginPro loginPro;
    static Logger logger= Logger.getLogger((LoginCase.class));
    /*
    * 有参构造函数
    * */
    public LoginCase(){
        this.driver=InitDriver("firefox");
        loginPro=new LoginPro(driver);
        driver.maxwindow();
    }
    /*
    * 获取测试地址
    * */
    @Test
    public void goLoginHome() throws InterruptedException {
        Thread.sleep(2000);
        driver.getUrl("http://www.imooc.com");
    }

    /*
    * 登录测试用例
    * */
    @Test(dependsOnMethods = "goLoginHome")
    public void testLogin() throws IOException, InterruptedException {
        logger.info("----------------");
        loginPro.Login("925259851@qq.com","q123456q");
    }
}
