package org.driver_handler;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.base.Base;

public class DriverHandler {

    private static AndroidDriver driver;
    private static AppiumDriverLocalService service;
    private static UiAutomator2Options options;

    public DriverHandler() throws MalformedURLException, URISyntaxException {
        configureAppium();
    }

    public static void configureAppium() throws URISyntaxException, MalformedURLException {
        options = new UiAutomator2Options();
        options.setDeviceName(Base.configAppium.getProperty("deviceName"));
        options.setApp( System.getProperty("user.dir") + "\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk");
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home") + "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(Base.configAppium.getProperty("localIpAddress")).usingPort(Integer.parseInt(Base.configAppium.getProperty("localPortNumber"))).build();
        service.start();
        driver = new AndroidDriver(new URI(Base.configAppium.getProperty("localURI")).toURL(), options);
    }

    public AndroidDriver getDriver(){return driver;}

    public static void quitAppium(){
        driver.quit();
    }

}
