package com.qubo.learning.cases;

import com.thoughtworks.selenium.DefaultSelenium;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Qubo_Song on 3/27/2014.
 */
public class Hello extends BasicCases {

    public Hello() {

        super();

        this.properties = new Properties();

        try {
            properties.load(Hello.class.getClassLoader().getResourceAsStream("hello.properties"));
            setInitialUrl(properties.getProperty("Hello.initUrl"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean test() {
        String keyWordsLocator = "document.getElementById('lst-ib')";
        String search = "document.getElementsByName('btnK')[0]";
        DefaultSelenium seleniumClient = init();

        seleniumClient.open(getInitialUrl());
        seleniumClient.type(keyWordsLocator, "java selenium");
        seleniumClient.click(search);
        return getSeleniumClient().isTextPresent("java selenium");
    }

}
