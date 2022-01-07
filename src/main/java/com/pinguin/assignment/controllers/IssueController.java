package com.pinguin.assignment.controllers;

import com.pinguin.assignment.persistences.data.Issue;
import com.pinguin.assignment.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping
    public ResponseEntity<Issue> getIssue() {
        try {
            return new ResponseEntity(issueService.getIssues(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Issue> addIssue(@RequestBody Issue issue) {
        try {
            issue.setCreateDate(new Date());
            return new ResponseEntity(issueService.addIssue(issue), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping
    public ResponseEntity<Issue> updateIssue(@RequestBody Issue issue) {
        try {
            issue.setCreateDate(new Date());
            return new ResponseEntity(issueService.updateIssue(issue), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
