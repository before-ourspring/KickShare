package com.ajou.kickshare.main.Distribution;

public class KickBoardInfo {
    private int kickBoardID;
    private boolean status;
    private int battery;
    private Double currentLocationX;
    private Double currentLocationY;

    public KickBoardInfo(int kickboardID, boolean status, int battery, Double currentLocationX, Double currentLocationY) {
        this.kickBoardID = kickboardID;
        this.battery = battery;
        this.status = status;
        this.currentLocationX = currentLocationX;
        this.currentLocationY = currentLocationY;
    }
}
