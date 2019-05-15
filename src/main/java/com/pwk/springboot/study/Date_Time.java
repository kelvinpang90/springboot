package com.pwk.springboot.study;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Date_Time {
    public static void main(String[] args) throws InterruptedException {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990,01,20);

        System.out.println(today);
        System.out.println(today.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println(LocalDate.parse("2018-01-01"));
        System.out.println(today.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(today.getMonth());
        System.out.println(LocalDate.of(2016,01,01).isLeapYear());
        System.out.println(Clock.systemDefaultZone());
        System.out.println(today.isAfter(LocalDate.now().minusDays(-1)));
        System.out.println(today.withMonth(05));
        System.out.println(today.toEpochDay());
        System.out.println(today.atTime(1,1));

        LocalDateTime time = LocalDateTime.now();
        Instant instant = Instant.now();
        Thread.sleep(100);
        Instant instant1 = Instant.now();

        System.out.println("Duration = "+Duration.between(instant,instant1).toNanos());
        System.out.println("Period = "+Period.between(today,birthday));

        System.out.println(LocalDateTime.parse(""));
        System.out.println(DayOfWeek.MONDAY);
        System.out.println(Month.FEBRUARY.maxLength());
        System.out.println(Instant.now());
        System.out.println(Clock.systemUTC());
    }
}
