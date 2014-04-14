package com.qubo.learning.cases;

import com.thoughtworks.selenium.DefaultSelenium;


import java.io.IOException;
import java.util.Properties;

/**
 * Created by Qubo_Song on 3/27/2014.
 */
public abstract class BasicCases {

    private DefaultSelenium seleniumClient;
    private String host;
    private int port;
    private String browserType;
    private String initialUrl;
    private boolean result = false;

    protected Properties properties;

    protected BasicCases() {
        this.properties = new Properties();

        try {
            properties.load(BasicCases.class.getClassLoader().getResourceAsStream("basic.properties"));
            this.host = properties.getProperty("BasicCases.host");
            this.port = Integer.parseInt(properties.getProperty("BasicCases.port"));
            this.browserType = properties.getProperty("BasicCases.browserType");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public DefaultSelenium getSeleniumClient() {
        return seleniumClient;
    }

    public void setSeleniumClient(DefaultSelenium seleniumClient) {
        this.seleniumClient = seleniumClient;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getInitialUrl() {
        return initialUrl;
    }

    public void setInitialUrl(String initialUrl) {
        this.initialUrl = initialUrl;
    }

    public DefaultSelenium init() {
        seleniumClient = new DefaultSelenium(host, port, browserType, initialUrl);
        seleniumClient.start();
        return seleniumClient;
    }

    public boolean test() {
        init();
        seleniumClient.stop();
        return true;
    }
}
