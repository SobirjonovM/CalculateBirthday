package org.example.controller;

import org.example.CalendarBot;
import org.example.dto.Profile;
import org.example.util.InlineKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class DayController {
    private CalendarBot app;

    public DayController(CalendarBot app) {
        this.app = app;
    }
    public void handleMessage(String text, Message message, User user) {
        String[] items = text.split("/");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());

        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(message.getChatId());
        editMessageText.setMessageId(message.getMessageId());

        if (!CalendarBot.profileMap.containsKey(user.getId())) {
            sendMessage.setText("Don't be mazgi, siz yo'qsiz ! ");
            return;
        }
        Integer day = Integer.valueOf(items[2]);
        Profile profile = CalendarBot.profileMap.get(user.getId());
        profile.setDay(day);
        System.out.println(CalendarBot.profileMap);
        editMessageText.setText("Bizzy bizzy tamam tamam");
        editMessageText.setReplyMarkup(InlineKeyboardUtil.getDayKeyboard(profile.getYear(), profile.getMonth()));
        app.sendMsg(editMessageText);
    }
}
