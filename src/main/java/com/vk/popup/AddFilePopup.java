package com.vk.popup;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddFilePopup {

    public void selectFirstFileFromAlbum() {
        $$("#docs_choose_rows ._docs_choose_attach").first().click();
    }

    public void uploadNewFileFromClasspath(String file) {
        $("#choose_doc_upload").uploadFromClasspath(file);
    }

}
