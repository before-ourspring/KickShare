package com.ajou.kickshare.main.FareCalculation;

public class StudentStrategy extends TotalStrategy {
    public String getName(){
        return "Student";
    }

    public int getFareStrategy(int MTime){
        return MTime*150;
    }
}
