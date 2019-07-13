import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class interviewsmoketest {
    public WebDriver webDriver;
    public String windowsHandle;
    public void SetUp(){
        System.setProperty("webdriver.gecko.driver","D:/漆卉君学习资料/git/test/comcoursecode/src/main/resources/geckodriver.exe");
        System.setProperty("webdriver.Firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        webDriver=new FirefoxDriver();
        webDriver.manage().window().maximize();
    }
    /*
    * 时间控件12306
    * 先让时间控件变为可以读写
    * 再清空原内容
    * 再手动输入内容
    * */
    public void Date() throws InterruptedException {
        webDriver.get("https://www.12306.cn/index");
        Thread.sleep(2000);
        String js="document.getElementById('train_date').removeAttribute('readOnly')";
        JavascriptExecutor jscript= (JavascriptExecutor) webDriver;
        jscript.executeScript(js);
        WebElement date=webDriver.findElement(By.id("train_date"));
        date.clear();
        date.sendKeys("2019-05-21");
    }
    /*
    * 下拉滚动条https://www.jd.com/
    * */
    public void ChangeScroll(){
        webDriver.get("https://www.jd.com");
        String js="window.scrollTo(1000,10000)";
        JavascriptExecutor jscript= (JavascriptExecutor) webDriver;
        jscript.executeScript(js);
    }
    /*
    * 获取当前窗口句柄http://www.sohu.com/
    * */
    public void switchHandle(){
        webDriver.get("http://www.sohu.com");
        webDriver.findElement(By.linkText("新闻")).click();
//        获取当前句柄
        windowsHandle=webDriver.getWindowHandle();
        //        获取全部句柄
        Set<String>  windowsHandles=webDriver.getWindowHandles();
        for (String s:windowsHandles){

        }
        String[] strSet = new String[windowsHandles.size()];
        System.out.println(strSet);
        windowsHandles.toArray();
//        webDriver.switchTo().window( windowsHandles.toArray(strSet).toString());
    }

    public static void main(String[] args) throws InterruptedException {
        interviewsmoketest interviewsmoketest=new interviewsmoketest();
        interviewsmoketest.SetUp();
//        interviewsmoketest.Date();
//        interviewsmoketest.ChangeScroll();
        interviewsmoketest.switchHandle();
    }
}
