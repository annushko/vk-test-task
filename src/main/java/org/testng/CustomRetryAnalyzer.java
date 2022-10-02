package org.testng;

import com.codeborne.selenide.ex.ElementIsNotClickableException;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.TimeoutException;
import org.testng.util.RetryAnalyzerCount;

import java.util.List;

public class CustomRetryAnalyzer extends RetryAnalyzerCount {

    private List<Class<? extends Throwable>> exceptions = List.of(ElementNotFound.class,
                                                                  ElementIsNotClickableException.class,
                                                                  TimeoutException.class);

    public CustomRetryAnalyzer() {
        this.setCount(4);
    }

    @Override
    public boolean retryMethod(ITestResult result) {
        if (!result.isSuccess()) {
            var throwable = result.getThrowable();
            if (throwable != null) {
                return exceptions.contains(throwable.getClass());
            }
        }
        return false;
    }

}
