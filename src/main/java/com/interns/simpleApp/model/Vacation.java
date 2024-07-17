package com.interns.simpleApp.model;

import java.time.LocalDate;
import java.time.Period;

public class Vacation {
    private LocalDate startDate;
    private LocalDate endDate;
    private String person;

    public Vacation (LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int durationInDays(Vacation vacation) {
        Period period = Period.between(vacation.startDate, vacation.endDate);
        return period.getDays();
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
