package com.course.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
    WebDriver webDriver;
    public WebDriver driverName(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","D:/漆卉君学习资料/git/test/comcoursecode/src/main/resources/geckodriver.exe");
            System.setProperty("webdriver.Firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
            webDriver= new FirefoxDriver();
            return webDriver;
        }
        else {
            System.setProperty("webdriver.gecko.driver","D:/漆卉君学习资料/git/test/comcoursecode/src/main/resources/geckodriver.exe");
            System.setProperty("webdriver.Firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
            webDriver= new FirefoxDriver();
            return webDriver;
        }
    }
}
