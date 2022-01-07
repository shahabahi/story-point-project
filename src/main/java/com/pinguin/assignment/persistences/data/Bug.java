package com.pinguin.assignment.persistences.data;

import com.pinguin.assignment.enums.BugPriority;
import com.pinguin.assignment.enums.BugStatus;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_bugs")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BugPriority priority;

    private BugStatus status;

    @JoinColumn(name = "ISSUE_ID")
    @OneToOne(fetch = FetchType.LAZY  , cascade = { CascadeType.MERGE })
    private Issue issueId;
}
