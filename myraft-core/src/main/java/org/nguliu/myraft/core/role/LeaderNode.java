package org.nguliu.myraft.core.role;

import org.nguliu.myraft.core.enums.RoleTypeEnum;
import org.nguliu.myraft.core.schedule.LogReplicationTask;

public class LeaderNode extends AbstractNodeRole {

    private final LogReplicationTask logReplicationTask;

    public LeaderNode(Integer term, LogReplicationTask logReplicationTask) {
        super(RoleTypeEnum.LEADER, term);
        this.logReplicationTask = logReplicationTask;
    }

    @Override
    public void cancelTimeoutOrTask() {
        logReplicationTask.cancel();
    }

    @Override
    public String toString() {
        return "LeaderNode{" +
                "logReplicationTask=" + logReplicationTask +
                '}';
    }
}
