package org.nguliu.myraft.core.log;

import org.nguliu.myraft.common.utils.enums.ErrorCodeEnum;
import org.nguliu.myraft.common.utils.tools.AssertTool;

public class ReplicationState {

    private int matchIndex;

    private int nextIndex;

    public ReplicationState(int matchIndex, int nextIndex) {
        AssertTool.assertTrue(matchIndex >= 0, ErrorCodeEnum.PARAM_INVALID_ERROR, "matchIndex不能为负数");
        AssertTool.assertTrue(nextIndex >= 0, ErrorCodeEnum.PARAM_INVALID_ERROR, "nextIndex不能为负数");
        this.matchIndex = matchIndex;
        this.nextIndex = matchIndex;
    }

    public static ReplicationState getInstance(int matchIndex, int nextIndex) {
        return new ReplicationState(matchIndex, nextIndex);
    }

    public int getMatchIndex() {
        return matchIndex;
    }

    public void setMatchIndex(int matchIndex) {
        this.matchIndex = matchIndex;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }
}
