package org.testng;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        final var screenshot = Selenide.screenshot(OutputType.BYTES);
        Allure.getLifecycle().addAttachment("Screenshot",
                                            "image/png",
                                            "png",
                                            screenshot);
    }

}
