package com.bootcamp.sdn.netconfclient.service;

import com.google.common.base.Optional;
import org.opendaylight.controller.md.sal.binding.api.MountPoint;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.netconf.node.fields.AvailableCapabilities;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.netconf.node.fields.UnavailableCapabilities;

public interface NetconfclientConnectionCallback {
    /* to check if we can invoke the specified RPCs on the required yang model. */
    public void validate(UnavailableCapabilities unavailableCapabilities, AvailableCapabilities availableCapabilities);

    /* do our business here when all ready. */
    public void callback(Optional<MountPoint> mountPointOptional);
}
