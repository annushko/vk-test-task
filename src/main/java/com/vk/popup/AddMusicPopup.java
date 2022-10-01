package com.vk.popup;

import static com.codeborne.selenide.Selenide.$$;

public class AddMusicPopup {

    public void selectFirstAudioTrackFromAlbum() {
        $$(".popup_box_container .box_body .ape_attach").first().click();
    }

}
