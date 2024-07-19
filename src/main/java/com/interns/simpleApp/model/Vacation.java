package com.interns.simpleApp.model;

import java.time.LocalDate;
import java.time.Period;

public class Vacation {
    private LocalDate startDate;
    private LocalDate endDate;

    public Vacation (LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int durationInDays() {
        Period period = Period.between(startDate, endDate);
        return period.getDays() +1;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean vacationInputImpossible() {
        if (startDate.isAfter(endDate)){
            return true;
        }
        if (startDate.isBefore(LocalDate.now())){
            return true;
        }
        return false;
    }
}
