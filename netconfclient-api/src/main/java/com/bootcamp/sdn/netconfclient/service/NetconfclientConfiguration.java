package com.bootcamp.sdn.netconfclient.service;

import java.net.InetSocketAddress;

public class NetconfclientConfiguration {
    private final InetSocketAddress address;
    private final Long connectionMaxAttempts;
    private final Long connectionTimeoutMillis;
    /* TODO: username and password should be used in security */
    private final String username;
    private final String password;

    public NetconfclientConfiguration(final InetSocketAddress address,
                                      final Long connectionMaxAttempts,
                                      final Long connectionTimeoutMillis,
                                      final String username,
                                      final String password) {
        this.address = address;
        this.connectionMaxAttempts = connectionMaxAttempts;
        this.connectionTimeoutMillis = connectionTimeoutMillis;
        this.username = username;
        this.password = password;
    }

    public Long getConnectionTimeoutMillis() {
        return connectionTimeoutMillis;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    public Long getConnectionMaxAttempts() {
        return connectionMaxAttempts;
    }
}
