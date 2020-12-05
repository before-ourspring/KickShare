package com.ajou.kickshare.main.FareCalculation;

public abstract class FareStategyFactory {
    public abstract TotalStrategy createCalculator(String name);
}
