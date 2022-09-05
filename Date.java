package Nonhotel;
import java.util.Calendar;

public class Date {

    public static final int MIN_YEAR;
    public static final int MAX_YEAR;

    protected int day = 1, month = 1, year = 1900;
    protected String mName = arrMName[0];
    protected static String [] arrMName = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    static {
        MIN_YEAR = 1900;
        MAX_YEAR = 3000;
    }

    public Date() {
        Calendar cal = Calendar.getInstance();
        setYear(cal.get(Calendar.YEAR));
        setMonth(cal.get(Calendar.MONTH) + 1);
        setDay(cal.get(Calendar.DAY_OF_MONTH));
    }

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            setYear(year);
            setMonth(month);
            setDay(day);
        }
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public String getMName() { return mName; }

    public void setDay(int day) {
        if (isValidDate (day, month, year))	this.day = day;
    }

    public void setMonth(int month) {
        if (isValidDate(day, month, year)) {
            this.month = month;
            this.mName = arrMName[month-1];
        }
    }

    public void setYear(int year) {
        if (isValidDate(day, month, year)) this.year = year;
    }


    public boolean isLeap() {
        return isLeap(year);
    }

    public static boolean isLeap(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0 ))	return true;
        else return false;
    }

    public boolean isValidDate() { return isValidDate(day, month, year); }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 0) return false;

        if (month < 0 || month > 12) return false;

        if (day < 0 || day > maxDay(month, year)) return false;

        return true;
    }

    public String toString()
    {
        return String.format("%d-%d-%d", year, month, day);
    }
    public static int maxDay(int month, int year) {
        int maxDay= 31;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;
            case 2:
                if (isLeap(year)) maxDay = 29;
                else maxDay = 30;
                break;
        }
        return maxDay;
    }

    public void next() {
        day++;
        if (day == maxDay(month, year) + 1) {
            day = 1;
            month++;
            if (month == 13) {
                month = 1;
                year ++;
            }
        }
    }

    public boolean equals(Object o)
    {
        Date date = (Date) o;
        return date.month == month && date.year == year && date.day == day;
    }
}

