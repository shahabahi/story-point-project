package com.pinguin.assignment.persistences.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_sprints")
public class Sprints {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "ISSUE_ID")
    @ManyToOne(fetch = FetchType.LAZY  , cascade = { CascadeType.MERGE })
    private Issues issues;

    private int weekNumber;
}
