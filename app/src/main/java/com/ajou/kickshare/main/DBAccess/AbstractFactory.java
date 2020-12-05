package com.ajou.kickshare.main.DBAccess;

public abstract class AbstractFactory {
    public abstract AbstractAdapter createAdapter(String name);
}
