package com.metlease.DAO.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String toMySQLFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
