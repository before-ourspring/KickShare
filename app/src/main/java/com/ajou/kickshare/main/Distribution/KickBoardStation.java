package com.ajou.kickshare.main.Distribution;

public class KickBoardStation implements Comparable<KickBoardStation>{
    private int stationID;
    private int kickBoardScore;
    public KickBoardStation(int StationID, int kickBoardScore){
        this.stationID = StationID;
        this.kickBoardScore = kickBoardScore;
    }

    public int getStationID(){
        return this.stationID;
    }
    public void setStationID(int stationID){
        this.stationID = stationID;
    }
    public int getKickBoardScore(){
        return this.kickBoardScore;
    }
    public void setKickBoardScore(int kickBoardScore){
        this.kickBoardScore = kickBoardScore;
    }

    @Override
    public int compareTo(KickBoardStation o) {
        if (this.kickBoardScore < o.getKickBoardScore()) {
            return -1;
        } else if (this.kickBoardScore > o.getKickBoardScore()) {
            return 1;
        }
        return 0;

    }
}
