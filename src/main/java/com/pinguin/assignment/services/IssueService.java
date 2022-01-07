package com.pinguin.assignment.services;

import com.pinguin.assignment.persistences.data.Issue;
import java.util.List;

public interface IssueService {
    List<Issue> getIssues() throws Exception;
    Issue addIssue(Issue issue) throws Exception;
    Issue updateIssue(Issue issue) throws Exception;
}
