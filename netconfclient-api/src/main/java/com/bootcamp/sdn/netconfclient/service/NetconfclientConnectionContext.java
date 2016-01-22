package com.bootcamp.sdn.netconfclient.service;

import com.bootcamp.sdn.netconfclient.service.NetconfclientAutoCloseable;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConfiguration;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionCallback;

public class NetconfclientConnectionContext {
    private NetconfclientConfiguration configuration;
    private NetconfclientConnectionCallback callback;
    private NetconfclientAutoCloseable session;

    public NetconfclientConnectionContext(NetconfclientConfiguration configuration, NetconfclientConnectionCallback callback, NetconfclientAutoCloseable session) {
        this.configuration = configuration;
        this.callback = callback;
        this.session = session;
    }

    public NetconfclientConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(NetconfclientConfiguration configuration) {
        this.configuration = configuration;
    }

    public NetconfclientConnectionCallback getCallback() {
        return callback;
    }

    public void setCallback(NetconfclientConnectionCallback callback) {
        this.callback = callback;
    }

    public NetconfclientAutoCloseable getSession() {
        return session;
    }

    public void setSession(NetconfclientAutoCloseable session) {
        this.session = session;
    }
}
