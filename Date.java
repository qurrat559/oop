package sample;

import java.io.Serializable;

public class Date implements Serializable {
    private int year;
    private int month;
    private int day;

    public Date(int day,int month,int year){
        if(year % 4!=0 && month !=2 && year > 1919 && year < 2119 && month > 0 && month < 13 && day < 32){
            this.day = day;
            this.month = month;
            this.year= year;
        }
        else if(year % 4 ==0 && month==2 && year > 1919 && day > 0 && day < 30){
            this.day = day;
            this.month = month;
            this.year= year;
        }
        else if(year % 4 ==0 && month==2 && year > 1919 && day > 0 && day < 29){
            this.day = day;
            this.month = month;
            this.year= year;
        }
        else {
        }
    }

    public void setYear(int year) {
        if (year > 1919 && year < 2119) {
            this.year = year;
        }
        else {
            System.out.println("Not Correct range");
        }
    }
    public void setMonth(int month) {
        if (month > 0 && month< 13) {
            this.month = month;
        }
        else {
            System.out.println("Not Correct range");
        }
    }


    public void setDay(int day,int month,int year) {
        if (year % 4 != 0 && month != 2 && day > 0 && day < 32) {
            this.day = day;
        } else if (year % 4 == 0 && month == 2 && day > 0 && day < 30) {
            this.day = day;
        } else if (year % 4 != 0 && month == 2 && day > 0 && day < 29) {
            this.day = day;
        } else {
            System.out.println("Not correct range");
        }

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDate(){
        String dateStr = String.format("%02d/%02d/%04d",this.day, this.month,this.year);
        return dateStr;
    }
    public String toString(){
        String dateStr = String.format("%02d/%02d/%04d", this.day, this.month, this.year);
        return dateStr;
    }
}
