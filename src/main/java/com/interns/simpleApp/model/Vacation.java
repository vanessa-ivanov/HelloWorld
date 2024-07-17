package com.interns.simpleApp.model;

import javax.print.attribute.standard.MediaSize;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Vacation {
    private LocalDate start;
    private LocalDate end;
    private String person;
    private static List<Vacation> vacations = new ArrayList<>();

    public Vacation (LocalDate start, LocalDate end){
        this.start = start;
        this.end = end;
    }

    // WHAT IF END OF ONE AND START OF OTHER ON THE SAME DAY?
    public boolean overlaps(Vacation vacation){
        for (Vacation other : vacations){
            if (vacation.start.isAfter(other.start) && vacation.start.isBefore(other.end)
            || vacation.end.isAfter(other.start) && vacation.end.isBefore(other.end)){
                return true;
            }
        }
        return false;
    }

    public int durationInDays(Vacation vacation){
        Period period = Period.between(vacation.start, vacation.end);
        return period.getDays();
    }

    public static void addVacation (Vacation vacation){
        vacations.add(vacation);
    }
}
