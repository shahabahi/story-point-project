package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.persistences.data.Bugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugsRepository extends JpaRepository<Bugs, Long> {

}
