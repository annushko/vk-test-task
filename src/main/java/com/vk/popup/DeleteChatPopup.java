package com.vk.popup;

import static com.codeborne.selenide.Selenide.$;

public class DeleteChatPopup {

    public DeleteChatPopup checkDeleteHistory() {
        $(".popup_box_container ._check_is_delete").click();
        return this;
    }

    public void closeChat() {
        $(".popup_box_container .FlatButton--primary").click();
    }

}
