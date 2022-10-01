package com.vk.chat;

import com.vk.AbstractVKTest;
import com.vk.fragment.LeftMenuFragment;
import com.vk.popup.DeleteChatPopup;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.CollectionCondition.noneMatch;

@Feature("VK - Create new Chat")
public class CreateChatTest extends AbstractVKTest {

    @Description("Create new Chat with random name")
    @Test
    public void createNewChatTest() {
        var leftMenuFragment = new LeftMenuFragment();
        leftMenuFragment.clickOnMessengerItem();
        messengerPage.createNewChatWithRandomName();

        chatName = messengerPage.getChatName();
        messengerPage.getAllChats()
                          .shouldBe(anyMatch(String.format("no chat with name '%s'", this.chatName),
                                             chat -> chat.getText().equals(this.chatName)));
    }

    @Description("Delete created Chat")
    @AfterMethod
    public void deleteChat() {
        messengerPage.deleteChat();
        new DeleteChatPopup()
                .checkDeleteHistory()
                .closeChat();

        messengerPage.getAllChats()
                          .shouldBe(noneMatch(String.format("no chat with name '%s'", this.chatName),
                                              chat -> chat.getText().equals(this.chatName)));
    }

}
