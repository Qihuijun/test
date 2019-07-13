package com.course.cases;

import com.course.base.DriverBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testCourseList extends CaseBase {
    public DriverBase driver;
    public testCourseList(){
        this.driver=InitDriver("firefox");
    }
    @Test
    public void CourseList(){
        driver.getUrl("http://coding.imooc.com");

    }
}
