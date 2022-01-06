package com.pinguin.assignment.persistences.data;

import com.pinguin.assignment.enums.Story;
import com.pinguin.assignment.enums.StoryStatus;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_stories")
public class Stories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Story estimatedPointValue;
    private StoryStatus status;

    @JoinColumn(name = "ISSUE_ID")
    @ManyToOne(fetch = FetchType.LAZY  , cascade = { CascadeType.MERGE })
    private Issues issueId;


}
