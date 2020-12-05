package com.ajou.kickshare.main.DBAccess;

import com.ajou.kickshare.main.Distribution.KickBoardInfo;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class EnternalDBAdapter {
    private static ArrayList<KickBoardInfo> kbIfArrayList;
    public ArrayList<KickBoardInfo> getKickBoardList(){
        List<Double> kbLocationListX = null;
        List<Double> kbLocationListY = null;
        kbLocationListX.add(37.2800147);
        kbLocationListY.add(127.0436415);

        kbLocationListX.add(37.2814443);
        kbLocationListY.add(127.045162);

        kbLocationListX.add(37.2827246);
        kbLocationListY.add(127.045851);

        kbLocationListX.add(37.2800147);
        kbLocationListY.add(37.2800147);

        kbLocationListX.add(37.2843748);
        kbLocationListY.add(127.0443452);

        kbLocationListX.add(37.2863922);
        kbLocationListY.add(127.045851);

        kbLocationListX.add(37.2829729);
        kbLocationListY.add(127.0474774);

        kbLocationListX.add(37.2829669);
        kbLocationListY.add(127.0434387);

        kbLocationListX.add(37.2838055);
        kbLocationListY.add(127.0433987);

        kbLocationListX.add(37.2836885);
        kbLocationListY.add(127.0426417);

        kbLocationListX.add(37.2822024);
        kbLocationListY.add(127.0463244);

        kbLocationListX.add(37.2821187);
        kbLocationListY.add(127.0476976);

        kbLocationListX.add(37.2808444);
        kbLocationListY.add(127.0470122);

        kbLocationListX.add(37.279969);
        kbLocationListY.add(127.0451841);

        kbLocationListX.add(37.279430);
        kbLocationListY.add(127.047742);

        kbLocationListX.add(37.284719);
        kbLocationListY.add(127.045536);

        kbLocationListX.add(37.2841308);
        kbLocationListY.add(127.0454224);

        kbLocationListX.add(37.2835771);
        kbLocationListY.add(127.045156);

        kbLocationListX.add(37.285220);
        kbLocationListY.add(127.045055);


        for(int i = 0; i < kbLocationListX.size(); i ++){
            KickBoardInfo kbIf = new KickBoardInfo(i, true, 100, kbLocationListX.get(0), kbLocationListY.get(0));
            kbIfArrayList.add(kbIf);
        }


        return kbIfArrayList;
    }
}
