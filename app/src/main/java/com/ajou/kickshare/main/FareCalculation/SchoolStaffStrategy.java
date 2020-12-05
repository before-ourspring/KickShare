package com.ajou.kickshare.main.FareCalculation;

public class SchoolStaffStrategy extends TotalStrategy {
    public String getName(){
        return "SchoolStaff";
    }

    public int getFareStrategy(int MTime){
        return MTime*180;
    }
}
