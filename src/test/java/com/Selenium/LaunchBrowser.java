package com.Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		List<String> urlList=new ArrayList<>();
		
		for(WebElement e:links)
		{
			String url=e.getAttribute("href");
			urlList.add(url);
		}
		urlList.parallelStream().forEach(e->checkBrokenLink(e));
		
		driver.quit();
	}
	
	public static void checkBrokenLink(String link)
	{
		try {
			URL url=new URL(link);
			HttpURLConnection httpUrlConnection= (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(6000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode()>=400)
			{
				System.out.println(link+" is broken link.");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
