package com.pinguin.assignment.services.impl;

import com.pinguin.assignment.enums.StoryStatus;
import com.pinguin.assignment.persistences.data.Story;
import com.pinguin.assignment.persistences.repository.StoriesRepository;
import com.pinguin.assignment.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StoryServiceImpl implements StoryService {
    
    private final StoriesRepository storiesRepository;

    @Autowired
    public StoryServiceImpl(StoriesRepository storiesRepository) {
        this.storiesRepository = storiesRepository;
    }

    @Override
    public List<Story> getStoriesByStatus(StoryStatus storyStatus) throws Exception {
        return storiesRepository.findByStatus(storyStatus);
    }

    @Override
    public Story addStory(Story story) throws Exception {
        return storiesRepository.save(story);
    }
}
