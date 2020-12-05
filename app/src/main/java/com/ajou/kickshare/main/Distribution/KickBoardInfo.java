package com.ajou.kickshare.main.Distribution;

public class KickBoardInfo {
    private int kickBoardID;
    private boolean status;
    private int battery;
    private Double currentLocationX;
    private Double currentLocationY;

    public KickBoardInfo(int kickBoardID, boolean status, int battery, Double currentLocationX, Double currentLocationY) {
        this.kickBoardID = kickBoardID;
        this.battery = battery;
        this.status = status;
        this.currentLocationX = currentLocationX;
        this.currentLocationY = currentLocationY;
    }

    public int getBattery(){
        return this.battery;
    }
    public Double getCurrentLocationX() {
        return this.currentLocationX;
    }
    public Double getCurrentLocationY() {
        return this.currentLocationY;
    }
}
