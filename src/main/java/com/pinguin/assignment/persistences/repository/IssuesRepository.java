package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.persistences.data.Issues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuesRepository extends JpaRepository<Issues,Long> {
}
