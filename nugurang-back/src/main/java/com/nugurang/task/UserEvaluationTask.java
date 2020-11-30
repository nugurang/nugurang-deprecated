package com.nugurang.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserEvaluationTask {
    private final Logger logger = LoggerFactory.getLogger(UserEvaluationTask.class);

    @Scheduled(fixedDelay = 1000)
    private void scheduleTest() {
        //logger.info("user evaluation task");
    }
}
