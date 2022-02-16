package com.knoldus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.Point;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class TesseractExtender {
    public static void capturePicture(WebElement element) throws IOException {
        WrapsDriver wrapsDriver = (WrapsDriver) element;         //cast element to wrapsDriver
        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver())
                .getScreenshotAs(OutputType.FILE);         // get the entire screenshot from the driver of passed WebElement
        BufferedImage image = ImageIO.read(screen);        // create an instance of buffered image from captured screenshot
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();        // get the width and height of the WebElement using getSize()
        Rectangle rect = new Rectangle(width, height);        // create a rectangle using width and height
        Point point = element.getLocation();         // this will provide X & Y co-ordinates of the WebElement
        BufferedImage dest = image.getSubimage(point.getX(), point.getY(), rect.width,
                rect.height);        // create image  for element using its location and size.
        // write back the image data for element in new File
        ImageIO.write(dest, "png", new File("src/test/resources/testImage.png"));
    }
}
