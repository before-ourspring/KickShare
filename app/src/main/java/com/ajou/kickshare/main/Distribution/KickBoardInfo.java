package com.ajou.kickshare.main.Distribution;

import java.io.Serializable;

public class KickBoardInfo implements Serializable {
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

    public int getKickBoardID() { return this.kickBoardID; }
    public int getBattery(){
        return this.battery;
    }
    public Double getCurrentLocationX() {
        return this.currentLocationX;
    }
    public Double getCurrentLocationY() {
        return this.currentLocationY;
    }
    public void setStatus(boolean status) { this.status = status; }
    public boolean getStatus() { return this.status; }
}
