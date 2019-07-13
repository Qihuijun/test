import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Login {
    WebDriver driver;
    public void setUp(){
//        驱动加载
        System.setProperty("webdriver.gecko.driver","D:/漆卉君学习资料/git/test/comcoursecode/src/main/resources/geckodriver.exe");
        System.setProperty("webdriver.Firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        driver= new FirefoxDriver();
//        浏览器最大化
        driver.manage().window().maximize();
//        获取地址
        driver.get("http://imooc.com");
    }
    public void script(String username,String password) throws InterruptedException, IOException {
//        调用driver
        this.setUp();
        String usernametext="慕粉1934322775";
        Thread.sleep(3000);
//  点击登录链接弹出登录窗口 元素获取
        WebElement login=this.webElement(this.byStr("login_element"));
        login.click();
        Thread.sleep(3000);
        WebElement userName=this.webElement(this.byStr("username_element"));
        WebElement passport=this.webElement(this.byStr("password_element"));
        WebElement loginButton=this.webElement(this.byStr("loginButton_element"));
        //        检查账号，密码，输入框登录按钮状态
        userName.isDisplayed();
        passport.isDisplayed();
        loginButton.isDisplayed();
//        输入内容
        userName.sendKeys(username);
        passport.sendKeys(password);
//        点击登录按钮
        loginButton.click();
        Thread.sleep(3000);
        WebElement hover=this.webElement(this.byStr("hover_element"));

//        鼠标移入悬浮框
        Actions actions=new Actions(driver);
        actions.moveToElement(hover).perform();
        Thread.sleep(2000);
        WebElement username1=this.webElement(this.byStr("username1_elemtent"));
        //        获取账号名称
        String testinfo=username1.getText();
        System.out.println(testinfo);
        if(testinfo.equals(usernametext)){
            System.out.println("登录成功！");
        }else {System.out.println("登录失败!");}
        driver.close();
    }
/*
* 封装BY
* */
public By byStr(String key) throws IOException{
    //        引用ProUtil类
    ProUtil properties=new ProUtil("D:\\漆卉君学习资料\\git\\test\\comcoursecode\\src\\test\\java\\element.properties");
//       获取定位信息
    String locator=properties.getpro(key);
    String locatorType=locator.split(">")[0];
    String locatorvalue=locator.split(">")[1];
    if (locatorType.equals("id")){
        return By.id(locatorvalue);
    }else if (locatorType.equals("classname")){
        return By.className(locatorvalue);
    }else if (locatorType.equals("name")){
        return By.name(locatorvalue);
    }else if (locatorType.equals("tagName")){
        return By.tagName(locatorvalue);
    }else if (locatorType.equals("linkText")){
        return By.linkText(locatorvalue);
    }else {
        return By.xpath(locatorvalue);
    }
}
/*
* 封装Element
* */
public WebElement webElement(By by){
    WebElement webElement= driver.findElement(by);
    return webElement;

}
@Test()
    public  void loginPage() throws InterruptedException, IOException {
        Login login=new Login();
//        login.script("925259851@qq.com","qihuijun852");
        /*
        * 账户名和密码从配置文件中读取
        * key-value
        * username-password
        * */
        HashMap<String,String> user=new HashMap<String, String>();
//        添加数据
        user.put("925259851@qq.com","q123456q");
        user.put("15312502345","q123456");
//        使用entryset遍历map,iterator迭代器
        Iterator us=user.entrySet().iterator();
        while (us.hasNext()){
            Map.Entry entry= (Map.Entry) us.next();
            String username=entry.getKey().toString();
            String passport=entry.getValue().toString();
            login.script(username,passport);
        }
    }
}
