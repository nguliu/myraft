package org.nguliu.myraft.core.node;

import org.nguliu.myraft.core.log.ReplicationState;

import javax.annotation.Nonnull;

public class GroupMember {

    private final NodeEndpoint endpoint;

    private ReplicationState replicationState;

    public GroupMember(NodeEndpoint endpoint) {
        this(endpoint, ReplicationState.getInstance(0, 0));
    }

    public GroupMember(@Nonnull NodeEndpoint endpoint, @Nonnull ReplicationState replicationState) {
        this.endpoint = endpoint;
        this.replicationState = replicationState;
    }

    int getMatchIndex() {
        return replicationState.getMatchIndex();
    }

    int getNextIndex() {
        return replicationState.getNextIndex();
    }

    public NodeEndpoint getEndpoint() {
        return endpoint;
    }

    public ReplicationState getReplicationState() {
        return replicationState;
    }

    public void setReplicationState(ReplicationState replicationState) {
        this.replicationState = replicationState;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
                "endpoint=" + endpoint +
                ", replicationState=" + replicationState +
                '}';
    }
}
