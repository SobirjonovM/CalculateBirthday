package org.example.controller;

import org.example.CalendarBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.HashMap;
import java.util.Map;

public class KeyboardController {
    private CalendarBot app;
    public static Map<Long, StringBuilder> map = new HashMap<>();
    private YearController yearController;
    private MonthController monthController;
    private DayController dayController;

    public KeyboardController(CalendarBot app) {
        this.app = app;
        yearController = new YearController(app);
        monthController = new MonthController(app);
        dayController = new DayController(app);
    }

    public void handleMessage(String text, Message message, User user) {

        if (text.startsWith("/year")) {
            yearController.handleMessage(text, message, user);
        } else if (text.startsWith("/month")) {
            monthController.handleMessage(text, message, user);
        } else if (text.startsWith("/day")) {
            dayController.handleMessage(text, message, user);
        }

    }
}
