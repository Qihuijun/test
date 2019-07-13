import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test {
    public WebDriver webDriver;
    String windowsHandle=null;
//    初始化浏览器驱动
    public void SetUp(){
        System.setProperty("webdriver.gecko.driver","D:/漆卉君学习资料/git/test/comcoursecode/src/main/resources/geckodriver.exe");
        System.setProperty("webdriver.Firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        webDriver=new FirefoxDriver();
        webDriver.get("http://www.imooc.com");
        webDriver.manage().window().maximize();
    }
//    输入框
    public void InputBox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement login=webDriver.findElement(By.id("js-signin-btn"));
        login.click();
        Thread.sleep(1000);
        WebElement userName=webDriver.findElement(By.xpath("/html/body/div[9]/div[2]/div/form/div[1]/input"));
//        获取文本框内容
        String user_info=userName.getAttribute("placeholder");
//        System.out.println(user_info);
//        判断文本框是否可输入内容
//        boolean user_isEnable=userName.isEnabled();
//        System.out.println(user_isEnable);
        WebElement passport=webDriver.findElement(By.xpath("/html/body/div[9]/div[2]/div/form/div[2]/input"));
        WebElement loginButton=webDriver.findElement(By.xpath("/html/body/div[9]/div[2]/div/form/div[5]/input"));
//        userName.sendKeys("111111");
//        Thread.sleep(1000);
//        userName.clear();
//        Thread.sleep(1000);
        userName.sendKeys("925259851@qq.com");
        passport.sendKeys("qihuijun852");
        loginButton.click();
    }
//    单选框
    public void RadioBox() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.get("https://www.imooc.com/user/setprofile");
        WebElement edit=webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div[2]/a"));
        edit.click();
        WebElement sex=webDriver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div/form/div[4]/div/label[3]"));
        sex.click();
    }
//    复选框
    public void CheckBox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement login=webDriver.findElement(By.id("js-signin-btn"));
        login.click();
        Thread.sleep(2000);
        WebElement check=webDriver.findElement(By.id("auto-signin"));
        System.out.println("是否可以选择？"+check.isEnabled());
        System.out.println("是否选中？"+check.isSelected());
        Thread.sleep(1000);
//   如果默认是勾选，再次点击就是取消勾选
        check.click();
    }
//    隐藏按钮，引用js案例
    public void DisplayButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement login=webDriver.findElement(By.id("js-signin-btn"));
        login.click();
        Thread.sleep(1000);
        WebElement button=webDriver.findElement(By.xpath("/html/body/div[9]/div[2]/div/form/div[5]/input"));
        String jscript="document.getElementsByClassName('moco-btn moco-btn-red moco-btn-lg btn-full xa-login')[0].style.display='none'";
        JavascriptExecutor js=(JavascriptExecutor) webDriver;
        js.executeScript(jscript);
        Boolean is_displayed=button.isDisplayed();
        System.out.println("登录按钮是否显示"+is_displayed);
    }
//    隐藏首页的悬浮框
    public void HideSuspensionBox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement button=webDriver.findElement(By.xpath("//*[@id='J_GotoTop']"));
        String jscript="document.getElementsByClassName('elevator')[0].style.display='none'";
        JavascriptExecutor js=(JavascriptExecutor) webDriver;
        js.executeScript(jscript);
        Boolean is_displayed=button.isDisplayed();
        System.out.println("首页悬浮框是否显示"+is_displayed);
    }
//    通过web_form提交表单
//    由于提交的地址与form提交地址不一样，所以登录不成功
    public void Form(){
        WebElement web_form=webDriver.findElement(By.id("signup-form"));
        web_form.submit();
    }
//    upfile，上传图片,sendkeys属性只针对input标签
    public void UpLoadFile() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.get("https://www.imooc.com/user/setprofile");
        Thread.sleep(1000);
//        本来更换头像为hover类型style.bottom='-30px'，移入鼠标才显示，现在将更换头像链接一直显示在页面上
        String jscript="document.getElementsByClassName('update-avator')[0].style.bottom='0';";
        JavascriptExecutor js= (JavascriptExecutor) webDriver;
        js.executeScript(jscript);
        WebElement upLoad=webDriver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div[1]/div/p/a"));
        upLoad.click();
//        用xpath定位的是上传头像链接的元素，并不是上传空间元素，所以上传文件最好用id来定位元素
        WebElement upLoadPic=webDriver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div/div[1]/div[2]/form/a"));
        WebElement upLoadPic1=webDriver.findElement(By.id("upload"));
//        路径地址一定要用\，而不能用/，比如D:/upload2.jpg
        upLoadPic1.sendKeys("D:\\upload2.jpg");
    }
//    将鼠标移入hover
    public void moveToHover() throws InterruptedException{
        Thread.sleep(1000);
        webDriver.get("https://www.imooc.com/user/setprofile");
        Thread.sleep(1000);
        WebElement hover=webDriver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div[1]/img"));
        Actions action=new Actions(webDriver);
        action.moveToElement(hover).perform();
    }
    public void getText(){

        WebElement text=webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/ul/li[5]/div/div/div[1]/div/a/span"));
        System.out.println(text.getText());
    }
/*
***下拉框
* 根据父节点form表单再定位下拉框select元素
* .all_selected_options 所有选中的项
.first_selected_option 第一个选中的项
.options
deselect只能用于多选下拉列表
.deselect_all() 删除所有选中项
.deselect_by_index() 按照索引删除所选项
.deselect_by_value() 按照值删除所选项
.deselect_by_visible_text() 按照可见文本删除所选项
.select_by_index() 通过索引选择项
.select_by_value() 通过值选择项
.select_by_visible_text() 通过可见文本选择项
*/

    public void DownSelected() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.get("https://www.imooc.com/user/setprofile");
        WebElement edit=webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div[2]/a"));
        edit.click();
        Thread.sleep(1000);
        WebElement formElement=webDriver.findElement(By.id("profile"));
        WebElement job=formElement.findElement(By.id("job"));
        Select selectList=new Select(job);
//        selectList.selectByValue("18");
//        selectList.selectByIndex(5);
        selectList.selectByVisibleText("学生");
    }
/*
* 鼠标悬停
* 运用父节点和子节点元素定位方法
* 子节点数组存储，然后数组元素定位
* */
    public void MouseAction() throws InterruptedException {
        Thread.sleep(1000);
//        WebElement login=webDriver.findElement(By.xpath("//*[@id='js-signin-btn']"));
        Actions action=new Actions(webDriver);
//        单击
//        action.click(login).perform();
//        双击
//        action.doubleClick(login).perform();
////        右击
//          action.contextClick(login).perform();
//          悬停
        WebElement menuParent=webDriver.findElement(By.className("menuContent"));
        WebElement menu=menuParent.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[9]/div[1]/a/span"));
//        action.moveToElement(menu).perform();
        List<WebElement> item= menuParent.findElements(By.className("item"));
        action.moveToElement(item.get(0)).perform();
        windowsHandle=webDriver.getWindowHandle();
        System.out.println(windowsHandle);
        Thread.sleep(5000);
        WebElement href=webDriver.findElement(By.linkText("区块链"));
//        用鼠标悬浮会不稳定，经常报错
        action.click(href).click().perform();
        Thread.sleep(5000);
    }
/*
* iframe切换
* */
    public void IframeSwitch() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.get("https://www.imooc.com/article/publish#");
        WebElement iframe=webDriver.findElement(By.id("ueditor_0"));
        webDriver.switchTo().frame(iframe);
        WebElement text=webDriver.findElement(By.tagName("body"));
        text.sendKeys("123456");
    }
    /*
     * handle切换
     * */
    public void DisplayBlock() throws InterruptedException {
//        将需要悬浮才显示的内容用js控制直接显示在页面
        String jscript="document.getElementsByClassName('submenu a hide')[0].style.display='block'";
        JavascriptExecutor js= (JavascriptExecutor) webDriver;
        js.executeScript(jscript);
        WebElement w=webDriver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/a[2]"));
        Thread.sleep(2000);
        w.click();
        Thread.sleep(2000);
//        获得切换之前的句柄
        windowsHandle=webDriver.getWindowHandle();
        System.out.println(windowsHandle);
//        获得所有的句柄
        Set<String> windowHandles=webDriver.getWindowHandles();
//        遍历句柄，当数组中句柄和切换前句柄不一致时，继续，直到句柄与切换前句柄不一致时跳出if
        for (String s:windowHandles){
            if (s.equals(windowsHandle)){
                continue;
            }
            System.out.println(s);
            webDriver.switchTo().window(s);
        }
        System.out.println(webDriver.getCurrentUrl());
        WebElement difficulty=webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div/div[3]/div/ul/li[4]/a"));
        difficulty.click();
    }
    /*
    * 等待,主要用于调试
    * */
    public void WaitForElement(){
//        隐示等待,如果某一元素未被检索到就一直检索到时间截止.
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        显示等待,在当前页面找某个元素10s.
        WebDriverWait wait=new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("test")));

    }
    public static void main(String args[]) throws InterruptedException {

        test test =new test();
        test.SetUp();
        test.InputBox();
        test.getText();
//        test.DisplayBlock();
//        test.IframeSwitch();
//        test.MouseAction();
//        test.HideSuspensionBox();
//        test.DisplayButton();
//        test.CheckBox();
//        test.WaitForElement();
//        test.IframeSwitch();
//        test.DownSelected();
//        test.UpLoadFile();
//        test.moveToHover();
//        test.Form();
//        test.RadioBox();





    }
}
