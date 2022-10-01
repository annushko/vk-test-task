package org.testng;

import org.testng.util.RetryAnalyzerCount;

public class CustomRetryAnalyzer extends RetryAnalyzerCount {

    public CustomRetryAnalyzer() {
        this.setCount(4);
    }

    @Override
    public boolean retryMethod(ITestResult result) {
        if (!result.isSuccess()) {
            var throwable = result.getThrowable();
            if (throwable != null) {
                return throwable.getMessage().contains("NoSuchElementException");
            }
        }
        return false;
    }

}
