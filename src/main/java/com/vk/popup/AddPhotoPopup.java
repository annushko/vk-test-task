package com.vk.popup;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddPhotoPopup {

    public void selectFirstPhotoFromAlbum() {
        $$(".popup_box_container a div.media_check_btn_wrap").first().click();
    }

    public void uploadNewImageFromClasspath(String image) {
        $(".photos_choose_upl input").uploadFromClasspath(image);
    }

}
