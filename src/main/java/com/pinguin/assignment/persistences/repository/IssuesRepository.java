package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.persistences.data.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuesRepository extends JpaRepository<Issue,String> {
}
