package org.example.controller;

import org.example.util.InlineKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MainController {
    public SendMessage handleMessage(String text, Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        if (text.equals("/start")) {
            sendMessage.setText("Yilni tanlang.");
            sendMessage.setReplyMarkup(InlineKeyboardUtil.getYearKeyboard(1990));
            return sendMessage;
        }
        sendMessage.setText("Do not be mazgi.");
        return sendMessage;
    }
}
