package com.ajou.kickshare.main.Distribution;

import com.ajou.kickshare.main.DBAccess.AdapterList;
import com.ajou.kickshare.main.DBAccess.ExternalDBAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class DistributionPlanner {
    private int hour = 13; //배치할 시간대 숫자 삽입
    private ArrayList<KickBoardInfo> finalKickBoardInfos = new ArrayList<>();
    private ArrayList<KickBoardStation> hourlyKickBoardLocation = new ArrayList<>();
    private ArrayList<KickBoardStation> beforeKickBoardLocation = new ArrayList<>();
    private ArrayList<KickBoardStation> stationDeviation = new ArrayList<>();

    public ArrayList<KickBoardStation> DistributionPlanner(){
        AdapterList abFactory = new AdapterList();
        ExternalDBAdapter externalDBAdapter = (ExternalDBAdapter) abFactory.createAdapter("ExternalDBAdaptor");
        finalKickBoardInfos = externalDBAdapter.getKickBoardList();
        hourlyKickBoardLocation = externalDBAdapter.getHourlyLocation(hour); //시간을 매개변수로 줘서 그 시간대에 어떤 스테이션에 킥보드가 몇개 있었는지를 받아옴
        beforeKickBoardLocation = externalDBAdapter.getHourlyLocation(hour - 1); //그 전 시간에대 킥보드의 어떤 스테이션에 킥보드가 몇개 있었는지를 받아옴

        for(int i = 0; i < hourlyKickBoardLocation.size(); i++){
            KickBoardStation kbS = new KickBoardStation(hourlyKickBoardLocation.get(i).getStationID(),
                    hourlyKickBoardLocation.get(i).getStationID() - beforeKickBoardLocation.get(i).getKickBoardScore());    //그 전시간대와 배치할 시간대의 킥보드 숫자 편차를 구함
            stationDeviation.add(kbS); //ArrayList 삽입
        }

        Collections.sort(stationDeviation); //킥보드의 편차를 기준으로 ArrayList를 정렬한다. ( 오름차순 )
                                            //편차가 큰건 사람들이 들쭉날쭉으로 방문하는곳
                                            //편차가 작은 건 사람들이 일정하게 방문하는곳 따라서 편차가 작은게 우선
        for(int i = 0; i < hourlyKickBoardLocation.size(); i++){
            for(int j = 0; j < hourlyKickBoardLocation.size(); j++){
                if(stationDeviation.get(i).getStationID() == hourlyKickBoardLocation.get(i).getStationID()){
                    hourlyKickBoardLocation.get(i).setKickBoardScore(hourlyKickBoardLocation.get(i).getKickBoardScore() - stationDeviation.get(i).getStationID()); //마지막으로 편차를 기반으로 배치할 킥보드 계산
                }
            }
        }
        return stationDeviation;
    }
}
