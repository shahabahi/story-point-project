package com.pinguin.assignment.controllers;

import com.pinguin.assignment.enums.StoryStatus;
import com.pinguin.assignment.models.response.StoryModel;
import com.pinguin.assignment.persistences.data.Story;
import com.pinguin.assignment.services.DeveloperService;
import com.pinguin.assignment.services.StoryService;
import com.pinguin.assignment.utils.Plan;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private final StoryService storyService;

    private final DeveloperService developerService;

    @Autowired
    public PlanController(StoryService storyService, DeveloperService developerService) {
        this.storyService = storyService;
        this.developerService = developerService;
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public ResponseEntity<StoryModel> getPlan() throws Exception {
        List<Story> stories = storyService.getStoriesByStatus(StoryStatus.NEW);
        List<StoryModel> storyModels = new ModelMapper().map(stories, new TypeToken<List<StoryModel>>() {
        }.getType());
        return new ResponseEntity(new Plan().doBestPlaning(storyModels, developerService.getDevelopers()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StoryModel> setPlan(@RequestBody List<Story> stories) throws Exception {

        List<Story> outStories = storyService.updateStories(stories);
        return new ResponseEntity(outStories, HttpStatus.OK);
    }


}
