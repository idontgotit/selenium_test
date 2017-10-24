package my.lib.serenity.primefaces.sars.utils;

import my.lib.serenity.primefaces.constant.CommonConstant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ngoc on 06/10/2016.
 */
public class CommonUtils {

    public static HashMap<String, Integer> countAllResultIsSame(List<String> listAll) {
        HashMap<String, Integer> listMapCountAllResultIsSame = new HashMap<>();
        for (int i = 0; i < listAll.size(); i++) {
            int count = 1;
            for (int j = 0; j < listAll.size(); j++) {
                if (i == j)
                    continue;
                else {
                    if (listAll.get(j).substring(0, 1).equalsIgnoreCase(listAll.get(i).substring(0, 1))) {
                        count++;
                    }
                }
            }
            listMapCountAllResultIsSame.put(listAll.get(i).substring(0, 1).toLowerCase(), count);
        }
        return listMapCountAllResultIsSame;
    }

    public static HashMap<String, Integer> countNextResultIsSame(List<String> listAll) {
        HashMap<String, Integer> listCountNextResultIsSame = new HashMap<>();
        for (int i = 0; i < listAll.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < listAll.size(); j++) {
                if (listAll.get(j).substring(0, 1).equalsIgnoreCase(listAll.get(i).substring(0, 1))) {
                    count++;
                    i = j;
                }
            }
            listCountNextResultIsSame.put(listAll.get(i).substring(0, 1).toLowerCase(), count);
        }
        return listCountNextResultIsSame;
    }

    public static final DateTimeFormatter getYearMonthDayFormatter() {
        return DateTimeFormatter.ofPattern(CommonConstant.DateTimePattern.YEAR_MONTH_DAY);
    }

    public static final LocalDate parseStringToYearMonthDayLocalDate(String dateString) {
        return LocalDate.parse(dateString, CommonUtils.getYearMonthDayFormatter());
    }
}
