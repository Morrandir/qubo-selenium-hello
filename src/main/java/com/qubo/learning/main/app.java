package com.qubo.learning.main;

import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.server.SeleniumServer;

/**
 * Created by Qubo_Song on 3/26/2014.
 */
public class app {

    public static void main(String[] args) {

        SeleniumServer seleniumServer;
        DefaultSelenium seleniumClient;
        boolean passed = false;

        String host = "localhost";
        int port = 4444;
        String url = "http://www.baidu.com/";
        String browserType = "*firefox";

        try {
            if((seleniumServer = new SeleniumServer()) != null) {
                seleniumServer.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String keyWordsLocator = "document.getElementById('kw1')";
        String search = "document.getElementById('su1')";
        seleniumClient = new DefaultSelenium(host,port,browserType,url);
        seleniumClient.start();
        seleniumClient.open(url);
        seleniumClient.type(keyWordsLocator,"java selenium");
        seleniumClient.click(search);
        seleniumClient.waitForPageToLoad("50000");
        passed = seleniumClient.isTextPresent("java selenium");
        seleniumClient.stop();

    }
}
