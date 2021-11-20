package org.nguliu.myraft.core.node;

import javax.annotation.Nonnull;
import java.net.InetSocketAddress;

public class NodeEndpoint {

    private final NodeId nodeId;

    private final InetSocketAddress address;

    public NodeEndpoint(String id, String host, int port) {
        this(NodeId.getInstance(id), new InetSocketAddress(host, port));
    }

    public NodeEndpoint(@Nonnull NodeId nodeId, @Nonnull InetSocketAddress address) {
        this.nodeId = nodeId;
        this.address = address;
    }

    public NodeId getNodeId() {
        return nodeId;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "NodeEndpoint{" +
                "nodeId=" + nodeId +
                ", address=" + address +
                '}';
    }
}
