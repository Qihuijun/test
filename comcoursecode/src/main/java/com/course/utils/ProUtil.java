package com.course.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {
    String filePath;
    public Properties pro;
    /*
    * 构造方法，存放配置文件路径
    * */
    public ProUtil(String filePath) throws IOException {
       this.filePath=filePath;
       this.pro=readProperties();
    }
    /*
    * 读取配置文件
    * */
    public Properties readProperties() throws IOException {
        //        创建property对象
        Properties pro=new Properties();
//        获取配置文件路径
        InputStream fileInputStream=new FileInputStream(filePath);
//        读取本地文件
        InputStream in=new BufferedInputStream(fileInputStream);
//        装在本地文件
        pro.load(in);
        return pro;
    }
/*
* 读取关键字内容
* */

    public String getpro(String key) {
        if (pro.containsKey(key)){
        String username=pro.getProperty(key);
        return username;
        }else{
            return "未查找到这个元素";}
    }
  public static void main(String[] args) throws IOException {
        ProUtil proUtil=new ProUtil("D:\\漆卉君学习资料\\git\\test\\comcoursecode\\src\\test\\java\\element.properties");
        String locator=proUtil.getpro("username_element");
       String locatorType=locator.split(">")[0];
       System.out.println(locatorType);
       String locatortext=locator.split(">")[1];
       System.out.println(locatortext);

   }

}
