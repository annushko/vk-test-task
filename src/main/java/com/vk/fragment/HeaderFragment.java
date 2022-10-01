package com.vk.fragment;

import static com.codeborne.selenide.Selenide.$;

public class HeaderFragment {

    public void expandTopProfileLink() {
        $("#top_profile_link").click();
    }

}
