package com.pinguin.assignment.utils;


import com.pinguin.assignment.models.response.StoryModel;
import com.pinguin.assignment.persistences.data.Developer;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


public class Plan {
    private static final int DEVELOPER_MAX_STORIES = 10;

    private List<StoryModel> sortStories(List<StoryModel> stories) {

        Comparator<StoryModel> com = (o1, o2) -> {
            if (o1.getEstimatedPointValue().getValue() < o2.getEstimatedPointValue().getValue())
                return 1;
            else
                return -1;
        };
        Collections.sort(stories, com);
        return stories;
    }

    public List<StoryModel> doOldPlaningWithRemoveExtraStories(List<StoryModel> stories, List<Developer> developers) {
        List<StoryModel> finalStories = sortStories(getStoryPlan(stories, developers));
        List<StoryModel> stories1 = new ArrayList<>();
        Map<Long, Integer> developersStory = new HashMap<>();
        for (int i = 0; i < developers.size(); i++) {
            for (Developer developer : developers) {
                for (StoryModel story : finalStories) {
                    if (story.getIssue().getDeveloper() == null) {
                        int sumStories = 0;
                        if (developersStory.containsKey(developer.getId())) {
                            sumStories = developersStory.get(developer.getId());
                        }
                        if (sumStories + story.getEstimatedPointValue().getValue() <= DEVELOPER_MAX_STORIES) {
                            if (sumStories > 0) {
                                developersStory.replace(developer.getId(), sumStories + story.getEstimatedPointValue().getValue());
                            } else {
                                developersStory.put(developer.getId(), story.getEstimatedPointValue().getValue());
                            }
                            story.getIssue().setDeveloper(developer);
                            stories1.add(story);
                            break;
                        }
                    }
                }
            }
        }

        return stories1;
    }

    public List<StoryModel> doBestPlaning(List<StoryModel> stories, List<Developer> developers) {
        List<StoryModel> finalStories = sortStories(stories);
        List<StoryModel> outputStories = new ArrayList<>();
        Map<Long, Integer> developersStory = new HashMap<>();
        boolean findCandidDeveloper = false;
        int mapSkip = 0;
        for (Developer developer : developers) {
            developersStory.put(developer.getId(), 0);
        }
        for (StoryModel story : finalStories) {
            findCandidDeveloper = false;
            while (!findCandidDeveloper) {
                final long developerCandidate = getMinDeveloperEstimatedPointValue(developersStory, mapSkip);
                if (developersStory.containsKey(developerCandidate)) {
                    int sumStories = 0;
                    sumStories = developersStory.get(developerCandidate);
                    if (sumStories + story.getEstimatedPointValue().getValue() <= DEVELOPER_MAX_STORIES) {
                        findCandidDeveloper = true;
                        mapSkip = 0;
                        developersStory.replace(developerCandidate, sumStories + story.getEstimatedPointValue().getValue());
                        Developer developer = getCurrentDeveloper(developers,developerCandidate);
                        story.getIssue().setDeveloper(developer);
                        outputStories.add(story);
                    } else {
                        if (mapSkip < developersStory.size() - 1) {
                            mapSkip++;
                        } else {
                            findCandidDeveloper = true;
                        }
                    }
                }
            }
        }

        return outputStories;
    }

    private Developer getCurrentDeveloper(List<Developer> developers,long developerCandidate) {
       return developers.stream()
                .filter(cDeveloper -> developerCandidate == cDeveloper.getId())
                .findAny()
                .orElse(null);
    }

    private List<StoryModel> getStoryPlan(List<StoryModel> stories, List<Developer> developers) {
        return getSprintStories(stories, developers);
    }

    private List<StoryModel> getSprintStories(List<StoryModel> stories, List<Developer> developers) {
        List<StoryModel> outStories = stories;
        Integer sumStories = stories.stream()
                .map(x -> x.getEstimatedPointValue().getValue())
                .reduce(0, Integer::sum);
        AtomicLong extraStories = new AtomicLong(sumStories - (developers.size() * DEVELOPER_MAX_STORIES));
        List<StoryModel> deletedStories = new ArrayList<>();
        stories.stream()
                .forEach(story -> {
                    if (extraStories.get() > 0) {
                        deletedStories.add(story);
                    }
                    extraStories.addAndGet(-story.getEstimatedPointValue().getValue());
                });
        outStories.removeAll(deletedStories);
        return outStories;
    }

    public Long getMinDeveloperEstimatedPointValue(Map<Long, Integer> developersStory, int mapSkip) {
        Comparator<? super Map.Entry<Long, Integer>> valueComparator = Comparator.comparing(Map.Entry::getValue);

        Optional<Map.Entry<Long, Integer>> minValue = developersStory.entrySet()
                .stream().skip(mapSkip).min(valueComparator);

        return minValue.get().getKey();

    }
}


