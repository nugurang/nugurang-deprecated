package com.nugurang.service;

import com.nugurang.dao.NotificationDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationDao userDao;
}
