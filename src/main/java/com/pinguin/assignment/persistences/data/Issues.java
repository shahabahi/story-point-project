package com.pinguin.assignment.persistences.data;

import com.pinguin.assignment.enums.IssueType;
import lombok.Data;
import java.sql.Date;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tbl_issues")
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Date createDate;
    private IssueType type;

    @JoinColumn(name = "DEVELOPER_ID")
    @OneToOne(fetch = FetchType.LAZY  , cascade = { CascadeType.MERGE })
    private Developers developers;

}
