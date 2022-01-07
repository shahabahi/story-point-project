package com.pinguin.assignment.services;

import com.pinguin.assignment.enums.StoryStatus;
import com.pinguin.assignment.persistences.data.Story;
import java.util.List;


public interface StoryService {
    List<Story> getStoriesByStatus(StoryStatus storyStatus) throws Exception;
    Story addStory(Story story) throws Exception;
}
