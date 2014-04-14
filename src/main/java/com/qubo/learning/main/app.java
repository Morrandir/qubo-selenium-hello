package com.qubo.learning.main;

import com.qubo.learning.cases.BasicCases;
import com.qubo.learning.cases.Hello;
import com.qubo.learning.cases.TC1;
import org.openqa.selenium.server.SeleniumServer;


/**
 * Created by Qubo_Song on 3/26/2014.
 */
public class App {

    public static void main(String[] args) {

        SeleniumServer seleniumServer;
        BasicCases hello = new Hello();

        boolean passed = false;

        try {
            if((seleniumServer = new SeleniumServer()) != null) {
                seleniumServer.start();
            }
            passed = hello.test();
            seleniumServer.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
