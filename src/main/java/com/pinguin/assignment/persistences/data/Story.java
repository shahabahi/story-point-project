package com.pinguin.assignment.persistences.data;

import com.pinguin.assignment.enums.EnumStory;
import com.pinguin.assignment.enums.StoryStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumStory estimatedPointValue;

    @Enumerated(EnumType.STRING)
    private StoryStatus status;

    @JoinColumn(name = "ISSUE_ID")
    @OneToOne(fetch = FetchType.EAGER  , cascade = { CascadeType.MERGE })
    private Issue issue;
}
