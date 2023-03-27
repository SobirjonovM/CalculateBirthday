package org.example.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import javax.naming.InitialContext;
import java.util.LinkedList;
import java.util.List;

public class InlineKeyboardUtil {
    public static InlineKeyboardButton button(String text, String callBack) {
        InlineKeyboardButton button = new InlineKeyboardButton(text);
        button.setCallbackData(callBack);
        return button;
    }

    public static InlineKeyboardMarkup getYearKeyboard(int beginYear) { // 1990
        int year = beginYear;
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            List<InlineKeyboardButton> row = new LinkedList<>();
            for (int j = 0; j < 3; j++) {
                InlineKeyboardButton button = InlineKeyboardUtil.button(String.valueOf(year), "/year/" + year);
                year++;
                row.add(button);
            }
            rowList.add(row);
        }
        List<InlineKeyboardButton> navigation = new LinkedList<>();
        navigation.add(InlineKeyboardUtil.button("<<", "/year/prev/" + (beginYear - 9)));
        navigation.add(InlineKeyboardUtil.button(">>", "/year/next/" + (beginYear + 9)));
        rowList.add(navigation);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getMonthKeyboard(){
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        List<InlineKeyboardButton> row1 = new LinkedList<>();

        row1.add(InlineKeyboardUtil.button("Yanvar", "/month/1"));
        row1.add(InlineKeyboardUtil.button("Fevral", "/month/2"));
        row1.add(InlineKeyboardUtil.button("Mart", "/month/3"));
        row1.add(InlineKeyboardUtil.button("Aprel", "/month/4"));
        rowList.add(row1);

        List<InlineKeyboardButton> row2 = new LinkedList<>();
        row2.add(InlineKeyboardUtil.button("May", "/month/5"));
        row2.add(InlineKeyboardUtil.button("Iyun", "/month/6"));
        row2.add(InlineKeyboardUtil.button("Iyul", "/month/7"));
        row2.add(InlineKeyboardUtil.button("Avgust", "/month/8"));
        rowList.add(row2);

        List<InlineKeyboardButton> row3 = new LinkedList<>();
        row3.add(InlineKeyboardUtil.button("Sentabr", "/month/9"));
        row3.add(InlineKeyboardUtil.button("Oktabr", "/month/10"));
        row3.add(InlineKeyboardUtil.button("Noyabr", "/month/11"));
        row3.add(InlineKeyboardUtil.button("Dekabr", "/month/12"));
        rowList.add(row2);


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
    public static InlineKeyboardMarkup getDayKeyboard(int currentYear,int currentMonth){
        int year = currentYear;
        int month = currentMonth;
        int beginDay = 1;
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        for (int i = 0; i < 4; i++){
            List<InlineKeyboardButton> row = new LinkedList<>();
            for (int j = 0; j < 7; j++){
                InlineKeyboardButton button = InlineKeyboardUtil.button(String.valueOf(beginDay), "/day/" + beginDay);
                beginDay++;
                row.add(button);
            }
            rowList.add(row);
        }

        if ((currentYear % 4 == 0 && currentYear % 100 != 0 || currentYear % 400 == 0) && currentMonth == 2){
            InlineKeyboardButton button = InlineKeyboardUtil.button("29", "/day/" + 29);
            List<InlineKeyboardButton> row = new LinkedList<>();
            row.add(button);
            rowList.add(row);
        }else if (currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8 || currentMonth == 10 || currentMonth == 12){
            InlineKeyboardButton button1 = InlineKeyboardUtil.button("29", "/day/" +29);
            InlineKeyboardButton button2 = InlineKeyboardUtil.button("30", "/day/" +30);
            InlineKeyboardButton button3 = InlineKeyboardUtil.button("31", "/day/" +31);
            List<InlineKeyboardButton> row = new LinkedList<>();
            row.add(button1);
            row.add(button2);
            row.add(button3);
            rowList.add(row);
        } else if (currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || currentMonth == 11) {
            InlineKeyboardButton button = InlineKeyboardUtil.button("29", "/day/" + 29);
            List<InlineKeyboardButton> row = new LinkedList<>();
            row.add(button);
            rowList.add(row);
        }
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }


}
