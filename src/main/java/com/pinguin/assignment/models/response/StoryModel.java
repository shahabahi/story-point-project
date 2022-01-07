package com.pinguin.assignment.models.response;

import com.pinguin.assignment.enums.EnumStory;
import com.pinguin.assignment.enums.StoryStatus;
import com.pinguin.assignment.persistences.data.Issue;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class StoryModel implements Serializable {

    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumStory estimatedPointValue;

    @Enumerated(EnumType.STRING)
    private StoryStatus status;

    private Issue issue;
}
