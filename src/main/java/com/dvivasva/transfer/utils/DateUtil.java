package com.dvivasva.transfer.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static Date toDate(LocalDateTime dateTimeToday){
        return Date.from(dateTimeToday.atZone(ZoneId.systemDefault()).toInstant());
    }
}
