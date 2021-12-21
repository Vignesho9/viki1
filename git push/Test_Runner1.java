package com.Runner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.Helper.File_Reader_Manager;
import com.Mini_Projects.Base_Class;
import com.pom.Book_Hotel;
import com.pom.Conform_Booking;
import com.pom.Home_page;
import com.pom.Search_Hotel;
import com.pom.Select;
import com.v.Po_Manager;

public class Test_Runner1 extends Base_Class {
	
	private static final String log4j = null;
	public static WebDriver driver = browserlaunch("chrome");
	public static Po_Manager pom = new Po_Manager(driver);
	public static Logger log = Logger.getLogger(Test_Runner.class);
	public static void main(String[] args) throws Throwable  {
		
	PropertyConfigurator.configure("log4j.properties");
	
	     log.info("Browser Launch");
	     String url = File_Reader_Manager.getInstanceFRM().getInstanceCR().getUrl();
		get(url);
         log.info("URL Launched Successfully");
		String perticular_Data = perticular_Data("C:\\Users\\Vignesh\\git\\viki\\Mini_Projects\\TC2.xlsx", 1, 5);
		inputvalues(pom.gethp().getemail(),perticular_Data);
		String perticular_Data2 = perticular_Data("C:\\Users\\Vignesh\\git\\viki\\Mini_Projects\\TC2.xlsx", 2, 5);
		inputvalues(pom.gethp().getPassword(),perticular_Data2);
		click(pom.gethp().getLogin());
		sleep(3000);
	    log.info("Sign in Successfully");
	    
		selectindex(pom.getsh().getLocation(), 7);
		selectindex(pom.getsh().getHotel(), 2);
		selectindex(pom.getsh().getRoom(), 2);
		clear(pom.getsh().getChi());
		inputvalues(pom.getsh().getChi(), "09/12/2021");
		clear(pom.getsh().getCho());
		inputvalues(pom.getsh().getCho(), "18/12/2021");
		selectindex(pom.getsh().getAdultroom(), 2);
		click(pom.getsh().getSubmit());
		waitt();
		log.info("Hotel Searched Successfully");
		
		click(pom.gets().getRadio());
		click(pom.gets().getContinu());
	    log.info("Hotel Selected Successfully");
	    
	    String fname = perticular_Data("C:\\Users\\Vignesh\\git\\viki\\Mini_Projects\\TC2.xlsx", 14, 5);
		inputvalues(pom.getbh().getFname(), fname);
		String lname = perticular_Data("C:\\Users\\Vignesh\\git\\viki\\Mini_Projects\\TC2.xlsx", 15, 5);
		inputvalues(pom.getbh().getLname(), lname);
		String ads = perticular_Data("C:\\Users\\Vignesh\\git\\viki\\Mini_Projects\\TC2.xlsx", 16, 5);
		inputvalues(pom.getbh().getAddress(), ads);
		String creditcard = File_Reader_Manager.getInstanceFRM().getInstanceCR().getCreditcard();
		inputvalues(pom.getbh().getCcnum(), creditcard);
		selectindex(pom.getbh().getCctype(), 2);
	    selectindex(pom.getbh().getCcexpm(), 6);
	    selectindex(pom.getbh().getCcexpy(), 8);
	    String cv = perticular_Data("C:\\Users\\Vignesh\\git\\viki\\Mini_Projects\\TC2.xlsx", 21, 5);
	    inputvalues(pom.getbh().getCvv(), cv);
    	click(pom.getbh().getBooknow());
	    waitt();
		 log.info("Hotel Booking Successfully");
		 
		 click(pom.getcb().getItey());
		 waitt();
		 log.info("LogOut Successfully");
		 
			TakesScreenshot t = (TakesScreenshot) driver;
			File adt = t.getScreenshotAs(OutputType.FILE);
			File a=new File("C:\\Users\\Vignesh\\eclipse-workspace\\selenium\\screenshot\\adt.png");
			FileHandler.copy(adt, a);
	}

	}

	
	


