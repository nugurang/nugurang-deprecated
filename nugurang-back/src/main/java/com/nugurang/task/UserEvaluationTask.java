package com.nugurang.task;

import com.nugurang.service.UserEvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserEvaluationTask {

    private final UserEvaluationService userEvaluationService;

    @Scheduled(fixedDelay = 10000)
    private void evaluateUsers() {
        log.info("user evaluation task");
        userEvaluationService.evaluateUsers();
    }
}
