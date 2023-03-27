package org.example;

import org.example.controller.KeyboardController;
import org.example.controller.MainController;
import org.example.dto.Profile;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

public class CalendarBot extends TelegramLongPollingBot {
    public static Map<Long, Profile> profileMap = new HashMap<>();
    private MainController mainController = new MainController();
    private KeyboardController keyBoardController;

    public CalendarBot() {
        keyBoardController = new KeyboardController(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                SendMessage sendMessage = mainController.handleMessage(message.getText(), message);
                sendMsg(sendMessage);
                return;
            } else if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                String data = callbackQuery.getData();
                keyBoardController.handleMessage(data, callbackQuery.getMessage(), callbackQuery.getFrom());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }





    public void sendMsg(SendMessage method) {
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMsg(EditMessageText method) {
        try {
            execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotUsername() {
        return "calculate_birthday_bot";
    }

    @Override
    public String getBotToken() {
        return "6207929376:AAFMTw3ecSBvQb8iaxAK0UcDTrZFFurShb8";
    }
}
