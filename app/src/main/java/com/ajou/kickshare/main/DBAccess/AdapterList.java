package com.ajou.kickshare.main.DBAccess;

public class AdapterList extends AbstractFactory{
    @Override
    public ExternalDBAdapter creatEnternalDBAdapter(String name){
        switch (name) {
            case "ExternalDB" : return new ExternalDBAdapter();
        }
        return null;
    };
}
