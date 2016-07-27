/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Tests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.InstagramApp;
import Tests.AbstractBaseTests.TestBase;

/**
 * Tests for Instagram Login
 */
public class InstagramTest extends TestBase {
    private InstagramApp instaPage;

    @Override
    public String getName() {
        return "Instagram";
    }

    @BeforeTest
    @Override
    public void setUpPage() {
        instaPage = new InstagramApp(driver);
    }

    @Test
    public void testAlertMessage() throws Exception{
      instaPage.login("ID", "PASSWORD");
      takeScreenshot("loginpassed");
    }
    
    public boolean takeScreenshot(final String name) {
        String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }
}