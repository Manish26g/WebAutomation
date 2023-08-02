package com.lambdaEcommerce.reports;

import com.lambdaEcommerce.driver01.Manager.driverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class screenShot {

    public static String getScreenshot(String imagename){
        TakesScreenshot ts = (TakesScreenshot) driverManager.getDriver();
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshot/"+imagename;
        try {
            FileUtils.copyFile(f, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public static String convertImg_Base64(String screenshotPath) throws IOException {
        byte[] file = FileUtils.readFileToByteArray(new File(screenshotPath));
        String base64Img = Base64.encodeBase64String(file);
        return  base64Img;
    }

}
