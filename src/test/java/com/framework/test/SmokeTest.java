package com.framework.test;

import com.framework.base.BaseTest;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openDemoQA() {
        driver.get("https://demoqa.com");
        System.out.println("Page Title: " + driver.getTitle());
    }
}
