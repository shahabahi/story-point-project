package com.pinguin.assignment.controllers;

import com.pinguin.assignment.persistences.data.Story;
import com.pinguin.assignment.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stories")
public class StoryController {
    @Autowired
    private StoryService storyService;

    @PutMapping(path = "/add")
    public ResponseEntity<Story> addStory(Story story) {
        try {
            return new ResponseEntity(storyService.addStory(story), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
