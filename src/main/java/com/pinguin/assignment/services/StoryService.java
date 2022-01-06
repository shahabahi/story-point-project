package com.pinguin.assignment.services;

import com.pinguin.assignment.persistences.data.Story;
import java.util.List;


public interface StoryService {
    List<Story> getStories() throws Exception;
}
