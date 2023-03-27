package org.example.controller;

import org.example.CalendarBot;
import org.example.dto.Profile;
import org.example.util.InlineKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class YearController {
    private CalendarBot app;

    public YearController(CalendarBot app) {
        this.app = app;
    }

    public void handleMessage(String text, Message message, User user) {
        String[] items = text.split("/");  //  /year/prev/1981  /year/next/1999   /year/1999

        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(message.getChatId());
        editMessageText.setMessageId(message.getMessageId());

        if (items[2].equals("prev") || items[2].equals("next")) {
            editMessageText.setText("Yilni tanlang.");
            int beginYear = Integer.parseInt(items[3]);
            editMessageText.setReplyMarkup(InlineKeyboardUtil. getYearKeyboard(beginYear));
        } else if (items[2].equals("next")) {
            editMessageText.setText("Yilni tanlang.");
            int beginYear = Integer.parseInt(items[3]);
            editMessageText.setReplyMarkup(InlineKeyboardUtil.getYearKeyboard(beginYear));
        } else { // year chosen
            Integer year = Integer.parseInt(items[2]);
            Profile profile = new Profile(user.getId());
            profile.setYear(year);
            CalendarBot.profileMap.put(user.getId(), profile);
            editMessageText.setText("Oyni tanlang.");
            editMessageText.setReplyMarkup(InlineKeyboardUtil.getMonthKeyboard());
            System.out.println(CalendarBot.profileMap);
        }
        app.sendMsg(editMessageText);
    }
}
