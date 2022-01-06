package com.pinguin.assignment.persistences.data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Sprints {
    private Long id;

    @JoinColumn(name = "ISSUE_ID")
    @ManyToOne(fetch = FetchType.LAZY  , cascade = { CascadeType.MERGE })
    private Issues issues;

    private int weekNumber;
}
