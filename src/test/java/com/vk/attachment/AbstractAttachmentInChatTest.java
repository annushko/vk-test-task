package com.vk.attachment;

import com.vk.AbstractVKTest;
import com.vk.fragment.LeftMenuFragment;
import com.vk.popup.DeleteChatPopup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.CollectionCondition.noneMatch;

abstract class AbstractAttachmentInChatTest extends AbstractVKTest {

    @BeforeMethod
    public void createNewChat() {
        var leftMenuFragment = new LeftMenuFragment();
        leftMenuFragment.clickOnMessengerItem();
        messengerPage.createNewChatWithRandomName();
        chatName = messengerPage.getChatName();
    }

    @AfterMethod
    public void deleteChat() {
        messengerPage.deleteChat();
        var deleteChatPopup = new DeleteChatPopup();
        deleteChatPopup.checkDeleteHistory()
                       .closeChat();

        messengerPage.getAllChats()
                          .shouldBe(noneMatch(String.format("no chat with name '%s'", chatName),
                                              el -> el.getText().equals(chatName)));
    }

}
