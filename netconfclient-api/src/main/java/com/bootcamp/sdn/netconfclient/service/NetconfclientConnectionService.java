package com.bootcamp.sdn.netconfclient.service;

import com.bootcamp.sdn.netconfclient.service.NetconfclientConfiguration;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionCallback;

public interface NetconfclientConnectionService {
    public void connect(final NetconfclientConfiguration configuration, final NetconfclientConnectionCallback callback);
}
