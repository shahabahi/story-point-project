package com.pinguin.assignment.models.response;

import com.pinguin.assignment.enums.IssueType;
import com.pinguin.assignment.persistences.data.Developer;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class IssueModel implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Date createDate;

    @Enumerated(EnumType.STRING)
    private IssueType type;

    private Developer developer;
}
