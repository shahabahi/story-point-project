package com.pinguin.assignment.persistences.repository;

import com.pinguin.assignment.enums.StoryStatus;
import com.pinguin.assignment.persistences.data.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoriesRepository extends JpaRepository<Story,Long> {
    List<Story> findByStatus(StoryStatus storyStatus);
}
