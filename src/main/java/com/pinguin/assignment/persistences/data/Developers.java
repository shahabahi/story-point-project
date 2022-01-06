package com.pinguin.assignment.persistences.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_developers")
public class Developers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
