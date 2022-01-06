package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.persistences.data.Developers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developers, Long> {
}
