package com.pinguin.assignment.controllers;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PlanController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private DeveloperService developerService;

    @GetMapping(value = "/plan",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            })
    public ResponseEntity<StoryModel> getPlan() throws Exception {
        List<Story> stories=storyService.getStories();
        List<StoryModel> storyModels = new ModelMapper().map(stories, new TypeToken<List<StoryModel>>() {}.getType());
        return new ResponseEntity(new Plan().doBestPlaning(storyModels,developerService.getDevelopers()), HttpStatus.OK);
    }
}
