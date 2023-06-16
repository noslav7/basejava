package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private String period;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Period(String period, String description, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(period, "period must not be null");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period1 = (Period) o;

        if (!period.equals(period1.period)) return false;
        if (!startDate.equals(period1.startDate)) return false;
        return endDate.equals(period1.endDate);
    }

    @Override
    public int hashCode() {
        int result = period.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Period{" +
                "period='" + period + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
