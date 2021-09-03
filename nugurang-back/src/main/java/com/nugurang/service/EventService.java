package com.nugurang.service;

import com.nugurang.dao.EventDao;
import com.nugurang.dto.EventInputDto;
import com.nugurang.entity.EventEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventDao eventDao;

    public EventEntity createEvent(EventInputDto eventInputDto) {
        return eventDao.save(
            EventEntity
            .builder()
            .name(eventInputDto.getName())
            .description(eventInputDto.getDescription())
            .recruitingStart(eventInputDto.getRecruitingStart())
            .recruitingEnd(eventInputDto.getRecruitingEnd())
            .eventStart(eventInputDto.getEventStart())
            .eventEnd(eventInputDto.getEventEnd())
            .build()
        );
    }

    public Optional<EventEntity> getEvent(Long eventId) {
        return eventDao.findById(eventId);
    }

    public EventEntity updateEvent(EventInputDto eventInputDto, Long eventId) {
        EventEntity eventEntity = eventDao.findById(eventId).get();
        eventEntity.setName(eventInputDto.getName());
        eventEntity.setDescription(eventInputDto.getDescription());
        eventEntity.setRecruitingStart(eventInputDto.getRecruitingStart());
        eventEntity.setRecruitingEnd(eventInputDto.getRecruitingEnd());
        eventEntity.setEventStart(eventInputDto.getEventStart());
        eventEntity.setEventEnd(eventInputDto.getEventEnd());
        return eventDao.save(eventEntity);
    }

    public void deleteEvent(Long eventId) {
        eventDao.deleteById(eventId);
    }
}
