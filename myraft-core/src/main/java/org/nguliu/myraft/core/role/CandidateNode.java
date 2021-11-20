package org.nguliu.myraft.core.role;

import org.nguliu.myraft.core.enums.RoleTypeEnum;
import org.nguliu.myraft.core.schedule.ElectionTimeout;

public class CandidateNode extends AbstractNodeRole {

    private final Integer votesCount;

    private final ElectionTimeout electionTimeout;

    public CandidateNode(Integer term, ElectionTimeout electionTimeout) {
        this(term, 1, electionTimeout);
    }

    public CandidateNode(Integer term, Integer votesCount, ElectionTimeout electionTimeout) {
        super(RoleTypeEnum.CANDIDATE, term);
        this.votesCount = votesCount;
        this.electionTimeout = electionTimeout;
    }

    @Override
    public void cancelTimeoutOrTask() {
        electionTimeout.cancel();
    }

    public Integer getVotesCount() {
        return votesCount;
    }

    public ElectionTimeout getElectionTimeout() {
        return electionTimeout;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "votesCount=" + votesCount +
                ", electionTimeout=" + electionTimeout +
                '}';
    }
}
