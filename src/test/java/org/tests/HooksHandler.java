package org.tests;

import io.cucumber.java.*;
import org.base.Base;
import org.device.Device;
import org.driver_handler.DriverHandler;
import org.utils.ConfigProperties;
import org.utils.Waits;

import java.io.IOException;
import java.net.URISyntaxException;

public class HooksHandler extends Base {

    @Before
    public void setup() throws IOException, URISyntaxException {
        configTestData = new ConfigProperties("resources/configTestData.properties");
        configAppium = new ConfigProperties("resources/configAppium.properties");
        driverHandler = new DriverHandler();
        device = new Device();
        waits = new Waits();
    }

    @After
    public static void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driverHandler.quitAppium();
    }
}
