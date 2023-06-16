package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONE_NUMBER("Телефон"),
    MOBILE_NUMBER("Мобильный"),
    HOME_PHONE_NUMBER("Домашний телефон"),
    SKYPE("Skype"),
    EMAIL("Электронная почта"),
    LINKEDIN("Профиль Linkedin"),
    GITHUB("Профиль Github"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    WEBSITE("Сайт");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
