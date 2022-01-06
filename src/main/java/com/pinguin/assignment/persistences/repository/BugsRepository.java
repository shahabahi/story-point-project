package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.persistences.data.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugsRepository extends JpaRepository<Bug, String> {

}
