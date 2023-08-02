package com.lambdaEcommerce.utils.screenshots;

import com.lambdaEcommerce.driver01.Manager.driverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public final class ScreenshotUtils {

    public static String getScreenShot(String imagename){
        File src= ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String path= System.getProperty("user.dir") + "/screenshots/" + imagename + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try{
            FileUtils.copyFile(src,destination);
        }catch(IOException e){
            System.out.println("capture failed" + e.getMessage());
        }
        return path;
    }

      public static String convertImg_Base64(String screenshotPath) throws IOException {
          byte[] file= FileUtils.readFileToByteArray(new File(screenshotPath));
          String base64Img= Base64.encodeBase64String(file);
          return base64Img;
      }
}
