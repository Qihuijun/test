package com.course.pageObject;

import com.course.base.DriverBase;
import com.course.utils.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class BasePage {
//声明一个DriverBase类型
    public DriverBase driver;
    /*
    * 构造函数，调用DriverBase中的webdriver
    * */
    public BasePage(DriverBase driver) {
        this.driver=driver;
    }

}
