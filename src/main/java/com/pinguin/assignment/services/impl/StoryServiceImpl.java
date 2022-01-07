package com.pinguin.assignment.services.impl;

import com.pinguin.assignment.persistences.data.Story;
import com.pinguin.assignment.persistences.repository.StoriesRepository;
import com.pinguin.assignment.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoriesRepository storiesRepository;

    @Override
    public List<Story> getStories() throws Exception {
        return storiesRepository.findAll();
    }

    @Override
    public Story addStory(Story story) throws Exception {
        return storiesRepository.save(story);
    }
}
