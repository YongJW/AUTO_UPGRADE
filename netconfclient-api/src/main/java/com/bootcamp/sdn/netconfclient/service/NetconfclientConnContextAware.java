package com.bootcamp.sdn.netconfclient.service;

import java.util.concurrent.ConcurrentHashMap;

import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionContext;
public interface NetconfclientConnContextAware {
    public void closeNetconfNode(String nodeName);
    public NetconfclientConnectionContext getNetconfConnContext(String nodeName);
    public void removeNetconfConnContext(String nodeName);
    public ConcurrentHashMap<String, NetconfclientConnectionContext> getAllNetconfConnContext();
}
