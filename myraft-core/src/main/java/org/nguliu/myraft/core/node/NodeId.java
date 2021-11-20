package org.nguliu.myraft.core.node;

import org.nguliu.myraft.common.utils.enums.ErrorCodeEnum;
import org.nguliu.myraft.common.utils.tools.AssertTool;

import java.io.Serializable;
import java.util.Objects;

/**
 * 集群节点
 */
public class NodeId implements Serializable {

    private final String value;

    NodeId(final String value) {
        AssertTool.assertNotBlank(value, ErrorCodeEnum.PARAM_INVALID_ERROR, "NodeId值不能为空");
        this.value = value;
    }

    public static NodeId getInstance(final String value) {
        return new NodeId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeId nodeId = (NodeId) o;
        return Objects.equals(value, nodeId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NodeId{" +
                "value=" + value +
                '}';
    }
}
