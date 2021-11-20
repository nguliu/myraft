package org.nguliu.myraft.core.node;

import org.nguliu.myraft.common.utils.enums.ErrorCodeEnum;
import org.nguliu.myraft.common.utils.tools.AssertTool;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NodeGroup {

    private final NodeId selfId;

    private Map<NodeId, GroupMember> groupMemberMap;

    public NodeGroup(NodeEndpoint endpoint) {
        this(endpoint.getNodeId(), Collections.singleton(endpoint));
    }

    public NodeGroup(@Nonnull NodeId selfId, @Nonnull Collection<NodeEndpoint> endpoints) {
        AssertTool.assertNotEmpty(endpoints, ErrorCodeEnum.PARAM_INVALID_ERROR, "集群成员列表不能为空");
        this.selfId = selfId;
        initGroupMemberMap(endpoints);
    }

    public GroupMember getGroupMember(NodeId nodeId) {
        return groupMemberMap.get(nodeId);
    }

    public Collection<GroupMember> listReplicationTarget() {
        return groupMemberMap.values().stream()
                .filter(m -> !m.getEndpoint().getNodeId().equals(selfId))
                .collect(Collectors.toList());
    }

    private void initGroupMemberMap(Collection<NodeEndpoint> endpoints) {
        groupMemberMap = new HashMap<>(endpoints.size());
        for (NodeEndpoint endpoint : endpoints) {
            groupMemberMap.put(endpoint.getNodeId(), new GroupMember(endpoint));
        }
    }

    @Override
    public String toString() {
        return "NodeGroup{" +
                "selfId=" + selfId +
                ", groupMemberMap=" + groupMemberMap +
                '}';
    }
}
