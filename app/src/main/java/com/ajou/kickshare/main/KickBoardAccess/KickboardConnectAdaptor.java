package com.ajou.kickshare.main.KickBoardAccess;

import com.ajou.kickshare.main.DBAccess.AbstractAdapter;
import com.ajou.kickshare.main.Distribution.KickBoardInfo;

import java.util.ArrayList;

public class KickboardConnectAdaptor extends AbstractAdapter {
    public String getName(){
        return "KickBoardInfo";
    }
    public KickBoardInfo getKickBoardInfo(int kickBoardID, ArrayList<KickBoardInfo> kickBoardInfos){

        return null;
    }
}
