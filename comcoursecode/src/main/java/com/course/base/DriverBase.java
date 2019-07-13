package com.course.base;

import com.course.utils.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class DriverBase {
    public WebDriver webDriver;
    /*
    * 构造方法
    * 引用选择浏览器类并加载驱动
    * */
    public DriverBase(String browser){
        SelectDriver selectDriver=new SelectDriver();
        this.webDriver=selectDriver.driverName(browser);
    }
    /*
    * 获取driver
    * */
    public WebDriver getDriver() {
        return webDriver;
    }
    /*
    * 关闭浏览器
    * */
    public void stop(){
        System.out.println("关闭浏览器");
        webDriver.close();
    }
    /*
     * 封装Element方法
     * */
    public WebElement element(By by){
        WebElement webElement=webDriver.findElement(by);
        return webElement;
    }
    /*
     * 封装By
     * 元素用配置文件存储，声明配置文件工具对象，读取配置文件中的元素信息
     * */
    public By by(String key) throws IOException {
//        获取配置文件
        ProUtil proUtil=new ProUtil("D:\\漆卉君学习资料\\git\\test\\comcoursecode\\src\\main\\resources\\element.properties");
//        读取配置文件一条信息，例如username=xpath>元素定位信息
        String locator=proUtil.getpro(key);
//        获取元素属性，eg.xpath
        String locatorType=locator.split(">")[0];
//        获取元素value，eg.元素定位信息
        String locatortext=locator.split(">")[1];
        if (locatorType.equals("name")){
            return By.name(locatortext);
        }else if (locatorType.equals("classname")){
            return By.className(locatortext);
        }else if (locatorType.equals("tagname")){
            return By.tagName(locatortext);
        }else if (locatorType.equals("linktext")){
            return By.linkText(locatortext);
        }else if (locatorType.equals("id")){
            return By.id(locatortext);
        }else {
            return By.xpath(locatortext);
        }
    }
    /*
     * 封装click
     * */
    public void click(WebElement element){
//        对元素判断，如果元素为空则提示，如果不为空，则执行click事件
        if (element!=null){
            element.click();}else {
            System.out.println(element+"元素定位失败！");}
    }
    /*
     * 封装sendkeys
     * */
    public void sendKeys(WebElement element,String text){
//        对元素判断，如果元素为空则提示，如果不为空，则执行sendKeys事件
        if (element!=null){
            element.sendKeys(text);}else {
            System.out.println(element+"元素定位失败！");}
    }
    /*
    * 封装鼠标移入hover处
    * */
    public void moveToHover(WebElement element){
        Actions actions=new Actions(webDriver);
        actions.moveToElement(element).perform();
    }
    /*
     * 判断元素是否显示
     * */
    public boolean isDisplayed(WebElement element){
//        对元素判断，如果元素为空则提示，如果不为空，则执行sendKeys事件
        if (element!=null){
            return   element.isDisplayed();}else {
            System.out.println(element+"元素定位失败！");
            return false;}
    }
    /*
    * 封装获取元素文本信息
    * */
    public String getTextInfo(WebElement element){
        if (element!=null){
            return   element.getText();}else {
            System.out.println(element+"元素定位失败！");
            return "";}
    }
    /*
    * 封装get，获取地址
    * */
    public void getUrl(String url){
        webDriver.get(url);
    }
    /*
    * 屏幕最大化
    * */
    public void maxwindow(){
        webDriver.manage().window().maximize();
    }
}
