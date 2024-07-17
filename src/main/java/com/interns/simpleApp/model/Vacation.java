package com.interns.simpleApp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Vacation {
    private LocalDate startDate;
    private LocalDate endDate;
    private String person;
    private static List<Vacation> vacations = new ArrayList<>();

    public Vacation (LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // WHAT IF END OF ONE AND START OF OTHER ON THE SAME DAY?
    public boolean overlaps(Vacation vacation) {
        for (Vacation other : vacations){
            if (vacation.startDate.isAfter(other.startDate) && vacation.startDate.isBefore(other.endDate)
            || vacation.endDate.isAfter(other.startDate) && vacation.endDate.isBefore(other.endDate)){
                return true;
            }
        }
        return false;
    }

    public int durationInDays(Vacation vacation) {
        Period period = Period.between(vacation.startDate, vacation.endDate);
        return period.getDays();
    }

    public static void addVacation (Vacation vacation) {
        vacations.add(vacation);
    }

    public static void removeVacation (Vacation vacation) {
        vacations.remove(vacation);
    }
}
