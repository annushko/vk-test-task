package com.vk.attachment;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attributeMatching;

@Feature("VK - Upload photo to Chat")
public class AddPhotoAttachmentInChatTest extends AbstractAttachmentInChatTest {

    @Description("Upload first photo from album")
    @Test
    public void addPhotoToChatFromAlbumTest() {
        messengerPage.addFirstPhotoAttachmentFromAlbum();
        messengerPage.getLastPhotoAttachmentFromChat()
                     .shouldHave(attributeMatching("href", ".*/photo.*"));
    }

    @DataProvider(name = "photos")
    public Object[][] photos() {
        return new Object[][]{{"pencil.jpg"}, {"pencils.png"}};
    }

    @Description("Upload photo from PC")
    @Test(dataProvider = "photos")
    public void uploadPhotoFromPCTest(String photo) {
        messengerPage.addPhotoAttachmentFromPC(photo);
        messengerPage.getLastPhotoAttachmentFromChat()
                     .shouldHave(attributeMatching("aria-label", "фотография"));
    }

}
