package com.talkevents.jpa.services;

import com.talkevents.jpa.dtos.SaveEventRecordDto;
import com.talkevents.jpa.entities.Attendee;
import com.talkevents.jpa.entities.Event;
import com.talkevents.jpa.entities.Location;
import com.talkevents.jpa.repositories.AttendeeRepository;
import com.talkevents.jpa.repositories.EventRepository;
import com.talkevents.jpa.repositories.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;
    private final LocationRepository locationRepository;


    public EventService(EventRepository eventRepository, AttendeeRepository attendeeRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
        this.locationRepository = locationRepository;
    }

    @Transactional
    public Event saveEvent(SaveEventRecordDto eventDto) {
        var event = new Event();
        Location location = locationRepository.findById(eventDto.location().getId()).orElseThrow(() -> new RuntimeException("Localização não encontrada"));

        Set<Attendee> attendees = new HashSet<>(attendeeRepository.findAllById(eventDto.attendees()));

        event.setName(eventDto.name());
        event.setDate(eventDto.date());
        event.setAttendees(attendees);
        event.setLocation(location);
        location.setEvent(event);

        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
