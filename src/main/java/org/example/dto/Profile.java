package org.example.dto;

public class Profile {
    private Long chatId;
    private Integer year;
    private Integer month;
    private Integer day;
    ///
    public Profile(Long chatId) {
        this.chatId = chatId;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "chatId=" + chatId +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
