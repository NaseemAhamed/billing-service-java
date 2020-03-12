package com.retail.pricing.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

    public static int getDiffYears(LocalDate startDate, LocalDate endDate) {
        Period age = Period.between(startDate, endDate);
        return age.getYears();
    }

}
