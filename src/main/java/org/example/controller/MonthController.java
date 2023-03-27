package org.example.controller;

import org.example.CalendarBot;
import org.example.dto.Profile;
import org.example.util.InlineKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import javax.swing.text.EditorKit;

public class MonthController {
    private CalendarBot app;

    public MonthController(CalendarBot app) {
        this.app = app;
    }

    public void handleMessage(String text, Message message, User user) {
        String[] items = text.split("/");

        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(message.getChatId());
        editMessageText.setMessageId(message.getMessageId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());

        if (!CalendarBot.profileMap.containsKey(user.getId())) {
            sendMessage.setText("Don't be mazgi, siz yo'qsiz ! ");
            return;
        }
        Integer month = Integer.parseInt(items[2]);
        Profile profile = CalendarBot.profileMap.get(user.getId());
        profile.setMonth(month);
        System.out.println(CalendarBot.profileMap);
        editMessageText.setText("Kunni tanlang");
        editMessageText.setReplyMarkup(InlineKeyboardUtil.getDayKeyboard(profile.getYear(), profile.getMonth()));
        app.sendMsg(editMessageText);
    }
}
