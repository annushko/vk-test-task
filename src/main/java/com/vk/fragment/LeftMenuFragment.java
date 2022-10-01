package com.vk.fragment;

import static com.codeborne.selenide.Selenide.$;

public class LeftMenuFragment {

    public void clickOnMessengerItem() {
        $("a[href='/im']").click();
    }

}
