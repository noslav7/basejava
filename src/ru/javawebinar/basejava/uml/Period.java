package ru.javawebinar.basejava.uml;

import java.time.LocalDate;

public class Period {
    private String period;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Period(String period, String description, LocalDate startDate, LocalDate endDate) {
        this.period = period;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPeriod() {
        return period;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
