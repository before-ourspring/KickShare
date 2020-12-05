package com.ajou.kickshare.main.FareCalculation;

public class OutsiderStrategy extends TotalStrategy {
    public String getName(){
        return "Outsider";
    }

    public int getFareStrategy(int MTime){

        return MTime*200;
    }
}
