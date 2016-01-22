package com.bootcamp.sdn.netconfclient.service;

import org.opendaylight.controller.sal.connect.api.RemoteDeviceHandler;
import org.opendaylight.controller.sal.connect.netconf.listener.NetconfDeviceCommunicator;
import org.opendaylight.controller.sal.connect.netconf.listener.NetconfSessionPreferences;

public class NetconfclientAutoCloseable implements AutoCloseable {
    private String sessionId;
    private NetconfDeviceCommunicator listener;
    private RemoteDeviceHandler<NetconfSessionPreferences> facade;

    public NetconfclientAutoCloseable(String sessionId, NetconfDeviceCommunicator listener, RemoteDeviceHandler<NetconfSessionPreferences> facade) {
        this.sessionId = sessionId;
        this.listener = listener;
        this.facade = facade;
    }

    @Override
    public void close() throws Exception {
        listener.close();
        facade.close();
    }

    public String getSessionId() {
        return sessionId;
    }

    public RemoteDeviceHandler<NetconfSessionPreferences> getFacade() {
        return facade;
    }

    public NetconfDeviceCommunicator getListener() {
        return listener;
    }
}
