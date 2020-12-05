package com.ajou.kickshare.main.DBAccess;

import com.ajou.kickshare.main.KickBoardAccess.KickboardConnectAdaptor;

public class AdapterList extends AbstractFactory{
    @Override
    public AbstractAdapter createAdapter(String name){
        switch (name) {
            case "ExternalDBAdaptor" : return new ExternalDBAdapter();
            case "kickBoardConnectAdaptor" : return new KickboardConnectAdaptor();
            case "internalDBAdaptor" : return new InternalDBAdapter();
        }
        return null;
    };
}
