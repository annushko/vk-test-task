package com.vk.attachment;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attributeMatching;

@Feature("VK - Upload new audio to Chat")
public class AddAudioAttachmentInChatTest extends AbstractAttachmentInChatTest {

    @Description("Upload first audio track from album")
    @Test
    public void addFirstAudioAttachmentFromAlbumTest() {
        messengerPage.addFirstAudioAttachmentFromAlbum();
        messengerPage.getLastAudioAttachmentFromChat()
                          .shouldHave(attributeMatching("href", ".*/audio.*"));
    }

}
