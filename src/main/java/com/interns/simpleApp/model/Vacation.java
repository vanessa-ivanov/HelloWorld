package com.interns.simpleApp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Vacation {
    private LocalDate startDate;
    private LocalDate endDate;
    private int id;

    private static int vacationID = 0;

    public Vacation (LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        id = ++vacationID;
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

    public int getId() {
        return id;
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

    public static boolean notEnoughVacationDays(List<Vacation> vacations, Vacation vacation) {
        return (vacationDaysLeft(vacations) - vacation.durationInDays() < 0);
    }

    public static int vacationDaysLeft(List<Vacation> vacations) {
        int vacationDaysLeft = 30;
        for (Vacation vacation : vacations) {
            vacationDaysLeft -= (Period.between(vacation.startDate, vacation.getEndDate()).getDays() +1);
        }
        return vacationDaysLeft;
    }

    public static void reduceId(List<Vacation> vacations, int deletedId){
        for (Vacation vacation : vacations) {
            if (vacation.id > deletedId) {
                vacation.id -= 1;
            }
        }
        reduceVacationID();
    }

    public static void reduceVacationID() {
        vacationID -= 1;
    }
}
