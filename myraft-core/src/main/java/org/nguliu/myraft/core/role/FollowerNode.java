package org.nguliu.myraft.core.role;

import org.nguliu.myraft.core.enums.RoleTypeEnum;
import org.nguliu.myraft.core.node.NodeId;
import org.nguliu.myraft.core.schedule.ElectionTimeout;

public class FollowerNode extends AbstractNodeRole {

    private final NodeId votedFor;

    private final NodeId leaderId;

    private final ElectionTimeout electionTimeout;

    public FollowerNode(Integer term, NodeId votedFor, NodeId leaderId, ElectionTimeout electionTimeout) {
        super(RoleTypeEnum.FOLLOWER, term);
        this.votedFor = votedFor;
        this.leaderId = leaderId;
        this.electionTimeout = electionTimeout;
    }

    @Override
    public void cancelTimeoutOrTask() {
        electionTimeout.cancel();
    }

    public NodeId getVotedFor() {
        return votedFor;
    }

    public NodeId getLeaderId() {
        return leaderId;
    }

    public ElectionTimeout getElectionTimeout() {
        return electionTimeout;
    }

    @Override
    public String toString() {
        return "FollowerNode{" +
                "term=" + term +
                ", votedFor=" + votedFor +
                ", leaderId=" + leaderId +
                ", electionTimeout=" + electionTimeout +
                '}';
    }
}
