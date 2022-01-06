package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.persistences.data.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintsRepository extends JpaRepository<Sprint,String> {
}
