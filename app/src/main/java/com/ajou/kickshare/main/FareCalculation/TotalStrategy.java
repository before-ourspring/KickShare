package com.ajou.kickshare.main.FareCalculation;

public abstract class TotalStrategy {
    public abstract String getName();

    public abstract int getFareStrategy(int MTime);
}
