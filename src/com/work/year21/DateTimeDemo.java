package com.work.year21;

import java.time.*;

public class DateTimeDemo {

    public static void main(String[] args){
        /*LocalDate today = LocalDate.now();
        System.out.println("today=" + today);

        today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("today=" + today);

        //yyyy-mm-dd
        LocalDate dateObj = LocalDate.of(2021,02,25);
        System.out.println("dateObj=" + dateObj);

        dateObj = LocalDate.of(2021, Month.FEBRUARY,25);
        System.out.println("dateObj=" + dateObj);

        //365th day from start of Epoch[1 Jan 1970 UTC]
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("dateFromBase=" + dateFromBase);

        //125th day of year 2016
        LocalDate dateFromYear = LocalDate.ofYearDay(2016,125);
        System.out.println("dateFromYear=" + dateFromYear);*/

        // System.out.println("");

       /* LocalTime todayTime = LocalTime.now();
        System.out.println("todayTime=" + todayTime);

        todayTime = LocalTime.of(04,25,12,30);
        System.out.println("todayTime=" + todayTime);

        todayTime = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("todayTime=" + todayTime);

        //obtains an instance of LocalTime from a second-of-day value.
        //Time Obj created does not have nanoseconds
        LocalTime specificTime =  LocalTime.ofSecondOfDay(1000);
        System.out.println("specificTime=" + specificTime);

        //obtains an instance of LocalTime from a NANO second-of-day value.
        //Time Obj created has nanoseconds
        specificTime =  LocalTime.ofNanoOfDay(1000);
        System.out.println("specificTime=" + specificTime);
        //There are no epoch methods for time*/

        LocalDateTime todayDateTime = LocalDateTime.now();
        System.out.println("todayDateTime=" + todayDateTime);

        //Current Date using LocalDate and LocalTime //IMPORTANT
        todayDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("todayDateTime=" + todayDateTime);

        todayDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("todayDateTime=" + todayDateTime);

        todayDateTime = LocalDateTime.of(05,11,25,23,23,45,14);
        System.out.println("todayDateTime=" + todayDateTime); // 0005-11-25T23:23:45.000000014

        LocalDateTime specificDateTime = LocalDateTime.ofEpochSecond(12,12,ZoneOffset.UTC);
        System.out.println("specificDateTime=" + specificDateTime);

        //ZoneId is a representation of the time-zone such as ‘Europe/Paris‘.
        //ZoneOffset extends ZoneId and defines the fixed offset of the current time-zone with GMT/UTC, such as +02:00.
        // This means that this number represents fixed hours and minutes,
        // representing the difference between the time in current time-zone and GMT/UTC

    }
}
