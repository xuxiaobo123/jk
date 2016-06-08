package jkstTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.junit.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class JkstTest {
	private AppiumDriver driver;
	@BeforeClass
	@Parameters("port")
    public void setUp(String port) throws Exception{
        //设置apk的路径,已安装APP下面可注释掉
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        File app = new File(appDir, "SwatowHealth.apk");
        
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");   //移动浏览器的名称
        capabilities.setCapability("platformName", "Android");  //使用哪种移动平台
        capabilities.setCapability("deviceName", "PLK-AL10");  //启动哪种设备
        
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "5.0.2");
        //设置apk路径，应用的绝对路径，注意一定是绝对路径。
       // capabilities.setCapability("app", app.getAbsolutePath());
        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.zq.swatowhealth");  //待测试的app的java package
        capabilities.setCapability("appActivity", ".activity.QRCStartApp");
        capabilities.setCapability("appWaitActivity", ".activity.MainActivity");
        //初始化
        driver = new AndroidDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"), capabilities);  
    }
    
    @Test
    public void addContact() throws InterruptedException{
    	
    	Thread.sleep(1 * 5000); 
    	
    	//driver.navigate().to("www.baidu.com");
    	
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	List<WebElement> elLists = driver.findElements(By.id("com.zq.swatowhealth:id/item_img"));
        System.out.println(elLists.size());
        //String date = "";
        //date = DateUtil.convertDateToString(new Date());
        Thread.sleep(1 * 5000); 
       // System.out.println(date.getTime());
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height; 
        System.out.println(width+"and"+height);
        driver.swipe(width/2,height* 3 / 4, width/2,20, 500);
        Thread.sleep(1 * 5000); 
        List<WebElement> textList = driver.findElements(By.id("com.zq.swatowhealth:id/item_img"));
        textList.get(1).click();
        WebElement back = driver.findElement(By.id("com.zq.swatowhealth:id/layout_btn_back"));
        back.click();
        System.out.println(textList.size());
        //Thread.sleep(5000);
      /*  for (WebElement textLists : textList) {
        
        	
        	textLists.click();
        	//driver.swipe(width/2,height* 3 / 4, width/2,height/16, 500);
        	back.click();
        	
		}
     */  
    	//截屏并保存至本地
     /*   for (WebElement elList : elLists) {
        	elList.click();
        	Thread.sleep(1 * 2000);
        	Date date = new Date();
        	int date1 = (int) (date.getTime());
        	File screen = driver.getScreenshotAs(OutputType.FILE);
        	File screenFile = new File("d:\\健康汕头\\screen"+date1+".png");
        	try {
        	    FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}
        	WebElement back = driver.findElement(By.id("com.zq.swatowhealth:id/layout_btn_back"));
        	back.click();
		}*/
    }
    @Test
    public void RamdomTest() throws InterruptedException{
    	Thread.sleep(1 * 5000); 
    	//driver.removeApp("com.zq.swatowhealth");
//    	WebElement gundong = driver.findElement(By.id("com.zq.swatowhealth:id/item_tv_name"));
//    	String gundongtest = gundong.getText();
//    	driver.scrollTo(gundongtest);
    	driver.resetApp();
    }
    
    @Test
    public void installTest() throws InterruptedException{
    	Thread.sleep(1 * 5000); 
    	List<WebElement> elLists = driver.findElements(By.id("com.zq.swatowhealth:id/item_img"));
    	for (WebElement elList : elLists) {
        	elList.click();
        	Thread.sleep(1 * 2000);
        	Date date = new Date();
        	int date1 = (int) (date.getTime());
        	File screen = driver.getScreenshotAs(OutputType.FILE);
        	File screenFile = new File("d:\\健康汕头\\screen"+date1+".png");
        	try {
        	    FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}
        	WebElement back = driver.findElement(By.id("com.zq.swatowhealth:id/layout_btn_back"));
        	back.click();
        	}
    } 
    
    @AfterClass
    public void tearDown() throws Exception{
		// TODO Auto-generated method stub
    	driver.quit();
	}
}