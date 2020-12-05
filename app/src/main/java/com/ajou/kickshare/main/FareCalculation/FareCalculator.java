package com.ajou.kickshare.main.FareCalculation;

public class FareCalculator extends FareStategyFactory {
    @Override
    public TotalStrategy createCalculator(String name){
        switch (name) {
            case "Student" : return new StudentStrategy();
            case "SchoolStaff" : return new SchoolStaffStrategy();
            case "Outsider" : return new OutsiderStrategy();
        }
        return null;
    };
}
