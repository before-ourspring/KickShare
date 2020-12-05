package com.ajou.kickshare.main.DBAccess;

public abstract class AbstractFactory {
    public abstract ExternalDBAdapter creatEnternalDBAdapter(String name);
}
