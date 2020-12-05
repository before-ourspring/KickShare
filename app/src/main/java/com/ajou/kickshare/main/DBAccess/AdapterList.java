package com.ajou.kickshare.main.DBAccess;

import com.ajou.kickshare.main.KickBoardAccess.KickboardConnectAdaptor;

public class AdapterList extends AbstractFactory{
    @Override
    public AbstractAdapter createAdapter(String name){
        switch (name) {
            case "ExternalDB" : return new ExternalDBAdapter();
            case "KickBoardInfo" : return new KickboardConnectAdaptor();
            case "EnternalDB" : return new EnternalDBAdapter();
        }
        return null;
    };
}
