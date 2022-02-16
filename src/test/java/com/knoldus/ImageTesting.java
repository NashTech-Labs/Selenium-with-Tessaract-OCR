package com.knoldus;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
public class ImageTesting {
    WebDriver driver;
    Config config = ConfigFactory.load("application.conf");
    String driverPath = config.getString("driverPath");
    String webDriveName = config.getString("webDriveName");
    static Logger log = Logger.getLogger(ImageTesting.class.getName());
    @BeforeClass
    public void setup() {
        System.setProperty(webDriveName, driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://challengepost-s3-challengepost.netdna-ssl.com/photos/production/software_photos/001/205/265/datas/original.png");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test(testName = "DUMMY_TEST")
    public void dummyTest() throws IOException, TesseractException {
        WebElement image = driver.findElement(By.tagName("img"));
        TesseractExtender.capturePicture(image);         // call the method to write the image to resource folder
        Tesseract tesseract = new Tesseract();          // get the Tesseract direct interace
        tesseract.setDatapath("src/test/resources/tessdata");
        // the doOCR method of Tesseract will retrieve the text from image captured by Selenium
        String result = tesseract.doOCR(new File("src/test/resources/testImage.png"));
        log.debug(result);
        Assert.assertTrue(result.contains("TEST"));
    }
}
