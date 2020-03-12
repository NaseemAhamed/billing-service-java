package com.retail.pricing.util;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilTest {

    @Test
    public void testDateDiff() {
        assertEquals(3, DateUtil.getDiffYears(LocalDate.now(), LocalDate.now().plusYears(3)));
    }
}
