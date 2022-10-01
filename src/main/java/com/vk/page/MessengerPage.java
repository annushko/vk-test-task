package com.vk.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.vk.popup.AddFilePopup;
import com.vk.popup.AddMusicPopup;
import com.vk.popup.AddPhotoPopup;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessengerPage {

    private final AddPhotoPopup addPhotoPopup = new AddPhotoPopup();
    private final AddMusicPopup addMusicPopup = new AddMusicPopup();
    private final AddFilePopup addFilePopup = new AddFilePopup();
    private String chatName;

    public String getChatName() {
        return chatName;
    }

    public void createNewChatWithRandomName() {
        $("._im_start_new").click();
        $("#im_dialogs_creation_name").setValue(generateChatName());
        $("._im_confirm_creation").click();
    }

    public void deleteChat() {
        $(".im-page--aside .ui_actions_menu_icons[aria-label='Действия']").hover();
        $(".im-action_leave").click();
    }

    //Photo
    public void addFirstPhotoAttachmentFromAlbum() {
        hoverOnAttachment();
        $("._type_photo").click();
        addPhotoPopup.selectFirstPhotoFromAlbum();
        $("#photos_choose_button").click();
        $(".im-send-btn_send").click();
    }

    public void addPhotoAttachmentFromPC(String photo) {
        hoverOnAttachment();
        $("._type_photo").click();
        addPhotoPopup.uploadNewImageFromClasspath(photo);
        $(".im-send-btn_send").click();
    }

    //Audio
    public void addFirstAudioAttachmentFromAlbum() {
        hoverOnAttachment();
        $("._type_audio").click();
        addMusicPopup.selectFirstAudioTrackFromAlbum();
        $(".im-send-btn_send").click();
    }

    //File
    public void addFirstFileAttachmentFromAlbum() {
        hoverOnAttachment();
        $("._type_doc").click();
        addFilePopup.selectFirstFileFromAlbum();
        $(".im-send-btn_send").click();
    }

    public void addFileAttachmentFromPC(String doc) {
        hoverOnAttachment();
        $("._type_doc").click();
        addFilePopup.uploadNewFileFromClasspath(doc);
        $(".im-send-btn_send").click();
    }

    //Getters for last attachment
    public SelenideElement getLastPhotoAttachmentFromChat() {
        return $("._im_log_body a");
    }

    public SelenideElement getLastAudioAttachmentFromChat() {
        return $("._im_log_body .audio_row__performers a");
    }

    public SelenideElement getLastFileAttachmentFromChat() {
        return $("._im_log_body a.page_doc_title");
    }

    public ElementsCollection getAllChats() {
        return $$("._im_dialog_link");
    }

    private String generateChatName() {
        chatName = RandomStringUtils.randomAlphabetic(7);
        return chatName;
    }

    private void hoverOnAttachment() {
        $(".ms_item_more").hover();
    }

}
