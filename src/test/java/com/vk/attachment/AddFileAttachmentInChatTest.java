package com.vk.attachment;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attributeMatching;

@Feature("VK - Upload file to Chat")
public class AddFileAttachmentInChatTest extends AbstractAttachmentInChatTest {

    @Description("Upload first file from album")
    @Test
    public void addFirstFileAttachmentFromAlbumTest() {
        messengerPage.addFirstFileAttachmentFromAlbum();
        messengerPage.getLastFileAttachmentFromChat()
                     .shouldHave(attributeMatching("href", ".*/doc.*"));
    }

    @DataProvider(name = "files")
    public Object[][] docs(){
        return new Object[][] {{"test.docx"}, {"test.pdf"}};
    }

    @Description("Upload file from PC")
    @Test(dataProvider = "files")
    public void uploadDocsFromPCTest(String file) {
        messengerPage.addFileAttachmentFromPC(file);
        messengerPage.getLastFileAttachmentFromChat()
                     .shouldHave(attributeMatching("href", ".*/doc.*"));
    }

}
