package com.nugurang.task;

import com.nugurang.dao.MatchRequestDao;
import lombok.RequiredArgsConstructor;
import net.time4j.Moment;
import net.time4j.range.IntervalTree;
import net.time4j.range.MomentInterval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MatchTask {
    private final Logger logger = LoggerFactory.getLogger(MatchTask.class);
    private final MatchRequestDao matchRequestDao;

    @Scheduled(fixedDelay = 10000)
    private void matchUsers() {
        IntervalTree<Moment, MomentInterval> tree;
        logger.info("match task");
    }
}
