package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.persistences.data.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoriesRepository extends JpaRepository<Story,Long> {
}
