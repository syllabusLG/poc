package com.syllabus.poc.POC.services;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserChromeSession implements Browser {
	
	@Value("${poc.server.web}")
	private String pocServerWeb;

	@Value("${poc.server.backend}")
	private String pocServerBackend;
	
	private WebDriver webDriver;
	
	public UserChromeSession() {
		getWebDriver();
		openWebPage();
		handleWebSearch();
	}
	
	private void getWebDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:9222");
		webDriver = new ChromeDriver(options);

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setCacheDisabled(true));
		
		webDriver.manage().timeouts().implicitlyWait(Duration.of(60, ChronoUnit.SECONDS));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.of(60, ChronoUnit.SECONDS));
		webDriver.manage().window().maximize();
	}
	
	private void openWebPage() {
		webDriver.get("https://www.vermittlerregister.info/");
		if (!webDriver.findElements(By.xpath("//button[@class='cm-btn cm-btn-success']")).isEmpty()) {
			webDriver.findElement(By.xpath("//button[@class='cm-btn cm-btn-success']")).click();
		}
	}
	
	private void handleWebSearch() {
		webDriver.findElement(By.id("registernummer")).sendKeys("SSSSSSSSSS");
		log.info("handle Web Search");
		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
		if (!webDriver.findElements(By.tagName("mat-error")).isEmpty()) {
			log.info("Web Search complete, browser authenticated successfully");
		}else {
			throw new RuntimeException("Browser check failed");
		}
	}
	
	@Override
	public String getSeedAsJson(String seedId) {
		log.info("------ get seed : {}", seedId);
		webDriver.get(pocServerBackend + seedId);
		return webDriver.findElement(By.tagName("pre")).getText();
	}
}
