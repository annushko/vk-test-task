package com.vk.fragment;

import static com.codeborne.selenide.Selenide.$;

public class TopProfileFragment {

    public void logout() {
        $("#top_logout_link").click();
    }

}
