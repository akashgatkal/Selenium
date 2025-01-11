package com.crm.Vtiger_Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.ReadFromPropertyFile;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;

public class Vtiger_Base {
	public static WebDriver driver=null;
	
	@BeforeClass
	public static void preCondition() throws InterruptedException, IOException
	{
		String browser =ReadFromPropertyFile.propertyData("browser");
		String url=ReadFromPropertyFile.propertyData("url");
		LoginPage lgn=new LoginPage(driver);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			
		}
		else if(browser.equalsIgnoreCase("InternetExplorer"))
		{
			driver=new InternetExplorerDriver();
			
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
			
		}
		else 
		{
			driver=new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("url");
	}
	@BeforeMethod
	public void logIn() throws IOException
	{
		String username=ReadFromPropertyFile.propertyData("username");
		String password=ReadFromPropertyFile.propertyData("password");
		LoginPage lgn=new LoginPage(driver);
		lgn.userName(username);
		lgn.password(password);
		lgn.submit();
		
		
	}
	@AfterMethod
	public void logOut()
	{
		HomePage hp=new HomePage(driver);
		hp.profile();
		hp.signOut();
		
	}
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}

}
