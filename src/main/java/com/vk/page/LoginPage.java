package com.vk.page;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void login(String login, String password) {
        $("#index_email").setValue(login);
        $("button[type='submit']").click();

        // redirect to password page
        $("input[name='password']").setValue(password);
        $("button[type='submit']").click();
    }

}
