package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;


    public Position(String title, String description, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
